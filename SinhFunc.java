/**
 * Calculate the hyperbolic sine of the input argument and return it.
 */
public class SinhFunc implements IAction {
    @Override
    public double calculate(double arg) {
        return Math.sinh(arg);
    }
}