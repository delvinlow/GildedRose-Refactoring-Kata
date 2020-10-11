package com.gildedrose.entities;

public class TypedItemFactory {
    public static TypedItem createItem(Item item) {
        TypedItem typedItem;
        switch (item.name) {
            case "Aged Brie":
                typedItem = new AgedItem(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                typedItem = new EventItem(item);
                break;
            case "Sulfuras, Hand of Ragnaros":
                typedItem = new LegendaryItem(item);
                break;
            case "Conjured Mana Cake":
                typedItem = new ConjuredItem(item);
                break;
            default:
                typedItem = new OrdinaryItem(item);
        }
        return typedItem;
    }
}
