package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

// Example scenarios for testing
//   Item("+5 Dexterity Vest", 10, 20));
//   Item("Aged Brie", 2, 0));
//   Item("Elixir of the Mongoose", 5, 7));
//   Item("Sulfuras, Hand of Ragnaros", 0, 80));
//   Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
//   Item("Conjured Mana Cake", 3, 6));

	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10_11() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(11, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_50_50() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 50) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(50, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_After_0d() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 0, 11) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(12, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_SellIn_1_0() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 0, 11) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(-1, itemBrie.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_SellIn_0_0() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 1, 11) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(0, itemBrie.getSellIn());
	}
    
	@Test
	public void testUpdateEndOfDay_DexterityVest_Quality_20_19() {
		
		GildedRose store = new GildedRose();
		
		//arrange
		store.addItem(new Item("+5 Dexterity Vest", 10, 20));
		
		//act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemVest = items.get(0);
		
		assertEquals(19, itemVest.getQuality());
		
	}
	
	@Test
	public void testUpdateEndOfDay_DexterityVest_Quality_20_18() {
		GildedRose store = new GildedRose();
		
		//arrange
		store.addItem(new Item("+5 Dexterity Vest", 0, 20));
		
		//act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemVest = items.get(0);
		
		assertEquals(18, itemVest.getQuality());
	}
	
	@Test
	public void testUpdateEndOfday_DexterityVest_Quality_0_0() {
		GildedRose store = new GildedRose();
		
		//arrange
		store.addItem(new Item("+5 Dexterity Vest", 0, 0));
		
		//act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemVest = items.get(0);
		
		assertEquals(0, itemVest.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_DexterityVest_SellIn_1_0() {
		GildedRose store = new GildedRose();
		
		//arrange
		store.addItem(new Item("+5 Dexterity Vest", 1, 5));
		
		//act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemVest = items.get(0);
		
		assertEquals(0, itemVest.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_DexterityVest_SellIn_0_0() {
		GildedRose store = new GildedRose();
		
		//arrange
		store.addItem(new Item("+5 Dexterity Vest", 0, 5));
		
		//act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item itemVest = items.get(0);
		
		assertEquals(-1, itemVest.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_Sulfuras() {
		GildedRose store = new GildedRose();
		
		//arrange
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		
		//act
		store.updateEndOfDay();
		
		
		//assert
		List<Item> items = store.getItems();
		Item itemSulfuras = items.get(0);
		
		assertEquals(80, itemSulfuras.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Sulfuras_SellIn() {
		GildedRose store = new GildedRose();
		
		//arrange
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		
		//act
		store.updateEndOfDay();
		
		
		//assert
		List<Item> items = store.getItems();
		Item itemSulfuras = items.get(0);
		
		assertEquals(0, itemSulfuras.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_BackstagePass_Increase_By_1() {
		GildedRose store = new GildedRose();
		
		//arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20));
		
		//act
		store.updateEndOfDay();		
		
		//assert
		List<Item> items = store.getItems();
		Item itemSulfuras = items.get(0);
		
		assertEquals(21, itemSulfuras.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_BackstagePass_Increase_By_2() {
		GildedRose store = new GildedRose();
		
		//arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20));
		
		//act
		store.updateEndOfDay();		
		
		//assert
		List<Item> items = store.getItems();
		Item itemSulfuras = items.get(0);
		
		assertEquals(22, itemSulfuras.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_BackstagePass_Increase_By_3() {
		GildedRose store = new GildedRose();
		
		//arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20));
		
		//act
		store.updateEndOfDay();		
		
		//assert
		List<Item> items = store.getItems();
		Item itemSulfuras = items.get(0);
		
		assertEquals(23, itemSulfuras.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_BackstagePass_Quality_50_50_After_5d() {
		GildedRose store = new GildedRose();
		
		//arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50));
		
		//act
		store.updateEndOfDay();		
		
		//assert
		List<Item> items = store.getItems();
		Item itemSulfuras = items.get(0);
		
		assertEquals(50, itemSulfuras.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_BackstagePass_Quality_50_50_After_10d() {
		GildedRose store = new GildedRose();
		
		//arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50));
		
		//act
		store.updateEndOfDay();		
		
		//assert
		List<Item> items = store.getItems();
		Item itemSulfuras = items.get(0);
		
		assertEquals(50, itemSulfuras.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_BackstagePass_Quality_50_50_Before_10d() {
		GildedRose store = new GildedRose();
		
		//arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 20, 50));
		
		//act
		store.updateEndOfDay();		
		
		//assert
		List<Item> items = store.getItems();
		Item itemSulfuras = items.get(0);
		
		assertEquals(50, itemSulfuras.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_BackstagePass_Drop_To_0() {
		GildedRose store = new GildedRose();
		
		//arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20));
		
		//act
		store.updateEndOfDay();		
		
		//assert
		List<Item> items = store.getItems();
		Item itemSulfuras = items.get(0);
		
		assertEquals(0, itemSulfuras.getQuality());
	}
	
	@Test
	public void testUpdateEndOfToday_BackstagePass_SellIn_1_0() {
		GildedRose store = new GildedRose();
		
		//arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20));
		
		//act
		store.updateEndOfDay();		
		
		//assert
		List<Item> items = store.getItems();
		Item itemSulfuras = items.get(0);
		
		assertEquals(0, itemSulfuras.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfToday_BackstagePass_SellIn_0_0() {
		GildedRose store = new GildedRose();
		
		//arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20));
		
		//act
		store.updateEndOfDay();		
		
		//assert
		List<Item> items = store.getItems();
		Item itemSulfuras = items.get(0);
		
		assertEquals(-1, itemSulfuras.getSellIn());
	}
	
	
	
}
