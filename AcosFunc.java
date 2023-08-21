/**
 * Calculate the arccosine (inverse cosine) of the input argument and return it.
 */
public class AcosFunc implements IAction {
    @Override
    public double calculate(double arg) {
        return Math.acos(arg);
    }
}