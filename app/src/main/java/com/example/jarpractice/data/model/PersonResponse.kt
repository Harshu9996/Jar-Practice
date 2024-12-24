package com.example.jarpractice.data.model

import com.example.jarpractice.domain.model.Person

data class PersonResponse(
    val name:String,
    val id:String,
    val rollNumber:String
){
    fun toPerson():Person{
        return Person(id=id,name=name, rollNumber = rollNumber)
    }
}
