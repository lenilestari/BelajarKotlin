package com.example.belajarkotlin

import android.app.Person
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveDataParcelable : AppCompatActivity() {

    companion object {
        const val EXTRA_DATACLASS = "extra_data_class"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_data_parcelable)

        val DataParcelable: TextView = findViewById(R.id.text_DataParcelable)

        val person = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<DataClass>(EXTRA_DATACLASS, DataClass::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<DataClass>(EXTRA_DATACLASS)
        }

        if (person != null) {
            val text =
                "Nama : ${person.nama.toString()},\nUmur : ${person.umur},\nAlamat : ${person.alamat},\nKota : ${person.kota}"
            DataParcelable.text = text
        }
    }
}