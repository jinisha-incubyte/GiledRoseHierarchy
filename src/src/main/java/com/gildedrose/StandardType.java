package com.gildedrose;

public class StandardType implements ItemType {
    @Override
    public void updateExpired(Item item) {
        decrementQuality(item);
    }

    @Override
    public void updateQuality(Item item) {
        decrementQuality(item);
    }
}
