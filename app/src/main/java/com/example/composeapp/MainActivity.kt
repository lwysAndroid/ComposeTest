package com.example.composeapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            CounterView()
//            MainContent()
            UsedInComposeXml()
        }
    }
}

@Composable
fun UsedInComposeXml(){
    AndroidView(
        factory = {context->
                  View.inflate(context,R.layout.used_in_compose,null)
        },
        modifier = Modifier.fillMaxSize(),
        update = {view->
            val usedInComposeButton = view.findViewById<Button>(R.id.usedInComposeButton)
            val usedInComposeText = view.findViewById<TextView>(R.id.usedInComposeText)

            usedInComposeButton.setOnClickListener {
                val random  = Math.random()
                usedInComposeText.text = "The value has changed for this ${random}"
            }


        }
    )
}

@Composable
fun CounterView() {
    val counterValue = remember { mutableStateOf(1) }

    Box(modifier = Modifier.fillMaxSize()) {
        Text(modifier = Modifier
            .padding(12.dp)
            .align(Alignment.TopCenter),
            fontSize = 32.sp,
            color = Color.Blue,
            fontFamily = FontFamily.Monospace,
            text = "Counter: ${counterValue.value}")
        Button(
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.BottomCenter),
            onClick = {
                counterValue.value = counterValue.value + 1
            }) {
            Text(text = "Add One")

        }
    }
}

data class User(val id: Int = 1)

@Composable
fun MainContent() {
    val users = remember { mutableStateListOf(User(1)) }
    Box(modifier = Modifier.fillMaxSize()) {
        UserList(users)
        Button(
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.BottomCenter),
            onClick = {
                users.add(User(1))
            }) {
            Text(text = "Add More")
        }

    }

}

@Composable
fun UserList(userList:List<User>) {
    LazyColumn{
        items(userList) { user->
            UserCard()
        }
    }
}

@Composable
fun UserCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(12.dp)
            .border(1.dp, color = Color.Gray)
            .padding(12.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape),
        )

        Column {
            Text(text = stringResource(id = R.string.dummy_text))
            Button(onClick = { /*
            perform button click action here
            */ }) {
                Text(text = "View Profile")
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun ShowPreview(){
    Surface(modifier = Modifier.fillMaxSize()) {
        MainContent()
    }

}