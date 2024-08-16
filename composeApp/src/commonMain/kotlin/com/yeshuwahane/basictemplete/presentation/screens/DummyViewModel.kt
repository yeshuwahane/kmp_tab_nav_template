package com.yeshuwahane.basictemplete.presentation.screens

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class DummyViewModel() :ScreenModel {

   private val _uiState = MutableStateFlow("")
    val uiState = _uiState.asStateFlow()


    fun getText(){
        screenModelScope.launch {
            _uiState.update {
                "shinzou sasageyo"
            }
        }
    }



}