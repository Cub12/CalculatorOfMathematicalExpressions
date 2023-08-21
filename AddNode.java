/**
 * A node representing the addition operation in an expression tree.
 */
public class AddNode implements ExpressionNode {
    private final ExpressionNode left;
    private final ExpressionNode right;

    /**
     * Constructs an AddNode with the specified left and right child nodes.
     *
     * @param left  The left child node representing the left operand of the addition.
     * @param right The right child node representing the right operand of the addition.
     */
    AddNode(ExpressionNode left, ExpressionNode right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Calculates and returns the result of the addition operation between the left and right nodes.
     *
     * @return The sum of the values represented by the left and right nodes.
     */
    @Override
    public double calc() {
        return left.calc() + right.calc();
    }
}