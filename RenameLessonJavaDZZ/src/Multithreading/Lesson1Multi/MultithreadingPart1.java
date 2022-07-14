package Multithreading.Lesson1Multi;

public class MultithreadingPart1 {
    public static void main(String[] args) throws Exception {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread2 = new Thread(myRunnable);
        Thread thread3 = new Thread(myRunnable);


        thread2.start();
        thread3.start();

        System.out.println(Thread.currentThread().getName());
    }
}
class MyRunnable implements Runnable{
    @Override
    public void run(){
        for (int i = 0; i < 400; i++ ){
            System.out.println("Thread name is .... " + Thread.currentThread().getName() + " i = " + i);
        }
    }
}