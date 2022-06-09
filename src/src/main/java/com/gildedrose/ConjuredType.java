package com.gildedrose;

public class ConjuredType implements ItemType {

    @Override
    public void updateExpired(Item item) {
        decrementQuality(item);
        decrementQuality(item);
    }

    @Override
    public void updateQuality(Item item) {
        decrementQuality(item);
        decrementQuality(item);
    }
}
