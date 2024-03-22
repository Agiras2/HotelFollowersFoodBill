/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelfollowersfoodbill;
/**
 *
 * @author Andrés
 */
import java.util.ArrayList;
import java.util.List;


public class ArrayChef {
    private List<Chef> chefList;
    

    public ArrayChef() {
        this.chefList = new ArrayList<>();  // Inicializar la lista de chefs
        initializeChefList();  // Inicializar la lista de chefs con el método adecuado
    }

    public List<Chef> getChefList() {
        return chefList;
    }

    public void setChefList(List<Chef> chefList) {
        this.chefList = chefList;
    }

    public void addChef(Chef chef) {
        chefList.add(chef);
    }
    
    private void initializeChefList() {
       ChefFileReader chefFileReader = new ChefFileReader();
       this.chefList = chefFileReader.readChefsFromFile();
    }

     public void showChefs() {
        if (!chefList.isEmpty()) {
            System.out.println("Chefs:");
            for (Chef chef : chefList) {
                System.out.println("Nombre: " + chef.getName());
                System.out.println("Apellido: " + chef.getLastName());
                System.out.println("ID: " + chef.getId());
                System.out.println("Nacionalidad: " + chef.getNationality());
                System.out.println("Costo Extra: " + chef.getExtraCost());
                System.out.println("--------------------");
            }
        } else {
            System.out.println("No hay chefs asignados.");
        }
    }
}


