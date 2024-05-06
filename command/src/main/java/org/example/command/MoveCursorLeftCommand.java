package org.example.command;

public class MoveCursorLeftCommand implements Command{
    private Grid grid;

    public MoveCursorLeftCommand(Grid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.moveCursor("LEFT");
    }}
