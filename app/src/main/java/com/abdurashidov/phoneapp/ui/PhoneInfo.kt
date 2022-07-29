package com.abdurashidov.phoneapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abdurashidov.phoneapp.R
import com.abdurashidov.phoneapp.models.Phone
import com.abdurashidov.phoneapp.utils.PhoneList
import com.abdurashidov.phoneapp.utils.PhoneTypeList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_phone_info.*
import java.util.ArrayList

class PhoneInfo : AppCompatActivity() {
    lateinit var listOutput:ArrayList<Phone>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_info)

        listOutput= ArrayList()
        val index=intent.getIntExtra("index", 0)
        val list1=intent.getStringExtra("list")
        val type=object : TypeToken<ArrayList<Phone>>(){}.type
        listOutput=Gson().fromJson(list1, type)

        pi_name.text=listOutput[index].phoneName
        pi_tv.text=listOutput[index].phoneInfo

    }
}