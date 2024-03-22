/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelfollowersfoodbill;

/**
 *
 * @author Andrés
 */
public class Employee extends Person {
    private String nationality;

    public Employee() {
    }

    public Employee(String nationality) {
        this.nationality = nationality;
    }

    public Employee(String nationality, String name, String lastName, long id) {
        super(name, lastName, id);
        this.nationality = nationality;
    }

    /**
     * @return the nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * @param nationality the nationality to set
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employee{");
        sb.append("nationality=").append(nationality);
        sb.append('}');
        return sb.toString();
    }
    
}
