package org.sevendroids.java.guildedrose;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.sevendroids.java.guildedrose.GildedRose;
import org.sevendroids.java.guildedrose.Item;

public class BackstageItemTest {

    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";

    @Test
    public final void qualityIncreaseBy1IfSellInGT11() {
	Item item = new Item(BACKSTAGE, 11, 30);
	GildedRose gildedRose = new GildedRose(new Item[] { item });
	gildedRose.updateQuality();
	assertEquals(10, item.sellIn);
	assertEquals(31, item.quality);
    }

    @Test
    public final void qualityNotIncreaseBy1IfSellInGT11AndQualityGE50() {
	Item item = new Item(BACKSTAGE, 11, 49);
	GildedRose gildedRose = new GildedRose(new Item[] { item });
	gildedRose.updateQuality();
	assertEquals(10, item.sellIn);
	assertEquals(50, item.quality);
    }

    @Test
    public final void qualityIncreaseBy2IfSellInLT11() {
	Item item = new Item(BACKSTAGE, 10, 30);
	GildedRose gildedRose = new GildedRose(new Item[] { item });
	gildedRose.updateQuality();
	assertEquals(9, item.sellIn);
	assertEquals(32, item.quality);
    }

    @Test
    public final void qualityNotIncreaseBy2IfSellInLT11AndQualityGE50() {
	Item item = new Item(BACKSTAGE, 10, 49);
	GildedRose gildedRose = new GildedRose(new Item[] { item });
	gildedRose.updateQuality();
	assertEquals(9, item.sellIn);
	assertEquals(50, item.quality);
    }

    @Test
    public final void qualityIncreaseBy2IfSellInGT5() {
	Item item = new Item(BACKSTAGE, 6, 30);
	GildedRose gildedRose = new GildedRose(new Item[] { item });
	gildedRose.updateQuality();
	assertEquals(5, item.sellIn);
	assertEquals(32, item.quality);
    }

    @Test
    public final void qualityNotIncreaseBy2IfSellInGT5AndQualityGE50() {
	Item item = new Item(BACKSTAGE, 6, 49);
	GildedRose gildedRose = new GildedRose(new Item[] { item });
	gildedRose.updateQuality();
	assertEquals(5, item.sellIn);
	assertEquals(50, item.quality);
    }

    @Test
    public final void qualityIncreaseBy3IfSellInLE5() {
	Item item = new Item(BACKSTAGE, 5, 30);
	GildedRose gildedRose = new GildedRose(new Item[] { item });
	gildedRose.updateQuality();
	assertEquals(4, item.sellIn);
	assertEquals(33, item.quality);
    }

    @Test
    public final void qualityNotIncreaseBy3IfSellInLE5AndQualityGE50() {
	Item item = new Item(BACKSTAGE, 5, 49);
	GildedRose gildedRose = new GildedRose(new Item[] { item });
	gildedRose.updateQuality();
	assertEquals(4, item.sellIn);
	assertEquals(50, item.quality);
    }

    @Test
    public final void qualityEQ0IfSellInLE0() {
	Item item = new Item(BACKSTAGE, 0, 30);
	GildedRose gildedRose = new GildedRose(new Item[] { item });
	gildedRose.updateQuality();
	assertEquals(-1, item.sellIn);
	assertEquals(0, item.quality);
    }
}
