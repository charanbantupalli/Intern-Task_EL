import java.util.Scanner;
public class CAl {
    public static double addition(double a1, double b1){
        return a1 + b1;
    } 

    public static double sutraction(double a1, double b1){
        return a1 - b1;
    } 

    public static double Multiplication(double a1, double b1){
        return a1 * b1;
    } 

    public static double division(double a1, double b1){
        if(b1 == 0){
            System.out.println("division by zero is not allowed");
            return Double.NaN;
        }
        return a1 / b1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Java Console Calculator ---");
        while(true){
            System.out.println("1. additionition");
            System.out.println("2. subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. division");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            if(choice == 5){
                System.out.println("Exit, Thank you!");
                break;
            }

            System.out.println("Enter first number: ");
            double a = sc.nextDouble();
            System.out.println("Enter second number: ");
            double b = sc.nextDouble();

            double result = 0;

            switch(choice){
                case 1:
                    result = addition(a, b);
                    break;
                case 2:
                    result = sutraction(a, b);
                    break;
                case 3:
                    result = Multiplication(a, b);
                    break;
                case 4:
                    result = division(a, b);
                    break;
                default:
                    System.out.println("Invaild choice!");
                    continue;
            }
            System.out.println("Result: "+ result);
        }
        sc.close();
    }
}