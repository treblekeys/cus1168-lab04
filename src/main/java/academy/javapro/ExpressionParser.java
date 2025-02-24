//Jinqing Mei
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
        double result = parseTerm();
        while (position < input.length() && input.charAt(position) == '+') {
            position++;
            result = result + parseTerm();
        }
        return result;
    }

    // term → term * factor
    private double parseTerm() {
        double result2 = parseFactor();
        while (position < input.length() && input.charAt(position) == '*') {
            position++;
            result2 = result2 * parseFactor();
        }
        return result2;
    }

    // factor → ( expr )
    private double parseFactor() {
       if (position < input.length() && input.charAt(position) == '(') {
           position++;
           double result3 = parseExpression();
           if (position < input.length() && input.charAt(position) == ')') {
               position++;
           }
           return result3;
       }
       else {
           return parseNumber();
       }
    }

    // Parse a numeric value
    private double parseNumber() {
       StringBuilder stringbuilder = new StringBuilder();
       while (position < input.length() && (Character.isDigit(input.charAt(position)) || input.charAt(position) == '.')) {
           stringbuilder.append(input.charAt(position));
           position++;
       }
       return Double.parseDouble(stringbuilder.toString());
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