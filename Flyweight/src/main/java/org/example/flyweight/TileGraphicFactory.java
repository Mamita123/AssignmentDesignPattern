package org.example.flyweight;

import javafx.scene.image.Image;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class TileGraphicFactory {
    private static final Map<String,Image> tileGraphics = new HashMap<>();
    private static final TileGraphicFactory instance = new TileGraphicFactory();

    private TileGraphicFactory() {}

    public static TileGraphicFactory getInstance() {
        return instance;
    }  // Returns the singleton instance.

    public Image getTileGraphic(String imagePath) {
        // Uses computeIfAbsent to ensure each image is loaded once.
        return tileGraphics.computeIfAbsent(imagePath, path -> {
            InputStream is = getClass().getResourceAsStream(path);
            if (is == null) {
                throw new IllegalArgumentException("Resource not found: " + path);
            }
            return new Image(is); // Creates a new image only if it's not already loaded.
        });
    }
}
