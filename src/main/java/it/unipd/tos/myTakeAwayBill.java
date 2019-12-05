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
		
		//caso 4
        if (itemsOrdered.size() > 30) {
            throw new TakeAwayBillException("Troppi elementi ordinati");
        }
		
		//totale
		double totale = 0;
		//numero totale panini
        int numPanini = 0;
        //costo minimo panino
        double minPrice = Double.MAX_VALUE;
        //totale panini + fritti
        double totalepf=0;


        //caso 1
        for (int i = 0; i < itemsOrdered.size(); i++) {
            totale += itemsOrdered.get(i).getPrice();

            if (itemsOrdered.get(i).getType() == itemType.Panini) {
                numPanini++;
                if (itemsOrdered.get(i).getPrice() < minPrice) {
                    minPrice = itemsOrdered.get(i).getPrice();
                }
            }

            if (itemsOrdered.get(i).getType() == itemType.Panini
                    || itemsOrdered.get(i).getType() == itemType.Fritti) {
                totalepf += itemsOrdered.get(i).getPrice();
            }
        }

        //caso 2
        if (numPanini > 5) {
            totale -= minPrice;
            totale += minPrice * 0.5;
        }
        
        //caso 3
        if (totalepf > 50) {
            double sconto = totale * 10 / 100;
            totale = totale - sconto;
        }
        
        //caso 5
        if (totale < 10) {
            totale += 0.5;
        }

        
		return totale;
	}
	
	
}