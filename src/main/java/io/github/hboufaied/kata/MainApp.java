package io.github.hboufaied.kata;

import io.github.hboufaied.kata.exception.FileFormatInvalidException;
import io.github.hboufaied.kata.rule.Position;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.List;

public class MainApp {

    public static void main(final String[] args) throws FileNotFoundException {
        if(args == null || args.length == 0) {
            throw new FileFormatInvalidException("Please provide the input movement file");
        }
        LawnMower lawnMower = new LawnMower(Path.of(args[0]));
        List<Position> p = lawnMower.processMovement();
        p.forEach(System.out::println);
    }
}
