package ru.gb.level2.lesson1;

public class Human extends Team {
    public Human(String name, int jumpRange, int runRange) {
        super(name, jumpRange, runRange);
    }

//    public void runTreadmill(Treadmill treadmill) {
//        if (treadmill.getRange() <= runRange) {
//            System.out.println(name + " пробежал");
//        } else {
//            System.out.println(name + " не смог пробежать");
//        }
//    }
//
//    public void jumpWall(Treadmill wall) {
//        if (wall.getRange() <= jumpRange) {
//            System.out.println(name + " Перепрыгнуд");
//        } else {
//            System.out.println(name + " не смог перепрыгнуть");
//        }
//    }
}