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
public class Room {
    private final List<ArrayGuest> rooms;
    private final List<List<FoodItems>> roomSelectedFoods; // Lista para almacenar platillos seleccionados en cada habitación
    private final List<List<Chef>> roomSelectedChefs; // Lista para almacenar Chefs seleccionados en cada habitación
    

    public Room() {
        rooms = new ArrayList<>();
        roomSelectedFoods = new ArrayList<>(); // Inicializar la lista de plkatillos seleccionados
        roomSelectedChefs = new ArrayList<>(); // Inicializar la lista de chefs seleccionados
        // Inicializar las habitaciones
        for (int i = 0; i < 50; i++) {
            rooms.add(new ArrayGuest(new ArrayList<>())); // Cada habitación se inicializa con un ArrayList de huéspedes vacío
            roomSelectedFoods.add(new ArrayList<>()); // Inicializar la lista de alimentos seleccionados para cada habitación
            roomSelectedChefs.add(new ArrayList<>()); // Inicializar la lista de alimentos seleccionados para cada habitación
        }
    }
    
    public List<ArrayGuest> getRooms() {
        return rooms;
    }

    public List<List<FoodItems>> getRoomSelectedFoods() {
        return roomSelectedFoods;
    }

    public List<List<Chef>> getRoomSelectedChefs() {
        return roomSelectedChefs;
    }
    
    
   public void addGuestToRoom(int roomNumber, Guest newGuest) {
        if (roomNumber >= 0 && roomNumber < rooms.size()) {
            rooms.get(roomNumber).getGuestList().add(newGuest);
            System.out.println("Huesped agregado exitosamente a la habitación " + roomNumber);
        } else {
            System.out.println("Número de habitación inválido.");
        }
    }
    
     public void changeGuestRoom(int currentRoomNumber, int newRoomNumber, long guestId) {
        // Verificar si los números de habitación actual y nueva son válidos
        if (currentRoomNumber >= 0 && currentRoomNumber < getRooms().size() &&
                newRoomNumber >= 0 && newRoomNumber < getRooms().size()) {
            ArrayGuest currentRoom = getRooms().get(currentRoomNumber);
            ArrayGuest newRoom = getRooms().get(newRoomNumber);
            Guest guest = currentRoom.findGuestById(guestId); // Usar el método findGuestById para obtener el huésped
            if (guest != null) {
                currentRoom.deleteGuest(); // Eliminar al huésped de la habitación actual
                addGuestToRoom(newRoomNumber, guest); // Agregar al huésped a la nueva habitación
                System.out.println("Huésped movido exitosamente a la nueva habitación.");
            } else {
                System.out.println("Huésped no encontrado en la habitación actual.");
            }
        } else {
            System.out.println("Número de habitación inválido.");
        }
    }

    public void removeGuestFromRoom(int roomNumber, long guestId) {
        if (roomNumber >= 0 && roomNumber < rooms.size()) {
            ArrayGuest room = rooms.get(roomNumber);
            if (room.getNumberOfGuests() == 0) {
                room.clearRoom(); // Borra todo lo que hay en la habitación si no hay huéspedes
                System.out.println("La habitación ahora está vacía.");
            } else {
                room.deleteGuest(); // Llama al método deleteGuest de ArrayGuest para eliminar al huésped de la habitación
            }
        } else {
            System.out.println("Número de habitación inválido.");
        }
    }
    
    public void modifyGuestInRoom(int roomNumber, long guestId) {
        if (roomNumber >= 0 && roomNumber < rooms.size()) {
            ArrayGuest room = rooms.get(roomNumber);
            room.modifyGuest(); // Llama al método modifyGuest de ArrayGuest para modificar los datos del huésped en la habitación
        } else {
            System.out.println("Número de habitación inválido.");
        }
    }
    
    public void showEmptyRooms() {
        System.out.println("Habitaciones sin huéspedes:");
        for (int i = 0; i < rooms.size(); i++) {
            ArrayGuest room = rooms.get(i);
            if (room.getGuestList().isEmpty()) {
                System.out.println("Habitación " + i);
            }
        }
    }
    

    public void showOccupiedRooms() {
        System.out.println("Habitaciones con huéspedes:");
        for (int i = 0; i < rooms.size(); i++) {
            ArrayGuest room = rooms.get(i);
            if (!room.getGuestList().isEmpty()) {
                System.out.println("Habitación " + i);
            }
        }

    }
    public int findRoomByGuestId(long guestId) {
        for (int i = 0; i < rooms.size(); i++) {
            ArrayGuest room = rooms.get(i);
            for (Guest guest : room.getGuestList()) {
                if (guest.getId() == guestId) {
                    return i; // Se encontró el huésped en esta habitación
                }
            }
        }
        return -1; // No se encontró el huésped en ninguna habitación
    }

    public void showGuestsInRoom(int roomNumber) {
    if (roomNumber >= 0 && roomNumber < rooms.size()) {
        ArrayGuest room = rooms.get(roomNumber);
        ArrayList<Guest> guestList = room.getGuestList();

        if (!guestList.isEmpty()) {
            System.out.println("Habitación " + roomNumber + " - Huéspedes:");
            for (Guest guest : guestList) {
                System.out.println("Nombre: " + guest.getName());
                System.out.println("Apellido: " + guest.getLastName());
                System.out.println("ID: " + guest.getId());
                System.out.println("Edad: " + guest.getAge());
                System.out.println("Tipo de Huésped: " + guest.getTypeOfGuest());
                System.out.println("Número de Teléfono: " + guest.getPhoneNo());
                System.out.println();
            }
        } else {
            System.out.println("La habitación " + roomNumber + " no tiene huéspedes.");
        }
    } else {
        System.out.println("Número de habitación inválido.");
    }
    }
    
    public ArrayGuest getArrayGuest(int roomNumber) {
        if (roomNumber >= 0 && roomNumber < rooms.size()) {
            return rooms.get(roomNumber);
        } else {
            return null; // Retorna null si el número de habitación es inválido
        }
    }
    

    public List<FoodItems> getSelectedFood(int roomNumber) {
        if (roomNumber >= 0 && roomNumber < roomSelectedFoods.size()) {
            return roomSelectedFoods.get(roomNumber);
        } else {
            return null; // Retorna null si el número de habitación es inválido
        }
    }
    
    
}


    
