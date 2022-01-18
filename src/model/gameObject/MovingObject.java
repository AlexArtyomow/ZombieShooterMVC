package model.gameObject;

import model.enums.Direction;

public abstract class MovingObject {

    private int speed;
    private Direction direction;

    public MovingObject(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
