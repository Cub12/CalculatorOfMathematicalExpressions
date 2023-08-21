/**
 * A node representing a constant numerical value in an expression tree.
 */
public class ConstantNode implements ExpressionNode {
    private final double value;

    /**
     * Constructs a ConstantNode with the given numerical value.
     *
     * @param value The constant numerical value represented by this node.
     */
    ConstantNode(double value) {
        this.value = value;
    }

    /**
     * Calculates and returns the numerical value of this constant node.
     *
     * @return The constant numerical value.
     */
    @Override
    public double calc() {
        return value;
    }
}