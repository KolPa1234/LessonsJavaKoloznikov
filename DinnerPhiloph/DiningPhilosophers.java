package Zadachki.NewDinner;

public class DiningPhilosophers {
    public static void main(String[] args) throws Exception {
        final Philosopherrr[] philosophers = new Philosopherrr[5];
        Object[] forks = new Object[philosophers.length];

        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < philosophers.length; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];

            if (i == philosophers.length - 1) {

                // The last philosopher picks up the right fork first
                philosophers[i] = new Philosopherrr(rightFork, leftFork);
            } else {
                philosophers[i] = new Philosopherrr(leftFork, rightFork);
            }

            Thread t
                    = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }
    }
}
