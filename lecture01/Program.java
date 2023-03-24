package gb_java_intro.lecture01;
import java.util.Scanner;
/**
 * Program
 */
public class Program {

    public static void main(String[] args) {

        System.out.println("bye world");

        // типы переменных
        String div = "----";
        float f = 54.34f;
        int i = 5;
        double d = 3.15;
        double dd = 3.15D;
        String s = "some text";
        System.out.println(s); 

        char ch = 'x';
        System.out.println(Character.isDigit(ch));
        char hc = '1';
        System.out.println(Character.isDigit(hc));

        //неявное преобразование
        char cc = 123; 
        System.out.println(cc);

        // булева логика
        System.out.println(div);
        boolean bo = true && false;
        System.out.println(bo);
        boolean bb = true ^ true; // разделительная дизьюнкция - только когда одно true
        System.out.println(bb);
        boolean bbb = 123 <= 234;
        System.out.println(bbb);

        System.out.println(div);
        var ii = 123;
        System.out.println(getType(ii));
        int iiii = 23_456_789; // примитив int vs обертка Integer
        System.out.println(Integer.MAX_VALUE);

        // строки
        System.out.println(div);
        String ss = "qwerty";
        char chch = ss.charAt(2);

        // инкремент и декремент
        System.out.println(div);
        int a = 123;
        System.out.println(a++); //123 - приоритет инкремента ниже приоритета вывода
        System.out.println(a); //124 ! 
        System.out.println(++a); //125 - пред/пост инкремент 
        int aa = a-- - --a;
        System.out.println(aa);
        aa = --a - a--;
        System.out.println(aa);

        // битовые операции
        System.out.println(div);
        a = 8;
        System.out.println(a << 1); // битовые операции
        System.out.println(a >> 1);
        int b = 4;
        System.out.println(a & b); // 1000 & 0100 = 0000
        System.out.println(a | b); // 1000 | 0100 = 1100
        System.out.println(a ^ b); // 1000 | 0100 = 1100

        // String s1 = "qwerty"; //6, 0..
        // boolean b1 = s1.length()>6 && s1.charAt(6) == 'y'; // false "быстрая операция"
        // не проверяет второе если первое условие false
        // boolean b2 = s1.length()>2 & s1.charAt(6) == 'y'; // error !!!
        // проверяет все 

        // массивы
        System.out.println(div);
        int[] arr = new int[10];
        System.out.println(arr.length);
        arr = new int[] {1, 2, 3, 4, 5};
        System.out.println(arr.length);
        System.out.println(arr[3]);
        arr[3]=45;
        System.out.println(arr[3]);

        // двумерные массивы
        System.out.println(div);
        int[] brr[] = new int[3][5];
        for (int[] line: brr) {
            for (int item: line) {
                System.out.printf("%d", item);
            }
            System.out.println();
        }

        int[][] crr = new int[3][5]; // так же можно так

        // явные преобразования
        System.out.println(div); // 
        int e = 123; double dub = e;
        System.out.println(e); // 123
        System.out.println(dub); // 123.0
        dub = 3.1415; e = (int)dub;
        System.out.println(e); // 3
        System.out.println(dub); // 3.1415
        byte by = Byte.parseByte("123");
        System.out.println(by); // 123
        // b = Byte.parseByte("1234"); // byte 0..255
        // System.out.println(by); // number format exceeded

        // массив целых чисел нельзя положить в массив нецелых чисел
        // int[] crr = new int[10];
        // double[] drr = crr; // не сработает

        // // Ввод пользователем
        // System.out.println(div);

        // Scanner iScanner = new Scanner(System.in);
        // System.out.printf("name: ");
        // String name = iScanner.nextLine();
        // System.out.printf("Привет, %s!\n", name);
        // // iScanner.close();

        // // Scanner iScanner = new Scanner(System.in);
        // System.out.printf("int a: ");
        // int scan_x = iScanner.nextInt();
        // System.out.printf("double a: ");
        // double scan_y = iScanner.nextDouble();
        // System.out.printf("%d + %f = %f\n",scan_x, scan_y, scan_x+scan_y);
        // // iScanner.close();

        // System.out.printf("bool: ");
        // boolean scan_bool = iScanner.nextBoolean(); // вводить с большой буквы
        // System.out.printf("Булеан %b!\n", scan_bool); // тут выводит с маленькой почему-то
        // // iScanner.close();

        // System.out.printf("int i: ");
        // boolean flag = iScanner.hasNextInt();
        // System.out.println(flag);
        // int scan_i = iScanner.nextInt();
        // System.out.println(i);
        // iScanner.close();

        // форматированный вывод
        System.out.println("Форматированный вывод:");
        int fa = 1; int fb = 2; // задали 1 строку
        int fc = fa + fb; // тут возникло 2 новых строки в памяти 
        String res = fa + " + " + fb + " = " + fc; // четвертая сртока - конкатинация это плохо!
        System.out.println(res);

        String res2 = String.format("%d + %d = %d", fa, fb, fc);
        System.out.println(res2);

        System.out.printf("%d + %d = %d\n", fa, fb, fc);
        // спецификаторы %d, %x (hex), %f, %e (exp), %c (single char), %s (string)
        // %2f, %3f, %4e - число знаков

        // SCOPE
        // int scope1 = 123
        // {
        //     int scope1 = 321 - wont work, as we have it in the main scope
        //     int third = scope1 + 1 = will work, using var from the first scope
        // }

        // {
        //     int scope2 = 321 - works, as it was not defined before
        // }
        // int scope2 = 123

        // functions

        System.out.println("Functions:");
        sayHi();
        lib.sayBye();
        System.out.println(factor(5));
        System.out.println(summm(5,9));

        // логика
        // ветвление
        int la = 1;
        int lb = 2;
        int lc;
        if (la>lb) {
            lc = 3;
        } else {
            lc = lb;
        }
        // короткая форма
        if (la>lb) lc = la;
        if (lb>la) lc = lb;
        // тернарный оператор
        int min = a < b ? a : b; // если true то то что до :, если false то после

        // switch
        // int month = value;
        // String text = "";
        // switch (month) {
        //     case 1:
        //     case 2: // проверяет сразу 2 кейса
        //     text = "Authumn";
        //     break;
        //     .....
        //     default:
        //     text = "mistake";
        //     break;
        // }

        // while 
        int input = 321;
        int count = 0;
        while (input != 0) {
            input /= 10;
            count++;
        }
        System.out.printf("%d числа\n", count);
        // do while
        input = 321;
        count = 0;
        do {
            input /= 10;
            count++;
        } while (input != 0);
        System.out.printf("%d числа\n", count);

        // for
        for (int index = 0; index < 10; index++) {
            if (index%2 == 0) continue; // следующий цикл
            System.out.println(index);
        }
 
        // for
        arr = new int[] {1,2,3,4,5};
        for (int index = 0; index < arr.length; index++) {
            arr[index]=10;
        }

        // foreach
        for (int item : arr) {
            System.out.printf("%d ", item);
        }
        System.out.println();
    }

    static public String getType(Object o){
        return o.getClass().getSimpleName();
    }

    static public void sayHi(){
        System.out.println("hi!");
    }

    static int summm(int a, int b){
        return a+b;
    }

    static double factor(int a){
        if (a==1) return 1;
        return factor(a-1)*a;
    }
        
}