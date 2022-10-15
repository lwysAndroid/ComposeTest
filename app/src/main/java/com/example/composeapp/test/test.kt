package com.example.composeapp.test

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {

}

fun makeFlow() = flow {
    for (i in 0..10) {
        delay(200)
        emit(i)
    }
}