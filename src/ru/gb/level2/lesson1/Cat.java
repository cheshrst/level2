package ru.gb.level2.lesson1;

public class Cat extends Team {

    public Cat(String name, int jumpRange, int runRange) {
        super(name, jumpRange, runRange);
    }


    public void runTreadmill(Treadmill treadmill) {
        if (treadmill.getRange() <= runRange) {
            System.out.println(name + " пробежал" );
        } else {
            System.out.println(name + " не смог пробежать");
        }
    }
    public void jumpWall(Wall wall) {
        if (wall.getRange() <= jumpRange) {
            System.out.println(name + " перепрыгнул");
        } else {
            System.out.println(name + " не смог перепрыгнуть");
        }
    }

//    public void run() {
//    System.out.println(name + " Run");
//    }
//    public void jump() {
//    System.out.println(name + " Jump");
//    }
    }

