package com.oguzdogdu.rickandmortypaging.repo

import androidx.paging.PagingData
import com.oguzdogdu.rickandmortypaging.model.RickMortyModel
import kotlinx.coroutines.flow.Flow

interface RickRepoInterface {
    fun getList(): Flow<PagingData<RickMortyModel>>
}