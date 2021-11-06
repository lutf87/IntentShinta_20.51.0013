package com.shinta.intentshinta

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnMoveActivity: Button
    private lateinit var btnMoveActivityWithData: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMoveActivity = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        btnMoveActivityWithData = findViewById(R.id.btn_move_activity_with_data)
        btnMoveActivityWithData.setOnClickListener(this)
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
            }
        }
    }
}