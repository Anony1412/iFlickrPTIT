package com.sunasterisk.iflickr.ui.fragment.photo

import android.util.Log
import androidx.core.os.bundleOf
import com.sunasterisk.iflickr.R
import com.sunasterisk.iflickr.base.BaseFragment
import com.sunasterisk.iflickr.data.model.Photo
import com.sunasterisk.iflickr.databinding.FragmentPhotoBinding

class PhotoFragment : BaseFragment<FragmentPhotoBinding>() {

    override val layoutRes: Int
        get() = R.layout.fragment_photo

    private var photo: Photo? = null

    override fun getArgument() {
        photo = arguments?.getParcelable<Photo>(ARGUMENT_PHOTO_ITEM)
        Log.d("TAG", "photoUrl: ${photo?.getPhotoUrl()}")
    }

    override fun initActionBar() {

    }

    override fun initData() {
        viewDataBinding?.photo = photo
    }

    override fun initViewModel() {

    }

    override fun initListeners() {

    }

    override fun observerData() {

    }

    override fun disposableObserver() {

    }

    companion object {

        private const val ARGUMENT_PHOTO_ITEM =
            "com.sunasterisk.iflickr.ui.fragment.photo.ARGUMENT_PHOTO_ITEM"

        fun newInstance(photo: Photo) = PhotoFragment().apply {
            arguments = bundleOf(ARGUMENT_PHOTO_ITEM to photo)
        }
    }
}
