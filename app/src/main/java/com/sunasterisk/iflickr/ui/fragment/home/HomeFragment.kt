package com.sunasterisk.iflickr.ui.fragment.home

import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import com.sunasterisk.iflickr.R
import com.sunasterisk.iflickr.base.BaseFragment
import com.sunasterisk.iflickr.data.model.Post
import com.sunasterisk.iflickr.data.model.User
import com.sunasterisk.iflickr.data.source.remote.response.PhotoSetPhotosResponse
import com.sunasterisk.iflickr.data.source.remote.response.PhotoSetsResponse
import com.sunasterisk.iflickr.databinding.FragmentHomeBinding
import com.sunasterisk.iflickr.ui.adapter.PostAdapter
import com.sunasterisk.iflickr.ui.fragment.profile.ProfileFragment
import kotlinx.android.synthetic.main.custom_action_bar.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val layoutRes: Int
        get() = R.layout.fragment_home

    private val homeViewModel: HomeViewModel by viewModel()

    private val postAdapter by lazy {
        PostAdapter {
            onPostItemClick(it)
        }
    }

    private val posts = mutableListOf<Post>()

    override fun getArgument() {

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun initActionBar() {

        buttonBackActionBar.visibility = View.GONE

        val typeFace = resources.getFont(R.font.shink)
        textActionBarTitle.apply {
            text = getString(R.string.app_name)
            typeface = typeFace
        }
    }

    override fun initData() {
        viewDataBinding?.recyclerViewHomeNewFeed?.adapter = postAdapter
    }

    override fun initViewModel() {
        homeViewModel.getPhotoSets("130158398@N07")
    }

    override fun initListeners() {

    }

    override fun observerData() {
        homeViewModel.photoSetsResponse.observe(this, Observer { showPost(it) })
        homeViewModel.photoSetPhotosResponse.observe(this, Observer { showPostPhotos(it) })
    }

    private fun showPostPhotos(photoSetPhotosResponse: PhotoSetPhotosResponse?) {
        posts.forEach {
            if (it.photoSet?.id.equals(photoSetPhotosResponse?.photoSetDes?.id)) {
                it.photos = photoSetPhotosResponse?.photoSetDes?.photos
            }
        }
        postAdapter.updateData(posts)
    }

    private fun showPost(photoSetsResponse: PhotoSetsResponse?) {
        photoSetsResponse?.photosets?.photoSet?.forEach {
            posts.add(Post(null, it, null))
        }

    }

    override fun disposableObserver() {
        homeViewModel.disposable.clear()
    }

    private fun onPostItemClick(post: Post) {
        post.user = User(null, "130158398@N07",
            null, null, null,
            null, null, null, null,
            null)
        replaceFragment(ProfileFragment.newInstance(post))
    }

    companion object {

        fun newInstance() = HomeFragment()
    }
}
