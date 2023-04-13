import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class task01{
    public static void main(String[] args) {
        int stock = 10; // the number of notebooks on our warehouse
        ArrayList<notebook> warehouse = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            warehouse.add(new notebook()); // the parameters are randomly generated by class
        }
        for (notebook item : warehouse) { // print all
            System.out.println(item); 
        }
        System.out.println();
        menu(warehouse);

    }

    public static int askForInt(Scanner sc){
        int input;
        try {
            input = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Wrong input!");
            return askForInt(sc);
        }
        
        return input;
    }

    public static void menu(ArrayList<notebook> warehouse){
        Scanner sc = new Scanner(System.in);
        HashMap<String, Object> selection = new HashMap<>(); // a dictinary with search criteria
        boolean inputs = true;

        while (inputs){
            System.out.println("Please select filter criteria by entering the command:");
            System.out.println("1 - memory");
            System.out.println("2 - hdd");
            System.out.println("3 - make");
            System.out.println("4 - operating system");
            System.out.println("5 - price");
            System.out.println("Enter 0 to start search");
            System.out.printf("Your input: ");
            int input = askForInt(sc);
            
            switch (input){
                case 1:
                    System.out.printf("Set the minimal memory size (128-1024 Gb): ");
                    int minMemSize = askForInt(sc);
                    selection.put("memory", minMemSize);
                    System.out.println(selection);
                    break;
                case 2:
                    System.out.printf("Set the minimal hdd size (1-8 Tb): ");
                    int minHddSize = askForInt(sc);
                    selection.put("hdd", minHddSize);
                    break;
                case 3:
                    System.out.printf("Select the producer: ");
                    ArrayList<String> makes = notebook.makes;
                    for (int i = 0; i < makes.size(); i++) {
                        System.out.printf("%d - %s\n", i+1, makes.get(i));
                    }
                    int make_selection = askForInt(sc)-1;
                    String make = makes.get(make_selection);
                    selection.put("make", make);
                    break;
                case 4:
                    System.out.println("Select the operating system: ");
                    ArrayList<String> operatingSystems = notebook.operatingSystems;
                    for (int i = 0; i < operatingSystems.size(); i++) {
                        System.out.printf("%d - %s\n", i+1, operatingSystems.get(i));
                    }
                    int osSelection = askForInt(sc)-1;
                    String operatingSystem = operatingSystems.get(osSelection);
                    selection.put("os", operatingSystem);
                    break;
                case 5:
                    System.out.printf("Set the minimal price ($$): ");
                    int minPrice = askForInt(sc);
                    selection.put("price", minPrice);
                    break;
                case 0:
                    inputs = false;
                    break;
                default:
                    System.out.println("Wrong selection, try again.");
                    break;
            }
        }

        System.out.println("The following notebooks were found:");
        filter(warehouse,selection);
    }

    public static void filter(ArrayList<notebook> warehouse, HashMap<String,Object> selection){
        ArrayList<notebook> searchResult = new ArrayList<>();

        for (notebook item : warehouse) {
            boolean match = true;

            if (selection.containsKey("memory") && (Integer)selection.get("memory")>item.getMemory()) 
                match = false;
            
            if (selection.containsKey("hdd") && (Integer)selection.get("hdd")>item.getHDD()) 
                match = false;
            
            if (selection.containsKey("price") && (Integer)selection.get("price")>item.getPrice()) 
                match = false;

            if (selection.containsKey("make") && !selection.get("make").equals(item.getMake())) 
                match = false;
            
            if (selection.containsKey("os") && !selection.get("os").equals(item.getOS())) 
                match = false;

            if (match) {
                searchResult.add(item);
            }
        }

        for (notebook item : searchResult) {
            System.out.println(item);
        }
    }
}