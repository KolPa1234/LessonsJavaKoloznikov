package Multithreading.Lesson5Mulri;

public class MultithreadingPart5 {
    //Volatile!!!
    //Суть практики отработать пишущие пототки и читающие, чтобы не кэшировать переменную
    volatile static int i = 0;

    public static void main(String[] args) throws  Exception{
       // MyThread myThread = new MyThread();
        // myThreadRead = new MyThreadRead();
        //myThread.start();
        //myThreadRead.start();
        new MyThread().start();
        new MyThreadRead().start();
    }
    static class MyThread extends Thread{
        @Override
        public void run(){
            while (i < 5){
                System.out.println("increment i do "+ (++i));
                try{
                Thread.sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    static class MyThreadRead extends  Thread{
        @Override
        public void run(){
            int localVar = i;
            while (localVar < 5){
                if(localVar != i){
                    System.out.println("new value of i is  " + i);
                    localVar = i;
                }
            }
        }
    }
}
