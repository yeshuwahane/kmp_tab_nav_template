package com.yeshuwahane.basictemplete

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.ui.tooling.preview.Preview

import cafe.adriel.voyager.navigator.Navigator
import com.yeshuwahane.basictemplete.di.appModule
import com.yeshuwahane.basictemplete.presentation.tabs.tabsetup.TabViewSetup
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App() {

    KoinApplication(
        application = {
            modules(appModule())
        }
    ){
        MaterialTheme {
            Scaffold { paddingValues ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .background(Color.Black)
                        .statusBarsPadding()
                        .navigationBarsPadding()
                        .windowInsetsPadding(WindowInsets.safeDrawing)
                        .windowInsetsPadding(WindowInsets.systemBars)
                ){
                    Navigator(TabViewSetup())

                }

            }
        }


    }

}