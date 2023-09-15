package com.example.belajarkotlin

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class DataClass(

    val nama: String?,
    val umur: Int,
    val alamat: String?,
    val kota: String?

        ) : Parcelable