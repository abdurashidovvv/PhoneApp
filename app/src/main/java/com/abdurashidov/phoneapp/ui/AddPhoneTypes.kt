package com.abdurashidov.phoneapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.abdurashidov.phoneapp.R
import com.abdurashidov.phoneapp.models.MyAdapterType
import com.abdurashidov.phoneapp.utils.PhoneTypeList
import kotlinx.android.synthetic.main.activity_add_phone_types.*

class AddPhoneTypes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_phone_types)



        val adapter=MyAdapterType(PhoneTypeList.phoneTypeList, this)
        apt_list_view.adapter=adapter
        apt_list_view.setOnItemClickListener { parent, view, position, id ->
            val intent=Intent(this, AddPhone::class.java)
            intent.putExtra("index", position)
            startActivity(intent)
        }
    }

    override fun onRestart() {
        super.onRestart()
        finish()
    }
}