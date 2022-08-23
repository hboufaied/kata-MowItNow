package io.github.hboufaied.kata.rule;

import java.util.Arrays;

/**
 * Command to move or rotate the mower
 * ADVANCE : move to next position if not exceed the garden
 * RIGHT : rotate the mower 90° to the right
 * LEFT : rotate the mower 90° to the left
 */
public enum Command {

    ADVANCE("A"),
    RIGHT("D"),
    LEFT("G");

    private String code;

    Command(String code) {
        this.code = code;
    }

    public static Command findCommandFromCode(String code) {
        return Arrays.stream(Command.values())
                .filter(c -> c.code.equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No command found for " + code));
    }
}
