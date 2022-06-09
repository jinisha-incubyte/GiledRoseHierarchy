package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    private void updateQualityAndAssert(GildedRose app, int expectedSellIn, int expectedQuality) {
        app.updateQuality();
        assertEquals(expectedSellIn, app.items[0].sellIn);
        assertEquals(expectedQuality, app.items[0].quality);
    }

    @Test
    public void foo() {
        GildedRose app = new GildedRose(new Item[] { new Item("foo", 2, 5)});
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void standardTypeTest() {
        GildedRose app = new GildedRose(new Item[] { new Item("Standard Item", 3, 3)});
        updateQualityAndAssert(app, 2, 2);  //Day1
        updateQualityAndAssert(app, 1, 1);  //Day2
    }

    @Test
    public void standardTypeTestDecreasesQualityByTwoIfSellInLessThanZero() {
        GildedRose app = new GildedRose(new Item[] { new Item("Standard Item", 2, 20)});
        updateQualityAndAssert(app, 1, 19);    //Day1
        updateQualityAndAssert(app, 0, 18);    //Day2
        updateQualityAndAssert(app, -1, 16);    //Day3
        updateQualityAndAssert(app, -2, 14);    //Day4
    }

    @Test
    public void standardTypeTestQualityNotLessThanZero() {
        GildedRose app = new GildedRose(new Item[] { new Item("Standard Item", 2, 1)});
        updateQualityAndAssert(app, 1, 0);  //Day1
        updateQualityAndAssert(app, 0, 0);  //Day2
    }

    @Test
    public void agedTypeTest(){
        GildedRose app = new GildedRose(new Item[] { new Item(GildedRose.AGED_BRIE, 3, 3)});
        updateQualityAndAssert(app, 2, 4);  //Day1
        updateQualityAndAssert(app, 1, 5);  //Day2
        updateQualityAndAssert(app, 0, 6);  //Day3
        updateQualityAndAssert(app, -1, 8);  //Day4
        updateQualityAndAssert(app, -2, 10);  //Day5
    }

    @Test
    public void agedTypeTestQualityIncreasesByTwoWhenBelowSellIn(){
        GildedRose app = new GildedRose(new Item[] { new Item(GildedRose.AGED_BRIE, 0, 3)});
        updateQualityAndAssert(app, -1, 5); //Day1
        updateQualityAndAssert(app, -2, 7); //Day2
    }

    @Test
    public void agedTypeQualityNotAboveFifty(){
        GildedRose app = new GildedRose(new Item[] { new Item(GildedRose.AGED_BRIE, 3, 47)});
        updateQualityAndAssert(app, 2, 48);  //Day1
        updateQualityAndAssert(app, 1, 49);  //Day2
        updateQualityAndAssert(app, 0, 50);  //Day3
        updateQualityAndAssert(app, -1, 50);  //Day4

    }

    @Test
    public void backstageTypeTestIncreasesQualityByTwoWhenIfSellInLessThanEleven(){
        GildedRose app = new GildedRose(new Item[] { new Item(GildedRose.BACKSTAGE_PASSES, 12, 3)});
        updateQualityAndAssert(app, 11, 4);  //Day1
        updateQualityAndAssert(app, 10, 6);  //Day2
        updateQualityAndAssert(app, 9, 8);  //Day3
        updateQualityAndAssert(app, 8, 10);  //Day4
        updateQualityAndAssert(app, 7, 12);  //Day5
        updateQualityAndAssert(app, 6, 14);  //Day6
    }

    @Test
    public void backstageTypeTestIncreasesQualityByThreeWhenIfSellInLessThanSix(){
        GildedRose app = new GildedRose(new Item[] { new Item(GildedRose.BACKSTAGE_PASSES, 7, 3)});
        updateQualityAndAssert(app, 6, 5);  //Day1
        updateQualityAndAssert(app, 5, 8);  //Day2
        updateQualityAndAssert(app, 4, 11);  //Day3
        updateQualityAndAssert(app, 3, 14);  //Day4
        updateQualityAndAssert(app, 2, 17);  //Day5
        updateQualityAndAssert(app, 1, 20);  //Day6
        updateQualityAndAssert(app, 0, 23);  //Day7
    }

    @Test
    public void backstageTypeTestQualityIsZeroWhenSellInIsComplete(){
        GildedRose app = new GildedRose(new Item[] { new Item(GildedRose.BACKSTAGE_PASSES, 2, 3)});
        updateQualityAndAssert(app, 1, 6);  //Day1
        updateQualityAndAssert(app, 0, 9);  //Day2
        updateQualityAndAssert(app, -1, 0);  //Day3
        updateQualityAndAssert(app, -2, 0);  //Day4
    }

    @Test
    public void backstageTypeTestCompleteFlow(){
        GildedRose app = new GildedRose(new Item[] { new Item(GildedRose.BACKSTAGE_PASSES, 12, 3)});
        updateQualityAndAssert(app, 11, 4);
        updateQualityAndAssert(app, 10, 6);
        updateQualityAndAssert(app, 9, 8);
        updateQualityAndAssert(app, 8, 10);
        updateQualityAndAssert(app, 7, 12);
        updateQualityAndAssert(app, 6, 14);
        updateQualityAndAssert(app, 5, 17);
        updateQualityAndAssert(app, 4, 20);
        updateQualityAndAssert(app, 3, 23);
        updateQualityAndAssert(app, 2, 26);
        updateQualityAndAssert(app, 1, 29);
        updateQualityAndAssert(app, 0, 32);
        updateQualityAndAssert(app, -1, 0);
    }

    @Test
    public void backstageTypeQualityNotAboveFifty(){
        GildedRose app = new GildedRose(new Item[] { new Item(GildedRose.BACKSTAGE_PASSES, 3, 47)});
        updateQualityAndAssert(app, 2, 50);
        updateQualityAndAssert(app, 1, 50);
        updateQualityAndAssert(app, 0, 50);
    }

    @Test
    public void legendaryTypeQualityAndSellInDoesNotChange(){
        GildedRose app = new GildedRose(new Item[] { new Item(GildedRose.SULFURAS, 3, 80)});
        updateQualityAndAssert(app, 3, 80);
    }

    @Test
    public void conjuredTypeTestQualityDecreasesByTwoWhenAboveSellIn(){
        GildedRose app = new GildedRose(new Item[] { new Item(GildedRose.CONJURED, 2, 10)});
        updateQualityAndAssert(app, 1, 8);
        updateQualityAndAssert(app, 0, 6);
    }

    @Test
    public void conjuredTypeTestQualityDecreasesByFourWhenBelowSellIn(){
        GildedRose app = new GildedRose(new Item[] { new Item(GildedRose.CONJURED, 0, 10)});
        updateQualityAndAssert(app, -1, 6);
        updateQualityAndAssert(app, -2, 2);
    }

    @Test
    public void conjuredTypeTestQualityNotBelowZero(){
        GildedRose app = new GildedRose(new Item[] { new Item(GildedRose.CONJURED, 0, 4)});
        updateQualityAndAssert(app, -1, 0);
        updateQualityAndAssert(app, -2, 0);
    }

    @Test
    public void conjuredTypeTestComplete(){
        GildedRose app = new GildedRose(new Item[] { new Item(GildedRose.CONJURED, 2, 10)});
        updateQualityAndAssert(app, 1, 8);
        updateQualityAndAssert(app, 0, 6);
        updateQualityAndAssert(app, -1, 2);
    }
}