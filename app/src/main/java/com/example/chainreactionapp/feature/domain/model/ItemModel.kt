package com.example.chainreactionapp.feature.domain.model

import com.google.gson.annotations.SerializedName

data class ItemModel(
    val createdAt: String? = null,
    val imageIds: List<String?>? = null,
    val imageUrls: List<String?>? = null,
    val imageUrlsThumbnails: List<String?>? = null,
    val name: String? = null,
    val price: String? = null,
    val uid: String? = null
)