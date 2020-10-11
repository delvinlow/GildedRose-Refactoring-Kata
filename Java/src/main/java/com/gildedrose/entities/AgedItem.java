package com.gildedrose.entities;

public class AgedItem extends TypedItem {
    public AgedItem(Item item) {
        super(item.name, item.sellIn, item.quality);
    }

    public void updateQuality() {
        this.quality = Math.min(50, this.quality + 1);
    }
}
