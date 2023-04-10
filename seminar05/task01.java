import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
 // read db and find passport by name
 
public class task01 {
    public static void main(String[] args) {
        Map<Integer, String> db = loadFromFile();
        System.out.println(db);
        String keyword = "иванов";
        ArrayList<Integer> res = findByValue(db, keyword.toLowerCase());

        for (var item : db.entrySet()) {
            System.out.println(Arrays.toString(item.getValue().getBytes()));
        }
        
        System.out.println(db.size());
        System.out.println(res);
    }


    public static Map<Integer, String> loadFromFile() {
        Map<Integer, String> db = new HashMap<>();

        String fileName = "task01.txt";
        File f = new File(fileName);
        try {

            FileReader fr = new FileReader(f, StandardCharsets.UTF_8);
    

            char[] a = new char[(int)f.length()];
            fr.read(a);
            fr.close();

            StringBuilder sb = new StringBuilder();

            for(char c: a){
                sb.append(c);
            }
            String[] read = sb.toString().split(System.lineSeparator());
            
            for (String str : read) {

                String[] entry = str.split(" ");
                db.put(Integer.parseInt(entry[0]),entry[1]);

            }
        } catch (Exception e) {
            System.out.println("Oups");
        }
        
        return db;
    }

    public static ArrayList<Integer> findByValue(Map<Integer, String> db, String value){
        ArrayList<Integer> res = new ArrayList<>();
        for (var item : db.entrySet()) {
            if (item.getValue().equals(value)) {
                res.add(item.getKey());
            }
        }
        return res;
    }
}