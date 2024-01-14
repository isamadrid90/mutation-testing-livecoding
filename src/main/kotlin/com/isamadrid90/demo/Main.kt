package com.isamadrid90.demo

// fun main() {
//    val i =
//        mutableListOf(
//            Item("Aged Brie", 10, 20),
//            Item("Sulfuras, Hand of Ragnaros", 5, 80),
//            Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
//            Item("Common Item", 5, 10),
//        )
//
//    val g = GildedRose(i)
//
//    repeat(1) { g.updateQuality() }
//
//    i.forEach { println("${it.nameame}: sellIn=${it.sellIn}, quality=${it.quality}") }
// }

fun main() {
    val items =
        mutableListOf(
            Item("Aged Brie", 10, 20),
            Item("Sulfuras, Hand of Ragnaros", 5, 80),
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            Item("Conjured", 3, 6),
            Item("Common Item", 5, 10),
        )

    val gildedRose = GildedRose(items)

    println("Initial state:")
    items.forEach { println("${it.name}: sellIn=${it.sellIn}, quality=${it.quality}") }

    repeat(5) {
        gildedRose.updateQuality()
        println("\nDay ${it + 1} state:")
        items.forEach { println("${it.name}: sellIn=${it.sellIn}, quality=${it.quality}") }
    }
}
