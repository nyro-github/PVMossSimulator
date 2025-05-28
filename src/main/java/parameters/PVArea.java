package parameters;

/**
 * The class for the PVArea factor.
 * 
 * @author Alex
 */
public class PVArea extends AbstractFactor {
    
    public PVArea() {
        super(0, Double.MAX_VALUE-1, 100);
    }
}
