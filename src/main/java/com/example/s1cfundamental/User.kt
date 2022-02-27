package com.example.s1cfundamental

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var name: String,
    var location: String,
    var company: String,
    var photo: Int,
    var username : String,
    var followers: String,
    var following: String,
    var repository: String
):Parcelable