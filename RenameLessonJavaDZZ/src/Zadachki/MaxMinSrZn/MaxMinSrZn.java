package Zadachki.MaxMinSrZn;

//Заполните массив случайным числами и выведите максимальное, минимальное и среднее значение.

public class MaxMinSrZn {
    public static void main(String[] args) {
        int n = 100;

        double[] array = new double[n];
        for (int i = 0; i < array.length; i++){
            array[i] = Math.random();
        }
        double max = array[0];//array don't null
        double min = array[0];
        double avg = 0;

        for (int i = 0; i < array.length; i++){
            if(max < array[i]) max = array[i];
            if (min > array[i]) min = array[i];
            avg += array[i] / array.length;
        }
        System.out.println("Максимальное число в массивке - " + max);
        System.out.println("Минимальное число в массиве - " + min);
        System.out.println("Среднее арифметическое занчаение - " + avg);
    }
}
