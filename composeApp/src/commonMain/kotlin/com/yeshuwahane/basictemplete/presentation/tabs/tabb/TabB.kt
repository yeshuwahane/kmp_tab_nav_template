package com.yeshuwahane.basictemplete.presentation.tabs.tabb

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions

object TabB:Tab {

    @Composable
    override fun Content() {
        Navigator(TabBScreen())
    }


    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(Icons.Default.Settings)
            val title = "TabB"
            val index: UShort = 1u
            return TabOptions(index, title, icon)
        }
}