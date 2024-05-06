package org.example.command;

public class MoveCursorRightCommand implements Command{
    private Grid grid;

    public MoveCursorRightCommand(Grid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.moveCursor("RIGHT");
    }
}
