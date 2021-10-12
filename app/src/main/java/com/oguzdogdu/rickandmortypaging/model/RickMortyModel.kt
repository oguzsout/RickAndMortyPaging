package com.oguzdogdu.rickandmortypaging.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RickMortyModel(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) : Parcelable