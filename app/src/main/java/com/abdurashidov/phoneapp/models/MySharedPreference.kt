package com.abdurashidov.phoneapp.models

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object MySharedPreference {

    private const val NAME = "PhoneLists"
    private const val MODE = Context.MODE_PRIVATE

    private lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var listPhone: ArrayList<Phone>
        get() = stringToList(preferences.getString("listPhone", "[]")!!)
        set(value) = preferences.edit {
            if (value != null) {
                it.putString("listPhone", listToString(value))
            }
        }


    fun stringToList(str:String):ArrayList<Phone>{
        val gson = Gson()
        val list = ArrayList<Phone>()
        val type = object : TypeToken<ArrayList<Phone>>(){}.type
        list.addAll(gson.fromJson(str, type))

        return list
    }

    fun listToString(list: ArrayList<Phone>):String{
        return Gson().toJson(list)
    }



    var listType: ArrayList<String>
        get() = stringToList2(preferences.getString("listType", "[]")!!)
        set(value) = preferences.edit {
            if (value != null) {
                it.putString("listType", listToString2(value))
            }
        }

    fun stringToList2(str:String):ArrayList<String>{
        val gson = Gson()
        val list = ArrayList<String>()

        val type = object : TypeToken<ArrayList<String>>(){}.type
        list.addAll(gson.fromJson(str, type))

        return list
    }
    fun listToString2(list: ArrayList<String>):String{
        return Gson().toJson(list)
    }


}