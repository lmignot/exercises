
import java.util.Scanner;

public class E03_command_line_calculator { 
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
            // Get the operation, find the operator and operands and execute

            System.out.println("Enter a math operation (eg 12/4): ");
        String operation = input.nextLine();
        double op1;
        double op2;
        double result;
        String operator = getOperator(operation);
        if (!operator.equals("")) {
            System.out.println(operation.substring(0, operation.indexOf(operator)).trim());
            System.out.println(operation.substring(operation.indexOf(operator) + 1).trim());
            op1 = Double.parseDouble(operation.substring(0, operation.indexOf(operator)).trim());
            op2 = Double.parseDouble(operation.substring(operation.indexOf(operator) + 1).trim());
            result = executeOperationForOperator(operator, op1, op2);
            System.out.println(op1 + " " + operator + " " + op2 + " = " + result);
        } else {
            System.out.println("We were unable to execute a math operation from your input.");
        }
    }

    private static String getOperator(String op) {
        int len = op.length();
        String foundOperator = "";
        for (int i = 0; i < len; i++) {
            if(op.charAt(i) == '/') {
                foundOperator = "/";
                break;
            } else if (op.charAt(i) == '*') {
                foundOperator = "*";
                break;
            } else if (op.charAt(i) == '-') {
                foundOperator = "-";
                break;
            } else if (op.charAt(i) == '+') {
                foundOperator = "+";
                break;
            } else {
            continue;
            }
        }
        return foundOperator;
    }

    private static double executeOperationForOperator(String op, Double operand1, Double operand2) {
        Double result = 0.0;
        switch(op) {
            case "/":
                result = divide(operand1, operand2);
                break;
            case "*":
                result = multiply(operand1, operand2);
                break;
            case "-":
                result = subtract(operand1, operand2);
                break;
            case "+":
                result = add(operand1, operand2);
                break;
            default:
                break;
        }
        return result;
    }

    private static double add(double addend1, double addend2) {
        return addend1 + addend2;
    }

    private static double subtract(double minuend, double subtrahend) {
        return minuend - subtrahend;
    }

    private static double divide(double dividend, double divisor) {
        return dividend / divisor;
    }

    private static double multiply(double multiplicand, double multiplier) {
        return multiplicand * multiplier;
    }
}