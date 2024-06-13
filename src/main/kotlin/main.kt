package ru.netology

fun main() {
    val transferAmount = 10000.0
    val cardType = "Maestro"
    val isUKRayTransfer = false

    val commission = calculateCommission(transferAmount, cardType, isUKRayTransfer)
    println("Комиссия за перевод: $commission рублей")
}

fun calculateCommission(transferAmount: Double, cardType: String, isUKRayTransfer: Boolean): Double {
    val commissionRate = when (cardType) {
        "Maestro" -> if (transferAmount in 1000.0..75000.0) 0.0 else 0.08
        "Visa" -> if (isUKRayTransfer) 0.0 else 0.75
        else -> throw IllegalArgumentException("Unsupported card type: $cardType")
    }

    return transferAmount * commissionRate / 100
}