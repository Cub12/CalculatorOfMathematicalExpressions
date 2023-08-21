/**
 * Calculate the tangent of the input argument and return it.
 */
public class TanFunc implements IAction {
    @Override
    public double calculate(double arg) {
        return Math.tan(arg);
    }
}