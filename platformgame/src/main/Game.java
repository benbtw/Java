package main;

public class Game implements Runnable{

    private final Panel panel;

    public Game() {
        new Window();
        panel = new Panel();
        panel.requestFocus();
        startThread();
    }

    public void startThread(){
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        panel.repaint();
        try {
            Thread.sleep(1000 / 60);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
