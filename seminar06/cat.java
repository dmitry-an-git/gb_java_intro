import java.util.Scanner;

public class cat {

    public String name = "undefined";
    public String gender = "not known";
    public float weight = 1;
    public int age = 0;
    public String parent1;
    public String parent2;

    public cat(){}

    public cat(String name){ // конструктор 1
        this.name = name;
        this.weight = weight;
    }
    public cat(String name, float weight){ // конструктор 2
        this.name = name;
        this.weight = weight;
    }

    public void plusYear(){
        this.age +=1;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setWeight(float newWeight){
        this.weight = newWeight;
    }

    public float getWeight(){
        return this.weight;
    }

    @Override
    public String toString(){
        String st = String.format("Name: %s, Gender: %s, Weight: %s, Age: %s\n", this.name, this.gender, this.weight, this.age);
        return st;
    }

    public cat add(cat secondCat){
        cat newCat = new cat("TempName");
        newCat.parent1 = this.name;
        newCat.parent2 = secondCat.name;
        return newCat;
    }
    
}


