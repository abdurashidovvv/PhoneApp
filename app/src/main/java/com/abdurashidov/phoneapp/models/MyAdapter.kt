package com.abdurashidov.phoneapp.models

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.abdurashidov.phoneapp.R
import kotlinx.android.synthetic.main.item_1.view.*

class MyAdapter (val list:ArrayList<Phone>, context: Context):
    ArrayAdapter<Phone>(context, R.layout.item_1, list){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var itemView: View
        if (convertView==null){
            itemView= LayoutInflater.from(context).inflate(R.layout.item_1, parent, false)
        }else{
            itemView=convertView
        }

        itemView.item_text.text=list[position].phoneName

        return itemView
    }
}