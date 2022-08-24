package io.github.hboufaied.kata.rule;

import io.github.hboufaied.kata.entity.Garden;
import io.github.hboufaied.kata.rule.Direction;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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

    public String toString() {
        return new StringBuilder()
                .append(x).append(" ")
                .append(y).append(" ")
                .append(direction.getCode())
                .toString() ;
    }
}
