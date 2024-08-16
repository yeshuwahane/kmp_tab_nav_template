package com.yeshuwahane.basictemplete.presentation.tabs.tabsetup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.yeshuwahane.basictemplete.presentation.tabs.taba.TabA
import com.yeshuwahane.basictemplete.presentation.tabs.tabb.TabB


class TabViewSetup :Screen{
    @Composable
    override fun Content() {
        TabView()
    }
}


@Composable
fun TabView() {
    val snackbarHostState = remember { SnackbarHostState() }

    TabNavigator(TabA){
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                BottomNavigation(

                ){
                    tabItems(TabA)
                    tabItems(TabB)
                    //Add new Tabs here
                }
            },
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState)
            }
        ) {paddingValues ->
            Box(modifier = Modifier.fillMaxSize().padding(paddingValues), contentAlignment = Alignment.Center) {
                CurrentTab()
            }

        }
    }
}

@Composable
fun RowScope.tabItems(tab: Tab) {

    val navigator = LocalTabNavigator.current
    BottomNavigationItem(
        selected = navigator.current == tab,
        onClick = {
            navigator.current = tab
        },
        icon = {
            tab.options.icon?.let { painter ->
                Icon(painter, contentDescription = tab.options.title)
            }
        },
        modifier = Modifier
            .statusBarsPadding()
            .background(Color.Black),
        selectedContentColor = Color.Green,
        unselectedContentColor = Color.White
    )
}