package com.yeshuwahane.basictemplete.di

import com.yeshuwahane.basictemplete.presentation.screens.DummyViewModel
import org.koin.dsl.module


fun commonModule () = module {

    single {
        DummyViewModel()
    }
}