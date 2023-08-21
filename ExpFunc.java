/**
 * Calculate the exponential function e^x of the input argument and return it.
 */
public class ExpFunc implements IAction {
    @Override
    public double calculate(double arg) {
        return Math.exp(arg);
    }
}