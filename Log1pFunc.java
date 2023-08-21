/**
 * Calculate the natural logarithm of (1 + x) for the input argument and return it.
 */
public class Log1pFunc implements IAction {
    @Override
    public double calculate(double arg) {
        return Math.log1p(arg);
    }
}