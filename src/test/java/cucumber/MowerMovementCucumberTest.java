package cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.hboufaied.kata.entity.Garden;
import io.github.hboufaied.kata.entity.Mower;
import io.github.hboufaied.kata.entity.Position;
import io.github.hboufaied.kata.rule.Command;
import io.github.hboufaied.kata.rule.Direction;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MowerMovementCucumberTest {

    private Mower mower;
    private Position position;

    @Given("the initial position {int} {int} {string} and {int} {int}")
    public void the_initial_position_and(Integer x, Integer y, String direction, Integer gardenLimitX, Integer gardenLimitY) {
        Position p = new Position(x, y, Direction.findDirectionFromCode(direction));
        mower = Mower.builder().position(p).garden(new Garden(gardenLimitX, gardenLimitY)).build();
    }

    @Given("with the following {string}")
    public void with_the_following(String commandsAsString) {
        List<Command> commands = new ArrayList<>();
        char[] commandsAsCharacters = commandsAsString.toCharArray();
        for (char c : commandsAsCharacters) {
            commands.add(Command.findCommandFromCode(String.valueOf(c)));
        }
        mower.setCommands(commands);
    }

    @When("I move the mower with the following instructions")
    public void i_move_the_mower_with_the_following_instructions() {
        position = mower.processMowerCommands();
    }

    @Then("the final position is {int} {int} {string}")
    public void the_final_position_is(Integer x, Integer y, String direction) {
        assertThat(position).isNotNull();
        assertThat(position.getX()).isEqualTo(x);
        assertThat(position.getY()).isEqualTo(y);
        assertThat(position.getDirection().getCode()).isEqualTo(direction);
    }

}