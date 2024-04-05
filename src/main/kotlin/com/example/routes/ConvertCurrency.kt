package com.example.routes

import com.example.models.CurrencyData
import com.example.repository.CurrencyConversionRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.convertCurrency() {
    val currencyRepository: CurrencyConversionRepository by inject()

    get("/convertcurrency") {
        val conversionCurrency = call.request.queryParameters["conversionCurrency"].orEmpty()
        val amount = call.request.queryParameters["amount"]?.toDouble() ?: 0.0

        val conversionCurrencyData = CurrencyData(conversionCurrency = conversionCurrency, baseAmount = amount)

        val apiResponse = currencyRepository.convertCurrencyAmount(conversionCurrencyData)
        if (apiResponse.success)
            call.respond(message = apiResponse, status = HttpStatusCode.OK)
        else
            call.respond(message = apiResponse, status = HttpStatusCode.UnprocessableEntity)
    }
}