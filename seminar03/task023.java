import java.util.ArrayList;
import java.util.Random;

public class task023 {
    public static void main(String[] args) {
        String[] planets = new String[]{"mercury", "venus", "earth", "mars", "jupiter"};
        ArrayList<String> lst = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            int a = r.nextInt(planets.length);
            lst.add(planets[a]);
        }

        System.out.println(lst);

        lst.sort(null);
        int count = 0;
        String last = lst.get(0);
        for (String item : lst) {
            if (item == last) {
                count++;
            }
            else {
                System.out.printf("%s: %d\n", last, count);
                count = 1;
                last = item;
            }
        }
        System.out.printf("%s: %d\n", last, count);
        
        // for (String string : lst) {
        //     System.out.println(string);
        // }

        

    }
}
