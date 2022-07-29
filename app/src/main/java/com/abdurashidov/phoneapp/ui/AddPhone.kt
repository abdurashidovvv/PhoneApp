package com.abdurashidov.phoneapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abdurashidov.phoneapp.R
import com.abdurashidov.phoneapp.models.Phone
import com.abdurashidov.phoneapp.utils.PhoneList
import com.abdurashidov.phoneapp.utils.PhoneTypeList
import kotlinx.android.synthetic.main.activity_add_phone.*

class AddPhone : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_phone)

        val index=intent.getIntExtra("index", 0)
        val phoneName=ap_edt_1.text
        val phoneInfo=ap_edt_2.text
        val type=PhoneTypeList.phoneTypeList[index]

        ap_btn.setOnClickListener {
            val phone=Phone("$type", "$phoneName", "$phoneInfo")
            PhoneList.phoneList.add(phone)
            finish()
        }
    }
}
