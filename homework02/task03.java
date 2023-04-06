        // Реализовать простой калькулятор (+ - / *)
        // Ввод числа ->
        // Ввод знака ->
        // Ввод числа ->

        // 3*дополнительно. К калькулятору из предыдущего дз добавить логирование.
        // 1 + 3 = 4
        // 4 + 3 = 7

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

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
        String str = String.format("%.1f %s %.1f = %.1f", x1, operator, x2, res);
        stringToFile(str);

    
    }


    public static void stringToFile(String str) { 
        // it both prints to the console and saves to the file
        String fileName = "task03_log.txt";
        String subFolderName = "homework02";
        String filePath = subFolderName + File.separator + fileName;
        File f = new File(filePath);
        
        try {
            FileWriter fw = new FileWriter(f,true);
            fw.write(str);
            //fw.write("\n");
            fw.close();
            System.out.println(str);
        } catch (Exception e) {
            System.out.println("Oups");
        }
    }
}
