/**
 * A node representing the multiplication operation in an expression tree.
 */
public class MultiplyNode implements ExpressionNode {
    private final ExpressionNode left;
    private final ExpressionNode right;

    /**
     * Constructs a MultiplyNode with the specified left and right child nodes.
     *
     * @param left  The left child node representing the first factor of the multiplication.
     * @param right The right child node representing the second factor of the multiplication.
     */
    MultiplyNode(ExpressionNode left, ExpressionNode right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Calculates and returns the result of the multiplication operation between the left and right nodes.
     *
     * @return The product of the value represented by the left node and the value represented by the right node.
     */
    @Override
    public double calc() {
        return left.calc() * right.calc();
    }
}