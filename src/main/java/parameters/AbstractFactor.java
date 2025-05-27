/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parameters;

/**
 * A class for a factor of the simulation.
 * 
 * @author Alex
 */
public abstract class AbstractFactor {
    public double minVal;
    public double maxVal;
    public double defaultVal;
    
    public AbstractFactor() {
        minVal = 0.0;
        maxVal = 0.0;
        defaultVal = 0.0;
    }
}
