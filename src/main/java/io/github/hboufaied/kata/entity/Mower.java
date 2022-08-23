package io.github.hboufaied.kata.entity;

import io.github.hboufaied.kata.rule.Command;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Mower {

    private Position position;
    private List<Command> commands;
    private Garden garden;

    public Position processMowerCommands() {
        commands.forEach(command -> processCommand(command));
        return position;
    }

    private void processCommand(final Command command) {
        switch (command) {
            case ADVANCE -> position.processAdvance(garden);
            case RIGHT -> position.turnToRightDirection();
            case LEFT -> position.turnToLeftDirection();
        }
    }
}
