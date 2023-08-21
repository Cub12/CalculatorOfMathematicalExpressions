/**
 * Calculate the natural logarithm of the input argument and return it.
 */
public class LogFunc implements IAction {
    @Override
    public double calculate(double arg) {
        return Math.log(arg);
    }
}