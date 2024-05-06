package org.example.command;

public class ControlPanel {
    private Command moveUp;
    private Command moveDown;
    private Command moveLeft;
    private Command moveRight;
    private Command togglePixel;
    private Command generateCode;

    public ControlPanel(Command moveUp, Command moveDown, Command moveLeft, Command moveRight, Command togglePixel,
                        Command generateCode) {
        this.moveUp = moveUp;
        this.moveDown = moveDown;
        this.moveLeft = moveLeft;
        this.moveRight = moveRight;
        this.togglePixel = togglePixel;
        this.generateCode = generateCode;
    }

    public void moveCursorUp() {
        moveUp.execute();
    }

    public void moveCursorDown() {
        moveDown.execute();
    }

    public void moveCursorLeft() {
        moveLeft.execute();
    }

    public void moveCursorRight() {
        moveRight.execute();
    }

    public void togglePixel() {
        togglePixel.execute();
    }

    public void generateCode() {
        generateCode.execute();
    }
}
