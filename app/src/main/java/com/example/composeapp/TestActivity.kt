package com.example.composeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.composeapp.ui.TestFragment

class TestActivity :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainer,TestFragment())
            .commit()
    }
}