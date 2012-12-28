/**
 * 
 */
package de.sevendroids.java.guildedrose.testng;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import de.sevendroids.java.guildedrose.Item;

/**
 * @author 7droids.de (FA)
 * 
 */
@Test(groups = "Unit")
public class AgedBrieTest extends GildedRoseTest {

    public final void qualityShouldNotIncreaseOver50() {
	int quality = 50;
	Item agedBrie = createItem(1, quality);
	updateQuality(agedBrie);
	assertEquals(agedBrie.quality, quality);
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
	return new Object[][] { { "sellIn < 0", createItem(-1, 49) },
		{ "sellIn = 0", createItem(0, 49) },
		{ "sellIn > 0", createItem(1, 49) }, };
    }

    public final void qualityShouldIncreaseByTwoIfSellInLT0() {
	Item agedBrie = createItem(-1, 47);
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
	assertEquals(agedBrie.quality, 0);
    }

    public final void sellInShouldDecreaseByOne() {
	Item agedBrie = createItem(1, 49);
	updateQuality(agedBrie);
	assertEquals(agedBrie.sellIn, 0);
    }

    public final void sellInShouldDecreaseBelow0() {
	Item agedBrie = createItem(0, 49);
	updateQuality(agedBrie);
	assertEquals(agedBrie.sellIn, -1);
    }

    @Override
    protected String getItemName() {
	return "Aged Brie";
    }
}
