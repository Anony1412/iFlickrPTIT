package com.sunasterisk.iflickr.ui.activity.main

import android.content.Context
import android.content.Intent
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sunasterisk.iflickr.R
import com.sunasterisk.iflickr.base.BaseActivity
import com.sunasterisk.iflickr.ui.fragment.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override val layoutRes: Int
        get() = R.layout.activity_main

    private val bottomNavSelected = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                setFragment(HomeFragment.newInstance())
                true
            }
            R.id.navigation_people -> {
                true
            }
            R.id.navigation_favorite -> {
                true
            }
            else -> false
        }
    }

    override fun initView() {
        setFragment(HomeFragment.newInstance())
        bottomNavigation.setOnNavigationItemSelectedListener(bottomNavSelected)
    }

    override fun initData() {

    }

    override fun initViewModel() {

    }

    override fun observerData() {

    }

    companion object {

        fun getIntent(context: Context): Intent =
            Intent(context, MainActivity::class.java)
    }
}
