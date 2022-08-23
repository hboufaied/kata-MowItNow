package io.github.hboufaied.kata.entity;

import io.github.hboufaied.kata.rule.Direction;

public class Position {

    private int x;
    private int y;
    private Direction direction;

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void turnToRightDirection() {
        direction = direction.getRightDirection();
    }

    public void turnToLeftDirection() {
        direction = direction.getLeftDirection();
    }

    public void processAdvance(Garden garden) {
        switch (direction) {
            case North:
                if(y < garden.limitY()) {
                    y += 1;
                }
                break;
            case East:
                if(x < garden.limitX()) {
                    x += 1;
                }
                break;
            case South:
                if (y > 0) {
                    y -= 1;
                }
                break;
            case West:
                if (x > 0) {
                    x -= 1;
                }
                break;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
