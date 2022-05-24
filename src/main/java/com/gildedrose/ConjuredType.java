package com.gildedrose;

public class ConjuredType implements ItemType {

    @Override
    public void updateExpired(Item item) {
        decrementQuality(item);
        decrementQuality(item);
    }

    @Override
    public void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    @Override
    public void updateQuality(Item item) {
        decrementQuality(item);
        decrementQuality(item);
    }
}
