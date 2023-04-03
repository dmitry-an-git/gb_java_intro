
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

// this is a lazy version of this task, just builds one particular string 

public class task02a {
    public static void main(String[] args) {
    

        for (String entry : fileToStringArray()) {
            fillMask(entryToFields(entry));
        }
    }    

    public static String[] fileToStringArray() {
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
        String[] fields = entry.split("\"");
        String[] res = new String[] {fields[3],fields[7],fields[11]};
        return res;
    } 

    public static void fillMask(String[] fields){
        StringBuilder sb = new StringBuilder();
        sb.append("Студент ");
        sb.append(fields[0]);
        sb.append(" получил ");
        sb.append(fields[1]);
        sb.append(" по предмету ");
        sb.append(fields[2]);
        sb.append(".");
        System.out.println(sb.toString());
        //System.out.printf("Студент %s получил %s по предмету %s\n", fields[0],fields[1],fields[2]);
    }

}