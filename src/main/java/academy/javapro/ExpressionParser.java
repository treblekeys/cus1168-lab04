package academy.javapro;

class ExpressionParser {
    private final String input;
    private int position;

    public ExpressionParser(String input) {
        this.input = input;
        this.position = 0;
    }

    // expr → expr + term
    public double parseExpression() {
        // TODO: Get the leftmost term value by calling parseTerm()
        // TODO: While we haven't reached the end of input and current char is '+'
        // TODO: Increment position to skip the '+' operator
        // TODO: Get the next term on the right
        // TODO: Add the right term to our running total
        // TODO: Return the final value
        throw new UnsupportedOperationException("Implement parseExpression");
    }

    // term → term * factor
    private double parseTerm() {
        // TODO: Get the leftmost factor value by calling parseFactor()
        // TODO: While we haven't reached the end of input and current char is '*'
        // TODO: Increment position to skip the '*' operator
        // TODO: Get the next factor on the right
        // TODO: Multiply the right factor with our running total
        // TODO: Return the final value
        throw new UnsupportedOperationException("Implement parseTerm");
    }

    // factor → ( expr )
    private double parseFactor() {
        // TODO: Check if we have an opening parenthesis and haven't reached end of input
        // TODO: Increment position to skip the opening parenthesis
        // TODO: Parse the expression inside the parentheses
        // TODO: Increment position to skip the closing parenthesis
        // TODO: Return the result of the parenthesized expression
        // TODO: If no parentheses, parse and return a number
        throw new UnsupportedOperationException("Implement parseFactor");
    }

    // Parse a numeric value
    private double parseNumber() {
        // TODO: Create a StringBuilder to collect digits
        // TODO: While we haven't reached the end and current char is digit or decimal point
        // TODO: Append the current digit to our number string
        // TODO: Move to next character
        // TODO: Convert the string of digits to a double and return it
        throw new UnsupportedOperationException("Implement parseNumber");
    }

    public static void main(String[] args) {
        // Test cases
        String[] testCases = {
                "2 + 3 * (4 + 5)",    // Complex expression with parentheses
                "2 + 3 * 4",          // Basic arithmetic with precedence
                "(2 + 3) * 4",        // Parentheses changing precedence
                "2 * (3 + 4) * (5 + 6)", // Multiple parentheses
                "1.5 + 2.5 * 3"       // Decimal numbers
        };

        // Process each test case
        for (String expression : testCases) {
            System.out.println("\nTest Case: " + expression);
            try {
                ExpressionParser parser = new ExpressionParser(expression.replaceAll("\\s+", "")); // Remove spaces
                double result = parser.parseExpression();
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}