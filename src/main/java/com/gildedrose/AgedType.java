package com.gildedrose;

public class AgedType implements ItemType {

    @Override
    public void updateExpired(Item item) {
        incrementQuality(item);
    }

    @Override
    public void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    @Override
    public void updateQuality(Item item) {
        incrementQuality(item);
    }
}
