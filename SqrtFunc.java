/**
 * Calculate the square root of the input argument and return it.
 */
public class SqrtFunc implements IAction {
    @Override
    public double calculate(double arg) {
        return Math.sqrt(arg);
    }
}