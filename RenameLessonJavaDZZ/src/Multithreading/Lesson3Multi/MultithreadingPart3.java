package Multithreading.Lesson3Multi;

public class MultithreadingPart3 {
    public static void main(String[] args) throws Exception {
        Resourse resourse = new Resourse();

        resourse.setI(5);

        MyTread myTread = new MyTread();
        myTread.setName("first");
        MyTread myTread2 = new MyTread();
        myTread.setResourse(resourse);//сэтаем русурс в поток
        myTread2.setResourse(resourse);

        myTread.start();
        myTread2.start();

        myTread.join();
        myTread2.join();

        System.out.println(resourse.getI());
    }
}
class MyTread extends Thread{
    Resourse resourse;
    public void setResourse(Resourse resourse){
        this.resourse = resourse;
    }
    @Override
    public void run(){
      resourse.changeI();
    }
}
class Resourse{
    private int i;
    public int getI(){
        return i;
    }
    public synchronized void setI(int i){
        this.i = i;
    }
    public synchronized void changeI(){
        int i = this.i;
        if(Thread.currentThread().getName().equals("first")){
            Thread.yield();
        }
        i++;
        this.i = i;

        //thread 1
        //int i = this.i;
        //i = 5
        //trad 2
        //int i = this.i;
        //thread 2 i=5
        //thread 2 i = 6 and i++
        //i++;
        //this.i = i;
    }
}