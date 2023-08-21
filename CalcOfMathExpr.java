import java.text.DecimalFormat;
import java.util.HashMap;

/**
 * Calculator of mathematical expressions. Supported operators: -, +, /, *, ^, ()
 */
public class CalcOfMathExpr extends Constants {

    /**
     * You can enter parameters in two ways:
     *     First and the best: Enter each parameter in double quotes, with one or more spaces between the quotes.
     *         Example: "1 + a * 2" "a = 2"
     *         In this case, you can put spaces inside the quotation marks: "1+ a *2" "a =  2"
     *     Second: You can not use quotes and separate parameters with one or more spaces.
     *         Example: 1+a*2 a=2
     * <p>
     *     You can enter fractional numbers separated by a comma or a point: "1,2 + 3.5 * b" "b = 2,333"
     *     You can write variable names in both uppercase and lowercase letters. So B is equal to b: "5 * B" "b=2"
     * <p>
     *     You can name variables with any combination of letters without using numbers or other symbols.
     *         Example: вася^2 "вася = 3"
     * <p>
     *     You can use parentheses to change the priority of operations.
     * <p>
     *     You can put unary minus in front of variables: "-a" "a = 1"
     *     Such inputs will also be valid: "a + (-b)" "a = 3" "b=4" or a+-b a=3 b=4
     * <p>
     *     List of supported functions:
     *         sin, cos, tan, asin, acos, atan, sinh, cosh, tanh, cbrt, exp, expm1, log, log10, log1p, sqrt, abs, log2
     *     Functions should be entered as follows:
     *         "tan(1)" or "tan (1)" - the name of the function, then the argument in parentheses with possible spaces
     *         after the name.
     * <p>
     *     You can call variables by function names: tan(tan) tan=1
     *
     * @param args The first parameter is a mathematical expression; the rest of the parameters are optional and
     *             look like 'variableName = value'.
     */
    public static void main(String[] args) {
        try {
            // Remove spaces from the formula, replace commas with decimal points, and convert to lowercase
            String formula = args[0].replace(" ", "").replace(COMMA, POINT).toLowerCase();

            // Convert command line arguments to a HashMap of variables
            HashMap<String, Double> vars = convertArgumentsToHashMap(args);

            double result = calculate(formula, vars);

            // Format the result with the specified number of decimal places
            DecimalFormat decFormat = new DecimalFormat("0." + "0".repeat(DECIMAL_PLACES));

            String roundedRes = decFormat.format(result).replace(COMMA, POINT);

            System.out.println("Result: " + formula + EQUAL_SIGN + roundedRes);
        } catch (Exception e) {
            System.err.println("Error calculating expression: " + e.getMessage());
        }
    }

    /**
     * Converts the command line arguments into a HashMap of variables and their values.
     *
     * @param args Variable name and variable value.
     * @return A HashMap containing variable names as keys and their corresponding values.
     */
    private static HashMap<String, Double> convertArgumentsToHashMap(String[] args) {
        HashMap<String, Double> vars = new HashMap<>();
        for (int i = 1; i < args.length; i++) {
            String[] partsOfVar = args[i].split(String.valueOf(EQUAL_SIGN));

            // Get the variable name (get rid of spaces and convert to lowercase for case-insensitive matching)
            String nameOfVar = partsOfVar[0].trim().toLowerCase();

            // Parse the variable value, getting rid of spaces and replacing commas with decimal points
            Double value = Double.parseDouble(partsOfVar[1].trim().replace(COMMA, POINT));

            // Add the variable and its value to the HashMap
            vars.put(nameOfVar, value);
        }

        return vars;
    }

    /**
     * Calculates the result of a mathematical expression.
     *
     * @param formula The mathematical expression.
     * @param variables A HashMap containing variable names and their corresponding values.
     * @return The calculated result of the expression.
     * @throws IllegalArgumentException If there is an error in the expression.
     */
    private static double calculate(String formula, HashMap<String, Double> variables) {
        try {
            Parser parser = new Parser(formula, variables);
            ExpressionNode expression = parser.parseExpression();

            System.out.println("Variables: " + variables);

            return expression.calc();
        } catch (Exception e) {
            throw new IllegalArgumentException("Error in expression: " + e.getMessage());
        }
    }
}