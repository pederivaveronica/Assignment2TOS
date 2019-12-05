package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MenuItemTest {
	@Test
	public void testGetType() {
		MenuItem item = new MenuItem(MenuItem.itemType.Panini,
				"Primavera", 3.50);
		assertEquals(item.getType(), MenuItem.itemType.Panini);
	}
	
	@Test
	public void testGetName() {
		MenuItem item = new MenuItem(MenuItem.itemType.Fritti,
				"Arancino", 2);
		assertEquals(item.getName(), "Arancino");
	}
	
	@Test
	public void testGetPrice() {
		MenuItem item = new MenuItem(MenuItem.itemType.Bevande, 
				"Coca cola", 2.50);
		assertEquals(item.getPrice(), 2.50, 0);
	}
}