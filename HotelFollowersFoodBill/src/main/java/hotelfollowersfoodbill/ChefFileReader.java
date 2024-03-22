/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelfollowersfoodbill;
/**
 *
 * @author Andrés
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class ChefFileReader {
    private final String filename = "Resources/ChefList.txt";

    public List<Chef> readChefsFromFile() {
        List<Chef> chefList = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                if (parts.length == 5) {
                    String name = parts[0];
                    String lastName = parts[1];
                    long id = Long.parseLong(parts[2]);
                    String nationality = parts[3];
                    double extraCost = Double.parseDouble(parts[4]);
                    Chef chef = new Chef(name, lastName, id, nationality, extraCost);
                    chefList.add(chef);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir datos: " + e.getMessage());
        }
        return chefList;
    }
    
    public void addChefToFile(Chef chef) {
        try {
            FileWriter writer = new FileWriter(filename, true);
            writer.write(chef.getName() + " " + chef.getLastName() + " " + String.valueOf(chef.getId()) + " " +
                     chef.getNationality() + " " + chef.getExtraCost() + "\n");
            writer.close();
            System.out.println("Chef agregado correctamente al archivo.");
        } catch (IOException e) {
            System.out.println("Error al agregar el chef al archivo: " + e.getMessage());
        }
    }

    public void updateChefInFile(int index, Chef updatedChef) {
        List<Chef> chefList = readChefsFromFile();
        if (index >= 0 && index < chefList.size()) {
            chefList.set(index, updatedChef);
            rewriteFile(chefList);
            System.out.println("Chef actualizado correctamente en el archivo.");
        } else {
            System.out.println("Índice de chef fuera de rango.");
        }
    }

    public void deleteChefFromFile(int index) {
        List<Chef> chefList = readChefsFromFile();
        if (index >= 0 && index < chefList.size()) {
            chefList.remove(index);
            rewriteFile(chefList);
            System.out.println("Chef eliminado correctamente del archivo.");
        } else {
            System.out.println("Índice de chef fuera de rango.");
        }
    }

    private void rewriteFile(List<Chef> chefList) {
        try {
            FileWriter writer = new FileWriter(filename);
            for (Chef chef : chefList) {
                writer.write(chef.getName() + " " + chef.getLastName() + " " + chef.getId() + " " +chef.getNationality() + " " + chef.getExtraCost() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al reescribir el archivo: " + e.getMessage());
        }
    }

}