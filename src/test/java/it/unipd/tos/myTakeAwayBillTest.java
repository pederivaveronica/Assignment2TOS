package it.unipd.tos;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;

public class myTakeAwayBillTest {
	private ArrayList<MenuItem> item;
	private myTakeAwayBill myApp;

	public myTakeAwayBillTest() {
		myApp = new myTakeAwayBill();
	}

	@Test(expected = TakeAwayBillException.class)
	public void testQtaOrdinataException() throws TakeAwayBillException {

		item = new ArrayList<MenuItem>();
		for (int i = 0; i < 32; i++) {
			item.add(new MenuItem(MenuItem.itemType.Panini, "Primavera", 3.50));
		}
		myApp.getOrderPrice(item);
	}
	
	@Test
	public void testOrdinePiu5PaniniconSconto() throws TakeAwayBillException {
		item = new ArrayList<MenuItem>();
		for (int i = 0; i < 6; i++) {
			item.add(new MenuItem(MenuItem.itemType.Panini, "Primavera", 3.50));
		}
		item.add(new MenuItem(MenuItem.itemType.Panini, "Semplice", 2));
		// totale 23; 21+1 = 22
		assertEquals(myApp.getOrderPrice(item), 22, 0);
	}

	@Test
	public void testOrdineMaggiore50PaniniFrittiSconto() throws TakeAwayBillException {
		item = new ArrayList<MenuItem>();
		for (int i = 0; i < 5; i++) {
			item.add(new MenuItem(MenuItem.itemType.Fritti, "Fritto", 6));
		}
		for (int i = 0; i < 5; i++) {
			item.add(new MenuItem(MenuItem.itemType.Panini, "Panino", 5));
		}
		double totalPrice = myApp.getOrderPrice(item);

		assertEquals(totalPrice, 49.5, 0);
	}
	
	@Test
	public void testOrdineMinore10Commissione() throws TakeAwayBillException {
		item = new ArrayList<MenuItem>();
		for (int i = 0; i < 4; i++) {
			item.add(new MenuItem(MenuItem.itemType.Bevande, "Fanta", 2));
		}
		double totalPrice = myApp.getOrderPrice(item);
		assertEquals(totalPrice, 8.5, 0);
	}
}

