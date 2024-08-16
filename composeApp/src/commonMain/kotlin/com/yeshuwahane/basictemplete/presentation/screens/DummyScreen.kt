package com.yeshuwahane.basictemplete.presentation.screens

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class DummyScreen() : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        val viewModel = getScreenModel<DummyViewModel>()

        val uiState = viewModel.uiState.collectAsState()



        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Header(
                paddingValues = PaddingValues(0.dp),
                text = "Dummy Screen",
                onBackClick = {
                    navigator.pop()
                }
            )

            DummyStatic(
                onClick = {
                    viewModel.getText()
                },
                dummyText = uiState.value
            )

        }


    }


    @Composable
    fun DummyStatic(onClick: () -> Unit, dummyText: String) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(dummyText, textAlign = TextAlign.Center, fontSize = 32.sp)

            Button(
                onClick = {
                    onClick.invoke()
                }
            ) {
                Text("Get Text from viewModel")
            }


        }

    }

    @Composable
    fun Header(paddingValues: PaddingValues, text: String, onBackClick: () -> Unit) {
        Box(modifier = Modifier.fillMaxWidth().padding(paddingValues).background(Color.Black)) {
            IconButton(
                onClick = {
                    onBackClick.invoke()
                },
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)
            ) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack, // Replace with your back icon
                    contentDescription = "Back",
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