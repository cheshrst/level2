package ru.gb.prev;

public class RunningRoad implements Obstacle {
    @Override
    public void overcome(Participant p) {
        p.run();
    }
}
