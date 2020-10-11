package com.gildedrose.entities;

public class TypedItem extends Item {
    public TypedItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
    }

    public void updateSellIn() {
        this.sellIn = this.sellIn - 1;
    }
}
