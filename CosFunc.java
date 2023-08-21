/**
 * Calculate the cosine of the input argument and return it.
 */
public class CosFunc implements IAction {
    @Override
    public double calculate(double arg) {
        return Math.cos(arg);
    }
}