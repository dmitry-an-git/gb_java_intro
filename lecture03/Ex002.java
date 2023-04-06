
import java.util.ArrayList;
public class Ex002 {

   public static void main(String[] args) {
       ArrayList<Integer> list = new ArrayList<Integer>();
       //ArrayList list = new ArrayList();
       list.add(2809);
       System.out.println(list.size());

       for (Object o : list) {
           System.out.println(o);
       }
   }
}
