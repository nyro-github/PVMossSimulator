package output;

import parameters.SimulationParameters;

public class EnergyCalculator {
    
    private final static double PV_EFFICIENCY = 0.1;        
    private final static double MAX_SUN = 1000.0;            
    private final static double DAYLIGHT_HOURS = 12.0;       
    private final static double BIO_CONVERSION_FACTOR = 0.02;

    // Sine-averaged daily solar energy (kWh/m²)
    public static double calculateSunEnergy() {
        double sunLevel = SimulationParameters.getInstance().getSunLevel().getVal() / 100;
        double avgIrradiance = (2.0 / Math.PI) * MAX_SUN;
        return Math.round((avgIrradiance * DAYLIGHT_HOURS * sunLevel / 1000) * 10000.0) / 10000.0;
    }

    // Energy produced by PV windows in kWh
    public static double calculatePVEnergy() {
        SimulationParameters p = SimulationParameters.getInstance();

        if(!p.isEnabledPV()) {
            return 0.0;
        }
        
        double irradiance = calculateSunEnergy(); // Wh/m²
        double temp = p.getTemp().getVal();
        double angle = p.getPVAngle().getVal();
        double cloud = p.getCloudLevel().getVal() / 100;
        double area = p.getArea().getVal();

        double tempFactor = Math.max(0.8, 1 - 0.004 * (temp - 25));
        double angleFactor = Math.cos(Math.toRadians(angle));
        double cloudFactor = 1 - cloud;
        double finalAnswer = PV_EFFICIENCY * irradiance * area * tempFactor * angleFactor * cloudFactor;
        
        return Math.round(finalAnswer * 10000.0) / 10000.0; // Wh
    }

    // Energy "produced" or absorbed by moss layer in kWh
    public static double calculateMossEnergy() {
        SimulationParameters p = SimulationParameters.getInstance();

        if(!p.isEnabledMoss()) {
            return 0.0;
        }
        
        double irradiance = calculateSunEnergy(); // Wh/m²
        double area = p.getArea().getVal(); // Assuming same facade area
        double moisture = p.getMossMoisture().getVal() / 100;
        double humidity = p.getMossHumidity().getVal() / 100;
        double finalAnswer = BIO_CONVERSION_FACTOR * irradiance * area * moisture * humidity;

        return Math.round(finalAnswer * 10000.0) / 10000.0;
    }

    // Combined energy output in kWh
    public static double calculateTotalEnergy() {
        return calculatePVEnergy() + calculateMossEnergy();
    }
    
    // Status of the moss based on humidity and moisture
    public static String getMossStatus() {
        SimulationParameters p = SimulationParameters.getInstance();

        if (!p.isEnabledMoss()) {
            return "Disabled";
        }

        double moisture = p.getMossMoisture().getVal();
        double humidity = p.getMossHumidity().getVal();

       
        if (moisture >= 70 && humidity >= 70) {
            return "Thriving";
        } else if (moisture >= 40 && humidity >= 40) {
            return "Stable";
        } else if (moisture >= 20 || humidity >= 20) {
            return "Stressed";
        } else {
            return "Dormant";
        }
    }

}
