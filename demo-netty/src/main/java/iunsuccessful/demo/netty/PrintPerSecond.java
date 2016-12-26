package iunsuccessful.demo.netty;

import iunsuccessful.demo.netty.websoket.WebSocketClientHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintPerSecond implements Runnable {

    public static void start() {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.execute(new PrintPerSecond());
    }

        @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.err.println(WebSocketClientHandler.count.getAndSet(0));
        }
    }

}
