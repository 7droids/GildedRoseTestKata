package org.sevendroids.java.gildedrose;

import static org.testng.Assert.assertEquals;

import org.sevendroids.java.gildedrose.Item;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = "Unit")
public class NormalItemTest extends GildedRoseTest {

	public final void qualtiyDecreaseByOneIfSellInGT0() {
		Item item = createItem(SELLIN_POSITIVE, QUALITY_MAXIMUM);
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
		return new Object[][] {
				{ "SellIn > 0", createItem(SELLIN_POSITIVE, QUALITY_ZERO) },
				{ "SellIn = 0, quality = 0",
						createItem(SELLIN_ZERO, QUALITY_ZERO) },
				{ "SellIn = 0, quality = 1", createItem(SELLIN_ZERO, 1) },
				{ "SellIn = -1 quality = 1", createItem(SELLIN_NEGATIVE, 1) },
				{ "SellIn = -1 quality = 20", createItem(SELLIN_NEGATIVE, 2) }, };
	}

	public final void qualtiyDecreaseByTwoIfSellInLE0() {
		Item item = createItem(SELLIN_ZERO, QUALITY_MAXIMUM);
		updateQuality(item);
		assertEquals(item.quality, 48);
	}

	@Override
	protected String getItemName() {
		return "Any Item";
	}
}
