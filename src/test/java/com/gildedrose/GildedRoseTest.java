package com.gildedrose;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void foo() {
        GildedRose app = new GildedRose(new Item[] { new Item("foo", 2, 5)});
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void standardTypeTest() {
        GildedRose app = new GildedRose(new Item[] { new Item("Standard Item", 3, 3)});

        //Day1
        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
        //Day2
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    public void standardTypeTestDecreasesQualityByTwoIfSellInLessThanZero() {
        GildedRose app = new GildedRose(new Item[] { new Item("Standard Item", 2, 20)});

        //Day1
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(19, app.items[0].quality);
        //Day2
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(18, app.items[0].quality);
        //Day3
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(16, app.items[0].quality);
        //Day4
        app.updateQuality();
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(14, app.items[0].quality);
    }

    @Test
    public void standardTypeTestQualityNotLessThanZero() {
        GildedRose app = new GildedRose(new Item[] { new Item("Standard Item", 2, 1)});
        //Day1
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
        //Day3
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void agedTypeTest(){
        GildedRose app = new GildedRose(new Item[] { new Item(GildedRose.AGED_BRIE, 3, 3)});

        //Day1
        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
        //Day2
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(5, app.items[0].quality);
        //Day3
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
        //Day4
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
        //Day5
        app.updateQuality();
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(10, app.items[0].quality);
    }

    @Test
    public void agedTypeTestQualityIncreasesByTwoWhenBelowSellIn(){
        GildedRose app = new GildedRose(new Item[] { new Item(GildedRose.AGED_BRIE, 0, 3)});

        //Day1
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(5, app.items[0].quality);
        //Day2
        app.updateQuality();
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(7, app.items[0].quality);
    }

    @Test
    public void agedTypeQualityNotAboveFifty(){
        GildedRose app = new GildedRose(new Item[] { new Item(GildedRose.AGED_BRIE, 3, 47)});

        //Day1
        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
        assertEquals(48, app.items[0].quality);
        //Day2
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(49, app.items[0].quality);
        //Day3
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
        //Day4
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);

    }

    @Test
    public void backstageTypeTestIncreasesQualityByTwoWhenIfSellInLessThanEleven(){
        GildedRose app = new GildedRose(new Item[] { new Item(GildedRose.BACKSTAGE_PASSES, 12, 3)});

        //Day1
        app.updateQuality();
        assertEquals(11, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
        //Day2
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
        //Day3
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
        //Day4
        app.updateQuality();
        assertEquals(8, app.items[0].sellIn);
        assertEquals(10, app.items[0].quality);
        //Day5
        app.updateQuality();
        assertEquals(7, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
        //Day6
        app.updateQuality();
        assertEquals(6, app.items[0].sellIn);
        assertEquals(14, app.items[0].quality);
    }

    @Test
    public void backstageTypeTestIncreasesQualityByThreeWhenIfSellInLessThanSix(){
        GildedRose app = new GildedRose(new Item[] { new Item(GildedRose.BACKSTAGE_PASSES, 7, 3)});

        //Day1
        app.updateQuality();
        assertEquals(6, app.items[0].sellIn);
        assertEquals(5, app.items[0].quality);
        //Day2
        app.updateQuality();
        assertEquals(5, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
        //Day3
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
        //Day4
        app.updateQuality();
        assertEquals(3, app.items[0].sellIn);
        assertEquals(14, app.items[0].quality);
        //Day5
        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
        assertEquals(17, app.items[0].quality);
        //Day6
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(20, app.items[0].quality);
        //Day7
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(23, app.items[0].quality);
    }

    @Test
    public void backstageTypeTestQualityIsZeroWhenSellInIsComplete(){
        GildedRose app = new GildedRose(new Item[] { new Item(GildedRose.BACKSTAGE_PASSES, 2, 3)});

        //Day1
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
        //Day2
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
        //Day3
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
        //Day4
        app.updateQuality();
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void backstageTypeTestCompleteFlow(){
        GildedRose app = new GildedRose(new Item[] { new Item(GildedRose.BACKSTAGE_PASSES, 12, 3)});

        //Day1
        app.updateQuality();
        assertEquals(11, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
        //Day2
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
        //Day3
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
        //Day4
        app.updateQuality();
        assertEquals(8, app.items[0].sellIn);
        assertEquals(10, app.items[0].quality);
        //Day5
        app.updateQuality();
        assertEquals(7, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
        //Day6
        app.updateQuality();
        assertEquals(6, app.items[0].sellIn);
        assertEquals(14, app.items[0].quality);
        //Day7
        app.updateQuality();
        assertEquals(5, app.items[0].sellIn);
        assertEquals(17, app.items[0].quality);
        //Day8
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(20, app.items[0].quality);
        //Day9
        app.updateQuality();
        assertEquals(3, app.items[0].sellIn);
        assertEquals(23, app.items[0].quality);
        //Day10
        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
        assertEquals(26, app.items[0].quality);
        //Day11
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(29, app.items[0].quality);
        //Day12
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(32, app.items[0].quality);
        //Day13
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void backstageTypeQualityNotAboveFifty(){
        GildedRose app = new GildedRose(new Item[] { new Item(GildedRose.BACKSTAGE_PASSES, 3, 47)});

        //Day1
        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
        //Day2
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
        //Day3
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);

    }

    @Test
    public void legendaryTypeQualityAndSellInDoesNotChange(){
        GildedRose app = new GildedRose(new Item[] { new Item(GildedRose.SULFURAS, 3, 80)});
        //Day1
        app.updateQuality();
        assertEquals(3, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    public void conjuredTypeTestQualityDecreasesByTwoWhenAboveSellIn(){
        GildedRose app = new GildedRose(new Item[] { new Item(GildedRose.CONJURED, 2, 10)});

        //Day1
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
        //Day2
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }

    @Test
    public void conjuredTypeTestQualityDecreasesByFourWhenBelowSellIn(){
        GildedRose app = new GildedRose(new Item[] { new Item(GildedRose.CONJURED, 0, 10)});

        //Day1
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
        //Day2
        app.updateQuality();
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void conjuredTypeTestQualityNotBelowZero(){
        GildedRose app = new GildedRose(new Item[] { new Item(GildedRose.CONJURED, 0, 4)});

        //Day1
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
        //Day2
        app.updateQuality();
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void conjuredTypeTestComplete(){
        GildedRose app = new GildedRose(new Item[] { new Item(GildedRose.CONJURED, 2, 10)});

        //Day1
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
        //Day2
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
        //Day3
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }
}