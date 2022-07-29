package com.abdurashidov.phoneapp.models

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.abdurashidov.phoneapp.R
import kotlinx.android.synthetic.main.item_1.view.*
import kotlinx.android.synthetic.main.item_2.view.*

class MyAdapterType2 (val list:ArrayList<String>, context: Context):
    ArrayAdapter<String>(context, R.layout.item_2, list){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var itemView: View
        if (convertView==null){
            itemView= LayoutInflater.from(context).inflate(R.layout.item_2, parent, false)
        }else{
            itemView=convertView
        }

        itemView.item_text2.text=list[position]

        return itemView
    }
}