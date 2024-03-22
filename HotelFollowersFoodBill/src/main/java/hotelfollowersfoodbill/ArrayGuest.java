/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelfollowersfoodbill;
import lecture.Lecture;
import java.util.*;

/**
 *
 * @author Andrés
 */
public class ArrayGuest {
    private final ArrayList<Guest> guestList;
    private final Lecture lecture = new Lecture();
    private final Scanner sc = new Scanner(System.in);

    public ArrayGuest(ArrayList<Guest> guestList) {
        this.guestList = guestList;
    }
    
    /**
     * @return the guestList
     */
    public ArrayList<Guest> getGuestList() {
        return guestList;
    }
    
    public void clearRoom() {
        guestList.clear();

    }
    
    public Guest inputGuest() {
        String name = lecture.readString("Ingrese el nombre  del Huesped: ");
        String lastName = lecture.readString("Ingrese el primer apellido del Huesped: ");
        long id = lecture.readLongPositive("Ingrese el ID del Huesped: ");
        int age=lecture.readIntPositive("Ingrese la edad del Huesped: ");
        String typeOfGuest =lecture.readString("Ingrese el tipo de Huesped: ");
        long phoneNo=lecture.readLongPositive("Ingrese el numero telefonico del telefonico del Huesped: ");
        sc.nextLine();

        return new Guest(age, typeOfGuest, phoneNo, name, lastName, id);
    }


    public void searchGuest() {
        long idToSearch = lecture.readLongPositive("Ingrese el ID a buscar: ");
        boolean guestFound = false;

        for (int i = 0; i < getGuestList().size(); i++) {
            Guest guest = getGuestList().get(i);
            if (guest.getId() == idToSearch) {
                System.out.println("El Huesped se encuentra en la posición: " + i);
                guestFound = true;
                break;
            }
        }
        if (!guestFound) {
            System.out.println("El Huesped no se encuentra en la lista.");
        }
    }

    public void modifyGuest() {
        long guestId = lecture.readLongPositive("Ingrese el ID del Huesped a modificar: ");
        int index = findGuestIndexById(guestId);

        if (index != -1) {
            Guest guest = getGuestList().get(index);
            System.out.println("Huesped encontrado: ");

            String newName = lecture.readString("Ingrese el nuevo nombre del Huesped: ");
            String newLastName = lecture.readString("Ingrese el nuevo primer apellido del Huesped: ");
            long newId = lecture.readLongPositive("Ingrese el nuevo ID del Huesped: ");
            int newAge = lecture.readIntPositive("Ingrese la nueva edad del Huesped: ");
            String newTypeOfGuest = lecture.readString("Ingrese el nuevo tipo de Huesped: ");
            long newPhoneNo = lecture.readLongPositive("Ingrese el nuevo número telefónico del Huesped: ");

            guest.setName(newName);
            guest.setLastName(newLastName);
            guest.setId(newId);
            guest.setAge(newAge);
            guest.setTypeOfGuest(newTypeOfGuest);
            guest.setPhoneNo(newPhoneNo);

            System.out.println("¡Huesped modificado con éxito!");
        } else {
            System.out.println("El Huesped con el ID " + guestId + " no se encuentra en la lista.");
        }
    }

    public void deleteGuest() {
        long guestId = lecture.readLongPositive("Ingrese el ID del Huesped a remover de la habitacion: ");
        int index = findGuestIndexById(guestId);

        if (index != -1) {
            getGuestList().remove(index);
            System.out.println("Huesped eliminado exitosamente");
        } else {
            System.out.println("No se encontró ningún Huesped con el ID " + guestId);
        }
}
    

    public void showGuest() {
    if (!guestList.isEmpty()) {
        System.out.println("Lista de Huéspedes:");

        for (Guest guest : getGuestList()) {
            System.out.println("Nombre: " + guest.getName());
            System.out.println("Primer Apellido: " + guest.getLastName());
            System.out.println("ID: " + guest.getId());
            System.out.println("Edad: " + guest.getAge());
            System.out.println("Tipo de Huésped: " + guest.getTypeOfGuest());
            System.out.println("Número de Teléfono: " + guest.getPhoneNo());
            System.out.println();
        }
    } else {
        System.out.println("No hay huéspedes en la lista.");
    }
}
    
    public int findGuestIndexById(long guestId) {
        for (int i = 0; i < getGuestList().size(); i++) {
            if (getGuestList().get(i).getId() == guestId) {
                return i;
            }
        }
        return -1;
    }
    
    public Guest findGuestById(long guestId) {
    for (Guest guest : getGuestList()) {
        if (guest.getId() == guestId) {
            return guest;
        }
    }
    return null;
    }
    
    public int getNumberOfGuests() {
        return guestList.size(); // Suponiendo que 'guests' es la lista que contiene a los huéspedes de la habitación
    }
    
    public void addGuest(Guest guest) {
    this.guestList.add(guest);
}

}
