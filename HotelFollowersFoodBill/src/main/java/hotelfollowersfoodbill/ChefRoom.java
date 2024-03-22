/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelfollowersfoodbill;

import java.util.List;
import lecture.Lecture;
/**
 *
 * @author Andrés
 */
public class ChefRoom implements AdsToRoom {
    
    private final Lecture lecture = new Lecture();

    
    // Método para mostrar los chefs disponibles en todas las habitaciones
    public void showAvailableChefs(ArrayChef arrayChef, int roomNumber) {
        System.out.println("Lista de Chefs Disponibles:");
        arrayChef.showChefs();
        System.out.println("roomNumber: " + roomNumber);
    }
   public void addChefToRoomInteractively(Room room, int roomNumber, ArrayChef arrayChef) {
        if (roomNumber >= 0 && roomNumber < room.getRooms().size()) {
            List<Chef> selectedRoomChefs = arrayChef.getChefList();

            String continueInput = "s";

            while (continueInput.equalsIgnoreCase("s")) {
                System.out.println("Lista de chefs disponibles:");
                for (int i = 0; i < selectedRoomChefs.size(); i++) {
                    Chef chef = selectedRoomChefs.get(i);
                    System.out.println((i) + ". Nombre: " + chef.getName());
                    System.out.println("   Apellido: " + chef.getLastName());
                    System.out.println("   ID: " + chef.getId());
                    System.out.println("   Nacionalidad: " + chef.getNationality());
                    System.out.println("   Costo Extra: " + chef.getExtraCost());
                    System.out.println("-----------------------------------");
                }

                int selectedChefIndex = lecture.readInt("Seleccione el número del chef que desea agregar");

                // Verificar si el índice seleccionado es válido
                if (selectedChefIndex >= 0 && selectedChefIndex < selectedRoomChefs.size()) {
                    Chef selectedChef = selectedRoomChefs.get(selectedChefIndex);

                    // Agregar el chef seleccionado a la lista de chefs de la habitación
                    room.getRoomSelectedChefs().get(roomNumber).add(selectedChef);

                    // Print updated chefs in the room
                    List<Chef> updatedChefsInRoom = room.getRoomSelectedChefs().get(roomNumber);
                    System.out.println("Chefs actuales en la habitación: ");
                    for (int i = 0; i < updatedChefsInRoom.size(); i++) {
                        Chef chef = updatedChefsInRoom.get(i);
                        System.out.println((i + 1) + ". Nombre: " + chef.getName());
                        System.out.println("   Apellido: " + chef.getLastName());
                        System.out.println("   ID: " + chef.getId());
                        System.out.println("   Nacionalidad: " + chef.getNationality());
                        System.out.println("   Costo Extra: " + chef.getExtraCost());
                        System.out.println("-----------------------------------");
                    }

                    continueInput = lecture.readString("¿Desea agregar más chefs a esta habitación? (s/n)").toLowerCase();
                } else {
                    System.out.println("Índice de chef inválido. Intente nuevamente.");
                }
            }
        } else {
           System.out.println("Número de habitación inválido.");
        }
    }

    // Método para eliminar un chef de una habitación
    public void removeChefFromRoom(Room room, int roomNumber, int chefIndex) {
        if (roomNumber >= 0 && roomNumber < room.getRooms().size()) {
            List<Chef> roomChefs = room.getRoomSelectedChefs().get(roomNumber);
            if (roomChefs != null && chefIndex >= 0 && chefIndex < roomChefs.size()) {
                roomChefs.remove(chefIndex);
                System.out.println("¡Chef eliminado correctamente!");
            } else {
                System.out.println("No se puede eliminar el Chef. Habitación o índice de Chef inválido.");
            }
        } else {
            System.out.println("Número de habitación inválido.");
        }
    }

    // Método para eliminar todos los chefs de una habitación
    public void removeAllChefsFromRoom(Room room, int roomNumber) {
        if (roomNumber >= 0 && roomNumber < room.getRooms().size()) {
            room.getRoomSelectedChefs().get(roomNumber).clear();
            System.out.println("¡Todos los chefs eliminados correctamente de la habitación!");
        } else {
            System.out.println("Número de habitación inválido.");
        }
    }
    
    @Override
    public void adsToRoom() {
        // Implementación del método de la interfaz AdsToRoom
        System.out.println("Método adsToRoom implementado.");
    }
}
