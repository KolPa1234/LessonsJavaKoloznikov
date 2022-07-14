package Zadachki.Massiv;

import java.util.Arrays;
import java.util.Random;

public class Massiv {
    //Массив рандомными цифрами java, Заполните массив 20
    // рандомными цифрамимежду 0 и 100. В
    // ыведите на консоль значение элементовкоторые больше 50.
    public static void main(String[] args) {
        Random randNumber = new Random();
        int[] arrays = new int[10];
        for (int i = 0; i < arrays.length; i++){
            arrays[i] = randNumber.nextInt(100);//дипозон значений ранодмных чисел

            if (arrays[i] > 50){
                System.out.println(arrays[i]);
            }
            //проверка массива
            System.out.println("Провекра массива");
            System.out.println(Arrays.toString(arrays));
        }

    }
}
