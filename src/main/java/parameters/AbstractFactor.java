package parameters;

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
    
    public void setVal(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + 
               " [min=" + minVal + ", max=" + maxVal + ", default=" + defaultVal + ", value =" + value + "]";
    }
}
