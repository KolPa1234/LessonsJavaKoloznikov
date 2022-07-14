package Multithreading.Lesson4Multi;

public class MultithreadingPart4 {
    public static void main(String[] args) throws Exception {
        Resourse.i = 5;

        //Resourse resourse = new Resourse();
       // resourse.setI(5);// хороший тон приватить пременные и не дават к ни доступа сеттре и геттры

        MyTread myTread = new MyTread();
        myTread.setName("one");

        MyTread myTread1 = new MyTread();
        myTread1.setName("two");

       // myTread.resourse = resourse;
        //myTread1.resourse = resourse;

        myTread.start();
        myTread1.start();

        myTread.join();
        myTread.join();

        System.out.println(Resourse.i);

    }
}
class MyTread extends Thread{
    Resourse resourse;
    @Override
    public void run(){
       Resourse.changeStaticI();
       new Resourse().changeI();

    }
}
class Resourse{
    //private int i;
     static int i;
    //public int getI(){
        //return i;
    // }
    public synchronized void setI(int i){
        this.i = i;
    }
   //Попробуем со статической
    public  synchronized static void changeStaticI(){
        synchronized (Resourse.class) {
            int i = Resourse.i;
            //int i = this.i;
            if (Thread.currentThread().getName().equals("one"));{Thread.yield();}
            i++;
            Resourse.i = i;
            // this.i = i;
        }
    }
    //публичная
    //public synchronized void changeI(){
      //  int i = this.i;
       // if (Thread.currentThread().getName().equals("one"));{
            // Thread.yield();

       // i++;
        //this.i = i;
    //}
//}

    public  void changeI(){
        synchronized(this) {
            int i = Resourse.i;
            if (Thread.currentThread().getName().equals("one")) ;
            {
                // Thread.yield();
            }
            i++;
            Resourse.i = i;
        }
    }
}