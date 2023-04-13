import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class task01 {
    public static void main(String[] args) {
        Set<Integer> hs = new HashSet<>(Arrays.asList(1,2,30000,4,5000,6,4));
        System.out.println(hs);

        Set<Integer> lhs = new LinkedHashSet<>(Arrays.asList(1,2,30000,4,5000,6,4));
        System.out.println(lhs);

        Set<Integer> ths = new TreeSet<>(Arrays.asList(1,2,30000,4,5000,6,4));
        System.out.println(ths);
    }
}