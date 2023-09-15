package com.example.belajarkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class BelajarPindahActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_belajar_pindah)

        val moveActivity: Button = findViewById(R.id.btn_moveActivity)
        moveActivity.setOnClickListener(this)

        val moveActivittyWithData : Button = findViewById(R.id.btn_moveActivityData)
        moveActivittyWithData.setOnClickListener(this)

        val dataParcelableMove : Button = findViewById(R.id.btn_dataParcelable)
        dataParcelableMove.setOnClickListener(this)

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
        }
    }
}