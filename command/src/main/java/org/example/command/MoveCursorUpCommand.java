package org.example.command;

public class MoveCursorUpCommand implements Command{
    private Grid grid;

    public MoveCursorUpCommand(Grid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.moveCursor("UP");
    }


}
