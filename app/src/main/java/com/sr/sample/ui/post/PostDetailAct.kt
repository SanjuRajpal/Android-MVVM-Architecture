package com.sr.sample.ui.post

import androidx.databinding.ViewDataBinding
import com.sr.sample.R
import com.sr.sample.beans.PostBean
import com.sr.sample.databinding.ActPostDetailBinding
import com.sr.sample.ui.base.BaseAct

class PostDetailAct : BaseAct() {

    private lateinit var mBinding: ActPostDetailBinding

    private var post: PostBean? = null

    override fun getLayoutID(): Int = R.layout.act_post_detail

    override fun initBinding(binding: ViewDataBinding) {
        mBinding = binding as ActPostDetailBinding
    }

    override fun initActivity() {
        getArgsExtra()
        post?.let { mBinding.post = it }
    }

    private fun getArgsExtra() {
        post = intent?.extras?.getParcelable<PostBean>("post")
    }
}