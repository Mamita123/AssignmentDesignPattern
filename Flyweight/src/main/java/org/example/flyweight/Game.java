package org.example.flyweight;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Game extends Application {
    private static final int TILE_SIZE = 40;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("RPG Map Generator Using Flyweight Pattern");
        Canvas canvas = new Canvas(200, 200);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // testResourceLoading();
        Map map = new WildernessMap();
        //Map map = new CityMap();
        drawMap(gc, map);

        StackPane root = new StackPane();
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void testResourceLoading() {
        for (TileType type : TileType.values()) {
            try {
                Image image = new Image(type.getImagePath());
                System.out.println("Loaded image for " + type + " successfully.");
            } catch (Exception e) {
                System.out.println("Failed to load image for " + type);
                e.printStackTrace();
            }
        }
    }

    private void drawMap(GraphicsContext gc, Map map) {
        TileGraphicFactory graphicFactory = TileGraphicFactory.getInstance();
        for (int i = 0; i < map.getSize(); i++) {
            for (int j = 0; j < map.getSize(); j++) {
                Tile tile = map.getTileAt(i, j);
                Image image = graphicFactory.getTileGraphic(tile.getImagePath());
                gc.drawImage(image, j * TILE_SIZE, i * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
}
    public static void main(String[] args) {
        launch(args);
}}
