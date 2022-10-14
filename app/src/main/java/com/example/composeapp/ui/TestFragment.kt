package com.example.composeapp.ui

import android.os.Bundle
import android.view.View
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.composeapp.R
import com.example.composeapp.UserCard

class TestFragment :Fragment(R.layout.test_fragment){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<ComposeView>(R.id.composeContainer).setContent {
            UserCard()
        }
    }
}