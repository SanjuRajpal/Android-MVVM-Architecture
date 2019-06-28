package com.sr.sample.ui.splash

import android.os.CountDownTimer
import androidx.databinding.ViewDataBinding
import com.sr.sample.R
import com.sr.sample.databinding.ActSplashBinding
import com.sr.sample.extension.startActivity
import com.sr.sample.ui.base.BaseAct
import com.sr.sample.ui.main.MainAct

class SplashAct : BaseAct() {

    private lateinit var mBinding: ActSplashBinding

    override fun getLayoutID(): Int = R.layout.act_splash

    override fun initBinding(binding: ViewDataBinding) {
        mBinding = binding as ActSplashBinding
    }

    override fun initActivity() {
        val timer = object : CountDownTimer(1000, 2000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                startActivity(MainAct::class.java)
                this@SplashAct.finish()
            }
        }
        timer.start()
    }

}