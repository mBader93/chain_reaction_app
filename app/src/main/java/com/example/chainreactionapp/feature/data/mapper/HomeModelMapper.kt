package com.example.chainreactionapp.feature.data.mapper

import com.example.chainreactionapp.feature.data.model.HomeResponseModel
import com.example.chainreactionapp.feature.domain.model.HomeModel
import com.example.chainreactionapp.helper.MapperHelper
import javax.inject.Inject

internal class HomeModelMapper @Inject constructor(
    private val itemMapper: ItemModelMapper
) : MapperHelper<HomeResponseModel, HomeModel>() {
    override fun map(source: HomeResponseModel): HomeModel {
        return HomeModel(
            itemsList = source.resultItemsList?.let { itemMapper.mapList(it) }
        )
    }
}