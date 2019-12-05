//Veronica Pederiva 1161493
package it.unipd.tos.model;

public class MenuItem {

    public enum itemType {
        Panini, Fritti, Bevande
    }

    ;
    private itemType type;
    private String name;
    private double price;

    public MenuItem(itemType i, String n, double p) {
        setType(i);
        setName(n);
        setPrice(p);
    }

    public itemType getType() {
        return type;
    }

    public void setType(itemType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
