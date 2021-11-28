package com.oguzdogdu.rickandmortypaging.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.oguzdogdu.rickandmortypaging.model.RickMortyModel
import com.oguzdogdu.rickandmortypaging.paging.RickyMortyPagingSource
import com.oguzdogdu.rickandmortypaging.service.ApiService
import com.oguzdogdu.rickandmortypaging.utils.Constants.PAGE_ITEM_LIMIT
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RickRepository @Inject constructor(private val apiService: ApiService) {

    fun getList(): Flow<PagingData<RickMortyModel>> {
        return Pager(
            config = PagingConfig(pageSize = PAGE_ITEM_LIMIT, enablePlaceholders = false),
            pagingSourceFactory = { RickyMortyPagingSource(apiService) }
        ).flow
    }
}