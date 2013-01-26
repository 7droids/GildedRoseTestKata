package org.sevendroids.java.gildedrose;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.sevendroids.java.gildedrose.GildedRose;
import org.sevendroids.java.gildedrose.Item;

public class NormalItemTest {

    private static final int SELLIN_POSITIVE = 1;
    private static final int SELLIN_ZERO = 0;
    private static final int SELLIN_NEGATIVE = -1;
    private static final int QUALITY_MAXIMUM = 50;
    private static final int QUALITY_ZERO = 0;

    @Test
    public final void qualityAndSellInShouldDecreaseBy1IfSellInGT0() {
	Item item = new Item("Normal", SELLIN_POSITIVE, QUALITY_MAXIMUM);
	GildedRose gildedRose = new GildedRose(new Item[] { item });
	gildedRose.updateQuality();
	assertEquals(49, item.quality);
	assertEquals(SELLIN_ZERO, item.sellIn);
    }

    @Test
    public final void qualityShouldDecreaseBy2IfSellInLT0() {
	Item item = new Item("Normal", SELLIN_ZERO, QUALITY_MAXIMUM);
	GildedRose gildedRose = new GildedRose(new Item[] { item });
	gildedRose.updateQuality();
	assertEquals(48, item.quality);
	assertEquals(SELLIN_NEGATIVE, item.sellIn);
    }

    @Test
    public final void qualityShouldNeverLT0By1IfSellInGT0() {
	Item item = new Item("Normal", SELLIN_POSITIVE, QUALITY_ZERO);
	GildedRose gildedRose = new GildedRose(new Item[] { item });
	gildedRose.updateQuality();
	assertEquals(QUALITY_ZERO, item.quality);
	assertEquals(SELLIN_ZERO, item.sellIn);
    }

    @Test
    public final void qualityShouldNeverLT0By1IfSellInLT0() {
	Item item = new Item("Normal", SELLIN_ZERO, QUALITY_ZERO);
	GildedRose gildedRose = new GildedRose(new Item[] { item });
	gildedRose.updateQuality();
	assertEquals(QUALITY_ZERO, item.quality);
	assertEquals(SELLIN_NEGATIVE, item.sellIn);
    }
}
