/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelfollowersfoodbill;

/**
 *
 * @author Andrés
 */
public class Guest extends Person {
    private int age;
    private String typeOfGuest;
    private long phoneNo;

    public Guest() {
    }

    public Guest(int age, String typeOfGuest, long phoneNo) {
        this.age = age;
        this.typeOfGuest = typeOfGuest;
        this.phoneNo = phoneNo;
    }

    public Guest(int age, String typeOfGuest, long phoneNo, String name, String lastName, long id) {
        super(name, lastName, id);
        this.age = age;
        this.typeOfGuest = typeOfGuest;
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
     * @return the typeOfGuest
     */
    public String getTypeOfGuest() {
        return typeOfGuest;
    }

    /**
     * @param typeOfGuest the typeOfGuest to set
     */
    public void setTypeOfGuest(String typeOfGuest) {
        this.typeOfGuest = typeOfGuest;
    }

    /**
     * @return the phoneNo
     */
    public long getPhoneNo() {
        return phoneNo;
    }

    /**
     * @param phoneNo the phoneNo to set
     */
    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Guest{");
        sb.append("age=").append(age);
        sb.append(", typeOfGuest=").append(typeOfGuest);
        sb.append(", phoneNo=").append(phoneNo);
        sb.append('}');
        return sb.toString();
    }

   
}
