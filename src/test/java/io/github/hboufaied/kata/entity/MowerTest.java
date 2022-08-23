package io.github.hboufaied.kata.entity;

import io.github.hboufaied.kata.rule.Command;
import io.github.hboufaied.kata.rule.Direction;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MowerTest {

    private Garden garden = new Garden(5, 5);

    @Test
    public void shouldRotateToEastWhenMowerInNorthAndCommandIsRight() {
        Mower mower = Mower.builder()
                .position(new Position(2,2, Direction.North))
                .commands(Collections.singletonList(Command.RIGHT))
                .garden(garden).build();
        Position position = mower.processMowerCommands();
        Position expectedPosition = new Position(2, 2, Direction.East);
        assertThat(position).isNotNull();
        assertThat(position.getX()).isEqualTo(expectedPosition.getX());
        assertThat(position.getY()).isEqualTo(expectedPosition.getY());
        assertThat(position.getDirection()).isEqualTo(expectedPosition.getDirection());
    }

    @Test
    public void shouldRotateToWestWhenMowerInSouthAndCommandIsRight() {
        Mower mower = Mower.builder()
                .position(new Position(2,2, Direction.South))
                .commands(Collections.singletonList(Command.RIGHT))
                .garden(garden).build();
        Position position = mower.processMowerCommands();
        Position expectedPosition = new Position(2, 2, Direction.West);
        assertThat(position).isNotNull();
        assertThat(position.getX()).isEqualTo(expectedPosition.getX());
        assertThat(position.getY()).isEqualTo(expectedPosition.getY());
        assertThat(position.getDirection()).isEqualTo(expectedPosition.getDirection());
    }

    @Test
    public void shouldRotateToSouthWhenMowerInEastAndCommandIsRight() {
        Mower mower = Mower.builder()
                .position(new Position(2,2, Direction.East))
                .commands(Collections.singletonList(Command.RIGHT))
                .garden(garden).build();
        Position position = mower.processMowerCommands();
        Position expectedPosition = new Position(2, 2, Direction.South);
        assertThat(position).isNotNull();
        assertThat(position.getX()).isEqualTo(expectedPosition.getX());
        assertThat(position.getY()).isEqualTo(expectedPosition.getY());
        assertThat(position.getDirection()).isEqualTo(expectedPosition.getDirection());
    }

    @Test
    public void shouldRotateToNorthWhenMowerInWestAndCommandIsRight() {
        Mower mower = Mower.builder()
                .position(new Position(2,2, Direction.West))
                .commands(Collections.singletonList(Command.RIGHT))
                .garden(garden).build();
        Position position = mower.processMowerCommands();
        Position expectedPosition = new Position(2, 2, Direction.North);
        assertThat(position).isNotNull();
        assertThat(position.getX()).isEqualTo(expectedPosition.getX());
        assertThat(position.getY()).isEqualTo(expectedPosition.getY());
        assertThat(position.getDirection()).isEqualTo(expectedPosition.getDirection());
    }

    @Test
    public void shouldRotateToWestWhenMowerInNorthAndCommandIsLeft() {
        Mower mower = Mower.builder()
                .position(new Position(2,2, Direction.North))
                .commands(Collections.singletonList(Command.LEFT))
                .garden(garden).build();
        Position position = mower.processMowerCommands();
        Position expectedPosition = new Position(2, 2, Direction.West);
        assertThat(position).isNotNull();
        assertThat(position.getX()).isEqualTo(expectedPosition.getX());
        assertThat(position.getY()).isEqualTo(expectedPosition.getY());
        assertThat(position.getDirection()).isEqualTo(expectedPosition.getDirection());
    }

    @Test
    public void shouldRotateToNorthWhenMowerInEastAndCommandIsLeft() {
        Mower mower = Mower.builder().
                position(new Position(2,2, Direction.East))
                .commands(Collections.singletonList(Command.LEFT))
                .garden(garden).build();
        Position position = mower.processMowerCommands();
        Position expectedPosition = new Position(2, 2, Direction.North);
        assertThat(position).isNotNull();
        assertThat(position.getX()).isEqualTo(expectedPosition.getX());
        assertThat(position.getY()).isEqualTo(expectedPosition.getY());
        assertThat(position.getDirection()).isEqualTo(expectedPosition.getDirection());
    }

    @Test
    public void shouldRotateToEastWhenMowerInSouthAndCommandIsLeft() {
        Mower mower = Mower.builder()
                .position(new Position(2,2, Direction.South))
                .commands(Collections.singletonList(Command.LEFT))
                .garden(garden).build();
        Position position = mower.processMowerCommands();
        Position expectedPosition = new Position(2, 2, Direction.East);
        assertThat(position).isNotNull();
        assertThat(position.getX()).isEqualTo(expectedPosition.getX());
        assertThat(position.getY()).isEqualTo(expectedPosition.getY());
        assertThat(position.getDirection()).isEqualTo(expectedPosition.getDirection());
    }

    @Test
    public void shouldRotateToSouthWhenMowerInWestAndCommandIsLeft() {
        Mower mower = Mower.builder()
                .position(new Position(2,2, Direction.West))
                .commands(Collections.singletonList(Command.LEFT))
                .garden(garden).build();
        Position position = mower.processMowerCommands();
        Position expectedPosition = new Position(2, 2, Direction.South);
        assertThat(position).isNotNull();
        assertThat(position.getX()).isEqualTo(expectedPosition.getX());
        assertThat(position.getY()).isEqualTo(expectedPosition.getY());
        assertThat(position.getDirection()).isEqualTo(expectedPosition.getDirection());
    }

    @Test
    public void shouldMoveToNextYPositionWhenCommandIsAdvanceAndDirectionIsNorth() {
        Mower mower = Mower.builder()
                .position(new Position(2,2, Direction.North))
                .commands(Collections.singletonList(Command.ADVANCE))
                .garden(garden).build();
        Position position = mower.processMowerCommands();
        Position expectedPosition = new Position(2, 3, Direction.North);
        assertThat(position).isNotNull();
        assertThat(position.getX()).isEqualTo(expectedPosition.getX());
        assertThat(position.getY()).isEqualTo(expectedPosition.getY());
        assertThat(position.getDirection()).isEqualTo(expectedPosition.getDirection());
    }

    @Test
    public void shouldMoveToNextXPositionWhenCommandIsAdvanceAndDirectionIsEast() {
        Mower mower = Mower.builder()
                .position(new Position(2,2, Direction.East))
                .commands(Collections.singletonList(Command.ADVANCE))
                .garden(garden).build();
        Position position = mower.processMowerCommands();
        Position expectedPosition = new Position(3, 2, Direction.East);
        assertThat(position).isNotNull();
        assertThat(position.getX()).isEqualTo(expectedPosition.getX());
        assertThat(position.getY()).isEqualTo(expectedPosition.getY());
        assertThat(position.getDirection()).isEqualTo(expectedPosition.getDirection());
    }

    @Test
    public void shouldMoveToBackYPositionWhenCommandIsAdvanceAndDirectionIsSouth() {
        Mower mower = Mower.builder()
                .position(new Position(2,2, Direction.South))
                .commands(Collections.singletonList(Command.ADVANCE))
                .garden(garden).build();
        Position position = mower.processMowerCommands();
        Position expectedPosition = new Position(2, 1, Direction.South);
        assertThat(position).isNotNull();
        assertThat(position.getX()).isEqualTo(expectedPosition.getX());
        assertThat(position.getY()).isEqualTo(expectedPosition.getY());
        assertThat(position.getDirection()).isEqualTo(expectedPosition.getDirection());
    }

    @Test
    public void shouldMoveToBackXPositionWhenCommandIsAdvanceAndDirectionIsWest() {
        Mower mower = Mower.builder()
                .position(new Position(2,2, Direction.West))
                .commands(Collections.singletonList(Command.ADVANCE))
                .garden(garden).build();
        Position position = mower.processMowerCommands();
        Position expectedPosition = new Position(1, 2, Direction.West);
        assertThat(position).isNotNull();
        assertThat(position.getX()).isEqualTo(expectedPosition.getX());
        assertThat(position.getY()).isEqualTo(expectedPosition.getY());
        assertThat(position.getDirection()).isEqualTo(expectedPosition.getDirection());
    }

    @Test
    public void shouldStayAtSamePositionWhenXisZeroAndCommandIsAdvanceAndDirectionWest() {
        Mower mower = Mower.builder()
                .position(new Position(0,2, Direction.West))
                .commands(Collections.singletonList(Command.ADVANCE))
                .garden(garden).build();
        Position position = mower.processMowerCommands();
        Position expectedPosition = new Position(0, 2, Direction.West);
        assertThat(position).isNotNull();
        assertThat(position.getX()).isEqualTo(expectedPosition.getX());
        assertThat(position.getY()).isEqualTo(expectedPosition.getY());
        assertThat(position.getDirection()).isEqualTo(expectedPosition.getDirection());
    }

    @Test
    public void shouldStayAtSamePositionWhenYisZeroAndCommandIsAdvanceAndDirectionSouth() {
        Mower mower = Mower.builder()
                .position(new Position(3,0, Direction.South))
                .commands(Collections.singletonList(Command.ADVANCE))
                .garden(garden).build();
        Position position = mower.processMowerCommands();
        Position expectedPosition = new Position(3, 0, Direction.South);
        assertThat(position).isNotNull();
        assertThat(position.getX()).isEqualTo(expectedPosition.getX());
        assertThat(position.getY()).isEqualTo(expectedPosition.getY());
        assertThat(position.getDirection()).isEqualTo(expectedPosition.getDirection());
    }

    @Test
    public void shouldStayAtSamePlaceWhenMowerInGardenLimitX() {
        Mower mower = Mower.builder()
                .position(new Position(5,5, Direction.East))
                .commands(Collections.singletonList(Command.ADVANCE))
                .garden(garden).build();
        Position position = mower.processMowerCommands();
        Position expectedPosition = new Position(3, 0, Direction.South);
        assertThat(position).isNotNull();
        assertThat(position.getX()).isEqualTo(expectedPosition.getX());
        assertThat(position.getY()).isEqualTo(expectedPosition.getY());
        assertThat(position.getDirection()).isEqualTo(expectedPosition.getDirection());
    }

    @Test
    public void shouldMoveTo33EWhenMowerPositionIs12NAndCommandsGAGAGAGAA() {
        List<Command> commands = Arrays.asList(Command.LEFT, Command.ADVANCE,
                Command.LEFT, Command.ADVANCE, Command.LEFT, Command.ADVANCE,
                Command.LEFT, Command.ADVANCE, Command.ADVANCE);
        Mower mower = Mower.builder()
                .position(new Position(1,2, Direction.North))
                .commands(commands)
                .garden(garden).build();
        Position position = mower.processMowerCommands();
        Position expectedPosition = new Position(1, 3, Direction.North);
        assertThat(position).isNotNull();
        assertThat(position.getX()).isEqualTo(expectedPosition.getX());
        assertThat(position.getY()).isEqualTo(expectedPosition.getY());
        assertThat(position.getDirection()).isEqualTo(expectedPosition.getDirection());
    }

    @Test
    public void shouldMoveTo51EWhenMowerPositionIs33EAndCommandsAADAADADDA() {
        List<Command> commands = Arrays.asList(Command.ADVANCE, Command.ADVANCE,
                Command.RIGHT, Command.ADVANCE, Command.ADVANCE, Command.RIGHT,
                Command.ADVANCE, Command.RIGHT, Command.RIGHT, Command.ADVANCE);
        Mower mower = Mower.builder()
                .position(new Position(3,3, Direction.East))
                .commands(commands)
                .garden(garden).build();
        Position position = mower.processMowerCommands();
        Position expectedPosition = new Position(5, 1, Direction.East);
        assertThat(position).isNotNull();
        assertThat(position.getX()).isEqualTo(expectedPosition.getX());
        assertThat(position.getY()).isEqualTo(expectedPosition.getY());
        assertThat(position.getDirection()).isEqualTo(expectedPosition.getDirection());
    }
}
