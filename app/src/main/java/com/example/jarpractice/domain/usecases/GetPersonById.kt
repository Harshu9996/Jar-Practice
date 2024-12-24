package com.example.jarpractice.domain.usecases

import com.example.jarpractice.common.Result
import com.example.jarpractice.data.repository.PersonRepository
import com.example.jarpractice.domain.model.Person
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetPersonById(
    private val repository: PersonRepository
) {

    suspend operator fun invoke(id:Int): Flow<Result<Person>> = flow {

        emit(Result.Loading())

        val personResponse = repository.getPersonById(id)

        if(personResponse.isSuccessful){
            val person = personResponse.body()?.toPerson()
            person?.let {it->
                emit(Result.Success(data = it))
            }
        }else{
            emit(Result.Failure(message = personResponse.message()))

        }

    }

}