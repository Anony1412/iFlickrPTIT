package com.sunasterisk.iflickr.ui.fragment.profile

import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.sunasterisk.iflickr.R
import com.sunasterisk.iflickr.base.BaseFragment
import com.sunasterisk.iflickr.data.model.Photo
import com.sunasterisk.iflickr.data.model.Post
import com.sunasterisk.iflickr.data.source.remote.response.PublicPhotosResponse
import com.sunasterisk.iflickr.data.source.remote.response.UserProfileResponse
import com.sunasterisk.iflickr.databinding.FragmentProfileBinding
import com.sunasterisk.iflickr.ui.adapter.PhotoAdapter
import com.sunasterisk.iflickr.ui.fragment.photo.PhotoFragment
import com.sunasterisk.iflickr.utils.PhotoType
import kotlinx.android.synthetic.main.custom_action_bar.*
import kotlinx.android.synthetic.main.fragment_profile.*
import org.koin.android.viewmodel.ext.android.viewModel

const val ITEM_GRID_WIDTH = 88

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    override val layoutRes: Int
        get() = R.layout.fragment_profile

    private val profileViewModel: ProfileViewModel by viewModel()

    private var post: Post? = null

    private val photoAdapter by lazy {
        PhotoAdapter(PhotoType.PHOTO_PROFILE) {
            onPhotoItemClick(it)
        }
    }

    override fun getArgument() {
        post = arguments?.getParcelable(ARGUMENT_POST)
    }

    override fun initActionBar() {
        imageActionbarLogo.visibility = View.GONE
        textActionBarTitle.visibility = View.GONE
    }

    override fun initData() {
        viewDataBinding?.let {
            it.post = post
            it.recyclerPublicPhotos.apply {
                adapter = photoAdapter
                layoutManager = GridLayoutManager(context, columnFitScreen())
            }
        }
    }

    override fun initViewModel() {
        post?.user?.nsId?.let {
            profileViewModel.run {
                getUserProfile(it)
                getPublicPhotos(it)

            }
        }
    }

    override fun initListeners() {
        buttonFollow.setOnClickListener { checkFollowState() }
    }

    private fun checkFollowState() {

    }

    override fun observerData() {
        profileViewModel.userProfileResponse.observe(this, Observer { showUserInfo(it) })
        profileViewModel.publicPhotosResponse.observe(this, Observer { showPublicPhotos(it) })
    }

    private fun showPublicPhotos(publicPhotosResponse: PublicPhotosResponse?) {
        publicPhotosResponse?.photos?.let {
            viewDataBinding?.photos = it
            it.photos?.let { photos ->
                photoAdapter.updateData(photos)
            }
        }
    }

    private fun columnFitScreen(): Int {
        var value = 0
        val displayMetrics = context?.resources?.displayMetrics
        displayMetrics?.let {
            val screenWidthDp = it.widthPixels / it.density
            value = (screenWidthDp / (ITEM_GRID_WIDTH + 0.5)).toInt()
        }
        return value
    }

    private fun showUserInfo(userProfileResponse: UserProfileResponse?) {
        viewDataBinding?.user = userProfileResponse?.user
    }

    private fun onPhotoItemClick(photo: Photo) {
        replaceFragment(PhotoFragment.newInstance(photo))
    }

    override fun disposableObserver() {
        profileViewModel.disposable.clear()
    }

    companion object {

        private const val ARGUMENT_POST =
            "com.sunasterisk.iflickr.ui.fragment.profile.ARGUMENT_POST"

        fun newInstance(post: Post): ProfileFragment =
            ProfileFragment().apply {
                arguments = bundleOf(ARGUMENT_POST to post)
            }
    }
}
