package com.example.jarpractice.data.remote

import com.example.jarpractice.data.model.PersonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/person")
    suspend fun getPersonById(@Query("personId") personId:Int):Response<PersonResponse>

    @GET("/allPerson")
    suspend fun getAllPerson() : Response<List<PersonResponse>>


}