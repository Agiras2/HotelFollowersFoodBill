/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelfollowersfoodbill;
/**
 *
 * @author Andrés
 */
public class Chef extends Employee{
    private double extraCost;

    

    public Chef(double extraCost, String nationality) {
        super(nationality);
        this.extraCost = extraCost;
    }

    public Chef(String name, String lastName, long id, String nationality, double extraCost) {
        super(nationality, name, lastName, id);
        this.extraCost = extraCost;
    }

    /**
     * @return the extraCost
     */
    public double getExtraCost() {
        return extraCost;
    }

    /**
     * @param extraCost the extraCost to set
     */
    public void setExtraCost(double extraCost) {
        this.extraCost = extraCost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Chef{");
        sb.append("extraCost=").append(extraCost);
        sb.append('}');
        return sb.toString();
    }
    
}
