/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelfollowersfoodbill;
import java.util.List;
import java.text.DecimalFormat;
/**
 *
 * @author Andrés
 */
public class Bill {
    private final Room room;


    public Bill(Room room, FoodRoom foodRoom, ArrayGuest arrayGuest, ArrayFood arrayFood, ArrayChef arrayChef, ChefRoom chefRoom) {
        this.room = room;
    }

    public void printBill(int roomNumber) {
        System.out.println("***** Factura *****");

        // Obtener la lista de huéspedes en la habitación
        List<Guest> guests = room.getRooms().get(roomNumber).getGuestList();

        // Verificar si hay huéspedes en la habitación
        if (!guests.isEmpty()) {
            // Obtener el nombre del primer huésped
            String guestName = guests.get(0).getName();

            // Imprimir la factura a nombre del primer huésped
            System.out.println("Factura a nombre de: " + guestName);

            // Obtener los food items asignados a la habitación
            List<FoodItems> selectedFoods = room.getRoomSelectedFoods().get(roomNumber);
            double foodTotal = 0;

            // Imprimir los food items
            System.out.println("\nPlatillos y comidas:");
            for (FoodItems foodItem : selectedFoods) {
                System.out.println("Nombre: " + foodItem.getName());
                System.out.println("Precio: " + foodItem.getPrice());
                System.out.println("-----------------------------------");
                foodTotal += foodItem.getPrice();
            }

            // Obtener los chefs asignados a la habitación
            List<Chef> selectedChefs = room.getRoomSelectedChefs().get(roomNumber);

            // Verificar si hay chefs asignados
            if (!selectedChefs.isEmpty()) {
                
                
                
                // Imprimir información de los chefs
                System.out.println("\nChef:");
                double extraCostTotal = 1.0; // Inicializar el total del costo extra de los chefs
                for (Chef chef : selectedChefs) {
                    double extraCostPercentage = (chef.getExtraCost() - 1) * 100;
                    System.out.println("Nombre: " + chef.getName() + " " + chef.getLastName());
                    
                    DecimalFormat df = new DecimalFormat("#.##");
                    String formattedExtraCostPercentage = df.format(extraCostPercentage);
                    
                    System.out.println("Costo Extra (%): " + formattedExtraCostPercentage + "%");
                    System.out.println("-----------------------------------");
                    extraCostTotal *= chef.getExtraCost(); // Multiplicar el extra cost de cada chef
                }

                // Calcular el subtotal, el IVA y el total
                double subTotal = foodTotal * extraCostTotal;
                double iva = subTotal * 0.19;
                double total = subTotal + iva;

                // Formatear el total con dos cifras decimales
                DecimalFormat df = new DecimalFormat("#.##");
                String formattedTotal = df.format(total);
                String formattedSubTotal = df.format(subTotal);
                String formattedSubIval = df.format(iva);
                

                // Imprimir el subtotal y el total
                System.out.println("\nSubtotal: " + formattedSubTotal);
                System.out.println("IVA (19%): " + formattedSubIval);
                System.out.println("Total: " + formattedTotal);
            } else {
                System.out.println("\nNo hay chef asignado a esta habitación.");
            }
        } else {
            System.out.println("No hay huéspedes en esta habitación.");
        }
    }
}