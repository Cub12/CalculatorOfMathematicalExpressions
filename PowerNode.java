/**
 * A node representing the exponentiation operation in an expression tree.
 */
public class PowerNode implements ExpressionNode {
    private final ExpressionNode base;
    private final ExpressionNode exponent;

    /**
     * Constructs a PowerNode with the specified base and exponent child nodes.
     *
     * @param base     The base child node representing the base value of the exponentiation.
     * @param exponent The exponent child node representing the exponent value of the exponentiation.
     */
    PowerNode(ExpressionNode base, ExpressionNode exponent) {
        this.base = base;
        this.exponent = exponent;
    }

    /**
     * Calculates and returns the result of the exponentiation operation between the base and exponent nodes.
     *
     * @return The result of raising the base value to the power of the exponent value.
     */
    @Override
    public double calc() {
        double baseValue = base.calc();
        double exponentValue = exponent.calc();

        return Math.pow(baseValue, exponentValue);
    }
}