package ru.geekbrains.java3.homework5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable {

    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;

    private static final Lock lock = new ReentrantLock();
    private static volatile boolean checkWIN = false;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            MainClass.getCdlStart().countDown();
            MainClass.cyclicBarrier.await();

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        MainClass.getCdlFinish().countDown();
        checkWIN();
    }

    private boolean checkWIN() {
        if (!checkWIN) {
            try {
                lock.lock();
                checkWIN = true;
                System.out.println(this.name + " - WIN");
            } finally {
                lock.unlock();
            }
            return true;
        } else {
            return false;
        }
    }
}