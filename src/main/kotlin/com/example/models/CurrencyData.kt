package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class CurrencyData(
    val conversionCurrency: String,
    val baseAmount: Double
)
