import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

// Пусть дан список сотрудников:
// Иван Иванов
// Светлана Петрова
// Кристина Белова
// Анна Мусина
// Анна Крутова
// Иван Юрин
// Петр Лыков
// Павел Чернов
// Петр Чернышов
// Мария Федорова
// Марина Светлова
// Мария Савина
// Мария Рыкова
// Марина Лугова
// Анна Владимирова
// Иван Мечников
// Петр Петин
// Иван Ежов
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. 
// Отсортировать по убыванию популярности Имени.


public class task02 {
    public static void main(String[] args) {
        String[] fullList = readListFromFile();
        String[] nameList = getNamesOnly(fullList);
        Map<String, Integer> db = countNames(nameList);
        printSorted(db);
    }

    public static String[] readListFromFile() {
        String fileName = "task02.txt";
        try { 
            File f = new File(fileName);
            FileReader fr = new FileReader(f);
            char[] a = new char[(int)f.length()];
            fr.read(a);
            fr.close();
        
            StringBuilder sb = new StringBuilder();
        
            for(char c: a){
                sb.append(c);
            }
            String[] res = sb.toString().split(System.lineSeparator());
            return res;
        }
        catch (Exception e) {
            return new String[0];
        }
        
    }

    public static String[] getNamesOnly(String[] list) {
        String[] names = new String[list.length];
        for (int i = 0; i < list.length; i++) {
            names[i] = list[i].split(" ")[0];
        }
        return names;
    }

    public static void printList(String[] list) {
        for (String item : list) {
            System.out.println(item);
        }
    }

    public static Map<String, Integer> countNames(String[] list) {
        Map<String, Integer> db = new HashMap<>();
        for (String item : list) {
            if (db.containsKey(item)) {
                int count = db.get(item);
                db.put(item, count+1);
            } else {
                db.put(item, 1);
            }
        }
        return db;
    }

    public static void printSorted(Map<String, Integer> db){
        int max = 0;
        for (var item : db.entrySet()) {
            if (item.getValue()>max) max = item.getValue();
        }
        for (int i = max; i > 0; i--) {
            for (var item : db.entrySet()) {
                if (item.getValue()==i) {
                    System.out.printf("%s : %d\n", item.getKey(), item.getValue());
                }
            }
        }
    }
    
}
