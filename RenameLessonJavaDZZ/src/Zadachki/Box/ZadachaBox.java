package Zadachki.Box;

import javax.swing.*;


public class ZadachaBox {
    /* Есть класс Box у которого есть поле int value + флажок, что в ящике лежит значение.
     * Есть Producer, который генерирует числа от 1 до 20 и есть Consumer, который их потребляет.
     * Нужно написать программу с использованием wait,notify/notifyall, synchronized.
     * Producer и Сonsumer  должны работать в отдельных потоках.
     * Producer должен передать через Box все свои значения, а Consumer их получить.
     * Вывод программы должен быть примерно такой:
     *      P(1)
     *      C(1)
     *      P(2)
     *      C(2)
     */
    public static void main(String[] args) {
       /* Box box = new Box();
        Producer producer = new Producer(box);
        Consumer consumer = new Consumer(box);
        new Thread(producer).start();
        new Thread(consumer).start();
        */
    }
}
