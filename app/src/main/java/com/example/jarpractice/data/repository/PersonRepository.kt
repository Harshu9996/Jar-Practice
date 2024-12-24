package com.example.jarpractice.data.repository

import android.app.Person
import com.example.jarpractice.data.model.PersonResponse
import retrofit2.Response

interface PersonRepository {


    suspend fun getPersonById(id:Int):Response<PersonResponse>

    suspend fun getAllPersons(): Response<List<PersonResponse>>



}