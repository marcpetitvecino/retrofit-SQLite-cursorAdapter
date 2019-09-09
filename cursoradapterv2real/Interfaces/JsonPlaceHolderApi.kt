package com.example.cursoradapterv2real.Interfaces


import com.example.cursoradapterv2real.Model.Posts
import retrofit2.Call
import retrofit2.http.GET


interface JsonPlaceHolderApi {

    @GET("posts")
    fun getPosts(): Call<List<Posts>> // Creació de la funció getPosts, que retorna una llista d'objectes Posts

}
