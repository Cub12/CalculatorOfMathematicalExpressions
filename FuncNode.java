/**
 * Represents a node in an expression tree that corresponds to a mathematical function.
 */
public class FuncNode implements ExpressionNode {
    private final IAction function;
    private final ExpressionNode argument;

    /**
     * Constructs a new FuncNode with a specified mathematical function and argument.
     *
     * @param function The mathematical function to be applied.
     * @param argument The argument to the mathematical function.
     */
    public FuncNode(IAction function, ExpressionNode argument) {
        this.function = function;
        this.argument = argument;
    }

    /**
     * Calculates the result of applying the mathematical function to the argument.
     *
     * @return The result of the mathematical function applied to the argument.
     */
    @Override
    public double calc() {
        double argValue = argument.calc();
        return function.calculate(argValue);
    }
}