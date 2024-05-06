package org.example.command;

public class TogglePixelCommand implements Command{
    private Grid grid;

    public TogglePixelCommand(Grid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.togglePixel();
    }
}
