package com.gildedrose.entities;

class OrdinaryItem extends TypedItem {
    public OrdinaryItem(Item item) {
        super(item.name, item.sellIn, item.quality);
    }

    public void updateQuality() {
        int decrementBy;
        if (this.sellIn < 0) {
            decrementBy = 2;
        } else {
            decrementBy = 1;
        }
        this.quality = Math.max(0, this.quality - decrementBy);
    }

    public void updateSellIn() {
        this.sellIn = this.sellIn - 1;
    }
}
