/**
 * A functional interface representing a mathematical function.
 * It defines a single abstract method 'calculate' that takes a double argument and returns a double result.
 */
@FunctionalInterface
public interface IAction {
    /**
     * Calculates the result of the mathematical function for the given argument.
     *
     * @param arg The input value for the mathematical function.
     * @return The result of the mathematical function.
     */
    double calculate(double arg);
}