import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class task02 {
    public static void main(String[] args) {
        int size = 110;
        Integer[] arr = createArray(size);
        float share = unique(arr);
        System.out.printf("Share of unique values is: %.1f\n", share);

    }

    public static Integer[] createArray(int size){
        Random r = new Random();
        Integer[] array = new Integer[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(70);
        }
        return array;
    }

    public static float unique(Integer[] array){
        Set<Integer> set = new HashSet<>(Arrays.asList(array));
        float share = set.size()*100/array.length;
        return share;
    }
}
