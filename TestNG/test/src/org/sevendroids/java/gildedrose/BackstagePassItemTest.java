package org.sevendroids.java.gildedrose;

import static org.testng.Assert.assertEquals;

import org.sevendroids.java.gildedrose.Item;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = "Unit")
public class BackstagePassItemTest extends GildedRoseTest {

    @Test(dataProvider = "createItemWithQuality49")
    public final void qualityShouldNotIncreaseOver50(String testCaseDesc,
	    Item sulfuras) {
	updateQuality(sulfuras);
	assertEquals(sulfuras.quality, QUALITY_MAXIMUM, testCaseDesc);
    }

    @DataProvider(name = "createItemWithQuality49")
    protected final Object[][] createItemWithQuality49() {
	return new Object[][] { { "SellIn >= 11", createItem(11, 49) },
		{ "SellIn < 10", createItem(10, 49) },
		{ "SellIn >= 6", createItem(6, 49) },
		{ "SellIn < 6", createItem(5, 49) }, };
    }

    public final void qualityShouldIncreaseBy1IfSellInGE11() {
	int quality = 48;
	int sellIn = 11;
	Item sulfuras = createItem(sellIn, quality);
	updateQuality(sulfuras);
	assertEquals(sulfuras.quality, 49);
    }

    public final void qualityShouldIncreaseBy2IfSellInLT11() {
	int quality = 47;
	int sellIn = 10;
	Item sulfuras = createItem(sellIn, quality);
	updateQuality(sulfuras);
	assertEquals(sulfuras.quality, 49);
    }

    public final void qualityShouldIncreaseBy3IfSellInLT6() {
	int quality = 46;
	int sellIn = 5;
	Item sulfuras = createItem(sellIn, quality);
	updateQuality(sulfuras);
	assertEquals(sulfuras.quality, 49);
    }

    public final void qualityShouldBe0ForSellIn0() {
	Item sulfuras = createItem(SELLIN_ZERO, 49);
	updateQuality(sulfuras);
	assertEquals(sulfuras.quality, SELLIN_ZERO);
    }

    @Override
    protected String getItemName() {
	return "Backstage passes to a TAFKAL80ETC concert";
    }
}
