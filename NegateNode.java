/**
 * A node representing the negation operation in an expression tree.
 */
public class NegateNode implements ExpressionNode {
    private final ExpressionNode operand;

    /**
     * Constructs a NegateNode with the specified operand node.
     *
     * @param operand The operand node to be negated.
     */
    NegateNode(ExpressionNode operand) {
        this.operand = operand;
    }

    /**
     * Calculates and returns the result of the negation operation on the operand node.
     *
     * @return The negated value of the operand node's value.
     */
    @Override
    public double calc() {
        return -operand.calc();
    }
}