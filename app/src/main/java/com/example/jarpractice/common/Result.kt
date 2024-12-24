package com.example.jarpractice.common

sealed class Result<T>(data:T?=null, message:String?=null) {

    data class Success<T>(val data: T?): Result<T>(data = data)
    data class Failure<T>(val message: String?): Result<T>(message=message)
    class Loading<T>: Result<T>()

}