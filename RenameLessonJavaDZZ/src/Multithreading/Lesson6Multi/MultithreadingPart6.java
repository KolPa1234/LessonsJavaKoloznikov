package Multithreading.Lesson6Multi;

import java.util.concurrent.atomic.AtomicInteger;

public class MultithreadingPart6 {
    //атомарные переменные!!!
    //int i;
    //Integer I;
    //double d;
    //Double D;
       static AtomicInteger atomicInteger = new AtomicInteger();
    static int i;

    public static void main(String[] args) throws Exception{
        for (int j = 0; j < 10_000; j++){
            new MyTread().start();
        }
        Thread.sleep(2_000);
        System.out.println(atomicInteger.get());//атомические изменет текущее значение
    }
    static class MyTread extends Thread{
        @Override
        public void run(){
          atomicInteger.incrementAndGet();
            /* принцип работы в потоке
            int k = i + 1;
            i = k;
            int k = i + 1;
            i = k;
            int k = i + 1;
            i = k;
            int k = i + 1;
            i = k;
            int k = i + 1;
            i = k;
            int k = i + 1;
            i = k;
             */
        }
    }
}
