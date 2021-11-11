package com.shinta.intentshinta

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnMoveActivity: Button
    private lateinit var btnMoveActivityWithData: Button
    private lateinit var btnDialNumber: Button
    private lateinit var btnMoveActivityForResult: Button
    private lateinit var btnResultFromActivity: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMoveActivity = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        btnMoveActivityWithData = findViewById(R.id.btn_move_activity_with_data)
        btnMoveActivityWithData.setOnClickListener(this)

        btnDialNumber = findViewById(R.id.btn_dial_number)
        btnDialNumber.setOnClickListener(this)

        btnMoveActivityForResult = findViewById(R.id.btn_move_activity_for_result)
        btnMoveActivityForResult.setOnClickListener(this)

        btnResultFromActivity = findViewById(R.id.btn_move_activity_for_result)
        btnResultFromActivity.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)
        PorridgeReceiver()
    }

    private fun PorridgeReceiver() {
        val bundle =intent.extras
        val porridge = bundle?.getString("Porridge")
        tvResult.text = porridge
    }

    override fun onClick(v: View?) {
        if(v !=null){
            when(v.id){
                R.id.btn_move_activity -> run {
                    val intent = Intent(this, MoveActivity::class.java)
                    startActivity(intent)
                }
                R.id.btn_move_activity_with_data -> run{
                    val intent = Intent(this, MoveActivityWithData::class.java)
                    val bundle = Bundle()
                    bundle.putString("Nama", "Shinta")
                    bundle.putString("Alamat", "Jombang")
                    intent.putExtras(bundle)
                    startActivity(intent)
                }
                R.id.btn_dial_number -> run{
                    var dialNumber = "085707030786"
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+dialNumber))
                    startActivity(intent)
                }
                R.id.btn_move_activity_for_result -> run{
                    val intent = Intent(this, MoveActivityForResult::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}