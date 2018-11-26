package me.digi.sdk.models

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import me.digi.sdk.models.finance.Amount
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class AmountTest {
    private lateinit var gson: Gson

    @Before
    fun setup() {
        gson = GsonBuilder().create()
    }

    @Test
    fun `test 01`() {
        val json = """
            {
                "amount": 12.34,
                "currency": "1234 Currency"
            }
        """.trimIndent()

        val expected = Amount(12.34F, "1234 Currency")

        val result = gson.fromJson<Amount>(json, Amount::class.java)

        Assert.assertEquals(expected, result)
    }
}