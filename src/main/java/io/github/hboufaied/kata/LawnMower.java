package io.github.hboufaied.kata;

import io.github.hboufaied.kata.entity.Garden;
import io.github.hboufaied.kata.entity.Mower;
import io.github.hboufaied.kata.exception.FileFormatInvalidException;
import io.github.hboufaied.kata.rule.Command;
import io.github.hboufaied.kata.rule.Direction;
import io.github.hboufaied.kata.rule.Position;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LawnMower {

    private static final String GARDEN_POSITION_SEPARATOR = " ";
    private final List<Mower> mowers = new ArrayList<>();

    public LawnMower(Path mowerMovementInput) throws FileNotFoundException {
        if(mowerMovementInput == null) {
            throw new FileNotFoundException("The mower simulation file is not found");
        }
        try {
            List<String> fileLines = Files.readAllLines(mowerMovementInput);
            if (fileLines.isEmpty()) {
                throw new FileFormatInvalidException("Can't create Mower instruction with input file :"
                        + mowerMovementInput);
            }
            Iterator<String> iterator = fileLines.iterator();
            Garden garden = parseAndCreateGarden(iterator.next());

            while (iterator.hasNext()) {
                String mowerPosition = iterator.next();
                if(!iterator.hasNext()) {
                    throw new FileFormatInvalidException("Missing movement instruction");
                }
                String mowerCommands = iterator.next();
                Position p = parseAndCreatePosition(mowerPosition);
                List<Command> commands = parseAndCreateCommand(mowerCommands);
                mowers.add(Mower.builder().position(p).commands(commands).garden(garden).build());
            }
        } catch(IOException e) {
            throw new FileFormatInvalidException("Invalid input file", e);

        }
    }

    public List<Position> processMovement() {
        List<Position> finalPositions = new ArrayList<>(mowers.size());
        for (Mower mower : mowers) {
            finalPositions.add(mower.processMowerCommands());
        }
        return  finalPositions;
    }

    private Position parseAndCreatePosition(String mowerPosition) {
        int x = Integer.parseInt(mowerPosition.split(GARDEN_POSITION_SEPARATOR)[0]);
        int y = Integer.parseInt(mowerPosition.split(GARDEN_POSITION_SEPARATOR)[1]);
        String direction = mowerPosition.split(GARDEN_POSITION_SEPARATOR)[2];
        // to check if position is in  the garden limit
        return new Position(x, y, Direction.findDirectionFromCode(direction));
    }

    private List<Command> parseAndCreateCommand(String mowerCommands) {
        List<Command> commands = new ArrayList<>();
        char[] commandsAsCharacters = mowerCommands.toCharArray();
        for (char c : commandsAsCharacters) {
            commands.add(Command.findCommandFromCode(String.valueOf(c)));
        }
        return commands;
    }

    private Garden parseAndCreateGarden(String gardenLimit) {
        int x = Integer.parseInt(gardenLimit.split(GARDEN_POSITION_SEPARATOR)[0]);
        int y = Integer.parseInt(gardenLimit.split(GARDEN_POSITION_SEPARATOR)[1]);
        return new Garden(x, y);
    }

}
