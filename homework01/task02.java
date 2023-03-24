// Вывести все простые числа от 1 до 1000

// НО! на семинаре говорилось про сумму этих простых чисел

package gb_java_intro.homework01;

public class task02 {
    public static void main(String[] args) {
    
        int n = 1000;
        int sum = 0;
        boolean prime;


        for (int i = 2; i < n+1; i++) {
            prime = true;
            for (int j = 2; j <= i/2; j++) {
                //System.out.println(j);
                if (i%j == 0) {
                    prime = false;
                    break; 
                }
            }
            if (prime) sum += i;

        }

        System.out.printf("The sum of all prime numbers that are less than 1000 is: %d\n",sum);
    }
}
    

