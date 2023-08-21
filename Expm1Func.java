/**
 * Calculate the value of e^x - 1 for the input argument and return it.
 */
public class Expm1Func implements IAction {
    @Override
    public double calculate(double arg) {
        return Math.expm1(arg);
    }
}