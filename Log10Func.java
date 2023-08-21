/**
 * Calculate the base 10 logarithm of the input argument and return it.
 */
public class Log10Func implements IAction {
    @Override
    public double calculate(double arg) {
        return Math.log10(arg);
    }
}