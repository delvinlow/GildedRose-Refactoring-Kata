package com.gildedrose;

import com.gildedrose.entities.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void shouldDecrementQualityAndSellInByOneDailyForOrdinaryItem() {
        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("+5 Dexterity Vest", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(19, app.items[0].quality);
    }

    @Test
    void shouldDecrementQualityByTwoDailyAfterSellInDateForOrdinaryItems() {
        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", -10, 10),
                new Item("Elixir of the Mongoose", 0, 7)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("+5 Dexterity Vest", app.items[0].name);
        assertEquals(-11, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);

        assertEquals("Elixir of the Mongoose", app.items[1].name);
        assertEquals(-1, app.items[1].sellIn);
        assertEquals(5, app.items[1].quality);
    }

    @Test
    void shouldNotDecrementQualityBeyondZeroForItem() {
        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", -10, 0),
                new Item("Elixir of the Mongoose", 0, 1)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("+5 Dexterity Vest", app.items[0].name);
        assertEquals(-11, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);

        assertEquals("Elixir of the Mongoose", app.items[1].name);
        assertEquals(-1, app.items[1].sellIn);
        assertEquals(0, app.items[1].quality);
    }

    @Test
    void shouldNotDecrementQualityBeyondZeroForItems() {
        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", -10, 0),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("+5 Dexterity Vest", app.items[0].name);
        assertEquals(-11, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
        assertEquals(-1, app.items[1].sellIn);
        assertEquals(0, app.items[1].quality);
    }

    @Test
    void shouldIncrementQualityByOneForAgedBrieDaily() {
        Item[] items = new Item[]{
                new Item("Aged Brie", 2, 0),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void shouldNotIncrementQualityBeyondFiftyForItem() {
        Item[] items = new Item[]{
                new Item("Aged Brie", 10, 50),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void shouldNotChangeLegendaryItemSellInAndQuality() {
        Item[] items = new Item[]{
                new Item("Sulfuras, Hand of Ragnaros", 10, 80),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(10, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void shouldIncreaseQualityOfBackstagePassesByTwoWhenSellInIsBetween6To10Days() {
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 6, 10),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(22, app.items[0].quality);

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
        assertEquals(5, app.items[1].sellIn);
        assertEquals(12, app.items[1].quality);
    }

    @Test
    void shouldIncreaseQualityOfBackstagePassesByThreeWhenSellInIsFiveDaysOrLess() {
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 1, 10),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(23, app.items[0].quality);

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
        assertEquals(0, app.items[1].sellIn);
        assertEquals(13, app.items[1].quality);
    }

    @Test
    void shouldDropQualityOfBackstagePassesToZeroAfterConcert() {
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
        assertEquals(-1, app.items[1].sellIn);
        assertEquals(0, app.items[1].quality);
    }
}
