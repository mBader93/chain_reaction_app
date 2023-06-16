package com.example.chainreactionapp.feature.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "home")
data class HomeResponseModel(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @SerializedName("results")
    val resultItemsList: List<ItemResponseModel>? = null
)