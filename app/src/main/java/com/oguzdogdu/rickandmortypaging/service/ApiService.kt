package com.oguzdogdu.rickandmortypaging.service

import com.oguzdogdu.rickandmortypaging.model.ResponseApi
import com.oguzdogdu.rickandmortypaging.model.RickMortyModel
import com.oguzdogdu.rickandmortypaging.utils.Constants.END_POINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(END_POINT)
    suspend fun getAllCharacters(@Query("page") page : Int) : Response<ResponseApi>
}