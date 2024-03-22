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
public class FoodRoom implements AdsToRoom {

    private final Lecture lecture = new Lecture();


    // Método para mostrar los platillos disponibles en todas las habitaciones
    public void showAvailableFoodItems(ArrayFood arrayFood) {
        System.out.println("Lista de Elementos de Comida Disponibles:");
        arrayFood.showFoodItems();
    }


    public void addFoodToRoomInteractively(Room room, int roomNumber, ArrayFood arrayFood) {
        if (roomNumber >= 0 && roomNumber < room.getRooms().size()) {
            List<FoodItems> selectedRoomFood = arrayFood.getFoodItemsList();

            String continueInput = "s";

            while (continueInput.equalsIgnoreCase("s")) {
                System.out.println("Lista de platillos disponibles:");
                for (int i = 0; i < selectedRoomFood.size(); i++) {
                    FoodItems foodItem = selectedRoomFood.get(i);
                    System.out.println((i) + ". Nombre: " + foodItem.getName());
                    System.out.println("   Precio: " + foodItem.getPrice());
                    System.out.println("   Etiqueta: " + foodItem.getLabel());
                    System.out.println("-----------------------------------");
                }

                int selectedFoodIndex = lecture.readInt("Seleccione el número del platillo que desea agregar");

                // Verificar si el índice seleccionado es válido
                if (selectedFoodIndex >= 0 && selectedFoodIndex < selectedRoomFood.size()) {
                    // Obtener el platillo seleccionado
                    FoodItems selectedFoodItem = selectedRoomFood.get(selectedFoodIndex);

                    // Agregar el platillo seleccionado a la lista de alimentos seleccionados de la habitación
                    room.getRoomSelectedFoods().get(roomNumber).add(selectedFoodItem);

                    continueInput = lecture.readString("¿Desea agregar más platillos a esta habitación? (s/n)").toLowerCase();
                } else {
                    System.out.println("Índice de platillo inválido. Intente nuevamente.");
                }
            }
        } else {
            System.out.println("Número de habitación inválido.");
        }
    }

    // Método para eliminar un Platillo de una habitación
    public void removeFoodFromRoom(Room room, int roomNumber, int foodIndex) {
        if (roomNumber >= 0 && roomNumber < room.getRooms().size()) {
            List<FoodItems> roomFoods = room.getRoomSelectedFoods().get(roomNumber);
            if (roomFoods != null && foodIndex >= 0 && foodIndex < roomFoods.size()) {
                roomFoods.remove(foodIndex);
                System.out.println("¡Platillo eliminado correctamente!");
            } else {
                System.out.println("No se puede eliminar el Paltillo. Habitación o índice de Platillo inválido.");
            }
        } else {
            System.out.println("Número de habitación inválido.");
        }
    }

    // Método para eliminar todos los platillos de una habitación
    public void removeAllFoodFromRoom(Room room, int roomNumber) {
        if (roomNumber >= 0 && roomNumber < room.getRooms().size()) {
            room.getRoomSelectedFoods().get(roomNumber).clear();
            System.out.println("¡Todos los Platillos eliminados correctamente de la habitación!");
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
   