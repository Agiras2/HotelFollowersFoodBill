/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soccerteam;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import lecture.Lecture;
import java.io.PrintWriter;
/**
 *
 * @author Andrés
 */
public class Team {
    private final ArrayList<Player> team;
    private final Scanner sc = new Scanner(System.in);
    private final Lecture lecture = new Lecture();

    public Team() {
        team = new ArrayList<>();
    }

    public static void main(String[] args) {
        Team projectTeam = new Team();
        projectTeam.readOption();
    }

    public void readOption() {
        int option;
        do {
            System.out.println("Lista de acciones.");
            System.out.println("[1] Agregar");
            System.out.println("[2] Buscar jugador por ID");  
            System.out.println("[3] Modificar Jugador ");
            System.out.println("[4] Eliminar Jugador ");
            System.out.println("[5] Insertar Jugador ");
            System.out.println("[6] Mostrar Jugadores en la lista");
            System.out.println("[7] Ordenar por nombre de forma ascendente ");
            System.out.println("[8] Ordenar por nombre de forma descendente ");
            System.out.println("[9] Salir\n");
            System.out.print("Ingrese opcion (1-9): ");
            option = sc.nextInt();

            switch (option) {
                case 1 -> inputPlayer();
                case 2 -> searchPlayer();
                case 3 -> modifyPlayer();
                case 4 -> deletePlayer();
                case 5 -> insertPlayer();
                case 6 -> showList();
                case 7 -> ascendingOrder();
                case 8 -> descendingOrder();
            }
        } while (option != 9);
    }
    
    public void inputPlayer() {
        String name = lecture.readString("Ingrese el nombre del jugador: ");
        String lastName = lecture.readString("Ingrese el primer apellido del jugador: ");
        long id = lecture.readLong("Ingrese el ID del jugador: "); // Utilizar readLong() para IDs largos
        int age = lecture.readInt("Ingrese la edad del jugador: ");
        int phoneNo = lecture.readInt("Ingrese el número de teléfono del jugador: ");
        sc.nextLine();

        Player newPlayer = new Player(name, lastName, id, age, phoneNo);
        team.add(newPlayer);

        // Guardar el nuevo jugador en el archivo de texto
        savePlayerToFile(newPlayer);
    }
   
    public void savePlayerToFile(Player player) {
        try {
            FileWriter writer = new FileWriter("Resources/PlayerList.txt", true);
            PrintWriter printWriter = new PrintWriter(writer);

            String playerInfo = String.format("name: %s %s, id: %d, age: %d, phoneNo: %d%n",
                                                player.getName(), player.getLastName(),
                                                player.getId(), player.getAge(), player.getPhoneNo());
            printWriter.println(playerInfo);

            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void searchPlayer() {
        int idToSearch = lecture.readInt("Ingrese el ID a buscar: ");
        boolean playerFound = false;

        for (int i = 0; i < team.size(); i++) {
            Player player = team.get(i);
            if (player.getId() == idToSearch) {
                System.out.println("El jugador se encuentra en la posición: " + i);
                playerFound = true;
                break;
            }
        }
        if (!playerFound) {
            System.out.println("El jugador no se encuentra en la lista.");
        }
    }

    
    public void modifyPlayer() {
        long playerId = lecture.readLong("Ingrese el ID del jugador a modificar: ");
        int index = findPlayerIndexById(playerId);

        if (index != -1) {
            Player player = team.get(index);
            System.out.println("Jugador encontrado: ");

            String newName = lecture.readString("Ingrese el nombre completo del jugador: ");
            String newLastName = lecture.readString("Ingrese el primer apellido del jugador: ");
            int newAge = lecture.readInt("Ingrese la nueva edad del jugador: ");
            int newPhoneNo = lecture.readInt("Ingrese el nuevo número de teléfono del jugador: ");

            player.setName(newName);
            player.setLastName(newLastName);
            player.setAge(newAge);
            player.setPhoneNo(newPhoneNo);

            // Reemplazar el jugador antiguo con el jugador modificado en la lista
            team.set(index, player);

            // Actualizar el archivo de texto con la lista de jugadores
            updatePlayerListFile();

            System.out.println("¡Jugador modificado con éxito!");
        } else {
            System.out.println("El jugador con el ID " + playerId + " no se encuentra en el equipo.");
        }
    }
    
    public void deletePlayer() {
       long playerId = lecture.readLongPositive("Ingrese el ID del jugador a eliminar: ");
       int index = findPlayerIndexById(playerId);

       if (index != -1) {
           team.remove(index);
           System.out.println("Jugador eliminado exitosamente");

           // Actualizar el archivo de texto con la lista de jugadores
           updatePlayerListFile();
       } else {
           System.out.println("No se encontró ningún jugador con el ID " + playerId);
       }
   }

    public void insertPlayer() {
        String name = lecture.readString("Ingrese el nombre completo del jugador: ");
        String lastName = lecture.readString("Ingrese el primer apellido del jugador: ");
        long id = lecture.readLong("Ingrese el ID del jugador: ");
        int age = lecture.readInt("Ingrese la edad del jugador: ");
        int phoneNo = lecture.readInt("Ingrese el número de teléfono del jugador: ");

        Player newPlayer = new Player(name, lastName, id, age, phoneNo);
        int index = lecture.readIntPositive("Posicion donde desea insertar:");

        if (index >= 0 && index <= team.size()) {
            team.add(index, newPlayer);

            // Actualizar el archivo de texto con la lista de jugadores
            updatePlayerListFile();

            System.out.println("Jugador insertado exitosamente.");
        } else {
            System.out.println("Posición no válida");
        }
    }

    private void updatePlayerListFile() {
        try {
            FileWriter writer = new FileWriter("Resources/PlayerList.txt");
            PrintWriter printWriter = new PrintWriter(writer);

            for (Player player : team) {
                String playerInfo = String.format("name: %s %s, id: %d, age: %d, phoneNo: %d%n",
                                                    player.getName(), player.getLastName(),
                                                    player.getId(), player.getAge(), player.getPhoneNo());
                printWriter.println(playerInfo);
            }

            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showList() {
        if (!team.isEmpty()) {
            System.out.println("Elementos de la lista:");

            for (Player player : team) {
                System.out.println("Nombre: " + player.getName());
                System.out.println("Primer Apellido: " + player.getLastName());
                System.out.println("ID: " + player.getId());
                System.out.println("Edad: " + player.getAge());
                System.out.println("Teléfono: " + player.getPhoneNo());
                System.out.println();
            }
        } else {
            System.out.println("No existen valores en la lista");
        }
    }
    
    public void ascendingOrder() {
        Collections.sort(team);
        showList();
    }

    public void descendingOrder() {
        Comparator<Player> comparator = Collections.reverseOrder();
        team.sort(comparator);
        showList();
    }
    
    public int findPlayerIndexById(long playerId) {
        for (int i = 0; i < team.size(); i++) {
            if (team.get(i).getId() == playerId) {
                return i;
            }
        }
        return -1;
    }
}
    

            
