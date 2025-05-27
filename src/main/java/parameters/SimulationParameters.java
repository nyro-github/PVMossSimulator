/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parameters;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class SimulationParameters {
    private final List<AbstractFactor> factors;
    
    public SimulationParameters() {
        factors = new ArrayList<>();
        factors.add(new SunLevel());
        factors.add(new CloudLevel());
    }
    
    public void printAllFactors() {
        for (AbstractFactor factor : factors) {
            System.out.println(factor.toString());
        }
    }
    
    public void setFactors(List<Double> values) {
        int k = 0;
        for(AbstractFactor fct : factors) {
            fct.setVal(values.get(k));
            k++;
        }
    }

    public List<AbstractFactor> getFactors() {
        return factors;
    }
}
