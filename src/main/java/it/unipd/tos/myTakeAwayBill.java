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
		
		//totale
		double totale = 0;
		//numero totale panini
        int numPanini = 0;
        //costo minimo panino
        double minPrice = Double.MAX_VALUE;


        //caso 1
        for (int i = 0; i < itemsOrdered.size(); i++) {
            totale += itemsOrdered.get(i).getPrice();

            if (itemsOrdered.get(i).getType() == itemType.Panini) {
                numPanini++;
                if (itemsOrdered.get(i).getPrice() < minPrice) {
                    minPrice = itemsOrdered.get(i).getPrice();
                }
            }

          
        }

        //caso 2
        if (numPanini > 5) {
            totale -= minPrice;
            totale += minPrice * 0.5;
        }
		return totale;
	}
	
	
}