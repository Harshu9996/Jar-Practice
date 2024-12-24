package com.example.jarpractice.domain.usecases

import com.example.jarpractice.common.Result
import com.example.jarpractice.data.repository.PersonRepository
import com.example.jarpractice.domain.model.Person
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetAllPersonUseCase(
    private val repository: PersonRepository
) {

    operator fun invoke(): Flow<Result<List<Person>>> = flow {

        emit(Result.Loading<List<Person>>())

        val personsResponse = repository.getAllPersons()
        if(personsResponse.isSuccessful){
            personsResponse.body()?.let {it->
                val personList = it.map {personData->
                    personData.toPerson()
                }
                emit(Result.Success(data = personList))

            }
        }else{
            emit(Result.Failure(message = personsResponse.message()))
        }

    }


}