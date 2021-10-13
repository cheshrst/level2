package ru.gb.level2.lesson1;

public class Team {
    String name;
    int jumpRange; //meters
    int runRange; //meters
    public Team(String name, int jumpRange, int runRange) {
        this.name = name;
        this.jumpRange = jumpRange;
        this.runRange = runRange;
    }
    public void getRange(){
        this.runRange= runRange;
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
}
