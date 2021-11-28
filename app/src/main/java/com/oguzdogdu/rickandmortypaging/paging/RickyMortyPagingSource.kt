package com.oguzdogdu.rickandmortypaging.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.oguzdogdu.rickandmortypaging.model.RickMortyModel
import com.oguzdogdu.rickandmortypaging.service.ApiService

class RickyMortyPagingSource(
    private val apiService: ApiService
) : PagingSource<Int, RickMortyModel>() {


    override fun getRefreshKey(state: PagingState<Int, RickMortyModel>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>):
            LoadResult<Int, RickMortyModel> {

        return try {
            val currentPage = params.key ?: 1
            val response = apiService.getAllCharacters(currentPage)
            val responseData = mutableListOf<RickMortyModel>()
            val data = response.body()?.results ?: emptyList()
            responseData.addAll(data)

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
