package com.abdurashidov.phoneapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.abdurashidov.phoneapp.R
import com.abdurashidov.phoneapp.models.MyAdapter
import com.abdurashidov.phoneapp.models.MyAdapterType
import com.abdurashidov.phoneapp.models.MyAdapterType2
import com.abdurashidov.phoneapp.utils.PhoneTypeList
import kotlinx.android.synthetic.main.activity_phones.*

class Phones : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phones)

        val list=PhoneTypeList.phoneTypeList
        val adapter=MyAdapterType2(list,this)
        p_grid_view.adapter=adapter

        p_grid_view.setOnItemClickListener { parent, view, position, id ->
            val intent=Intent(this, PhoneInfoList::class.java)
            intent.putExtra("index", position)
            startActivity(intent)
        }
    }
}