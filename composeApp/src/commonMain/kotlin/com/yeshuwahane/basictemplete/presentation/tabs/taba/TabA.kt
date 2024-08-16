package com.yeshuwahane.basictemplete.presentation.tabs.taba

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions


object TabA:Tab {

    @Composable
    override fun Content() {
        Navigator(TabAScreen())
    }

    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(Icons.Default.Home)
            val title = "TabA"
            val index: UShort = 0u
            return TabOptions(index, title, icon)
        }
}