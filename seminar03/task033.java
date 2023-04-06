import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

// create an ArrayList with natural numbers and strings, remove numbers

public class task033 {
    public static void main(String[] args) {
        ArrayList<Object> lst = new ArrayList<>();
        Object[] map = new Object[]{"str", 1};
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            lst.add(map[r.nextInt(0,2)]);

        }
        System.out.println(lst);
        System.out.println(lst.get(0).getClass().getName());
        System.out.println(lst.get(1).getClass().getName());

        // List<Object> lstLst = lst;
        // Iterator<Object> col = lstLst.iterator(); 

        // Integer x = 0;
        // while (col.hasNext()) {
        //     if (col.next().getClass() == x.getClass() ) { // (col.next() instanceof Integer)
        //         col.remove();
        //     }
        // }
            
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i) instanceof Integer) {
                lst.remove(i);
                i--;
            }
            
        }

        System.out.println(lst);

    }
}
