package Zadachki.NewDinner;

public class Philosopherrr implements Runnable{
    // Вилки по обе стороны от этого Философа
    private Object leftFork;
    private  Object rightFork;

    public Philosopherrr (Object leftFork, Object rightFork){
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }
    // Переменные-члены, стандартный конструктор

    private void doAction(String action) throws InterruptedException{
        System.out.println(
                Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) (Math.random() * 100)));
    }

    /*Теперь давайте реализуем основную логику философа.
Чтобы имитировать получение fork, нам нужно заблокировать его, чтобы никакие
два потока Philosopher не получали его одновременно.
Для достижения этой цели мы используем ключевое слово synchronized
для получения внутреннего монитора объекта fork и предотвращения того, ч
тобы другие потоки делали то же самое.
Теперь мы приступаем к реализации метода run() в классе Philosopher:
     */
    /*@Override
    public void run(){
    try{
        while (true){
            //think
            doAction(System.nanoTime() + ": Thinking");
            synchronized (leftFork){
                doAction(
                        System.nanoTime() + "^ Picked up left fork");
                synchronized (rightFork){
                    //eating
                    doAction(
                            System.nanoTime() + ": Picked up right fork - eating");

                    doAction(
                            System.nanoTime() + ": Put down left fork. Back to thinking");
                }
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return;
        }
    }
}
     */
    @Override
    public void run() {
        try {
            while (true) {

                // thinking
                doAction(System.nanoTime() + ": Thinking");
                synchronized (leftFork) {
                    doAction(
                            System.nanoTime()
                                    + ": Picked up left fork");
                    synchronized (rightFork) {
                        // eating
                        doAction(
                                System.nanoTime()
                                        + ": Picked up right fork - eating");

                        doAction(
                                System.nanoTime()
                                        + ": Put down right fork");
                    }
                    // Back to thinking
                    doAction(
                            System.nanoTime()
                                    + ": Put down left fork. Back to thinking");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}
