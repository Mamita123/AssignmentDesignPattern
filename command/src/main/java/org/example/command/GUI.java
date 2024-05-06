package org.example.command;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application {
    private ControlPanel controlPanel;

    @Override
    public void start(Stage primaryStage) {
        Grid grid = new Grid();
        controlPanel = new ControlPanel(
                new MoveCursorUpCommand(grid),
                new MoveCursorDownCommand(grid),
                new MoveCursorLeftCommand(grid),
                new MoveCursorRightCommand(grid),
                new TogglePixelCommand(grid),
                new GenerateCodeCommand(grid));

        VBox root = new VBox();
        GridPane gridPane = grid.getGridPane();

        Button generateCodeButton = new Button("Generate Code");
        generateCodeButton.setOnAction(e -> {
            controlPanel.generateCode();
            gridPane.requestFocus();
        });
        root.getChildren().addAll(gridPane, generateCodeButton);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Pixel Art Editor");
        primaryStage.setScene(scene);
        primaryStage.show();

        setupKey(gridPane);
    }

    private void setupKey(GridPane gridPane) {
        gridPane.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    controlPanel.moveCursorUp();
                    break;
                case DOWN:
                    controlPanel.moveCursorDown();
                    break;
                case LEFT:
                    controlPanel.moveCursorLeft();
                    break;
                case RIGHT:
                    controlPanel.moveCursorRight();
                    break;
                case SPACE:
                    controlPanel.togglePixel();
                    break;
                default:
                    break;
            }
            event.consume();
        });
        gridPane.requestFocus();

    }



}
