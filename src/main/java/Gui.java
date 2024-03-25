
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class Gui extends Application {

    private Controller controller;
    private ColorBox colorBox1;
    private ColorBox colorBox2;
    private ColorBox colorBox3;
    private CheckBox checkBox;
    private Button redoButton;

    private Button historyButton;

    public void start(Stage stage) {

        controller = new Controller(this);

        Insets insets = new Insets(10, 10, 10, 10);

        colorBox1 = new ColorBox(1, controller);
        colorBox2 = new ColorBox(2, controller);
        colorBox3 = new ColorBox(3, controller);

        checkBox = new CheckBox("Click me!");
        checkBox.setPadding(insets);

        redoButton = new Button("Redo");
        redoButton.setOnAction(event -> controller.redo()); // Handle redo action

        // Create a button to show history window
        historyButton = new Button("History");
        historyButton.setOnAction(event -> showHistoryWindow());

        // Add button to a FlowPane
        FlowPane buttonPane = new FlowPane();
        buttonPane.getChildren().add(historyButton);

        HBox hBox = new HBox(colorBox1.getRectangle(), colorBox2.getRectangle(), colorBox3.getRectangle());
        hBox.setSpacing(10);
        hBox.setMargin(colorBox1.getRectangle(), insets);
        hBox.setMargin(colorBox2.getRectangle(), insets);
        hBox.setMargin(colorBox3.getRectangle(), insets);

        Label label = new Label("Press Ctrl-Z to undo the last change.");
        label.setPadding(insets);

        VBox vBox = new VBox(hBox, checkBox, redoButton, label, buttonPane);

        Scene scene = new Scene(vBox);
        scene.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.Z) {
                System.out.println("Undo key combination pressed");
                controller.undo();
            }

            if (event.isControlDown() && event.getCode() == KeyCode.Y) {
                System.out.println("Redo key combination pressed");
                controller.redo();
            }
        });

        stage.setScene(scene);
        stage.setTitle("Memento Pattern Example");
        stage.show();

        // Terminate the application with exit code 0
        stage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
        });
    }

    public void updateGui() {
        colorBox1.setColor(controller.getOption(1));
        colorBox2.setColor(controller.getOption(2));
        colorBox3.setColor(controller.getOption(3));
        checkBox.setSelected(controller.getIsSelected());
    }

    public void showHistoryWindow() {
        Stage historyStage = new Stage();
        ListView<String> historyList = new ListView<>();
        /*List<IMemento> undoList = controller.getUndoList();
        List<IMemento> redoList = controller.getRedoList();*/
        List<IMemento> history = controller.getHistoryList(); // Get history list from controller

        for (IMemento memento : history) {
            historyList.getItems().add("State " + (history.indexOf(memento) + 1));
        }



        Button restoreButton = new Button("Restore");
        restoreButton.setOnAction(event -> {
            int selectedIndex = historyList.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                controller.restoreState(selectedIndex);
                historyStage.close();
            }
        });

        // Add redo button
        Button redoButton = new Button("Redo");
        redoButton.setOnAction(event -> {
            controller.redo();
            historyStage.close();

        });




        VBox historyLayout = new VBox(historyList, restoreButton, redoButton); // Add redo button to layout
        Scene historyScene = new Scene(historyLayout);
        historyStage.setScene(historyScene);
        historyStage.setTitle("History");
        historyStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

