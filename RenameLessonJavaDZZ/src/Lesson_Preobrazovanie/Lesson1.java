package Lesson_Preobrazovanie;


import java.util.ArrayList;
import java.util.List;

public class Lesson1 {
    public static void main(String[] args) {
        List animals = new ArrayList();
        Animal ourAnimal = new Animal();
        animals.add("cat");
        animals.add("dog");
        animals.add("frog");
        animals.add(ourAnimal);

        String animal = (String) animals.get(1);
        System.out.println(animal);

        /////////////////////////////////
        List<String> animals2 = new ArrayList<String>();
        animals2.add("cat");
        animals2.add("dog");
        animals2.add("frog");

        String animal3 = animals2.get(1);
        System.out.println(animal3);

        ///////////////////////////// JAVA 7

        List<String> animal4 = new ArrayList<>();
        //animal4.add(ourAnimal);
    }
}

class Animal{

}