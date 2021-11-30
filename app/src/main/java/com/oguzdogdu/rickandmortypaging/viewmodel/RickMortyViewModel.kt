package com.oguzdogdu.rickandmortypaging.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.oguzdogdu.rickandmortypaging.model.RickMortyModel
import com.oguzdogdu.rickandmortypaging.repo.RickRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class RickMortyViewModel @Inject constructor(private val repository: RickRepository) : ViewModel() {

    fun getFileStream(): Flow<PagingData<RickMortyModel>> {
        return repository.getList().cachedIn(viewModelScope)
    }
    /*
    val listData = Pager(PagingConfig(pageSize = 20)) {
        RickyMortyPagingSource(apiService)
    }.flow.cachedIn(viewModelScope)

     */
}