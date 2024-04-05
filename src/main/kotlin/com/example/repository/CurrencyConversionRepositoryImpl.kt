package com.example.repository

import com.example.models.ApiResponse
import com.example.models.CurrenciesEnum
import com.example.models.CurrencyData

class CurrencyConversionRepositoryImpl : CurrencyConversionRepository {
    override suspend fun convertCurrencyAmount(data: CurrencyData): ApiResponse {
        println("currency: ${data.conversionCurrency}")
        return when (data.conversionCurrency) {
            CurrenciesEnum.USD.name -> {
                ApiResponse(
                    success = true,
                    message = "OK",
                    convertedAmount = calculate(CurrenciesEnum.USD.amount, data.baseAmount)
                )
            }

            CurrenciesEnum.EUR.name -> {
                ApiResponse(
                    success = true,
                    message = "OK",
                    convertedAmount = calculate(CurrenciesEnum.EUR.amount, data.baseAmount)
                )
            }

            CurrenciesEnum.AUSD.name -> {
                ApiResponse(
                    success = true,
                    message = "OK",
                    convertedAmount = calculate(CurrenciesEnum.AUSD.amount, data.baseAmount)
                )
            }

            CurrenciesEnum.DIN.name -> {
                ApiResponse(
                    success = true,
                    message = "OK",
                    convertedAmount = calculate(CurrenciesEnum.DIN.amount, data.baseAmount)
                )
            }

            CurrenciesEnum.YEN.name -> {
                ApiResponse(
                    success = true,
                    message = "OK",
                    convertedAmount = calculate(CurrenciesEnum.YEN.amount, data.baseAmount)
                )
            }

            CurrenciesEnum.DIR.name -> {
                ApiResponse(
                    success = true,
                    message = "OK",
                    convertedAmount = calculate(CurrenciesEnum.DIR.amount, data.baseAmount)
                )

            }

            else -> {
                ApiResponse(
                    success = false,
                    message = "Unsupported Currency Type",
                    convertedAmount = 0.0
                )
            }
        }
    }

    private fun calculate(currencyAmount: Double, baseAmount: Double): Double {
        return currencyAmount * baseAmount
    }
}