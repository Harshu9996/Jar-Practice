package com.example.jarpractice.data.repository

import com.example.jarpractice.data.model.PersonResponse
import com.example.jarpractice.data.remote.ApiService
import retrofit2.Response

class PersonRepositoryImpl(
    val apiService:ApiService
):PersonRepository {
    override suspend fun getPersonById(id: Int): Response<PersonResponse> {
        return apiService.getPersonById(id)
    }

    override suspend fun getAllPersons(): Response<List<PersonResponse>> {
        return apiService.getAllPerson()
    }
}