/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelfollowersfoodbill;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Andrés
 */
public class ArrayFood {
    private List<FoodItems> foodItemsList;
   

    public ArrayFood() {
        this.foodItemsList = new ArrayList<>();  // Inicializar la lista de platillos
        initializeFoodItemsList();  // Inicializar la lista de platillos con el método adecuado
    }

    public List<FoodItems> getFoodItemsList() {
        return foodItemsList;
    }

    public void setFoodItemsList(List<FoodItems> foodItemsList) {
        this.foodItemsList = foodItemsList;
    }

    public void addFoodItem(FoodItems foodItem) {
        foodItemsList.add(foodItem);
    }
    
    private void initializeFoodItemsList() {
       FoodFileReader foodFileReader = new FoodFileReader();
       this.foodItemsList = foodFileReader.readFoodItemsFromFile();
    }

     public void showFoodItems() {
        if (!foodItemsList.isEmpty()) {
            System.out.println("Platillos:");
            for (FoodItems foodItem : foodItemsList) {
                System.out.println("Nombre: " + foodItem.getName());
                System.out.println("Precio: " + foodItem.getPrice());
                System.out.println("Etiqueta: " + foodItem.getLabel());
                System.out.println("--------------------");
            }
        } else {
            System.out.println("No hay Platillos asignados a la habitación.");
        }
    }
    
}

