package com.isamadrid90.demo

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GildedRoseTest {
    @Test
    fun `common items should decrease 1 sellIn and 1 quality at the end of each day`() {
        val itemList = mutableListOf(Item("Common", 2, 4))
        GildedRose(itemList).updateQuality()

        val expected = mutableListOf(Item("Common", 1, 3))
        assertEquals(expected, itemList)
    }
}
