package com.gildedrose;

public class BackstageType implements ItemType {
    @Override
    public void updateExpired(Item item) {
        item.quality = 0;
    }

    @Override
    public void updateQuality(Item item) {
        incrementQuality(item);
        if (item.sellIn <= 10) {
            incrementQuality(item);
        }
        if (item.sellIn <= 5) {
            incrementQuality(item);
        }
    }

}
