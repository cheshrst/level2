package ru.gb.prev;

public class Main {
    public static void main(String[] args) {
        Obstacle[] obstacles = {new JumpingWall(), new RunningRoad()};
        Participant[] participants = {new Robot(), new Cat()};

        for (int i = 0; i < participants.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                obstacles[j].overcome(participants[i]);
            }
        }
    }
}
