// Реализовать простой калькулятор (+ - / *)
// Ввод числа ->
// Ввод знака ->
// Ввод числа ->

package gb_java_intro.homework01;

import java.util.Scanner;

public class task03 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.printf("Enter the first integer: ");
        double x1 = sc.nextInt();

        System.out.printf("Enter an operation (+,-,*,/): ");
        String operator = sc.next();

        System.out.printf("Enter the second integer: ");
        double x2 = sc.nextInt();

        double res = 0;

        switch (operator) {
            
            case "+":
                res = x1+x2;
                break;
            case "-": 
                res = x1-x2;
                break;
            case "*": 
                res = x1*x2;
                break;
            case "/":
                res = x1/x2;
                break;
            default:
                System.out.println("Wrong operator");
                System.out.printf("Enter an operation (+,-,*,/): ");
                operator = sc.next();
        }    

        sc.close();
        System.out.printf("%.1f %s %.1f = %.1f\n", x1, operator, x2, res);
    
    }
}
