package com.isamadrid90.demo

data class Item(var name: String, var sellIn: Int, var quality: Int)

class GildedRose(var itemList: MutableList<Item>) {
    fun updateQuality() =
        itemList.forEach {
            when {
                it.name == "Aged Brie" -> {
                    it.sellIn--
                    it.quality = updateQualityAgedBrie(it)
                }
                it.name == "Sulfuras, Hand of Ragnaros" -> {
                    it.sellIn = it.sellIn
                    it.quality = it.quality
                }
                it.name == "Backstage passes" -> {
                    it.sellIn--
                    it.quality +=
                        when {
                            it.sellIn > 10 -> 1
                            it.sellIn in 6..10 -> 2
                            it.sellIn in 1..5 -> 3
                            else -> -it.quality
                        }
                }
                else -> {
                    it.sellIn--
                    it.quality = if (it.quality > 0) it.quality - 1 - calculateDailyQualityUpdate(it) else it.quality
                }
            }
        }

    private fun updateQualityAgedBrie(it: Item) =
        if (it.quality < 50) {
            it.quality + 1 + calculateDailyQualityUpdate(it)
        } else {
            it.quality
        }

    private fun calculateDailyQualityUpdate(it: Item) =
        if (it.sellIn < 0) {
            1
        } else {
            0
        }
}
