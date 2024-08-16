package com.yeshuwahane.basictemplete.presentation.tabs.taba

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.yeshuwahane.basictemplete.presentation.screens.DummyScreen


class TabAScreen :Screen {
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Header(
                paddingValues = PaddingValues(0.dp),
                text = "Tab A Screen",
                onMenuClick = {

                }
            )

        }

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

            TabAStatic {
                navigator.push(DummyScreen())
            }

        }
    }

    @Composable
    fun TabAStatic(onClick:()->Unit) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

            Button(
                onClick = {
                    onClick.invoke()
                }
            ){
                Text("Navigate to Dummy screen")
            }

        }
    }


    @Composable
    fun Header(paddingValues: PaddingValues, text: String, onMenuClick: () -> Unit) {
        Box(modifier = Modifier.fillMaxWidth().padding(paddingValues).background(Color.Black)) {
            IconButton(
                onClick = {
                    onMenuClick.invoke()
                },
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)
            ) {
                Icon(
                    Icons.Default.Menu, // Replace with your back icon
                    contentDescription = "Menu",
                    tint = Color.White
                )
            }

            // Display topbar name
            Text(
                text = text,
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}