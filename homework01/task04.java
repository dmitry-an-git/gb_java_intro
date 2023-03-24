// *(ДОПОЛНИТЕЛЬНАЯ) +Задано уравнение вида q + w = e, q, w, e >= 0. 
// Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69 (пользователь). 
// Требуется восстановить выражение до верного равенства. 
// Предложить хотя бы одно решение или сообщить, что его нет.
// под знаками вопроса - одинаковые цифра
// Ввод: 2? + ?5 = 69
// Вывод: 24 + 45 = 69

package gb_java_intro.homework01;

import java.util.Scanner;

public class task04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the equation in the form of XX + XX = XX");
        String equation = sc.nextLine();
        sc.close();
        String[] arr = equation.split(" ");
        String[] arr_x = new String[] {arr[0], arr[2]};

        // если мы сделаем перестановки получим x*x_mult + add = sum
        // не может быть больше одного решения

        int x_mult = 0;
        int add = 0;
        int sum = Integer.parseInt(arr[4]);

        for (String item : arr_x) {
            if (item.charAt(0) == '?') x_mult += 10;
            else add += Character.getNumericValue(item.charAt(0))*10;
            if (item.charAt(1) == '?') x_mult += 1;
            else add += Character.getNumericValue(item.charAt(1));
        }

        int x = (sum - add)/x_mult; // если "?" не введут, то будет деление на 0

        String ans = equation.replace("?", Integer.toString(x));

        if (x*x_mult + add == sum && x>=0 && x<10) {
            System.out.println("Did you mean the following?");
            System.out.println(ans);
        }
        
        else System.out.println("The equation does not have a root.");

        

    }
}
