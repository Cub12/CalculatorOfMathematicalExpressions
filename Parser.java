import java.util.HashMap;

/**
 * A parser for converting a mathematical expression into an expression tree for evaluation.
 */
public class Parser extends Constants {
    private final String formula;
    private final HashMap<String, Double> variables;
    private int currentPos;

    /**
     * Constructs a Parser with the specified formula and variables.
     *
     * @param formula   The mathematical expression to be parsed.
     * @param variables A map of variable names and their corresponding values.
     */
    public Parser(String formula, HashMap<String, Double> variables) {
        this.formula = formula;
        this.variables = variables;
        this.currentPos = 0;
    }

    /**
     * Parses and returns the root node of the expression tree.
     *
     * @return The root node of the parsed expression tree.
     */
    ExpressionNode parseExpression() {
        return parseAddSubtract();
    }

    /**
     * Parses and returns an expression node for addition and subtraction operations.
     *
     * @return The expression node representing the parsed addition or subtraction operation.
     */
    private ExpressionNode parseAddSubtract() {
        ExpressionNode left = parseMultiplyDivide();

        while (currentPos < formula.length()) {
            char operator = formula.charAt(currentPos);

            if (operator != PLUS && operator != MINUS) {
                break;
            }

            currentPos++;

            ExpressionNode right = parseMultiplyDivide();

            if (operator == PLUS) {
                left = new AddNode(left, right);
            } else {
                left = new SubtractNode(left, right);
            }
        }

        return left;
    }

    /**
     * Parses and returns an expression node for multiplication and division operations.
     *
     * @return The expression node representing the parsed multiplication or division operation.
     */
    private ExpressionNode parseMultiplyDivide() {
        ExpressionNode left = parsePower();

        while (currentPos < formula.length()) {
            char operator = formula.charAt(currentPos);

            if (operator != MULTIPLICATION_SIGN && operator != DIVISION_SIGN) {
                break;
            }

            currentPos++;

            ExpressionNode right = parsePower();

            if (operator == MULTIPLICATION_SIGN) {
                left = new MultiplyNode(left, right);
            } else {
                left = new DivideNode(left, right);
            }
        }

        return left;
    }

    /**
     * Parses and returns an expression node for exponentiation operations.
     *
     * @return The expression node representing the parsed exponentiation operation.
     */
    private ExpressionNode parsePower() {
        ExpressionNode left = parseFactor();

        if (currentPos < formula.length() && formula.charAt(currentPos) == DEGREE_SIGN) {
            currentPos++;
            ExpressionNode right = parsePower();

            return new PowerNode(left, right);
        }

        return left;
    }

    /**
     * Parses and returns an expression node for factors (operands and sub-expressions).
     *
     * @return The expression node representing the parsed factor.
     */
    private ExpressionNode parseFactor() {
        char currentChar = formula.charAt(currentPos);

        if (Character.isDigit(currentChar)) {
            return parseNumber();
        } else if (Character.isLetter(currentChar)) {
            return parseVarOrFunc();
        } else if (currentChar == BRACKET) {
            currentPos++;
            ExpressionNode node = parseAddSubtract(); // Parse the inner sub-expression
            currentPos++;

            return node;
        } else if (currentChar == MINUS) {
            currentPos++;
            ExpressionNode node = parseFactor();

            return new NegateNode(node);
        }

        return null;
    }

    /**
     * Parses and returns an expression node for a numeric constant.
     *
     * @return The expression node representing the parsed numeric constant.
     * @throws IllegalArgumentException If an unexpected letter is found after the number.
     */
    private ExpressionNode parseNumber() {
        StringBuilder numberStr = new StringBuilder();

        while (currentPos < formula.length() && (Character.isDigit(formula.charAt(currentPos))
                || formula.charAt(currentPos) == POINT)) {
            numberStr.append(formula.charAt(currentPos));
            currentPos++;
        }

        if (currentPos < formula.length() && Character.isLetter(formula.charAt(currentPos))) {
            throw new IllegalArgumentException("Unexpected letter after number: " + numberStr);
        }

        double number = Double.parseDouble(numberStr.toString());

        return new ConstantNode(number);
    }

    /**
     * Parses and returns an expression node for a variable.
     *
     * @return The expression node representing the parsed variable.
     * @throws IllegalArgumentException If an unexpected number follows the variable or if the variable is undefined.
     */
    private ExpressionNode parseVarOrFunc() {
        StringBuilder nameOfVar = new StringBuilder();

        // Continue adding characters to nameOfVar while they are letters.
        while (currentPos < formula.length() && Character.isLetter(formula.charAt(currentPos))) {
            nameOfVar.append(formula.charAt(currentPos));
            currentPos++;
        }

        String var = nameOfVar.toString();

        if (currentPos < formula.length() && formula.charAt(currentPos) == '(') {
            currentPos++;
            ExpressionNode arg = parseAddSubtract(); // Parse the argument to the function

            if (currentPos < formula.length() && formula.charAt(currentPos) == ')') {
                currentPos++;
                IAction mathFunc = FUNCTIONS.get(var);

                if (mathFunc != null) {
                    return new FuncNode(mathFunc, arg);
                }
            }
        } else {
            if (variables.containsKey(var)) {

                if (currentPos < formula.length() && Character.isDigit(formula.charAt(currentPos))) {
                    throw new IllegalArgumentException("Unexpected number after variable: " + var);
                }

                double value = variables.get(var);

                return new ConstantNode(value);
            } else {
                throw new IllegalArgumentException("Undefined variable: " + var);
            }
        }

        return null; // Return null if no variable or function is parsed
    }
}