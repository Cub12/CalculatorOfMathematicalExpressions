/**
 * Calculate the arctangent (inverse tangent) of the input argument and return it.
 */
public class AtanFunc implements IAction {
    @Override
    public double calculate(double arg) {
        return Math.atan(arg);
    }
}