/**
 * A node representing the subtraction operation in an expression tree.
 */
public class SubtractNode implements ExpressionNode {
    private final ExpressionNode left;
    private final ExpressionNode right;

    /**
     * Constructs a SubtractNode with the specified left and right child nodes.
     *
     * @param left  The left child node representing the minuend of the subtraction.
     * @param right The right child node representing the subtrahend of the subtraction.
     */
    SubtractNode(ExpressionNode left, ExpressionNode right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Calculates and returns the result of the subtraction operation between the left and right nodes.
     *
     * @return The difference between the value represented by the left node and the value represented by the right node.
     */
    @Override
    public double calc() {
        return left.calc() - right.calc();
    }
}