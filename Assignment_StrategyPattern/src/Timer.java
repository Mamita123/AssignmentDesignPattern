package Assignment_StrategyPattern.src;

public class Timer extends Thread {

    int time = 0;
    boolean running = true;

    @Override
    public void run() {
        while (running) {
            try {
                time++;
                Thread.sleep(1);
            } catch (InterruptedException e) {
                // throw new RuntimeException(e);
            }
        }

    }

    public int getTime() {
        return time;
    }

    public void stopRunning() {
        running = false;
    }
}