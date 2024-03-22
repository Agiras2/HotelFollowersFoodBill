/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lecture;
import java.util.Scanner;
/**
 *
 * @author Andrés
 */
public class Lecture {
    Scanner sc = new Scanner(System.in);
    
    public int readInt(String mesaje){
        System.out.println(mesaje+": ");
        while (!sc.hasNextInt()) {
            System.out.println("Invalid Value.");
            sc.next();
        }
        int value = sc.nextInt();
        sc.nextLine(); // Consume the rest of the line to avoid issues
        return value;
    }
    
    public double readDouble(String mesaje) {
        System.out.print(mesaje+": ");
        while (!sc.hasNextDouble()) {
            System.out.println("Invalid Value.");
            sc.next();
            sc.nextLine();
        }
        double value = sc.nextDouble();
        return value;
    }
    
    public float readFloat(String mesaje) {
        System.out.print(mesaje+": ");
        while (!sc.hasNextFloat()) {
            System.out.println("Invalid Value.");
            sc.next();
            sc.nextLine();
        }
        float value = sc.nextFloat();
        return value;
    }
    
    public boolean readBoolean(String mesaje) {
        System.out.print(mesaje+": ");
        boolean value;
        while (true) {
            if (sc.hasNextBoolean()) {
                value = sc.nextBoolean();
                break;
            } else {
                System.out.println("Invalid Value.");
                sc.next();
                sc.nextLine();
            }
        }
        return value;
    }
        
    public byte readByte(String mesaje) {
        System.out.print(mesaje+": ");
        while (!sc.hasNextByte()) {
            System.out.println("Invalid Value.");
            sc.next();
            sc.nextLine();
        }
        byte value = sc.nextByte();
        return value;
    }
   
    public String readString(String mesaje) {
        System.out.println(mesaje + ": ");
        String value = sc.next();
        sc.nextLine(); // Consume the rest of the line
        return value;
    }
    
    public String readLine(String mesaje){
        System.out.println(mesaje+": ");
        String line = sc.nextLine();
        return line;
    }
    
    public int readIntPositive(String mesaje) {
    	int value;
        do{
            value =readInt(mesaje);
            if (value<0){
                System.out.println("Invalid value.");
            }
        }while (value<0);
    	return value;
    }
    
    public int readIntNegative(String mesaje) {
    	int value;
        do{
            value =readInt(mesaje);
            if (value>=0){
                System.out.println("Invalid value.");
            }
        }while (value>=0);
    	return value;
    }
    
    public float readFloatPositive(String mesaje) {
    	float value;
        do{
            value =readFloat(mesaje);
            if (value<0){
                System.out.println("Invalid value.");
            }
        }while (value<0);
    	return value;
    }
    
    public float readFloatNegative(String mesaje) {
    	float value;
        do{
            value =readFloat(mesaje);
            if (value>=0){
                System.out.println("Invalid value.");
            }
        }while (value>=0);
    	return value;
    }
    public long readLong(String mesaje) {
    System.out.print(mesaje + ": ");
    while (!sc.hasNextLong()) {
        System.out.println("Valor inválido.");
        sc.next();
        sc.nextLine();
    }
    long value = sc.nextLong();
    return value;
    }
    
    public long readLongPositive(String mesaje) {
        long value;
        do {
            value = readLong(mesaje);
            if (value < 0) {
                System.out.println("Valor inválido.");
            }
        } while (value < 0);
        return value;
    }

    public long readLongNegative(String mesaje) {
        long value;
        do {
            value = readLong(mesaje);
            if (value >= 0) {
                System.out.println("Valor inválido.");
            }
        } while (value >= 0);
        return value;
    }
  
}

