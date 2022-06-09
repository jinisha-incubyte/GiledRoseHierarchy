package com.gildedrose;

public interface ItemType {
    void updateExpired(Item item);

    void updateQuality(Item item);

    default void updateSellIn(Item item){
        item.sellIn = item.sellIn - 1;
    }

    default void incrementQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
    default void decrementQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    default void updateItem(Item item) {
        updateSellIn(item);
        updateQuality(item);
        if (item.sellIn < 0) {
            updateExpired(item);
        }
    }
}
