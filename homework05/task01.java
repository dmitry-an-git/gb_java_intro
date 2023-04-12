import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько 
// телефонов.
// Добавить функции 1) Добавление номера
// 2) Вывод всего 
// Пример:
// Я ввожу: 1
// К: Введите фамилию
// Я: Иванов
// К: Введите номер
// Я: 1242353
// К: Введите 1) Добавление номера
// 2) Вывод всего 
// Я ввожу: 1
// К: Введите фамилию
// Я: Иванов
// К: Введите номер
// Я: 547568
// К: Введите 1) Добавление номера
// 2) Вывод всего 
// Я: 2
// Иванов: 1242353, 547568

public class task01 {
    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> pb = new HashMap<>();
        menu(pb);
    }

    public static String askForName(Scanner sc){
        System.out.printf("Please enter the surname: ");
        String name = sc.nextLine();
        return name;
    }
    public static int askForNumber(Scanner sc){
        System.out.printf("Please enter the number: ");
        int number = sc.nextInt();
        return number;
    }
    public static void addContact(Scanner sc, Map<String, ArrayList<Integer>> pb){
        String name = askForName(sc);
        int number = askForNumber(sc);
        ArrayList<Integer> phones = new ArrayList<>();

        if (pb.containsKey(name)) {
            phones = pb.get(name);
        }
        
        phones.add(number);
        pb.put(name, phones);
    }

    public static void printBook(Map<String, ArrayList<Integer>> pb) {
        if (pb.isEmpty()) {
            System.out.println("Nothing to print, the phonebook is empty.");
            return;
        }
        for (var item : pb.entrySet()) {
            System.out.printf("%s: ", item.getKey());
            System.out.printf("%d", item.getValue().get(0));
            
            if (item.getValue().size()>1) {
                for (int i = 1; i < item.getValue().size(); i++) {
                    System.out.printf(", %d", item.getValue().get(i));
                }
            }
            System.out.println();
        }
    }

    public static void menu(Map<String, ArrayList<Integer>> pb) {
        Boolean run = true;
        while (run) {
            Scanner sc = new Scanner(System.in);
            System.out.printf("Please enter \"1\" to add new contact, \"2\" to print all contacts, \"3\" to exit: ");
            String input = sc.nextLine();
            switch (input) {
                case "1":
                    addContact(sc, pb);
                    break;
                case "2":
                    printBook(pb);
                    break;
                case "3":
                    run = false;
                    System.out.println("Good bye!");
                    break;
                default:
                    System.out.println("Wrong input, try again!");
            sc.close();
            }
        }
    }
}