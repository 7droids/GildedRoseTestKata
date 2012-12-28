package de.sevendroids.java.guildedrose.testng;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import de.sevendroids.java.guildedrose.Item;

@Test(groups = "Unit")
public class NormalItemTest extends GildedRoseTest {

    public final void qualtiyDecreaseByOneIfSellInGT0() {
	Item item = createItem(1, 50);
	updateQuality(item);
	assertEquals(item.quality, 49);
    }

    @Test(dataProvider = "createItemWithQualityZero")
    public final void qualtiyNeverDecreaseBelow0(String testCaseDesc, Item item) {
	updateQuality(item);
	assertEquals(item.quality, 0, testCaseDesc);
    }

    @DataProvider(name = "createItemWithQualityZero")
    protected final Object[][] createItemWithQualityZero() {
	return new Object[][] { { "SellIn > 0", createItem(1, 0) },
		{ "SellIn = 0, quality = 0", createItem(0, 0) },
		{ "SellIn = 0, quality = 1", createItem(0, 1) },
		{ "SellIn = -1 quality = 1", createItem(-1, 1) },
		{ "SellIn = -1 quality = 20", createItem(-1, 2) }, };
    }

    public final void qualtiyDecreaseByTwoIfSellInLE0() {
	Item item = createItem(0, 50);
	updateQuality(item);
	assertEquals(item.quality, 48);
    }

    @Override
    protected String getItemName() {
	return "Any Item";
    }
}
