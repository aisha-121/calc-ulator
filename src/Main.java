import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

public static void main(String[] args) {
		
		Calculator calc = new Calculator(); // creating new calculator object 
        Scanner scanner = new Scanner(System.in); // opening scanner

        double number1 = 0, number2 = 0; // initializing numbers
        boolean isOperationValid = true; // flag to check if the operation is valid
        boolean validInput = false; // flag to check if input is valid
        
        

        while (!validInput) {
            System.out.println("Enter the first number in the calculation: ");
            try {
                number1 = scanner.nextDouble(); // assigning user input to the first number in calculation
                validInput = true; // exit loop if input is valid
            } catch (InputMismatchException e) {
                System.out.println("The value inputed is invalid. Please enter a valid number.");
                scanner.next(); // clear the invalid input
            }
        }
        
        String operation = ""; // initialise operation
        validInput = false; // reset flag
        
        
        while (!validInput) {
            System.out.println("Enter the operation you would like to use (+, -, *, /): ");
            operation = scanner.next(); // assigning user input to the operation as a string

            if (operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/")) {
                validInput = true; // valid operation, exit loop
            } else {
                System.out.println("Invalid operation. Please enter again.");
            }
        }
        
        validInput = false; // reset flag
        
        while (!validInput) {
            System.out.println("Enter the second number in the calculation: ");
            try {
                number2 = scanner.nextDouble(); // assigning user input to the second number in calculation
                validInput = true; // exit loop if input is valid
            } catch (InputMismatchException e) {
                System.out.println("The value inputed is invalid. Please enter a valid number.");
                scanner.next(); // clear the invalid input
            }
        }
        
        
        double result = 0; // initialising result as 0

        switch (operation) { // switch cases to identify the operation 
            case "+":
                result = calc.add(number1, number2); // if the operation is add, the calculator adds the two numbers
                break;
                
            case "-":
                result = calc.subtract(number1, number2); // if the operation is subtract, the calculator subtracts the two numbers
                break;
                
            case "*":
                result = calc.multiply(number1, number2); // if the operation is multiply, the calculator multiplies the two numbers
                break;
                
            case "/":
                if (number2 != 0) { // if the second number is not 0 the calculation occurs
                    result = calc.divide(number1, number2); // if the operation is divide, the calculator divides the two numbers
                } else {
                    System.out.println("Cannot divide by zero."); // error message
                    isOperationValid = false; // if the second number is 0 no calculation occurs as it is not possible for a simple calculator to do
                }
                break;
                
            default:
                System.out.println("Invalid operation."); // if none of the 4 operations are inputed an error message is displayed
                isOperationValid = false;
                break;
        }

        if (isOperationValid) {
            System.out.println("Result: " + result); // prints out result
        }

        scanner.close();

	}
}
