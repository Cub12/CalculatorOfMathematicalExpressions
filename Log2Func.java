/**
 * Calculate the logarithm base 2 using the change of base formula.
 */
public class Log2Func implements IAction {
    @Override
    public double calculate(double arg) {
        if (arg <= 0) {
            throw new IllegalArgumentException("Logarithm with base 2 is undefined for non-positive values.");
        }

        // Math.log(arg) calculates the natural logarithm, so we divide by Math.log(2) to obtain log base 2.
        return Math.log(arg) / Math.log(2);
    }
}