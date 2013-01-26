/**
 * 
 */
package org.sevendroids.java.gildedrose;

import static org.testng.Assert.assertEquals;

import org.sevendroids.java.gildedrose.Item;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author 7droids.de (FA)
 * 
 */
@Test(groups = "Unit")
public class AgedBrieItemTest extends GildedRoseTest {

    public final void qualityShouldNotIncreaseOver50() {
	Item agedBrie = createItem(SELLIN_POSITIVE, QUALITY_MAXIMUM);
	updateQuality(agedBrie);
	assertEquals(agedBrie.quality, QUALITY_MAXIMUM);
    }

    @Test(dataProvider = "createItemToIncrease")
    public final void qualityShouldIncreaseByOne(String testCaseDesc,
	    Item agedBrie) {
	int oldQuality = agedBrie.quality;
	updateQuality(agedBrie);
	assertEquals(agedBrie.quality, oldQuality + 1, testCaseDesc);
    }

    @DataProvider(name = "createItemToIncrease")
    protected final Object[][] createItemToIncrease() {
	return new Object[][] {
		{ "sellIn < 0", createItem(SELLIN_NEGATIVE, 49) },
		{ "sellIn = 0", createItem(SELLIN_ZERO, 49) },
		{ "sellIn > 0", createItem(SELLIN_POSITIVE, 49) }, };
    }

    public final void qualityShouldIncreaseByTwoIfSellInLT0() {
	Item agedBrie = createItem(SELLIN_NEGATIVE, 47);
	updateQuality(agedBrie);
	assertEquals(agedBrie.quality, 49);
    }

    /**
     * Here is an error in the implementation. During creation of the item it is
     * not checked whether the quality is negative. So for aged brie the quality
     * can start negative and still be negative after an update.
     */
    @Test(enabled = false)
    public final void qualityShouldNeverBeNegative() {
	Item agedBrie = createItem(-2, 1);
	updateQuality(agedBrie);
	assertEquals(agedBrie.quality, SELLIN_ZERO);
    }

    public final void sellInShouldDecreaseByOne() {
	Item agedBrie = createItem(SELLIN_POSITIVE, 49);
	updateQuality(agedBrie);
	assertEquals(agedBrie.sellIn, SELLIN_ZERO);
    }

    public final void sellInShouldDecreaseBelow0() {
	Item agedBrie = createItem(SELLIN_ZERO, 49);
	updateQuality(agedBrie);
	assertEquals(agedBrie.sellIn, SELLIN_NEGATIVE);
    }

    @Override
    protected String getItemName() {
	return "Aged Brie";
    }
}
