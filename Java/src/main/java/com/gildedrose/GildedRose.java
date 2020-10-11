package com.gildedrose;

import com.gildedrose.entities.*;

import java.util.ArrayList;
import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    // This improved method needs not change even if more products have to be added in future
    public void updateQuality() {
        ArrayList<Item> updatedItems = new ArrayList<Item>();
        Arrays.stream(this.items).forEach(item -> {
            TypedItem typedItem = TypedItemFactory.createItem(item);
            typedItem.updateSellIn();
            typedItem.updateQuality();
            updatedItems.add(typedItem);
        });
        this.items = updatedItems.toArray(new Item[0]);
    }
}