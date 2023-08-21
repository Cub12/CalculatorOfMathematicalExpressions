/**
 * An interface representing a node in an expression tree that can be evaluated to a numerical value.
 */
public interface ExpressionNode {
    /**
     * Calculates and returns the numerical value of the expression represented by this node.
     *
     * @return The calculated numerical value.
     */
    double calc();
}