package com.abdurashidov.phoneapp.ui

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abdurashidov.phoneapp.R
import com.abdurashidov.phoneapp.utils.PhoneList
import com.abdurashidov.phoneapp.utils.PhoneTypeList
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_add_phone_tpes_get.*

class AddPhoneTypesGet : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_phone_tpes_get)

        aptg_btn.setOnClickListener {
            val text=aptg_edt.text.toString().trim()
            PhoneTypeList.phoneTypeList.add(text)

            sharedPreferences=getSharedPreferences("PhoneTypeList", Context.MODE_PRIVATE)

            val editor=sharedPreferences.edit()
            editor.putString("TypeList", Gson().toJson(PhoneList.phoneList))
            finish()
        }

    }
}