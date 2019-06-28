package com.sr.sample.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.disposables.Disposable

open class BaseViewModel(application: Application) : AndroidViewModel(application) {

    protected var mDisposable: Disposable? = null


    fun onUnauthorized(){

    }
    override fun onCleared() {
        super.onCleared()
        mDisposable?.dispose()
    }

}