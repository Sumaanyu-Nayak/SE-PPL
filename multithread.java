import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.CountDownLatch;

// PlayerThread class simulating player movement
class PlayerThread implements Runnable {
    private static final Random random = new Random();
    private static final AtomicBoolean running = new AtomicBoolean(true);

    @Override
    public void run() {
        while (running.get()) {
            try {
                TimeUnit.SECONDS.sleep(2); // Simulate player movement every 2 seconds
                System.out.println("Player moved to a new position.");
            } catch (InterruptedException e) {
                System.out.println("Player thread interrupted.");
                running.set(false);
            }
        }
    }
}
// EnemyThread class simulating enemy movement
class EnemyThread implements Runnable {
    private static final AtomicBoolean running = new AtomicBoolean(true);

    @Override
    public void run() {
        while (running.get()) {
            try {
                TimeUnit.SECONDS.sleep(3); // Simulate enemy movement every 3 seconds
                System.out.println("Enemy is moving closer!");
            } catch (InterruptedException e) {
                System.out.println("Enemy thread interrupted.");
                running.set(false);
            }
        }
    }
}
// CountdownTimerThread class simulating a countdown timer
class CountdownTimerThread implements Runnable {
    private static final CountDownLatch latch = new CountDownLatch(1);
    private static final AtomicBoolean running = new AtomicBoolean(true);

    @Override
    public void run() {
        for (int i = 10; i >= 0; i--) {
            try {
                TimeUnit.SECONDS.sleep(1); // Sleep for 1 second
                System.out.println("Time left: " + i + " seconds");
            } catch (InterruptedException e) {
                System.out.println("Countdown timer interrupted.");
                running.set(false);
            }
        }
        latch.countDown(); // Signal that the countdown is finished
    }
}
// Main class to run the game simulation
// This class contains the main method to start the threads
public class multithread {

    public static void main(String[] args) {
        Thread playerThread = new Thread(new PlayerThread());
        Thread enemyThread = new Thread(new EnemyThread());
        Thread countdownTimerThread = new Thread(new CountdownTimerThread());

        playerThread.start();
        enemyThread.start();
        countdownTimerThread.start();

        try {
            countdownTimerThread.join(); // Wait for the countdown timer to finish
            System.out.println("Game Over!"); // Optional Game Over message

            playerThread.interrupt(); // Interrupt player thread
            enemyThread.interrupt(); // Interrupt enemy thread
            countdownTimerThread.interrupt(); // Interrupt countdown timer thread
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
    }
}