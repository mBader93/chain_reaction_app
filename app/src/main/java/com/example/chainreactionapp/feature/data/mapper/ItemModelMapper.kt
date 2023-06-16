package com.example.chainreactionapp.feature.data.mapper

import com.example.chainreactionapp.feature.data.model.ItemResponseModel
import com.example.chainreactionapp.feature.domain.model.ItemModel
import com.example.chainreactionapp.helper.MapperHelper
import javax.inject.Inject

internal class ItemModelMapper @Inject constructor() : MapperHelper<ItemResponseModel, ItemModel>() {
    override fun map(source: ItemResponseModel): ItemModel {
        return ItemModel(
            name = source.name,
            uid = source.uid,
            imageIds = source.imageIds,
            imageUrls = source.imageUrls,
            imageUrlsThumbnails = source.imageUrlsThumbnails,
            price = source.price,
            createdAt = source.createdAt
        )
    }
}