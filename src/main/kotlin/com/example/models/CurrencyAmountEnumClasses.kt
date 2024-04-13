package com.example.models

enum class INRCurrencyEnum(val amount: Double) {
    INR(1.0),
    USD(0.012),
    EUR(0.011),
    AUSD(0.018),
    DIN(0.0037),
    YEN(1.84),
    DIR(0.044)
}

enum class USDCurrencyEnum(val amount: Double) {
    INR(83.61),
    USD(1.0),
    EUR(0.94),
    AUSD(1.54),
    DIN(0.31),
    YEN(153.28),
    DIR(3.67)
}

enum class EURCurrencyEnum(val amount: Double) {
    INR(89.23),
    USD(1.07),
    EUR(1.0),
    AUSD(1.64),
    DIN(0.33),
    YEN(163.57),
    DIR(3.92)
}

enum class DIRCurrencyEnum(val amount: Double) {
    INR(271.55),
    USD(3.25),
    EUR(2.04),
    AUSD(5.01),
    DIN(1.0),
    YEN(497.80),
    DIR(11.93)
}

enum class DINCurrencyEnum(val amount: Double) {
    INR(22.77),
    USD(0.27),
    EUR(0.26),
    AUSD(0.42),
    DIN(0.084),
    YEN(41.74),
    DIR(1.0)
}

enum class AUSDCurrencyEnum(val amount: Double) {
    INR(54.25),
    USD(0.65),
    EUR(0.61),
    AUSD(1.0),
    DIN(0.20),
    YEN(99.45),
    DIR(2.38)
}

enum class YENCurrencyEnum(val amount: Double) {
    INR(0.55),
    USD(0.0065),
    EUR(0.0061),
    AUSD(0.01),
    DIN(0.002),
    YEN(1.0),
    DIR(0.024)
}