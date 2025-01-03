import java.util.Scanner;

public class ScientificCalculator{
    public static void main(String[] args) {
        System.out.println("Welcome to the Scientific Calculator!");

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nSelect an operation");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Trignometric Functions");
            System.out.println("6. Logarithmic Functions");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter two numbers");
                    double a = scanner.nextDouble();
                    double b = scanner.nextDouble();
                    System.out.println("Result: " + (a + b));
                    break;
                case 2:
                    System.out.println("Enter two numbers");
                    a = scanner.nextDouble();
                    b = scanner.nextDouble();
                    System.out.println("Result: " + (a - b));
                    break;
                case 3:
                    System.out.println("Enter two numbers");
                    a = scanner.nextDouble();
                    b = scanner.nextDouble();
                    System.out.println("Result: " + (a * b));
                    break;
                case 4:
                    System.out.println("Enter two numbers");
                    a = scanner.nextDouble();
                    b = scanner.nextDouble();
                    if (b != 0) {
                        System.out.println("Result: " + (a / b));
                    } else {
                        System.out.println("Error: Division by zero is not allowed.");
                    }
                    break;
                case 5:
                    System.out.println("Conversion type:");
                    System.out.println("1. Sine");
                    System.out.println("2. Cosine");
                    System.out.println("3. Tangent");
                    int Func=scanner.nextInt();
                    switch(Func){
                        case 1:
                            System.out.println("Enter an angle in degree:");
                            double angle=scanner.nextDouble();
                            System.out.println("Sine: "+Math.sin(Math.toRadians(angle)));
                            break;
                        case 2:
                            System.out.println("Enter an angle in degree:");
                            angle=scanner.nextDouble();
                            System.out.println("Cosine "+Math.cos(Math.toRadians(angle)));
                            break;
                        case 3:
                            System.out.println("Enter an angle in degree:");
                            angle=scanner.nextDouble();
                            System.out.println("Tangent "+Math.tan(Math.toRadians(angle)));
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    break;
                case 6:
                    System.out.println("Enter a number:");
                    double number = scanner.nextDouble();
                    System.out.println("Logarithm: " + Math.log(number));
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid Choice. Please try again");
            }
        }
        scanner.close();
    }
}