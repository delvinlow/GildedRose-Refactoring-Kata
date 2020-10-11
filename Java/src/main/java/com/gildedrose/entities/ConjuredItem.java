package com.gildedrose.entities;

class ConjuredItem extends TypedItem {
    public ConjuredItem(Item item) {
        super(item.name, item.sellIn, item.quality);
    }

    public void updateQuality() {
        int decrementBy;
        if (this.sellIn < 0) {
            decrementBy = 4;
        } else {
            decrementBy = 2;
        }
        this.quality = Math.max(0, this.quality - decrementBy);
    }

    public void updateSellIn() {
        this.sellIn = this.sellIn - 1;
    }
}
