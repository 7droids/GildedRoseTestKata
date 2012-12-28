package de.sevendroids.java.guildedrose.testng;

import de.sevendroids.java.guildedrose.GildedRose;
import de.sevendroids.java.guildedrose.Item;

public abstract class GildedRoseTest {
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