package com.example.belajarkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView

class Result : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnPilih : Button
    private lateinit var rgGroupNumber : RadioGroup


    companion object {
        const val EXTRA_SELECT_VALUE = "extra_selext_value"
        const val RESULT_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        btnPilih = findViewById(R.id.btn_pilih)
        rgGroupNumber = findViewById(R.id.rg_Number)

        btnPilih.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_pilih) {

            if (rgGroupNumber.checkedRadioButtonId > 0) {
                var value = 0
                when (rgGroupNumber.checkedRadioButtonId) {
                    R.id.Rb_1 -> value = 100
                    R.id.Rb_2 -> value = 50
                    R.id.Rb_3 -> value = 200
                    R.id.Rb_4 -> value = 150
                    R.id.Rb_5 -> value = 200
                    R.id.Rb_6 -> value = 50
                }
                Log.i("Data", "ok masuk")

                val resultIntent = Intent ()
                resultIntent.putExtra(EXTRA_SELECT_VALUE, value)
                setResult(RESULT_CODE, resultIntent)
                finish()
            }
        }
    }
}