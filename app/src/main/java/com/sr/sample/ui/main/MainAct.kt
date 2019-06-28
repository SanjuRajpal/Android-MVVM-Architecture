package com.sr.sample.ui.main

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sr.sample.BR
import com.sr.sample.R
import com.sr.sample.beans.PostBean
import com.sr.sample.databinding.ActMainBinding
import com.sr.sample.extension.startActivity
import com.sr.sample.ui.base.BaseAct
import com.sr.sample.ui.base.BindingAdapter
import com.sr.sample.ui.post.PostDetailAct

class MainAct : BaseAct(), MainImpl {

    private lateinit var mBinding: ActMainBinding

    private lateinit var data: Array<PostBean>

    private val mViewModel: MainVM by lazy {
        ViewModelProviders.of(this).get(MainVM::class.java)
    }

    override fun getLayoutID(): Int = R.layout.act_main

    override fun initBinding(binding: ViewDataBinding) {
        mBinding = binding as ActMainBinding
    }

    override fun initActivity() {
        mViewModel.setPresenter(this)
        mViewModel.doGetPosts()


        mViewModel.getPosts().observe(this, Observer<Array<PostBean>> { data ->
            this@MainAct.data = data
            setAdapter()
        })
    }

    override fun onSuccess(data: Array<PostBean>?) {
//        data?.let {
//            this.data = data
//            setAdapter()
//        }
    }


    private fun setAdapter() {

        val adapter = BindingAdapter(
            layoutId = R.layout.row_post,
            br = BR.post,
            list = data.toList(),
            clickListener = { view, i ->
                val bundle = Bundle()
                bundle.putParcelable("post", data[i])
                startActivity(PostDetailAct::class.java, bundle)
            }
        )
        mBinding.myRecyclerView.setRecyclerViewAdapter(adapter)

    }

}

