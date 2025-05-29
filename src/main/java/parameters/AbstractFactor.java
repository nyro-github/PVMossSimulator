package parameters;

/**
 * Abstract class for all factors to inherit.
 * 
 * @author Alex
 */
public abstract class AbstractFactor {
    private final double minVal;
    private final double maxVal;
    private final double defaultVal;
    private double value;

    public AbstractFactor(double minVal, double maxVal, double defaultVal) {
        if (minVal > maxVal) {
            throw new IllegalArgumentException("Invalid range: minVal (" + minVal + ") cannot be greater than maxVal (" + maxVal + ")");
        }
        if (defaultVal < minVal || defaultVal > maxVal) {
            throw new IllegalArgumentException("Invalid default value: must satisfy minVal ≤ defaultVal ≤ maxVal");
        }
        this.minVal = minVal;
        this.maxVal = maxVal;
        this.defaultVal = defaultVal;
        this.value = defaultVal;
    }

    public double getMinVal() {
        return minVal;
    }

    public double getMaxVal() {
        return maxVal;
    }

    public double getDefaultVal() {
        return defaultVal;
    }
    
    public String getDefaultValString() {
        return Double.toString(this.defaultVal);
    }
    
    public void setVal(double value) {
        this.value = value;
    }
    
    public double getVal() {
        return this.value;
    }
    
    public boolean isValidValue(double value) {
        return (this.minVal <= value && value <= this.maxVal);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + 
               "value = " + value;
    }
}
