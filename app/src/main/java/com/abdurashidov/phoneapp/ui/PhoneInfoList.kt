package com.abdurashidov.phoneapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.abdurashidov.phoneapp.R
import com.abdurashidov.phoneapp.models.MyAdapter
import com.abdurashidov.phoneapp.models.Phone
import com.abdurashidov.phoneapp.utils.PhoneList
import com.abdurashidov.phoneapp.utils.PhoneTypeList
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_phone_info_list.*

class PhoneInfoList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_info_list)

        val index=intent.getIntExtra("index", 0)
        val type= PhoneTypeList.phoneTypeList[index]
        val list= PhoneList.phoneList
        val outputList=ArrayList<Phone>()
        for (i in 0 until list.size){
            if (list[i].phoneType==type){
                outputList.add(list[i])
            }
        }

        apil_toolbar.text=type

        val adapter=MyAdapter(outputList, this)
        pil_list_view.adapter=adapter
        val gson= Gson()

        pil_list_view.setOnItemClickListener { parent, view, position, id ->
            val intent= Intent(this, PhoneInfo::class.java)
            intent.putExtra("index", position)
            intent.putExtra("list", Gson().toJson(outputList))
            startActivity(intent)
        }
    }
}