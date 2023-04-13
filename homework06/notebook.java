import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class notebook {
    private Integer id;
    private Integer memory;
    private Integer hdd;
    private String make;
    private String os;
    private Integer price;

    private static Integer lastID = 0; 
    
    // options
    private static ArrayList<Integer> memoryOptions = new ArrayList<>() {{
        addAll(Arrays.asList(128, 256, 512, 1024));
    }};

    private static ArrayList<Integer> hddOptions = new ArrayList<>(){{
        addAll(Arrays.asList(1, 2, 4, 8));
    }}; 

    public static ArrayList<String> makes = new ArrayList<>(){{
        addAll(Arrays.asList("Sony", "Acer", "HP", "Toshiba", "Lenovo"));
    }};

    public static ArrayList<String> operatingSystems = new ArrayList<>(){{
        addAll(Arrays.asList("Windows", "Linux", "None"));
    }};

    public notebook(){
        Random r = new Random(); 
        notebook.lastID++;
        this.id = lastID;
        this.memory = memoryOptions.get(r.nextInt(memoryOptions.size()));
        this.hdd = hddOptions.get(r.nextInt(hddOptions.size()));
        this.make = makes.get(r.nextInt(makes.size()));
        this.os = operatingSystems.get(r.nextInt(operatingSystems.size()));
        setPrice();
    }

    private void setPrice(){
        
        Map<String, Integer> makeMult = new HashMap<>();
        makeMult.put("Sony",30);
        makeMult.put("Acer",0);
        makeMult.put("HP",20);
        makeMult.put("Toshiba",10);
        makeMult.put("Lenovo",10);

        Map<String,Integer> osAdd = new HashMap<>();
        osAdd.put("Windows", 200);
        osAdd.put("Linux",50);
        osAdd.put("None",0);

        this.price = (300+this.memory*1+this.hdd*50)
                            * (100 + makeMult.get(this.make))/100
                            + osAdd.get(this.os);
    }

    public Integer getID(){
        return this.id;
    }

    public Integer getMemory(){
        return this.memory;
    }
    
    public Integer getHDD(){
        return this.hdd;
    }

    public Integer getPrice(){
        return this.price;
    }

    public String getMake(){
        return this.make;
    }

    public String getOS(){
        return this.os;
    }

    @Override
    public String toString(){
        return String.format("ID: %-10d Mem: %-10d HDD: %-10d Mk: %-15s OS: %-15s $$: %-15d", this.id, this.memory, this.hdd, this.make, this.os, this.price);
    }
}
