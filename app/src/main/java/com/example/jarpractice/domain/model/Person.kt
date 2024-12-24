package com.example.jarpractice.domain.model

import com.example.jarpractice.data.model.PersonResponse
import java.util.stream.IntStream

data class Person(
    val id:String,
    val name:String,
    val rollNumber:String
){
    fun toPersonResponse():PersonResponse{
        return PersonResponse(
            id = id,
            name = name,
            rollNumber = rollNumber
        )
    }
}
