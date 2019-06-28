package com.sr.sample.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.sr.sample.beans.PostBean
import com.sr.sample.retrofit.APITask
import com.sr.sample.retrofit.OnResponseListener
import com.sr.sample.ui.base.BaseViewModel

class MainVM(application: Application) : BaseViewModel(application), OnResponseListener {

    private var mPresenter: MainImpl? = null
    private var mData = MutableLiveData<Array<PostBean>>()

    fun setPresenter(presenter: MainImpl) {
        this.mPresenter = presenter
    }

    fun doGetPosts() {
        mDisposable = APITask.getInstance().doGetPost(this)
    }

    override fun onResponseReceived(response: Any, requestCode: Int) {
        val data = Gson().fromJson(response.toString(), Array<PostBean>::class.java)
        mData.value = data
//        mPresenter?.onSuccess(data)
    }

    override fun onResponseError(message: String, requestCode: Int) {
    }

    override fun onTokenExpires() {
        onUnauthorized()
    }

    public fun getPosts(): LiveData<Array<PostBean>> {
        return mData
    }

}