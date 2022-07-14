package Exceptions.ExceptionsPart1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionsPart1 {
    public static void main(String[] args) throws FileNotFoundException{
        try {
            readFile();
        }catch (FileNotFoundException e){
            System.out.println("Отбработка исключения в методе main");
        }
    }
    public static void readFile()throws FileNotFoundException{
        File file = new File("test");
        Scanner scanner = new Scanner(file);
    }
}
