package com.example.repository

import com.example.models.*

class CurrencyConversionRepositoryImpl : CurrencyConversionRepository {
    override suspend fun convertAmount(data: CurrencyData): ApiResponse {
        val conversionRates = mapOf(
            Pair(
                SupportedCurrenciesEnum.INR.name,
                mapOf(
                    INRCurrencyEnum.INR.name to INRCurrencyEnum.INR.amount,
                    INRCurrencyEnum.USD.name to INRCurrencyEnum.USD.amount,
                    INRCurrencyEnum.EUR.name to INRCurrencyEnum.EUR.amount,
                    INRCurrencyEnum.AUSD.name to INRCurrencyEnum.AUSD.amount,
                    INRCurrencyEnum.DIN.name to INRCurrencyEnum.DIN.amount,
                    INRCurrencyEnum.DIR.name to INRCurrencyEnum.DIR.amount,
                    INRCurrencyEnum.YEN.name to INRCurrencyEnum.YEN.amount
                )
            ),
            Pair(
                SupportedCurrenciesEnum.USD.name,
                mapOf(
                    USDCurrencyEnum.USD.name to USDCurrencyEnum.USD.amount,
                    USDCurrencyEnum.INR.name to USDCurrencyEnum.INR.amount,
                    USDCurrencyEnum.EUR.name to USDCurrencyEnum.EUR.amount,
                    USDCurrencyEnum.AUSD.name to USDCurrencyEnum.AUSD.amount,
                    USDCurrencyEnum.DIN.name to USDCurrencyEnum.DIN.amount,
                    USDCurrencyEnum.DIR.name to USDCurrencyEnum.DIR.amount,
                    USDCurrencyEnum.YEN.name to USDCurrencyEnum.YEN.amount
                )
            ),
            Pair(
                SupportedCurrenciesEnum.EUR.name,
                mapOf(
                    EURCurrencyEnum.USD.name to EURCurrencyEnum.USD.amount,
                    EURCurrencyEnum.INR.name to EURCurrencyEnum.INR.amount,
                    EURCurrencyEnum.EUR.name to EURCurrencyEnum.EUR.amount,
                    EURCurrencyEnum.AUSD.name to EURCurrencyEnum.AUSD.amount,
                    EURCurrencyEnum.DIN.name to EURCurrencyEnum.DIN.amount,
                    EURCurrencyEnum.DIR.name to EURCurrencyEnum.DIR.amount,
                    EURCurrencyEnum.YEN.name to EURCurrencyEnum.YEN.amount
                )
            ),
            Pair(
                SupportedCurrenciesEnum.DIN.name,
                mapOf(
                    DINCurrencyEnum.USD.name to DINCurrencyEnum.USD.amount,
                    DINCurrencyEnum.INR.name to DINCurrencyEnum.INR.amount,
                    DINCurrencyEnum.EUR.name to DINCurrencyEnum.EUR.amount,
                    DINCurrencyEnum.AUSD.name to DINCurrencyEnum.AUSD.amount,
                    DINCurrencyEnum.DIN.name to DINCurrencyEnum.DIN.amount,
                    DINCurrencyEnum.DIR.name to DINCurrencyEnum.DIR.amount,
                    DINCurrencyEnum.YEN.name to DINCurrencyEnum.YEN.amount
                )
            ),
            Pair(
                SupportedCurrenciesEnum.DIR.name,
                mapOf(
                    DIRCurrencyEnum.USD.name to DIRCurrencyEnum.USD.amount,
                    DIRCurrencyEnum.INR.name to DIRCurrencyEnum.INR.amount,
                    DIRCurrencyEnum.EUR.name to DIRCurrencyEnum.EUR.amount,
                    DIRCurrencyEnum.AUSD.name to DIRCurrencyEnum.AUSD.amount,
                    DIRCurrencyEnum.DIN.name to DIRCurrencyEnum.DIN.amount,
                    DIRCurrencyEnum.DIR.name to DIRCurrencyEnum.DIR.amount,
                    DIRCurrencyEnum.YEN.name to DIRCurrencyEnum.YEN.amount
                )
            ),
            Pair(
                SupportedCurrenciesEnum.AUSD.name,
                mapOf(
                    AUSDCurrencyEnum.USD.name to AUSDCurrencyEnum.USD.amount,
                    AUSDCurrencyEnum.INR.name to AUSDCurrencyEnum.INR.amount,
                    AUSDCurrencyEnum.EUR.name to AUSDCurrencyEnum.EUR.amount,
                    AUSDCurrencyEnum.AUSD.name to AUSDCurrencyEnum.AUSD.amount,
                    AUSDCurrencyEnum.DIN.name to AUSDCurrencyEnum.DIN.amount,
                    AUSDCurrencyEnum.DIR.name to AUSDCurrencyEnum.DIR.amount,
                    AUSDCurrencyEnum.YEN.name to AUSDCurrencyEnum.YEN.amount
                )
            ),
            Pair(
                SupportedCurrenciesEnum.YEN.name,
                mapOf(
                    YENCurrencyEnum.USD.name to YENCurrencyEnum.USD.amount,
                    YENCurrencyEnum.INR.name to YENCurrencyEnum.INR.amount,
                    YENCurrencyEnum.EUR.name to YENCurrencyEnum.EUR.amount,
                    YENCurrencyEnum.AUSD.name to YENCurrencyEnum.AUSD.amount,
                    YENCurrencyEnum.DIN.name to YENCurrencyEnum.DIN.amount,
                    YENCurrencyEnum.DIR.name to YENCurrencyEnum.DIR.amount,
                    YENCurrencyEnum.YEN.name to YENCurrencyEnum.YEN.amount
                )
            )
        )

        return if (!conversionRates.containsKey(data.baseCurrency) || !conversionRates[data.baseCurrency]!!.containsKey(
                data.conversionCurrency
            )
        ) {
            ApiResponse(
                success = false,
                message = "Unsupported Currency Type",
                convertedAmount = 0.0
            )
        } else {
            ApiResponse(
                success = true,
                message = "OK",
                convertedAmount = calculate(
                    conversionRates[data.baseCurrency]!![data.conversionCurrency]!!,
                    data.baseAmount
                )
            )
        }
    }

    private fun calculate(currencyAmount: Double, baseAmount: Double): Double {
        return currencyAmount * baseAmount
    }
}