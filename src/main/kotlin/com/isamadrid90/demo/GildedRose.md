package com.isamadrid90.demo

data class Item(val name: String, var sellIn: Int, var quality: Int)

class GildedRose(private val items: MutableList<Item>) {

    fun updateQuality() {
        for (item in items) {
            when {
                item.name == "Aged Brie" -> updateAgedBrie(item)
                item.name == "Sulfuras, Hand of Ragnaros" -> updateSulfuras(item)
                item.name == "Backstage passes to a TAFKAL80ETC concert" -> updateBackstagePasses(item)
                item.name == "Conjured" -> updateConjured(item)
                else -> updateCommonItem(item)
            }
        }
    }

    private fun updateAgedBrie(item: Item) {
        decreaseSellIn(item)
        increaseQuality(item)
    }

    private fun updateSulfuras(item: Item) {
        // Sulfuras never changes
    }

    private fun updateBackstagePasses(item: Item) {
        decreaseSellIn(item)

        when {
            item.sellIn > 10 -> increaseQuality(item)
            item.sellIn in 6..10 -> increaseQuality(item, 2)
            item.sellIn in 1..5 -> increaseQuality(item, 3)
            else -> item.quality = 0
        }
    }

    private fun updateConjured(item: Item) {
        decreaseSellIn(item)
        decreaseQuality(item, 2)
    }

    private fun updateCommonItem(item: Item) {
        decreaseSellIn(item)
        decreaseQuality(item)
        if (item.sellIn < 0) {
            decreaseQuality(item)
        }
    }

    private fun decreaseSellIn(item: Item) {
        item.sellIn--
    }

    private fun increaseQuality(item: Item, amount: Int = 1) {
        if (item.quality + amount <= 50) {
            item.quality += amount
        }
    }

    private fun decreaseQuality(item: Item, amount: Int = 1) {
        if (item.quality - amount >= 0) {
            item.quality -= amount
        }
    }
}

fun main() {
    // Example usage
    val items = mutableListOf(
        Item("Aged Brie", 10, 20),
        Item("Sulfuras, Hand of Ragnaros", 5, 80),
        Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        Item("Conjured", 3, 6),
        Item("Common Item", 5, 10)
    )

    val gildedRose = GildedRose(items)

    // Update the quality for a certain number of days (e.g., 1 day)
    repeat(1) {
        gildedRose.updateQuality()
    }

    // Print the updated items
    for (item in items) {
        println("${item.name}: sellIn=${item.sellIn}, quality=${item.quality}")
    }
}
