package com.sr.sample.beans

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PostBean(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
) : Parcelable {
    private fun getId(): String {
        return "No.$id"
    }

    fun getFormattedTitle(): String {
        return "${getId()} $title"
    }
}

