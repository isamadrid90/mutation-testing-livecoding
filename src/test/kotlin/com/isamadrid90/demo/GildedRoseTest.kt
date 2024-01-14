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

    @Test
    fun `items should decrease quality twice as fast when the sellIn is 0`() {
        val itemList = mutableListOf(Item("Common", 0, 4))

        GildedRose(itemList).updateQuality()

        val expected = mutableListOf(Item("Common", -1, 2))
        assertEquals(expected, itemList)
    }

    @Test
    fun `aged brie quality should increases with time`() {
        val items = mutableListOf(Item("Aged Brie", 10, 20))

        GildedRose(items).updateQuality()

        val expected = mutableListOf(Item("Aged Brie", 9, 21))
        assertEquals(expected, items)
    }

    @Test
    fun `aged brie quality should not exceed 50`() {
        val items = mutableListOf(Item("Aged Brie", 10, 50))

        GildedRose(items).updateQuality()

        val expected = mutableListOf(Item("Aged Brie", 9, 50))
        assertEquals(expected, items)
    }

    @Test
    fun `aged brie quality should be increased regularly when sellIn is 1`() {
        val items = mutableListOf(Item("Aged Brie", 1, 33))

        GildedRose(items).updateQuality()

        val expected = mutableListOf(Item("Aged Brie", 0, 34))
        assertEquals(expected, items)
    }

    @Test
    fun `aged brie quality should increase twice as fast after sellIn`() {
        val items = mutableListOf(Item("Aged Brie", 0, 20))

        GildedRose(items).updateQuality()

        val expected = mutableListOf(Item("Aged Brie", -1, 22))
        assertEquals(expected, items)
    }
}
