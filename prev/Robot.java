package ru.gb.prev;

public class Robot implements Participant {
    @Override
    public void run() {
        System.out.println("Robot is running...");
    }

    @Override
    public void jump() {
        System.out.println("Robot is jumping...");
    }
}
