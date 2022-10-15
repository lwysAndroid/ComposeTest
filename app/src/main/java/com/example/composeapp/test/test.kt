package com.example.composeapp.test

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {

    val myFlow = makeFlow()
        .flowOn(Dispatchers.IO)
        .catch {
//            throw it
            emit(-1)
        }
//        .filter { it % 2 == 0 }
//        .map { "Value is $it" }
//        .transform {
//            emit(it)
//            emit(it*it)
//        }
//        .toList()
//        .first()
//        .reduce()
        .collect { println(it) }

}

fun makeFlow() = flow {
    for (i in 0..10) {
        delay(200)
        println("fromFlow $i")
        emit(i)
    }
}