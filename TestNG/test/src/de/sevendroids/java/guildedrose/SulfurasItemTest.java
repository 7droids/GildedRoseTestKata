package de.sevendroids.java.guildedrose;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = "Unit")
public class SulfurasItemTest extends GildedRoseTest {
    public final void qualityShouldNotIncreaseOver50() {
	Item sulfuras = createItem(SELLIN_POSITIVE, QUALITY_MAXIMUM);
	updateQuality(sulfuras);
	assertEquals(sulfuras.quality, QUALITY_MAXIMUM);
    }

    public final void qualityShouldNotIncrease() {
	int quality = 49;
	Item sulfuras = createItem(SELLIN_POSITIVE, quality);
	updateQuality(sulfuras);
	assertEquals(sulfuras.quality, quality);
    }

    public final void qualityShouldNotDecrease() {
	Item sulfuras = createItem(SELLIN_POSITIVE, 1);
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
	assertEquals(agedBrie.quality, QUALITY_ZERO);
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
	return new Item[][] { { createItem(SELLIN_ZERO, QUALITY_ZERO) },
		{ createItem(SELLIN_POSITIVE, QUALITY_ZERO) },
		{ createItem(SELLIN_ZERO, 49) },
		{ createItem(SELLIN_POSITIVE, 49) },
		{ createItem(SELLIN_ZERO, QUALITY_MAXIMUM) },
		{ createItem(SELLIN_POSITIVE, QUALITY_MAXIMUM) },

	};
    }

    @Override
    protected String getItemName() {
	return "Sulfuras, Hand of Ragnaros";
    }
}
