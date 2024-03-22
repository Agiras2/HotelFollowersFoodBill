/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelfollowersfoodbill;

/**
 *
 * @author Andrés
 */
public class Person {
    private String name;
    private String lastName;
    private long id;

    public Person() {
    }

    public Person(String name, String lastName, long id) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
    }


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person{");
        sb.append("name=").append(getName());
        sb.append(", lastName=").append(getLastName());
        sb.append(", id=").append(getId());
        sb.append('}');
        return sb.toString();
    }
}
