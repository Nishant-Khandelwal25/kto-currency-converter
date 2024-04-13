package com.example.repository

import com.example.models.ApiResponse
import com.example.models.CurrencyData

interface CurrencyConversionRepository {
    suspend fun convertAmount(data: CurrencyData): ApiResponse
}