package ru.gb.prev;

public class Cat implements Participant {
    @Override
    public void run() {
        System.out.println("Cat is running...");
    }

    @Override
    public void jump() {
        System.out.println("Cat is jumping...");
    }
}
