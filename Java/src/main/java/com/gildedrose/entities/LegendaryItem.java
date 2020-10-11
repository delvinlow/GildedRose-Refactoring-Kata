package com.gildedrose.entities;

public class LegendaryItem extends TypedItem {
    public LegendaryItem(Item item) {
        super(item.name, item.sellIn, item.quality);
    }

    public void updateQuality() {
    }

    public void updateSellIn() {
    }
}
