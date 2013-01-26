package org.sevendroids.java.guildedrose;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.sevendroids.java.guildedrose.GildedRose;
import org.sevendroids.java.guildedrose.Item;

public class SulfurasItemTest {

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final int SELLIN_ZERO = 0;
    private static final int SELLIN_POSITIVE = 1;
    private static final int SELLIN_NEGATIVE = -1;
    private static final int QUALITY_ZERO = 0;
    private static final int QUALITY_MAXIMUM = 50;

    @Test
    public final void qualityShouldNotChangeIfSellInGT0() {
	Item item = new Item(SULFURAS, SELLIN_POSITIVE, QUALITY_ZERO);
	GildedRose gildedRose = new GildedRose(new Item[] { item });
	gildedRose.updateQuality();
	assertEquals(SELLIN_POSITIVE, item.sellIn);
	assertEquals(QUALITY_ZERO, item.quality);
    }

    @Test
    public final void qualityShouldNotChangeIfSellInEQ0() {
	Item item = new Item(SULFURAS, SELLIN_ZERO, QUALITY_ZERO);
	GildedRose gildedRose = new GildedRose(new Item[] { item });
	gildedRose.updateQuality();
	assertEquals(SELLIN_ZERO, item.sellIn);
	assertEquals(QUALITY_ZERO, item.quality);
    }

    @Test
    public final void qualityShouldNotChangeIfSellInLT0() {
	Item item = new Item(SULFURAS, SELLIN_NEGATIVE, QUALITY_MAXIMUM);
	GildedRose gildedRose = new GildedRose(new Item[] { item });
	gildedRose.updateQuality();
	assertEquals(SELLIN_NEGATIVE, item.sellIn);
	assertEquals(QUALITY_MAXIMUM, item.quality);
    }
}
