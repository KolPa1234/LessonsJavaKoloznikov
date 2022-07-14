package Multithreading.Lesson2Multi;

public class MultithreadingPart2 {
    public static void main(String[] args) throws Exception {
        MyThread myThread = new MyThread();

        myThread.start();
        //Thread.yield();// - static method
        //myThread.join();// - ждем завершения потока, отдача выполния слудующему потоку
        System.out.println("thread main");


        //MyThread myThread1 = new MyThread();;
        //myThread1.start();
        //Thread.yield(); - метод для отдачи времени для другого потока
        //myThread.setPriority(5); - метод для расстанвоки приортитетов потоков
        //myThread1.setPriority(Thread.MAX_PRIORITY);
        //myThread.setPriority(Thread.MAX_PRIORITY);
        //System.out.println("tread main");
    }
}
class MyThread extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 50; i++){
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
             }
        }
       // System.out.println("thread 0");

    }
}