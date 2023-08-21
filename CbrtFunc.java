/**
 * Calculate the cube root of the input argument and return it.
 */
public class CbrtFunc implements IAction {
    @Override
    public double calculate(double arg) {
        return Math.cbrt(arg);
    }
}