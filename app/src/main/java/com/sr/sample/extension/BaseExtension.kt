package com.sr.sample.extension

import android.content.Intent
import android.os.Bundle
import com.sr.sample.ui.base.BaseAct

fun BaseAct.startActivity(cls: Class<*>) {

    val intent = Intent(this, cls)
    startActivity(intent)
    overridePendingTransitionEnter()
}

fun BaseAct.startActivity(cls: Class<*>, bundle: Bundle) {
    val intent = Intent(this, cls)
    intent.putExtras(bundle)
    startActivity(intent)
    overridePendingTransitionEnter()
}

