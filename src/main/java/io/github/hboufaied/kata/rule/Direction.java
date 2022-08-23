package io.github.hboufaied.kata.rule;

import java.util.Arrays;

/**
 * Set the current direction of the mower and direction when move on the right or on the left
 */
public enum Direction {

    North("N","E", "W"),
    East("E", "S", "N"),
    South("S","W", "E"),
    West("W", "N", "S");

    private final String code;
    private final String codeDirectionRight;
    private final String codeDirectionLeft;

    Direction(final String code,final String codeDirectionRight,final String codeDirectionLeft) {
        this.code = code;
        this.codeDirectionLeft = codeDirectionLeft;
        this.codeDirectionRight = codeDirectionRight;
    }

    public String getCode() {
        return this.code;
    }

    public Direction getLeftDirection() {
        return findDirectionFromCode(codeDirectionLeft);
    }

    public Direction getRightDirection() {
        return findDirectionFromCode(codeDirectionRight);
    }

    public static Direction findDirectionFromCode(String code) {
        return Arrays.stream(Direction.values())
                .filter(c -> c.code.equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No direction found for " + code));
    }
}
