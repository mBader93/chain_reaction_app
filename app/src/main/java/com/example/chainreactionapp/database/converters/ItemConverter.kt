package com.example.chainreactionapp.database.converters

import androidx.room.TypeConverter
import com.example.chainreactionapp.feature.data.model.ItemResponseModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ItemConverter {

    private val gson = Gson()

    @TypeConverter
    fun stringToItem(data: String?): List<ItemResponseModel> {
        if (data.isNullOrEmpty()) {
            return emptyList()
        }
        return gson.fromJson(data, object : TypeToken<List<ItemResponseModel>>() {}.type)
    }

    @TypeConverter
    fun itemToString(someObjects: List<ItemResponseModel>): String =
        gson.toJson(someObjects)
}