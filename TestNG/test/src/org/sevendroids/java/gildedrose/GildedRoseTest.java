package org.sevendroids.java.gildedrose;

import org.sevendroids.java.gildedrose.GildedRose;
import org.sevendroids.java.gildedrose.Item;


public abstract class GildedRoseTest {
    protected static final int SELLIN_POSITIVE = 1;
    protected static final int SELLIN_ZERO = 0;
    protected static final int SELLIN_NEGATIVE = -1;
    protected static final int QUALITY_ZERO = 0;
    protected static final int QUALITY_MAXIMUM = 50;

    protected void updateQuality(Item item) {
	GildedRose gildedRose;
	gildedRose = new GildedRose(new Item[] { item });
	gildedRose.updateQuality();
    }

    protected Item createItem(int sellIn, int quality) {
	return new Item(getItemName(), sellIn, quality);
    }

    protected abstract String getItemName();
}