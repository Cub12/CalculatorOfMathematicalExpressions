/**
 * Calculate the hyperbolic tangent of the input argument and return it.
 */
public class TanhFunc implements IAction {
    @Override
    public double calculate(double arg) {
        return Math.tanh(arg);
    }
}