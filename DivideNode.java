/**
 * A node representing the division operation in an expression tree.
 */
public class DivideNode implements ExpressionNode {
    private final ExpressionNode left;
    private final ExpressionNode right;

    /**
     * Constructs a DivideNode with the specified left and right child nodes.
     *
     * @param left  The left child node representing the numerator of the division.
     * @param right The right child node representing the denominator of the division.
     */
    DivideNode(ExpressionNode left, ExpressionNode right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Calculates and returns the result of the division operation between the left and right nodes.
     *
     * @return The result of dividing the value represented by the left node by the value represented by the right node.
     * @throws ArithmeticException If the right node's value is zero, resulting in division by zero.
     */
    @Override
    public double calc() {
        double denominator = right.calc();

        if (denominator == 0) {
            throw new ArithmeticException("Division by zero");
        }

        return left.calc() / denominator;
    }
}