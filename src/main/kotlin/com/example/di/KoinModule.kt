package com.example.di

import com.example.repository.CurrencyConversionRepository
import com.example.repository.CurrencyConversionRepositoryImpl
import org.koin.dsl.module

val koinModule = module {
    single<CurrencyConversionRepository> {
        CurrencyConversionRepositoryImpl()
    }
}