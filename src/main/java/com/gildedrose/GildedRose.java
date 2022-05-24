package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED = "Conjured";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(this.items).forEach(item -> {
            ItemType itemType = categorize(item);
            itemType.updateItem(item);
        });
    }

    private static ItemType categorize(Item item) {
        switch (item.name){
            case SULFURAS:
                return new SuldurasType();
            case BACKSTAGE_PASSES:
                return new BackstageType();
            case AGED_BRIE:
                return new AgedType();
            case CONJURED:
                return new ConjuredType();
            default:
                return new StandardType();
        }
    }
}