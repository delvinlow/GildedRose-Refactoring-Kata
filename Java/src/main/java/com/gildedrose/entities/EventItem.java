package com.gildedrose.entities;

public class EventItem extends TypedItem {
    public EventItem(Item item) {
        super(item.name, item.sellIn, item.quality);
    }

    public void updateQuality() {
        if (sellIn < 0) {
            this.quality = 0;
        } else if (sellIn < 5) {
            this.quality = Math.max(0, this.quality + 3);
        } else if (sellIn < 10) {
            this.quality = Math.max(0, this.quality + 2);
        }
    }
}
