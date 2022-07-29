package com.abdurashidov.phoneapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abdurashidov.phoneapp.models.MySharedPreference
import com.abdurashidov.phoneapp.ui.AddPhoneTypes
import com.abdurashidov.phoneapp.ui.AddPhoneTypesGet
import com.abdurashidov.phoneapp.ui.Phones
import com.abdurashidov.phoneapp.utils.PhoneList
import com.abdurashidov.phoneapp.utils.PhoneTypeList
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add_phone_types.setOnClickListener {
            val intent=Intent(this, AddPhoneTypesGet::class.java)
            startActivity(intent)
        }

        add_phone_card.setOnClickListener {
            val intent=Intent(this, AddPhoneTypes::class.java)
            startActivity(intent)
        }

        phones_card.setOnClickListener {
            val intent=Intent(this, Phones::class.java)
            startActivity(intent)
        }

        MySharedPreference.init(this)
        PhoneList.phoneList=MySharedPreference.listPhone
        PhoneTypeList.phoneTypeList=MySharedPreference.listType

    }


    override fun onRestart() {
        super.onRestart()
        MySharedPreference.listPhone=PhoneList.phoneList
        MySharedPreference.listType=PhoneTypeList.phoneTypeList
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}