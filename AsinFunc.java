/**
 * Calculate the arcsine (inverse sine) of the input argument and return it.
 */
public class AsinFunc implements IAction {
    @Override
    public double calculate(double arg) {
        return Math.asin(arg);
    }
}