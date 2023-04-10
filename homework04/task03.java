
// Часть 1: Реализовать простой калькулятор (+ - / *)
// Ввод числа ->
// Ввод знака ->
// Ввод числа ->

// Часть 2: дополнительно. К калькулятору из предыдущего дз добавить логирование.
// 1 + 3 = 4
// 4 + 3 = 7

// Часть 3: В калькулятор добавьте возможность отменить последнюю операцию.
// Пример
// 1
// +
// 2
// ответ:
// 3
// +
// 4
// ответ:
// 7
// +
// 2
// ответ:
// 9
// 1
// Ответ 8
// Отмена -> 9
// Отмена -> 7
// Отмена -> 3
// +
// 2
// Ответ 5

import java.util.Scanner;
import java.util.Stack;
import java.io.File;
import java.io.FileWriter;

public class task03 {
    public static void main(String[] args) {

        stringToFile("\n---- new calc ----\n");
        Scanner sc = new Scanner(System.in);
        // it doesnot work if I create a new scanner in each method

        double x1 = askForInput("Enter the first integer", sc); 
        String operator = askForOperator(sc);
        double x2 = askForInput("Enter the second integer", sc);
        double res = doCalcs(x1, x2, operator);

        String str = String.format("%.1f %s %.1f = %.1f\n", x1, operator, x2, res);
        stringToFile(str);

        Stack<Double> st = new Stack<>();
        x1 = res;

        while (true) {
            
            operator = askForOperator(sc);
            if (operator.equals("cancel")) {
                if (st.size()==0){ 
                    System.out.println("Nothing to cancel! The result is now 0");
                    x1 = 0;
                } else {
                    x1 = st.pop();
                    str = String.format("Cancel --> the result is now %.1f\n",x1);  
                    stringToFile(str);   
                }        
            } else {
                st.push(res);
                x2 = askForInput("Enter the second integer", sc);
                res = doCalcs(x1, x2, operator);
                str = String.format("%.1f %s %.1f = %.1f\n", x1, operator, x2, res);
                stringToFile(str);
                x1 = res;
            }

        }
    }


    public static double askForInput(String message, Scanner sc)  {
        
        System.out.print(message+": ");
        String digit = sc.next();
        sc.nextLine();
        double d;
        try {
            d = Double.parseDouble(digit);
        } catch (Exception e) {
            System.out.println("Wrong input!");
            d = askForInput(message, sc);
        }
        ; // clear the buffer of scanner

        return d;
        
    }

    public static String askForOperator(Scanner sc) {

        System.out.print("Enter operator (+,-,*,/,cancel): ");
        String operator = sc.nextLine();
        
        if (!(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/") || operator.equals("cancel"))){
            System.out.println("Wrong input!");
            operator = askForOperator(sc);
        }

        return operator;
    }  
    
    public static double doCalcs(double x1, double x2, String operator) {
        
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
        }    
        return res;
    }

    public static void stringToFile(String str) { 
        // it both prints to the console and saves to the file
        String fileName = "task03_log.txt";
        //String subFolderName = "homework02";
        //String filePath = subFolderName + File.separator + fileName;
        //File f = new File(filePath);
        File f = new File(fileName);

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

