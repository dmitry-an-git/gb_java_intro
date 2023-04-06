import java.util.ArrayList;
import java.util.List;
import java.util.Random;
// create list and input 10 random numbers
// sort and print it


public class task011 {
    public static void main(String[] args) {
        Random r = new Random();
        List<Integer> lst = new ArrayList<>();
        for (int index = 0; index < 10; index++) {
            lst.add(r.nextInt(10));
        }
            
        lst.sort(null);
        System.out.println(lst);
    
    }
        
}
