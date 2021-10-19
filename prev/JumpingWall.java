package ru.gb.prev;

public class JumpingWall implements Obstacle {
    @Override
    public void overcome(Participant p) {
        p.jump();
    }
}
