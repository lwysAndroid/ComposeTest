package com.example.composeapp.test

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val listGenerated = flowGenerator().flowOn(Dispatchers.IO)
        .collect {print("$it, ")  }
//    listGenerated.forEach { print("$it, ") }
}


fun flowGenerator(): Flow<Int> = flow {
    val integersList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println("list generated")
    while (true) {
        integersList.forEach {
            delay(1500)
            emit(it)
        }
        integersList.shuffled()
        println()
    }
}