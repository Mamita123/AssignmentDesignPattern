
package org.example.command;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Grid {
    private int size = 8;
    private Rectangle[][] pixels = new Rectangle[size][size];
    private int cursorX = 0;
    private int cursorY = 0;
    private GridPane gridPane = new GridPane();

    public Grid() {
        initializeGrid();
    }

    private void initializeGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Rectangle rect = new Rectangle(30, 30, Color.WHITE);
                rect.setStroke(Color.BLACK);
                pixels[i][j] = rect;
                gridPane.add(rect, j, i);
            }
        }
        updateCursor();
    }

    public void moveCursor(String direction) {
        // Remove current cursor
        pixels[cursorY][cursorX].setStroke(Color.BLACK);

        switch (direction) {
            case "UP":
                cursorY = Math.max(0, cursorY - 1);
                break;
            case "DOWN":
                cursorY = Math.min(size - 1, cursorY + 1);
                break;
            case "LEFT":
                cursorX = Math.max(0, cursorX - 1);
                break;
            case "RIGHT":
                cursorX = Math.min(size - 1, cursorX + 1);
                break;
        }

        updateCursor();
    }

    public void togglePixel() {
        Rectangle currentPixel = pixels[cursorY][cursorX];
        if (currentPixel.getFill().equals(Color.WHITE)) {
            currentPixel.setFill(Color.BLACK); // Turns the pixel "on".
        } else {
            currentPixel.setFill(Color.WHITE); // Turns the pixel "off".
        }
    }

    public String generateCode() {
        StringBuilder codeBuilder = new StringBuilder("int[][] pixelArt = {\n");
        for (int i = 0; i < size; i++) {
            codeBuilder.append("    {");
            for (int j = 0; j < size; j++) {
                // Add debug output to print the color value
                Color pixelColor = (Color) pixels[i][j].getFill();
                System.out.println("Pixel[" + i + "][" + j + "] color: " + (pixelColor.equals(Color.BLACK) ? "1" : "0"));

                // Append the appropriate value to the codeBuilder
                codeBuilder.append(pixelColor.equals(Color.BLACK) ? "1" : "0");
                if (j < size - 1) {
                    codeBuilder.append(", ");
                }
            }
            codeBuilder.append("}");
            if (i < size - 1) {
                codeBuilder.append(",\n");
            }
        }
        codeBuilder.append("\n};");
        return codeBuilder.toString();
    }


    public GridPane getGridPane() {
        return gridPane;
    }

    private void updateCursor() {
        pixels[cursorY][cursorX].setStroke(Color.RED);
    }
}
