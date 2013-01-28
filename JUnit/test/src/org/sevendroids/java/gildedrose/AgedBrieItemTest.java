package org.sevendroids.java.gildedrose;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.sevendroids.java.gildedrose.GildedRose;
import org.sevendroids.java.gildedrose.Item;

public class AgedBrieItemTest {

	private static final String AGED_BRIE = "Aged Brie";
	private static final int SELLIN_ZERO = 0;
	private static final int SELLIN_POSITIVE = 1;
	private static final int SELLIN_NEGATIVE = -1;
	private static final int QUALITY_MEDIUM = 30;
	private static final int QUALITY_MAXIMUM = 50;

	@Test
	public final void qualityShouldIncreaseBy1IfSellInGT0() {
		Item agedBrie = new Item(AGED_BRIE, SELLIN_POSITIVE, QUALITY_MEDIUM);
		GildedRose gildedRose = new GildedRose(new Item[] { agedBrie });
		gildedRose.updateQuality();
		assertEquals(QUALITY_MEDIUM + 1, agedBrie.quality);
		assertEquals(SELLIN_ZERO, agedBrie.sellIn);
	}

	@Test
	public final void qualityShouldIncreaseBy2IfSellInLT0() {
		Item agedBrie = new Item(AGED_BRIE, SELLIN_ZERO, QUALITY_MEDIUM);
		GildedRose gildedRose = new GildedRose(new Item[] { agedBrie });
		gildedRose.updateQuality();
		assertEquals(QUALITY_MEDIUM + 2, agedBrie.quality);
		assertEquals(SELLIN_NEGATIVE, agedBrie.sellIn);
	}

	@Test
	public final void qualityShouldNotBeOver50IfSellInGT0() {
		Item agedBrie = new Item(AGED_BRIE, SELLIN_POSITIVE, QUALITY_MAXIMUM);
		GildedRose gildedRose = new GildedRose(new Item[] { agedBrie });
		gildedRose.updateQuality();
		assertEquals(QUALITY_MAXIMUM, agedBrie.quality);
		assertEquals(SELLIN_ZERO, agedBrie.sellIn);
	}

	@Test
	public final void qualityShouldNotBeOver50IfSellInLT0() {
		Item agedBrie = new Item(AGED_BRIE, SELLIN_ZERO, QUALITY_MAXIMUM);
		GildedRose gildedRose = new GildedRose(new Item[] { agedBrie });
		gildedRose.updateQuality();
		assertEquals(QUALITY_MAXIMUM, agedBrie.quality);
		assertEquals(SELLIN_NEGATIVE, agedBrie.sellIn);
	}
}
