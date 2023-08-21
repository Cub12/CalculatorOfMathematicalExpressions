import java.util.HashMap;

/**
 * A collection of constant values.
 */
public abstract class Constants {
    /** A constant that controls how many decimal places to display in the answer */
    public static final int DECIMAL_PLACES = 3;

    /** Different mathematical symbols */
    public static final char EQUAL_SIGN = '=';
    public static final char COMMA = ',';
    public static final char POINT = '.';
    public static final char PLUS = '+';
    public static final char MINUS = '-';
    public static final char MULTIPLICATION_SIGN = '*';
    public static final char DIVISION_SIGN = '/';
    public static final char DEGREE_SIGN = '^';
    public static final char BRACKET = '(';

    /** A HashMap stores mathematical functions. */
    public static final HashMap<String, IAction> FUNCTIONS = new HashMap<>();
    static {
        FUNCTIONS.put("sin", new SinFunc());     // Sine
        FUNCTIONS.put("cos", new CosFunc());     // Cosine
        FUNCTIONS.put("tan", new TanFunc());     // Tangent
        FUNCTIONS.put("asin", new AsinFunc());   // Arcsine
        FUNCTIONS.put("acos", new AcosFunc());   // Arccosine
        FUNCTIONS.put("atan", new AtanFunc());   // Arctangent
        FUNCTIONS.put("sinh", new SinhFunc());   // Hyperbolic sine
        FUNCTIONS.put("cosh", new CoshFunc());   // Hyperbolic cosine
        FUNCTIONS.put("tanh", new TanhFunc());   // Hyperbolic tangent
        FUNCTIONS.put("cbrt", new CbrtFunc());   // Cube root
        FUNCTIONS.put("exp", new ExpFunc());     // Exponential
        FUNCTIONS.put("expm1", new Expm1Func()); // Exponential minus one function
        FUNCTIONS.put("log", new LogFunc());     // Natural logarithm
        FUNCTIONS.put("log10", new Log10Func()); // Base 10 logarithm
        FUNCTIONS.put("log1p", new Log1pFunc()); // Natural logarithm of (1 + x)
        FUNCTIONS.put("sqrt", new SqrtFunc());   // Square root
        FUNCTIONS.put("abs", new AbsFunc());     // Absolute value
        FUNCTIONS.put("log2", new Log2Func());   // Base 2 logarithm
    }
}