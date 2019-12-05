//Veronica Pederiva 1161493
package it.unipd.tos;

import java.util.List;

import it.unipd.tos.business.TakeAwayBill;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.MenuItem.itemType;

public class myTakeAwayBill implements TakeAwayBill {

	@Override
	public double getOrderPrice(List<MenuItem> itemsOrdered) 
			throws TakeAwayBillException {
		
		//totale ordine
		double totale = 0;
		
		//caso 1
        for (int i = 0; i < itemsOrdered.size(); i++) {
            totale += itemsOrdered.get(i).getPrice();
        }

		
		return totale;
	}
	
	
}