package org.example.command;

public class GenerateCodeCommand implements Command{
    private Grid grid;

    public GenerateCodeCommand(Grid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        System.out.println(grid.generateCode());
    }
}

