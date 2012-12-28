package de.sevendroids.java.guildedrose;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import de.sevendroids.java.guildedrose.Item;

@Test(groups = "Unit")
public class SulfurasTest extends GildedRoseTest {
    public final void qualityShouldNotIncreaseOver50() {
	int quality = 50;
	Item sulfuras = createItem(1, quality);
	updateQuality(sulfuras);
	assertEquals(sulfuras.quality, quality);
    }

    public final void qualityShouldNotIncrease() {
	int quality = 49;
	Item sulfuras = createItem(1, quality);
	updateQuality(sulfuras);
	assertEquals(sulfuras.quality, quality);
    }

    public final void qualityShouldNotDecrease() {
	Item sulfuras = createItem(1, 1);
	updateQuality(sulfuras);
	assertEquals(sulfuras.quality, 1);
    }

    public final void sellInShouldNotIncrease() {
	int quality = 49;
	int sellIn = 1;
	Item sulfuras = createItem(sellIn, quality);
	updateQuality(sulfuras);
	assertEquals(sulfuras.sellIn, sellIn);
    }

    public final void sellInShouldNotDecrease() {
	int sellIn = -1;
	Item sulfuras = createItem(sellIn, 1);
	updateQuality(sulfuras);
	assertEquals(sulfuras.sellIn, sellIn);
    }

    /**
     * Here is an error in the implementation. During creation of the item it is
     * not checked whether the quality is negative. So for Sulfuras the quality
     * can start negative and still be negative after an update.
     */
    @Test(enabled = false)
    public final void qualityShouldNeverBeNegative() {
	Item agedBrie = createItem(-2, 1);
	updateQuality(agedBrie);
	assertEquals(agedBrie.quality, 0);
    }

    @Test(dataProvider = "createItems")
    public final void sellInShouldNotChange(Item sulfuras) {
	int oldSellIn = sulfuras.sellIn;
	updateQuality(sulfuras);
	assertEquals(sulfuras.sellIn, oldSellIn);
    }

    /**
     * Create different versions of Items to check that "update" is not changing
     * anything
     * 
     * @return Item list
     */
    @DataProvider(name = "createItems")
    protected final Item[][] createItems() {
	return new Item[][] { { createItem(0, 0) }, { createItem(1, 0) },
		{ createItem(0, 49) }, { createItem(1, 49) },
		{ createItem(0, 50) }, { createItem(1, 50) },

	};
    }

    @Override
    protected String getItemName() {
	return "Sulfuras, Hand of Ragnaros";
    }
}
