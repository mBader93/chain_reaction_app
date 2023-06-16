package com.example.chainreactionapp.database.converters

import androidx.room.TypeConverter
import com.example.chainreactionapp.feature.data.model.HomeResponseModel
import com.example.chainreactionapp.feature.domain.HomeRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HomeDataConverter {

    private val gson = Gson()

    @TypeConverter
    fun stringToHomeData(data: String?): HomeResponseModel? {
        if (data.isNullOrEmpty()) {
            return null
        }
        return gson.fromJson(data, object : TypeToken<HomeResponseModel>() {}.type)
    }

    @TypeConverter
    fun homeDataToString(someObjects: HomeResponseModel?): String =
        gson.toJson(someObjects)

}