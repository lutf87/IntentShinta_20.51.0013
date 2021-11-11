package com.shinta.intentshinta

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class MoveActivityForResult : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnChoose: Button
    private lateinit var btnKembali: Button
    var rgPorridge: RadioGroup? = null
    lateinit var radioButton: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_for_result)

        btnKembali = findViewById(R.id.btn_kembali)
        btnKembali.setOnClickListener(this)

        rgPorridge = findViewById(R.id.rg_porridge)
        btnChoose = findViewById(R.id.btn_pilih)
        btnChoose.setOnClickListener {
            val selectedOption: Int = rgPorridge!!.checkedRadioButtonId
            radioButton = findViewById(selectedOption)

            val intent = Intent(this, MainActivity::class.java)
            val bundle = Bundle()
            bundle.putString("Porridge", radioButton.text as String)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

    override fun onClick(v: View?) {
        if (v !=null){
            when(v.id){
                R.id.btn_kembali -> run {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}