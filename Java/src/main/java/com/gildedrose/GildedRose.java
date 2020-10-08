package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items; // ! Do not change
    }

    public void updateQuality() {
        // TODO items.forEach(item -> item.updateQuality(); item.updateSellIn()). Internally calls setQuality

        // TODO Use a factory method and switch on to item.name to initialize the Item of the right type
        for (int i = 0; i < items.length; i++) {
            // If not Age Brie or Backstage passes
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) { // If not Sulfuras
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else { // Otherwise if Aged Brie or Backstage pass
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    // If  Backstage passes, special update
                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            // If not Sulfuras, decrease sell in
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            // If over sell in
            if (items[i].sellIn < 0) {
                // If not Aged Brie
                if (!items[i].name.equals("Aged Brie")) {
                    // If not Backstage passes
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else { // If is Backstage Pass
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else { // If is Aged Brie
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}