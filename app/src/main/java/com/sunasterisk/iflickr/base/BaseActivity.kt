package com.sunasterisk.iflickr.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sunasterisk.iflickr.R

abstract class BaseActivity: AppCompatActivity() {

    @get: LayoutRes
    protected abstract val layoutRes: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)
        initView()
        initData()
        initViewModel()
        observerData()
    }

    abstract fun initView()

    abstract fun initData()

    abstract fun initViewModel()

    abstract fun observerData()

    fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameContent, fragment)
            .commit()
    }
}
