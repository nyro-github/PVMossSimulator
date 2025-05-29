package output;

import parameters.SimulationParameters;

public class EnergyCalculator {
    
    private final static double PV_EFFICIENCY = 0.1;         // 10% conversion for PV glass
    private final static double MAX_SUN = 1000.0;            // W/m² peak irradiance
    private final static double DAYLIGHT_HOURS = 12.0;       // Assumed 6 AM – 6 PM

    // Sine-averaged daily solar energy (kWh/m²)
    public static double calculateSunEnergy() {
        double sunLevel = SimulationParameters.getInstance().getSunLevel().getVal() / 100;
        double avgIrradiance = (2.0 / Math.PI) * MAX_SUN;
        return avgIrradiance * DAYLIGHT_HOURS * sunLevel / 1000;
    }

    // Energy produced by PV windows in kWh
    public static double calculatePVEnergy() {
        SimulationParameters p = SimulationParameters.getInstance();

        if(!p.isEnabledPV()) {
            return 0.0;
        }
        
        double irradiance = calculateSunEnergy(); // Wh/m²
        double temp = p.getPVTemp().getVal();
        double angle = p.getPVAngle().getVal();
        double cloud = p.getCloudLevel().getVal() / 100;
        double area = p.getPVArea().getVal();

        double tempFactor = Math.max(0.8, 1 - 0.004 * (temp - 25));
        double angleFactor = Math.cos(Math.toRadians(angle));
        double cloudFactor = 1 - cloud;

        return PV_EFFICIENCY * irradiance * area * tempFactor * angleFactor * cloudFactor / 1000.0; // kWh
    }

    // Energy "produced" or absorbed by moss layer in kWh
    public static double calculateMossEnergy() {
        SimulationParameters p = SimulationParameters.getInstance();

        if(!p.isEnabledMoss()) {
            return 0.0;
        }
        
        double irradiance = calculateSunEnergy(); // Wh/m²
        double area = p.getPVArea().getVal(); // Assuming same facade area
        double moisture = p.getMossMoisture().getVal() / 100;
        double humidity = p.getMossHumidity().getVal() / 100;

        double mossEfficiency = 0.02; // Arbitrary bio-conversion factor

        return mossEfficiency * irradiance * area * moisture * humidity / 1000.0; // kWh
    }

    // Combined energy output in kWh
    public static double calculateTotalEnergy() {
        return calculatePVEnergy() + calculateMossEnergy();
    }
}
