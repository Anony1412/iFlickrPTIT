package com.sunasterisk.iflickr.ui.activity.splash

import android.animation.AnimatorInflater
import android.os.Handler
import com.sunasterisk.iflickr.R
import com.sunasterisk.iflickr.base.BaseActivity
import com.sunasterisk.iflickr.ui.activity.main.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity() {
    override val layoutRes: Int
        get() = R.layout.activity_splash

    override fun initView() {

        initAnimation()
        startMainActivity()
    }

    private fun startMainActivity() {
        Handler().postDelayed({
            startActivity(MainActivity.getIntent(this))
        }, 2000)
    }

    private fun initAnimation() {
        val animator = AnimatorInflater.loadAnimator(applicationContext, R.animator.anim_flip)
        animator.setTarget(imageLogo)
        animator.start()
    }

    override fun initData() {

    }

    override fun initViewModel() {

    }

    override fun observerData() {

    }
}
