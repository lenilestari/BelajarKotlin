package com.example.belajarkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Thread.State

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //ini agar dia jika di putar landscape tidak akan mengulang dari awal menghitung
    companion object {
        private const val STATE_RESULT = "state_result"
    }

    // Tampung variabel yang ada di view dan kemudian panggil di barisan ini

    private lateinit var edtPanjang: EditText
    private lateinit var edtLebar: EditText
    private lateinit var edtTinggi: EditText
    private lateinit var btnHitung: Button
    private lateinit var hasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // panggil variabel yang udah di panggil di main activity tadi disini, untuk di inilisasi

        edtPanjang = findViewById(R.id.edt_Panjang)
        edtLebar = findViewById(R.id.edt_Lebar)
        edtTinggi = findViewById(R.id.edt_Tinggi)
        btnHitung = findViewById(R.id.btn_hitung)
        hasil = findViewById(R.id.text_hasil)

        btnHitung.setOnClickListener(this)


        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            hasil.text = result
        }

    }



    override fun onClick(view: View?) {

        if (view?.id == R.id.btn_hitung) {

            val inputPanjang = edtPanjang.text.toString().trim()
            val inputLebar = edtLebar.text.toString().trim()
            val inputTinggi = edtTinggi.text.toString().trim()

            var isEmptyFields = false // Mengganti pengejaan variabel

            if (inputPanjang.isEmpty()) {
                isEmptyFields = true
                edtPanjang.error = "Tidak boleh kosong"
            }

            if (inputLebar.isEmpty()) {
                isEmptyFields = true
                edtLebar.error =
                    "Tidak boleh kosong" // Mengganti variabel yang digunakan untuk menetapkan pesan error
            }

            if (inputTinggi.isEmpty()) {
                isEmptyFields = true
                edtTinggi.error =
                    "Tidak boleh kosong" // Mengganti variabel yang digunakan untuk menetapkan pesan error
            }

            if (!isEmptyFields) { // Periksa apakah ada field yang kosong sebelum menghitung
                val jumlah =
                    inputPanjang.toDouble() * inputLebar.toDouble() * inputTinggi.toDouble()
                hasil.text = jumlah.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, hasil.text.toString())

    }
}
