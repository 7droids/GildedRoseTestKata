/**
 * 
 */
package org.sevendroids.java.gildedrose;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * @author 7droids.de (FA)
 * 
 */
public class NormalItem extends GildedRoseKataStories {

	private Item item;
	private GildedRose gildedRose;

	@Given("is a $name item with sellin = $sellIn and quality = $quality")
	@Aliases(values = { "a new item: $name with $sellIn and $quality" })
	public void createItem(String name, int sellIn, int quality) {
		item = new Item(getName(name), sellIn, quality);
		gildedRose = new GildedRose(new Item[] { item });
	}

	/**
	 * This method is necessary because JBehave is creating strings with new
	 * String(). So String == String always returns false what is a problem with
	 * the GildedRose. It's using == instead of equals to compare to strings.
	 * 
	 * @param name
	 *            Name from the story
	 * @return Translation to name in Kata
	 */
	private String getName(String name) {
		if (name.equals("Aged Brie"))
			return "Aged Brie";
		else if (name.equals("Sulfuras"))
			return "Sulfuras, Hand of Ragnaros";
		else if (name.equals("Backstage"))
			return "Backstage passes to a TAFKAL80ETC concert";
		return "Normal";
	}

	@When("I update the item")
	public void updateItem() {
		gildedRose.updateQuality();
	}

	@Then("sellin = $sellIn and quality = $quality")
	@Aliases(values = { "The sellIn is $sellIn and the quality is $quality" })
	public void validateResult(int sellIn, int quality) {
		assertThat(item.sellIn, equalTo(sellIn));
		assertThat(item.quality, equalTo(quality));
	}
}
