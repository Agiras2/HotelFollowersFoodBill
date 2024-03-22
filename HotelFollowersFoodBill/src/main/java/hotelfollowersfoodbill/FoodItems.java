/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelfollowersfoodbill;
/**
 *
 * @author Andrés
 */
public class FoodItems {
    private String name;
    private double  price;
    private int label;

    public FoodItems() {
    }

    public FoodItems(String name, double price, int label) {
        this.name = name;
        this.price = price;
        this.label = label;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the label
     */
    public int getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(int label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Nombre: " + name + "\nPrecio: " + price + "\nEtiqueta: " + label;
    }

}