package com.oguzdogdu.rickandmortypaging.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.oguzdogdu.rickandmortypaging.paging.RickyMortyPagingSource
import com.oguzdogdu.rickandmortypaging.service.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RickMortyViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {

    val listData = Pager(PagingConfig(pageSize = 20)) {
        RickyMortyPagingSource(apiService)
    }.flow.cachedIn(viewModelScope)
}