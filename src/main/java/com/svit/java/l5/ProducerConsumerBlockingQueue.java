package com.svit.java.l5;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.svit.java.l5.ProducerConsumerWaitNotify.Producer;

public class ProducerConsumerBlockingQueue {

    public static void main(String[] args) {

        BlockingQueue blockingDeque = new LinkedBlockingQueue();

        Thread threadProducer = new Thread(new Producer(blockingDeque));
        Thread threadConsumer = new Thread(new Consumer(blockingDeque));

        threadConsumer.start();
        threadProducer.start();
    }

    static class Producer implements Runnable{

        private final BlockingQueue blockingQueue;

        public Producer(BlockingQueue blockingQueue) {

            this.blockingQueue = blockingQueue;
        }

        @Override
        public synchronized void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println("producer"+i);
                    blockingQueue.put(i);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable{

        private final BlockingQueue blockingQueue;

        public Consumer(BlockingQueue blockingQueue) {
            this.blockingQueue = blockingQueue;
        }
        @Override
        public synchronized void run() {
            for (;;) {
                try {
                    System.out.println("consumer"+blockingQueue.take());
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

