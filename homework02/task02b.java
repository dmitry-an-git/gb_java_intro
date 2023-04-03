
import java.io.File;
import java.io.FileReader;

// Дана строка (получение через обычный текстовый файл!!!)
// "фамилия":"Иванов","оценка":"5","предмет":"Математика"
// "фамилия":"Петрова","оценка":"4","предмет":"Информатика"
// Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида: 
// Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода в консоль:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

// this version uses a mask and reads placeholders and replaces them with values, using keys from the file

public class task02b {
    public static void main(String[] args) {
        String mask = "Студент [фамилия] получил [оценка] по предмету [предмет].";

        for (String entry : fileToStringArray()) {
            fillMask(entryToFields(entry), mask);
        }
    }    

    public static String[] fileToStringArray() {
    // returns an array with lines from file
        String fileName = "task02.txt";
        String subFolderName = "homework02";
        String filePath = subFolderName + File.separator + fileName; 

        try { 
            File f = new File(filePath);
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
            // System.out.println(str);
    
        } catch (Exception e) {
            System.out.println("Unable to read file");
            String[] dummy = new String[] {"Unable to read file"};
            return dummy;
        }
    }

    public static String[] entryToFields(String entry){
    // turns a line into an array of strings, each string is a pair of key:value
        String[] fields = entry.replace("\"","").split(",");
        return fields;
    } 

    public static String pseudoDict(String[] dict, String key){
    // takes an array of key:value pairs and one key, and returns a relevant value for that key
        for (String item : dict) {
            String[] key_value = item.split(":");
            if (key_value[0].equals(key)) { // i've spent a lot of time resolving why == doesnt work
                return key_value[1];
            }
        }
        return key;
    }

    public static void fillMask(String[] fields, String mask) {
    // takes an array of key:value pairs and fills a mask
        
        String[] mask_arr = mask.split("\\[|\\]"); 
        // i uses " " first, but it get complicated when u have a comma or dot after a closing square bracket
        StringBuilder sb = new StringBuilder();

        for (String word : mask_arr) {
            sb.append(pseudoDict(fields,word));
        }
        
        System.out.println(sb.toString());

    }

}
 
