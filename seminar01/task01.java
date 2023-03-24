package gb_java_intro.seminar01;


public class task01 {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 1, 1, 0, 1, 1, 1, 1, 0, 1};
        // int[] arr = {1, 1, 1, 0, 1, 1, 1, 1, 0, 1}; // also possible

        int counter = 0;
        int max = 0;

        for (int item : arr) {
            if (item == 1) {
                counter++;
                if (counter>max) max = counter;
            }
            else {
                counter = 0;
            }
        }
        System.out.println(max);

    } 
}
