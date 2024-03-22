/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelfollowersfoodbill;

import java.util.ArrayList;
import lecture.Lecture;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author Andrés
 */
public class Reception {
    private final Room room = new Room(); // Instancia de la clase Room
    private final FoodRoom foodRoom = new FoodRoom(); // Instancia de la clase FoodRoom
    private final ArrayGuest arrayGuest = new ArrayGuest(new ArrayList<>()); // Instancia de la clase ArrayGuest
    private final Lecture lecture = new Lecture();
    private final ArrayFood arrayFood = new ArrayFood(); // Objeto ArrayFood creado como campo de clase
    private final FoodFileReader foodFileReader= new FoodFileReader();
    private final ArrayChef arrayChef = new ArrayChef(); // Objeto ArrayChef creado como campo de clase
    private final ChefRoom chefRoom = new ChefRoom(); // Instancia de la clase ChefRoom
    private final ChefFileReader chefFileReader= new ChefFileReader();
    private final Bill bill = new Bill(room, foodRoom, arrayGuest, arrayFood, arrayChef, chefRoom); // instancia de la clase Bill
    private static final int MAX_GUESTS_PER_ROOM = 3;

   
    public static void main(String[] args) {
        Reception reception = new Reception();
        reception.displayMainMenu();
    }

    public void displayMainMenu() {
        int option;
        do {
            System.out.println("\nMenú Principal");
            System.out.println("[1] Trabajar con Huéspedes");
            System.out.println("[2] Gestionar chef, platillos y Ordenes");
            System.out.println("[3] Ver Todo lo Asignado a una Habitación");
            System.out.println("[4] Crear Factura");
            System.out.println("[5] Salir");
            System.out.print("Ingrese opción (1-5): ");
            option = lecture.readInt("");
            switch (option) {
                case 1:
                    guestMenu();
                    break;
                case 2:
                    foodMenu();
                    break;
                case 3:
                    viewRoomAssignments();
                    break;
                case 4:
                    billMenu();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (option != 5);
    }


    private void guestMenu() {
    int option;
    do {
        System.out.println("\n*** Menú de Gestión de Huéspedes ***");
        System.out.println("1. Agregar Huésped a Habitación");
        System.out.println("2. Cambiar Huésped de Habitación");
        System.out.println("3. Eliminar Huésped de Habitación");
        System.out.println("4. Modificar Datos de Huésped en Habitación");
        System.out.println("5. Mostrar Habitaciones Sin Huéspedes");
        System.out.println("6. Mostrar Habitaciones Con Huéspedes");
        System.out.println("7. Mostrar Huéspedes de una Habitación");
        System.out.println("8. Buscar Habitación por ID de Huésped");
        System.out.println("9. Volver al Menú Principal");
        System.out.print("Seleccione una opción: ");
        option = lecture.readInt(""); // Limpiar el buffer del teclado
        switch (option) {
                case 1:
                    addGuestToRoom();
                    break;
                case 2:
                    changeGuestRoom();
                    break;
                case 3:
                    removeGuestFromRoom();
                    break;
                case 4:
                    modifyGuestInRoom();
                    break;
                case 5:
                    room.showEmptyRooms();
                    break;
                case 6:
                    room.showOccupiedRooms();
                    break;
                case 7:
                    showGuestsInRoom();
                    break;
                case 8:
                    findRoomByGuestId();
                    break;
                case 9:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (option != 9);
    }
    
    private void foodMenu() {
        int option;
        do {
            System.out.println("\n*** Menú de Gestión de Platillos por Habitación ***");
            System.out.println("1. Agregar Platillo");
            System.out.println("2. Eliminar Platillo");
            System.out.println("3. Mostrar Todos los Platillos");
            System.out.println("4. Modificar Menú");
            System.out.println("5. Agregar Chef");
            System.out.println("6. Eliminar Chef");
            System.out.println("7. Mostrar todos los Chefs");
            System.out.println("8. Modificar lista de Chefs");
            System.out.println("9. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            option = lecture.readInt(""); // Usar readInt de Lecture
            switch (option) {
                case 1:
                    addFoodToRoomInteractively();
                    break;
                case 2:
                    removeFood();
                    break;
                case 3:
                    FoodFileReader foodFileReader = new FoodFileReader();
                    List<FoodItems> allFoodItems = foodFileReader.readFoodItemsFromFile();
                    System.out.println("\n*** Lista de Todos los Platillos ***");
                    for (int i = 0; i < allFoodItems.size(); i++) {
                        FoodItems foodItem = allFoodItems.get(i);
                        System.out.println((i) + ". Nombre: " + foodItem.getName());
                        System.out.println("   Precio: " + foodItem.getPrice());
                        System.out.println("   Etiqueta: " + foodItem.getLabel());
                        System.out.println("-----------------------------------");
                    }
                    break;
                case 4:
                    modifyMenu();
                    break;
                case 5:
                    addChefToRoomInteractively();
                    break;
                case 6:
                    removeChef();
                    break;
                case 7:
                    ChefFileReader chefFileReader = new ChefFileReader();
                    List<Chef> allChefs = chefFileReader.readChefsFromFile();
                    System.out.println("\n*** Lista de Todos los Chefs ***");
                    for (int i = 0; i < allChefs.size(); i++) {
                        Chef chef = allChefs.get(i);
                        System.out.println((i) + ". Nombre: " + chef.getName());
                        System.out.println("   Apellido: " + chef.getLastName());
                        System.out.println("   ID: " + chef.getId());
                        System.out.println("   Nacionalidad: " + chef.getNationality());
                        System.out.println("   Costo Extra: " + chef.getExtraCost());
                        System.out.println("-----------------------------------");
                    }
                    break;
                case 8:
                    modifyChefList();
                    break;
                case 9:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (option != 9);
    }
    
    private void removeFood() {
        int removeOption;
        do {
            System.out.println("\n*** Opciones de Eliminación de Platillo ***");
            System.out.println("1. Eliminar un platillo específico");
            System.out.println("2. Eliminar todos los platillos de una habitación");
            System.out.println("3. Volver al Menú Anterior");
            System.out.print("Seleccione una opción de eliminación: ");
            removeOption = lecture.readInt(""); // Usar readInt de Lecture
            switch (removeOption) {
                case 1:
                    removeFoodFromRoom();
                    break;
                case 2:
                    removeAllFoodFromRoom();
                    break;
                case 3:
                    System.out.println("Volviendo al Menú Anterior...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (removeOption != 3);
           
    }
    
    private void modifyMenu() {
        int modifyOption;
        do {
            System.out.println("\n*** Menú de Modificación de Menú ***");
            System.out.println("1. Agregar Platillo al Menú");
            System.out.println("2. Actualizar Platillo en el Menú");
            System.out.println("3. Eliminar Platillo del Menú");
            System.out.println("4. Volver al Menú Anterior");
            System.out.print("Seleccione una opción de modificación: ");
            modifyOption = lecture.readInt(""); // Usar readInt de Lecture
            switch (modifyOption) {
                case 1:
                    addFoodItemToFileInteractively();
                    break;
                case 2:
                    updateFoodItemInFileInteractively();
                    break;
                case 3:
                    deleteFoodItemFromFileInteractively();
                    break;
                case 4:
                    System.out.println("Volviendo al Menú Anterior...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (modifyOption != 4);
    }
    
    private void removeChef() {
        int removeOption;
        do {
            System.out.println("\n*** Opciones de Eliminación de Chef ***");
            System.out.println("1. Eliminar un chef específico");
            System.out.println("2. Eliminar todos los chefs de una habitación");
            System.out.println("3. Volver al Menú Anterior");
            System.out.print("Seleccione una opción de eliminación: ");
            removeOption = lecture.readInt(""); // Usar readInt de Lecture
            switch (removeOption) {
                case 1:
                    removeChefFromRoom();
                    break;
                case 2:
                    removeAllChefsFromRoom();
                    break;
                case 3:
                    System.out.println("Volviendo al Menú Anterior...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (removeOption != 3);
    }

    private void modifyChefList() {
        int modifyOption;
        do {
            System.out.println("\n*** Menú de Modificación de Lista de Chefs ***");
            System.out.println("1. Agregar Chef a la Lista");
            System.out.println("2. Eliminar Chef de la Lista");
            System.out.println("3. Actualizar Chef en la Lista de Chefs");
            System.out.println("4. Volver al Menú Anterior");
            System.out.print("Seleccione una opción de modificación: ");
            modifyOption = lecture.readInt(""); // Usar readInt de Lecture
            switch (modifyOption) {
                case 1:
                    addChefToFileInteractively();
                    break;
                case 2:
                    deleteChefFromFileInteractively();
                    break;
                case 3:
                    updateChefInFileInteractively();
                    break;
                case 4:
                    System.out.println("Volviendo al Menú Anterior...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (modifyOption != 4);
    }
    
    public void billMenu() {
        int option;
        do {
            System.out.println("\n*** Menú de Factura ***");
            System.out.println("1. Ver factura de habitación");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            option = lecture.readInt("");
            switch (option) {
                case 1:
                    printRoomBill();
                    break;
                case 2:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (option != 2);
    }

    public void printRoomBill() {
        int roomNumber = lecture.readInt("Ingrese el número de habitación: ");
        bill.printBill(roomNumber);
    }

    
    public void viewRoomAssignments() {
        System.out.println("\nVer Todo Asignado a una Habitación");

        // Mostrar habitaciones ocupadas para seleccionar una
        room.showOccupiedRooms();

        int roomNumber = lecture.readIntPositive("Seleccione una habitación para ver todo lo asignado: ");
        if (roomNumber >= 0 && roomNumber < room.getRooms().size()) {
            room.showGuestsInRoom(roomNumber);

            // Mostrar los chefs asignados a la habitación seleccionada
            List<Chef> selectedChefs = room.getRoomSelectedChefs().get(roomNumber);
            if (!selectedChefs.isEmpty()) {
                System.out.println("\nChefs:");
                for (Chef chef : selectedChefs) {
                    System.out.println("Nombre: " + chef.getName());
                    System.out.println("Apellido: " + chef.getLastName());
                    System.out.println("ID: " + chef.getId());
                    System.out.println("Nacionalidad: " + chef.getNationality());
                    System.out.println("Costo Extra: " + chef.getExtraCost());
                    System.out.println("-----------------------------------");
                }
            } else {
                System.out.println("No se han asignado chefs a esta habitación.");
            }

            // Mostrar solo los alimentos asignados a la habitación seleccionada
            List<FoodItems> selectedFoods = room.getRoomSelectedFoods().get(roomNumber);
            if (!selectedFoods.isEmpty()) {
                System.out.println("\nPlatillos:");
                for (FoodItems foodItem : selectedFoods) {
                    System.out.println("Nombre: " + foodItem.getName());
                    System.out.println("Precio: " + foodItem.getPrice());
                    System.out.println("Etiqueta: " + foodItem.getLabel());
                    System.out.println("-----------------------------------");
                }
            } else {
                System.out.println("No se han asignado platillos a esta habitación.");
            }
        } else {
            System.out.println("Número de habitación inválido.");
        }
    }

    public void addGuestToRoom() {
        int option = lecture.readInt("Ingrese la opción deseada (1 para ingresar manualmente, 2 para obtener de la lista de jugadores de fútbol): ");

        if (option == 1) {
            int roomNumber = lecture.readIntPositive("Ingrese el número de habitación: ");

            // Verificar si la habitación está dentro del rango válido
            if (roomNumber >= 0 && roomNumber < room.getRooms().size()) {
                // Obtener los datos del huésped desde la entrada estándar
                Guest newGuest = arrayGuest.inputGuest();

                // Agregar el huésped a la habitación seleccionada
                room.getRooms().get(roomNumber).getGuestList().add(newGuest);

                System.out.println("Huesped agregado exitosamente a la habitación " + roomNumber);
            } else {
                System.out.println("Número de habitación inválido.");
            }
        } else if (option == 2) {
            // Opción para obtener de la lista de jugadores de fútbol
            List<Guest> guestsFromPlayersList = readPlayersFromFile("Resources/PlayerList.txt");
            distributeGuestsToRooms(guestsFromPlayersList);
        } else {
            System.out.println("Opción inválida.");
        }
    }

    private List<Guest> readPlayersFromFile(String filename) {
        // Lista para almacenar los huéspedes leídos del archivo
        List<Guest> guests = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            // Leer cada línea del archivo
            while ((line = reader.readLine()) != null) {
                // Dividir la línea en partes utilizando la coma y el espacio como delimitadores
                String[] parts = line.split(", ");
                // Utilizar una expresión regular para extraer los datos de la línea
                Matcher matcher = Pattern.compile("name: ([^,]+), id: ([^,]+), age: ([^,]+), phoneNo: ([^,]+)")
                        .matcher(line);
                // Verificar si se encontró un patrón coincidente en la línea
                if (matcher.find()) {
                    // Extraer el nombre completo del primer grupo de captura
                    String name = matcher.group(1);
                    // Dividir el nombre completo en nombre y apellido
                    String lastName = name.split(" ")[1];
                    String firstName = name.split(" ")[0];
                    // Obtener el ID del segundo grupo de captura y convertirlo a tipo long
                    long id = Long.parseLong(matcher.group(2));
                    // Obtener la edad del tercer grupo de captura y convertirla a tipo int
                    int age = Integer.parseInt(matcher.group(3));
                    // Obtener el número de teléfono del cuarto grupo de captura y convertirlo a tipo long
                    long phoneNo = Long.parseLong(matcher.group(4));

                    // Crear un nuevo objeto Guest con los datos extraídos y agregarlo a la lista
                    Guest guest = new Guest(age, "Deportista", phoneNo, firstName, lastName, id);
                    guests.add(guest);
                } else {
                    // Imprimir un mensaje de advertencia si la línea no tiene el formato esperado
                    System.out.println("Línea Inválida: " + line);
                }
            }
        } catch (IOException e) {
            // Imprimir cualquier excepción de E/S que ocurra durante la lectura del archivo
            e.printStackTrace();
        }

        // Devolver la lista de huéspedes creada a partir de los datos del archivo
        return guests;
    }

    /**
    * Distribuye los huéspedes en las habitaciones disponibles.
    * @param guests Lista de huéspedes a distribuir en las habitaciones.
    */
    private void distributeGuestsToRooms(List<Guest> guests) {
        // Obtener una lista de todas las habitaciones
        List<ArrayGuest> rooms = getEmptyRooms();
        // Array para rastrear si cada habitación está llena o no
        boolean[] isRoomFull = new boolean[rooms.size()];

        // Solicitar al usuario que elija una habitación para cada huésped
        for (Guest guest : guests) {
            // Imprimir las habitaciones disponibles
            for (int j = 0; j < rooms.size(); j++) {
                if (!isRoomFull[j]) {
                   System.out.println("Habitación " + j);
                   System.out.println("-------------------");
                }
            }

           // Imprimir el nombre del huésped que se está agregando
           System.out.println("Asignando Huésped: " + guest.getName() + " " + guest.getLastName());

           // Solicitar al usuario que elija una habitación para este huésped
           int choice = lecture.readIntPositive("Escoja una Habitación (0 para cancelar)");

            if (choice >= 0 && choice < rooms.size()) {
                // Agregar al huésped a la habitación seleccionada
                rooms.get(choice).addGuest(guest);
                // Marcar la habitación como llena si alcanza la capacidad máxima de huéspedes
                isRoomFull[choice] = rooms.get(choice).getGuestList().size() >= MAX_GUESTS_PER_ROOM;
            } else {
                System.out.println("Opción inválida o habitación llena. Selecciona otra habitación.");
            }
        }
        System.out.println("¡Los Huéspedes han sido distribuidos en las Habitaciones Exitosamente!");
    }

    // Provee la lista de habitaciones vacias
    public List<ArrayGuest> getEmptyRooms() {
        List<ArrayGuest> emptyRooms = new ArrayList<>();
        for (ArrayGuest room : room.getRooms()) {
            if (room.getGuestList().isEmpty()) {
                emptyRooms.add(room);
            }
        }
        return emptyRooms;
    }


    public void changeGuestRoom() {
        System.out.println("\nCambiar Huésped de Habitación");

        // Mostrar las habitaciones con huéspedes para seleccionar la habitación actual del huésped
        System.out.println("Habitaciones con huéspedes:");
        room.showOccupiedRooms();
        int currentRoomNumber = lecture.readIntPositive("Ingrese el número de la habitación actual del huésped: ");

        // Verificar si el número de habitación actual es válido
        if (currentRoomNumber >= 0 && currentRoomNumber < room.getRooms().size()) {
            // Mostrar las habitaciones disponibles para seleccionar la nueva habitación
            System.out.println("Habitaciones disponibles:");
            room.showEmptyRooms();
            int newRoomNumber = lecture.readIntPositive("Ingrese el número de la nueva habitación para mover al huésped: ");

            // Verificar si el número de la nueva habitación es válido
            if (newRoomNumber >= 0 && newRoomNumber < room.getRooms().size()) {
                room.showGuestsInRoom(currentRoomNumber);
                long guestId = lecture.readLongPositive("Ingrese el ID del huésped que desea mover: ");

                // Llamar al método changeGuestRoom con los valores proporcionados
                room.changeGuestRoom(currentRoomNumber, newRoomNumber, guestId);
            } else {
                System.out.println("Número de nueva habitación inválido.");
            }
        } else {
            System.out.println("Número de habitación actual inválido.");
        }
    }


   public void removeGuestFromRoom() {
        int roomNumber = lecture.readIntPositive("Ingrese el número de habitación: ");
        room.showGuestsInRoom(roomNumber);
        long guestId = lecture.readLongPositive("Ingrese el ID del huésped que desea eliminar: ");

        // Llamar al método removeGuestFromRoom de la clase Room
        room.removeGuestFromRoom(roomNumber, guestId);

        // Verificar si la habitación está vacía y eliminar todos los platillos si es el caso
        if (room.getRooms().get(roomNumber).getNumberOfGuests() == 0) {
            foodRoom.removeAllFoodFromRoom(room, roomNumber);
            chefRoom.removeAllChefsFromRoom(room, roomNumber);
        }
    }

    public void modifyGuestInRoom() {
        int roomNumber = lecture.readIntPositive("Ingrese el número de habitación: ");
        room.showGuestsInRoom(roomNumber);
        long guestId = lecture.readLongPositive("Ingrese el ID del huésped que desea modificar: ");

        // Llamar al método modifyGuestInRoom de la clase Room
        room.modifyGuestInRoom(roomNumber, guestId);
    }

    public void showGuestsInRoom() {
        int roomNumber = lecture.readInt("Ingrese el número de habitación: ");

        // Llamar al método showGuestsInRoom de la clase Room
        room.showGuestsInRoom(roomNumber);
    }

    public void findRoomByGuestId() {
        long guestId = lecture.readLongPositive("Ingrese el ID del huésped: ");

        // Llamar al método findRoomByGuestId de la clase Room
        int roomNumber = room.findRoomByGuestId(guestId);
        if (roomNumber != -1) {
            System.out.println("El huésped con ID " + guestId + " se encuentra en la habitación " + roomNumber);
        } else {
            System.out.println("El huésped con ID " + guestId + " no se encuentra en ninguna habitación.");
        }
    }
    
    private void addFoodToRoomInteractively() {    //menu 2
        System.out.println("Habitaciones con huéspedes:");
        room.showOccupiedRooms();
        // Obtener el número de habitación
        int roomNumber = lecture.readInt("Ingrese el número de la habitación: ");

        // Llamar al método addFoodToRoomInteractively de FoodRoom
        foodRoom.addFoodToRoomInteractively(room, roomNumber, arrayFood);
    }
    
    
    private void removeFoodFromRoom() {  
        System.out.println("\nVer Platillos Asignados a una Habitación");

        // Mostrar habitaciones ocupadas para seleccionar una
        room.showOccupiedRooms();

        int roomNumber = lecture.readIntPositive("Seleccione una habitación para ver los platillos asignados: ");
            if (roomNumber >= 0 && roomNumber < room.getRooms().size()) {
                System.out.println("\nPlatillos Asignados en Habitación " + roomNumber + ":");

                // Mostrar solo los alimentos asignados a la habitación seleccionada
                List<FoodItems> selectedFoods = room.getRoomSelectedFoods().get(roomNumber);
                if (!selectedFoods.isEmpty()) {
                    for (int i = 0; i < selectedFoods.size(); i++) {
                        FoodItems foodItem = selectedFoods.get(i);
                        System.out.println("No: " + i);
                        System.out.println("Nombre: " + foodItem.getName());
                        System.out.println("Precio: " + foodItem.getPrice());
                        System.out.println("Etiqueta: " + foodItem.getLabel());
                        System.out.println("-----------------------------------");
                    }
                } else { 
                    System.out.println("No se han asignado Platillos a esta habitación.");
                }
            } else {
                System.out.println("Número de habitación inválido.");
        }
        int foodIndex = lecture.readInt("Ingrese el número del platillo a eliminar: ");

        // Llamar al método removeFoodFromRoom de FoodRoom
        foodRoom.removeFoodFromRoom(room, roomNumber, foodIndex);
    }

    private void removeAllFoodFromRoom() {  
        System.out.println("Habitaciones con huéspedes:");
        room.showOccupiedRooms();
        // Obtener el número de habitación
        int roomNumber = lecture.readInt("Ingrese el número de la habitación: ");

        // Llamar al método removeAllFoodFromRoom de FoodRoom
        foodRoom.removeAllFoodFromRoom(room, roomNumber);
    }
    
    public void addFoodItemToFileInteractively() {
        String name = lecture.readString("Ingrese el nombre del platillo: ");
        double price = lecture.readDouble("Ingrese el precio del platillo: ");
        int label = lecture.readInt("Ingrese la etiqueta del platillo: ");

        FoodItems foodItem = new FoodItems(name, price, label);
        foodFileReader.addFoodItemToFile(foodItem);
    }

    public void updateFoodItemInFileInteractively() {
        List<FoodItems> foodItemsList = foodFileReader.readFoodItemsFromFile();
        int index = lecture.readInt("Ingrese el índice del platillo a actualizar: ");
        if (index >= 0 && index < foodItemsList.size()) {
            String name = lecture.readString("Ingrese el nuevo nombre del platillo: ");
            double price = lecture.readDouble("Ingrese el nuevo precio del platillo: ");
            int label = lecture.readInt("Ingrese la nueva etiqueta del platillo: ");

            FoodItems updatedFoodItem = new FoodItems(name, price, label);
            foodFileReader.updateFoodItemInFile(index, updatedFoodItem);
        } else {
            System.out.println("Índice de alimento fuera de rango.");
        }
    }

    public void deleteFoodItemFromFileInteractively() {
            List<FoodItems> foodItemsList = foodFileReader.readFoodItemsFromFile();
            int index = lecture.readInt("Ingrese el índice del platillo a eliminar: ");
            foodFileReader.deleteFoodItemFromFile(index);
        }

    private void addChefToRoomInteractively() {
        room.showOccupiedRooms();
        // Obtener el número de habitación
        int roomNumber = lecture.readInt("Ingrese el número de la habitación: ");

        // Llamar al método addChefToRoomInteractively de FoodRoom
        chefRoom.addChefToRoomInteractively(room, roomNumber, arrayChef);
    }

    private void removeChefFromRoom() {
        System.out.println("\nVer Chefs Asignados a una Habitación");

        // Mostrar habitaciones ocupadas para seleccionar una
        room.showOccupiedRooms();

        int roomNumber = lecture.readIntPositive("Seleccione una habitación para ver los chefs asignados: ");
        if (roomNumber >= 0 && roomNumber < room.getRooms().size()) {
            System.out.println("\nChefs Asignados en Habitación " + roomNumber + ":");

            // Mostrar solo los chefs asignados a la habitación seleccionada
            List<Chef> selectedChefs = room.getRoomSelectedChefs().get(roomNumber);
            if (!selectedChefs.isEmpty()) {
                for (int i = 0; i < selectedChefs.size(); i++) {
                    Chef chef = selectedChefs.get(i);
                    System.out.println("No: " + i);
                    System.out.println("Nombre: " + chef.getName());
                    System.out.println("Apellido: " + chef.getLastName());
                    System.out.println("ID: " + chef.getId());
                    System.out.println("Nacionalidad: " + chef.getNationality());
                    System.out.println("Costo Extra: " + chef.getExtraCost());
                    System.out.println("-----------------------------------");
                }
            } else {
                System.out.println("No se han asignado chefs a esta habitación.");
            }
        } else {
            System.out.println("Número de habitación inválido.");
        }
        int chefIndex = lecture.readInt("Ingrese el número del chef a eliminar: ");

        // Llamar al método removeChefFromRoom de FoodRoom
        chefRoom.removeChefFromRoom(room, roomNumber, chefIndex);
    }

    private void removeAllChefsFromRoom() {
        room.showOccupiedRooms();
        // Obtener el número de habitación
        int roomNumber = lecture.readInt("Ingrese el número de la habitación: ");

        // Llamar al método removeAllChefsFromRoom de FoodRoom
        chefRoom.removeAllChefsFromRoom(room, roomNumber);
    }
    
    public void addChefToFileInteractively() {
        String name = lecture.readString("Ingrese el nombre del chef: ");
        String lastName = lecture.readString("Ingrese el apellido del chef: ");
        long id = lecture.readLongPositive("Ingrese el ID del chef: ");
        String nationality = lecture.readString("Ingrese la nacionalidad del chef: ");
        double extraCost = lecture.readDouble("Ingrese el costo extra del chef: ");

        Chef chef = new Chef(name, lastName, id, nationality, extraCost);
        chefFileReader.addChefToFile(chef);
    }

    public void updateChefInFileInteractively() {
        List<Chef> chefList = chefFileReader.readChefsFromFile();
        int index = lecture.readInt("Ingrese el índice del chef a actualizar: ");
        if (index >= 0 && index < chefList.size()) {
            String name = lecture.readString("Ingrese el nuevo nombre del chef: ");
            String lastName = lecture.readString("Ingrese el nuevo apellido del chef: ");
            long id = lecture.readLongPositive("Ingrese el nuevo ID del chef: ");
            String nationality = lecture.readString("Ingrese la nueva nacionalidad del chef: ");
            double extraCost = lecture.readDouble("Ingrese el nuevo costo extra del chef: ");

            Chef updatedChef = new Chef(name, lastName, id, nationality, extraCost);
            chefFileReader.updateChefInFile(index, updatedChef);
        } else {
            System.out.println("Índice de chef fuera de rango.");
        }
    }

    public void deleteChefFromFileInteractively() {
        List<Chef> chefList = chefFileReader.readChefsFromFile();
        int index = lecture.readInt("Ingrese el índice del chef a eliminar: ");
        chefFileReader.deleteChefFromFile(index);
    }

}
