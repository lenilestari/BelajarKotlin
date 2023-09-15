package com.example.belajarkotlin

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class BelajarPindahActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var ResultPilih : TextView

    // buat dulu objek ActivityResultLauncher untuk pengembalian nilai

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Result.RESULT_CODE && result.data != null) {
            val selectedValue = result.data?.getIntExtra(Result.EXTRA_SELECT_VALUE, 0)
            ResultPilih.text = "Hasil : $selectedValue"
        }
        Log.i("Result", "ok masuk")
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_belajar_pindah)

        val moveActivity: Button = findViewById(R.id.btn_moveActivity)
        moveActivity.setOnClickListener(this)

        val moveActivittyWithData : Button = findViewById(R.id.btn_moveActivityData)
        moveActivittyWithData.setOnClickListener(this)

        val dataParcelableMove : Button = findViewById(R.id.btn_dataParcelable)
        dataParcelableMove.setOnClickListener(this)

        val dialNumber : Button = findViewById(R.id.btn_dialNumber)
        dialNumber.setOnClickListener(this)

        ResultPilih = findViewById(R.id.tv_HasilPilih)

    }

    override fun onClick(view: View?) {

        when (view?.id) {
            R.id.btn_moveActivity -> {
                val moveIntent = Intent(this@BelajarPindahActivity, MoveActivitty::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_moveActivityData -> {

                val moveDataWithIntent = Intent(this@BelajarPindahActivity, Data::class.java)
                startActivity(moveDataWithIntent)
                moveDataWithIntent.putExtra(Data.EXTRA_NAME, "Leni Lestari")
                moveDataWithIntent.putExtra(Data.EXTRA_AGE, 20)
                startActivity(moveDataWithIntent)

            }
            R.id.btn_dataParcelable -> {
                val dataClass = DataClass (

                    "Leni Lestari",
                    20,
                    "Tlogoadi",
                    "Yogyakarta"

                )

                val moveDataClass = Intent (this@BelajarPindahActivity, MoveDataParcelable::class.java)
                moveDataClass.putExtra(MoveDataParcelable.EXTRA_DATACLASS, dataClass)
                startActivity(moveDataClass)
            }

            R.id.btn_dialNumber -> {
                val phoneNumber = "085210603262"
                val dialPhoneIntent = Intent (Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
            R.id.btn_ResultPilih -> {
                val movePilih = Intent(this@BelajarPindahActivity, Result::class.java)
                resultLauncher.launch(movePilih)

            }
        }
    }
}