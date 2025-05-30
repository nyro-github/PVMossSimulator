package parameters;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class to manage all simulation parameters (factors).
 * Allows direct access and modification of individual parameters.
 * 
 * Example usage:
 *     SimulationParameters.getInstance().setSunLevel(0.8);
 *     double area = SimulationParameters.getInstance().getPVArea().getVal();
 * 
 * @author Alex
 */
public class SimulationParameters {

    private boolean isEnabledPV;
    
    private boolean isEnabledMoss;
    
    // Static instance for singleton
    private static SimulationParameters instance = null;

    // Individual factors
    private final SunLevel sunLevel;
    private final CloudLevel cloudLevel;
    private final FacadeArea area;
    private final PVAngle pvangle;
    private final Temp temp;
    private final MossHumidity mossHumidity;
    private final MossMoisture mossMoisture;

    // List of all factors (for iteration or bulk operations)
    private final List<AbstractFactor> factors;

    // Private constructor
    private SimulationParameters() {
        sunLevel = new SunLevel();
        cloudLevel = new CloudLevel();
        area = new FacadeArea();
        pvangle = new PVAngle();
        temp = new Temp();
        mossHumidity = new MossHumidity();
        mossMoisture = new MossMoisture();

        factors = new ArrayList<>();
        factors.add(sunLevel);
        factors.add(cloudLevel);
        factors.add(area);
        factors.add(pvangle);
        factors.add(temp);
        factors.add(mossMoisture);
        factors.add(mossHumidity);
        
        isEnabledPV = true;
        isEnabledMoss = true;
    }

    // Singleton accessor
    public static SimulationParameters getInstance() {
        if (instance == null) {
            instance = new SimulationParameters();
        }
        return instance;
    }

    // Direct getters
    public SunLevel getSunLevel() { return sunLevel; }
    public CloudLevel getCloudLevel() { return cloudLevel; }
    public FacadeArea getArea() { return area; }
    public PVAngle getPVAngle() { return pvangle; }
    public Temp getTemp() { return temp; }
    public MossMoisture getMossMoisture() { return mossMoisture; }
    public MossHumidity getMossHumidity() { return mossHumidity; }

    // Direct setters
    public void setSunLevel(double val) { sunLevel.setVal(val); }
    public void setCloudLevel(double val) { cloudLevel.setVal(val); }
    public void setArea(double val) { area.setVal(val); }
    public void setPVAngle(double val) { pvangle.setVal(val); }
    public void setTemp(double val) { temp.setVal(val); }
    public void setMossMoisture(double val) { mossMoisture.setVal(val); }
    public void setMossHumidity(double val) { mossHumidity.setVal(val); }

    // Bulk access
    public List<AbstractFactor> getFactors() {
        return factors;
    }
    
    public void setEnabledPV(boolean setting) {
        isEnabledPV = setting;
    }
    
    public void setEnabledMoss(boolean setting) {
        isEnabledMoss = setting;
    }
    
    public boolean isEnabledPV() {
        return isEnabledPV;
    }
    
    public boolean isEnabledMoss() {
        return isEnabledMoss;
    }

    public void printAllFactors() {
        System.out.println("-----------");
        for (AbstractFactor factor : factors) {
            System.out.println(factor.toString());
        }
        System.out.println("-----------");
    }

    public void setFactors(List<Double> values) {
        for (int i = 0; i < values.size() && i < factors.size(); i++) {
            factors.get(i).setVal(values.get(i));
        }
    }
}
