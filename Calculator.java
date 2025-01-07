import java.util.Scanner;
import java.util.Arrays;

public class Calculator {
    private static String[] history = new String[10];
    private static int historyIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean working = true;

        while (working) {
            System.out.println("\n=== Calculator ===");
            System.out.println("1. Basic Operations");
            System.out.println("2. Scientific Operations");
            System.out.println("3. Advanced Operations");
            System.out.println("4. Unit Conversion");
            System.out.println("5. Factorial Calculation");
            System.out.println("6. GCD and LCM");
            System.out.println("7. Reverse a Number");
            System.out.println("8. Prime Number Check");
            System.out.println("9. Percentage Calculation");
            System.out.println("10. View History");
            System.out.println("11. Clear History");
            System.out.println("12. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    basicOperations(scanner);
                    break;
                case 2:
                    scientificOperations(scanner);
                    break;
                case 3:
                    advancedOperations(scanner);
                    break;
                case 4:
                    unitConversion(scanner);
                    break;
                case 5:
                    factorialCalculation(scanner);
                    break;
                case 6:
                    gcdAndLcm(scanner);
                    break;
                case 7:
                    reverseNumber(scanner);
                    break;
                case 8:
                    primeNumberCheck(scanner);
                    break;
                case 9:
                    percentageCalculation(scanner);
                    break;
                case 10:
                    displayHistory();
                    break;
                case 11:
                    clearHistory();
                    break;
                case 12:
                    working = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private static void basicOperations(Scanner scanner) {
        System.out.println("\n=== Basic Operations ===");
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        System.out.println("Choose an operation: +, -, *, /");
        char operation = scanner.next().charAt(0);

        double result = 0;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Division by zero.");
                    return;
                }
                break;
            default:
                System.out.println("Invalid operation.");
                return;
        }

        System.out.println("Result: " + result);
        addToHistory("Basic Operation: " + num1 + " " + operation + " " + num2 + " = " + result);
    }

    private static void scientificOperations(Scanner scanner) {
        System.out.println("\n=== Scientific Operations ===");
        System.out.println("1. Sine");
        System.out.println("2. Cosine");
        System.out.println("3. Tangent");
        System.out.println("4. Logarithm");
        System.out.print("Choose an operation: ");
        int choice = scanner.nextInt();

        System.out.print("Enter angle in radians: ");
        double angle = scanner.nextDouble();

        double result = 0;
        switch (choice) {
            case 1:
                result = Math.sin(angle);
                break;
            case 2:
                result = Math.cos(angle);
                break;
            case 3:
                result = Math.tan(angle);
                break;
            case 4:
                result = Math.log(angle);
                break;
            default:
                System.out.println("Invalid operation.");
                return;
        }

        System.out.println("Result: " + result);
        addToHistory("Scientific Operation: " + choice + " = " + result);
    }

    private static void advancedOperations(Scanner scanner) {
        System.out.println("\n=== Advanced Operations ===");
        System.out.println("1. Power");
        System.out.println("2. Square Root");
        System.out.print("Choose an operation: ");
        int choice = scanner.nextInt();

        System.out.print("Enter base: ");
        double base = scanner.nextDouble();

        double result = 0;
        switch (choice) {
            case 1:
                System.out.print("Enter exponent: ");
                double exponent = scanner.nextDouble();
                result = Math.pow(base, exponent);
                break;
            case 2:
                if (base >= 0) {
                    result = Math.sqrt(base);
                } else {
                    System.out.println("Error: Cannot calculate square root of a negative number.");
                    return;
                }
                break;
            default:
                System.out.println("Invalid operation.");
                return;
        }

        System.out.println("Result: " + result);
        addToHistory("Advanced Operation: " + base + " result = " + result);
    }

    private static void unitConversion(Scanner scanner) {
        System.out.println("\n=== Unit Conversion ===");
        System.out.println("1. Kilometers to Miles");
        System.out.println("2. Pounds to Kilograms");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();

        System.out.print("Enter value to convert: ");
        double value = scanner.nextDouble();

        double result = 0;
        switch (choice) {
            case 1:
                result = value * 0.621371;
                break;
            case 2:
                result = value * 0.453592;
                break;
            default:
                System.out.println("Invalid option.");
                return;
        }

        System.out.println("Converted value: " + result);
        addToHistory("Unit Conversion: " + value + " -> " + result);
    }

    private static void factorialCalculation(Scanner scanner) {
        System.out.println("\n=== Factorial Calculation ===");
        System.out.print("Enter a non-negative integer: ");
        int number = scanner.nextInt();

        if (number < 0) {
            System.out.println("Error: Factorial is not defined for negative numbers.");
            return;
        }

        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }

        System.out.println("Factorial of " + number + " = " + factorial);
        addToHistory("Factorial: " + number + "! = " + factorial);
    }

    private static void gcdAndLcm(Scanner scanner) {
        System.out.println("\n=== GCD and LCM Calculation ===");
        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        int gcd = findGcd(num1, num2);
        int lcm = (num1 * num2) / gcd;

        System.out.println("GCD of " + num1 + " and " + num2 + " = " + gcd);
        System.out.println("LCM of " + num1 + " and " + num2 + " = " + lcm);

        addToHistory("GCD: " + gcd + ", LCM: " + lcm);
    }

    private static int findGcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static void reverseNumber(Scanner scanner) {
        System.out.println("\n=== Reverse a Number ===");
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        int reversed = 0;
        int original = number;

        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }

        System.out.println("Reversed number: " + reversed);
        addToHistory("Reverse: " + original + " -> " + reversed);
    }

    private static void primeNumberCheck(Scanner scanner) {
        System.out.println("\n=== Prime Number Check ===");
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        boolean isPrime = isPrime(number);
        System.out.println(number + " is " + (isPrime ? "prime" : "not prime"));
        addToHistory("Prime Check: " + number + " is " + (isPrime ? "prime" : "not prime"));
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void percentageCalculation(Scanner scanner) {
        System.out.println("\n=== Percentage Calculation ===");
        System.out.print("Enter total value: ");
        double total = scanner.nextDouble();
        System.out.print("Enter percentage: ");
        double percentage = scanner.nextDouble();

        double result = (total * percentage) / 100;
        System.out.println("Result: " + result);
        addToHistory("Percentage: " + total + " * " + percentage + "% = " + result);
    }

    private static void addToHistory(String entry) {
        history[historyIndex] = entry;
        historyIndex = (historyIndex + 1) % history.length;
    }

    private static void displayHistory() {
        System.out.println("\n=== Calculation History ===");
        for (String entry : history) {
            if (entry != null) {
                System.out.println(entry);
            }
        }
    }

    private static void clearHistory() {
        Arrays.fill(history, null);
        historyIndex = 0;
        System.out.println("History cleared.");
    }
}
