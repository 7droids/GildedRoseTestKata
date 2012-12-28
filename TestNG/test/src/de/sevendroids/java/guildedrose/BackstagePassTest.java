package de.sevendroids.java.guildedrose;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import de.sevendroids.java.guildedrose.Item;

@Test(groups = "Unit")
public class BackstagePassTest extends GildedRoseTest {

    @Test(dataProvider = "createItemWithQuality49")
    public final void qualityShouldNotIncreaseOver50(String testCaseDesc,
	    Item sulfuras) {
	updateQuality(sulfuras);
	assertEquals(sulfuras.quality, 50, testCaseDesc);
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
	Item sulfuras = createItem(0, 49);
	updateQuality(sulfuras);
	assertEquals(sulfuras.quality, 0);
    }

    @Override
    protected String getItemName() {
	return "Backstage passes to a TAFKAL80ETC concert";
    }
}
