/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelfollowersfoodbill;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;

/**
 *
 * @author Andrés
 */
public class FoodFileReader {
    private final String filename = "Resources/FoodItems.txt";

    public List<FoodItems> readFoodItemsFromFile() {
        List<FoodItems> foodItemsList = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(", ");
                if (parts.length == 3) {
                    String name = parts[0];
                    double price = Double.parseDouble(parts[1]);
                    int label = Integer.parseInt(parts[2]);
                    FoodItems foodItem = new FoodItems(name, price, label);
                    foodItemsList.add(foodItem);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir precio a número: " + e.getMessage());
        }
        return foodItemsList;
    }
    

    public void addFoodItemToFile(FoodItems foodItem) {
        try {
            FileWriter writer = new FileWriter(filename, true);
            writer.write(foodItem.getName() + ", " + foodItem.getPrice() + ", " + foodItem.getLabel() + "\n");
            writer.close();
            System.out.println("Platilo agregado correctamente al archivo.");
        } catch (IOException e) {
            System.out.println("Error al agregar alimento al archivo: " + e.getMessage());
        }
    }

    public void updateFoodItemInFile(int index, FoodItems updatedFoodItem) {
        List<FoodItems> foodItemsList = readFoodItemsFromFile();
        if (index >= 0 && index < foodItemsList.size()) {
            foodItemsList.set(index, updatedFoodItem);
            rewriteFile(foodItemsList);
            System.out.println("Platillo actualizado correctamente en el archivo.");
        } else {
            System.out.println("Índice de alimento fuera de rango.");
        }
    }

    public void deleteFoodItemFromFile(int index) {
        List<FoodItems> foodItemsList = readFoodItemsFromFile();
        if (index >= 0 && index < foodItemsList.size()) {
            foodItemsList.remove(index);
            rewriteFile(foodItemsList);
            System.out.println("Alimento eliminado correctamente del archivo.");
        } else {
            System.out.println("Índice de alimento fuera de rango.");
        }
    }

    private void rewriteFile(List<FoodItems> foodItemsList) {
        try {
            FileWriter writer = new FileWriter(filename);
            for (FoodItems foodItem : foodItemsList) {
                writer.write(foodItem.getName() + ", " + foodItem.getPrice() + ", " + foodItem.getLabel() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al reescribir el archivo: " + e.getMessage());
        }
    }

}