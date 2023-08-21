/**
 * Calculate the absolute value of the input argument and return it.
 */
public class AbsFunc implements IAction {
    @Override
    public double calculate(double arg) {
        return Math.abs(arg);
    }
}