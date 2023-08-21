/**
 * Calculate the sine of the input argument and return it.
 */
public class SinFunc implements IAction {
    @Override
    public double calculate(double arg) {
        return Math.sin(arg);
    }
}