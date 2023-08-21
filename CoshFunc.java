/**
 * Calculate the hyperbolic cosine of the input argument and return it.
 */
public class CoshFunc implements IAction {
    @Override
    public double calculate(double arg) {
        return Math.cosh(arg);
    }
}