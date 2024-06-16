package ru.netology

import org.junit.Assert.assertEquals
import org.junit.Test



class MainKtTest {


    @Test
    fun `calculateCommission for Maestro card with transfer amount within range`() {
        val transferAmount = 10000.0
        val cardType = "Maestro"
        val isUKRayTransfer = false

        val commission = calculateCommission(transferAmount, cardType, isUKRayTransfer)

        assertEquals(1.0, commission, 0.0)
    }
    @Test
    fun `calculateCommission for Maestro card with transfer amount outside range`() {
        val transferAmount = 100000.0
        val cardType = "Maestro"
        val isUKRayTransfer = false

        val commission = calculateCommission(transferAmount, cardType, isUKRayTransfer)

        assertEquals(80.0, commission, 0.0)
    }


    @Test
    fun `calculateCommission for Visa card`() {
        val transferAmount = 10000.0
        val cardType = "Visa"
        val isUKRayTransfer = false

        val commission = calculateCommission(transferAmount, cardType, isUKRayTransfer)

        assertEquals(75.0, commission, 0.0)
    }

    @Test
    fun `calculateCommission for UK Ray transfer`() {
        val transferAmount = 10000.0
        val cardType = "Visa"
        val isUKRayTransfer = true

        val commission = calculateCommission(transferAmount, cardType, isUKRayTransfer)

        assertEquals(0.0, commission, 0.0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `calculateCommission for unknown card type`() {
        val transferAmount = 10000.0
        val cardType = "UnknownCard"
        val isUKRayTransfer = false

        calculateCommission(transferAmount, cardType, isUKRayTransfer)
    }
}
