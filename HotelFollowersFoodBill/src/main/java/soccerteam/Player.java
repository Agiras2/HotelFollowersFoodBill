/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soccerteam;
/**
 *
 * @author Andrés
 */
public class Player extends Person implements Comparable<Player> {
    private int age;
    private int phoneNo;


    public Player() {
    }


    public Player(String name, String lastName, long id, int age, int phoneNo) {
        super(name, lastName, id);
        this.age = age;
        this.phoneNo = phoneNo;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the phoneNo
     */
    public int getPhoneNo() {
        return phoneNo;
    }

    /**
     * @param phoneNo the phoneNo to set
     */
    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Player{");
        sb.append("age=").append(age);
        sb.append(", phoneNo=").append(phoneNo);
        sb.append('}');
        return sb.toString();
    }
    @Override
        public int compareTo(Player otherPlayer) {
            // Compara los nombres de los jugadores
            return this.getName().compareTo(otherPlayer.getName());
        }    
    
}