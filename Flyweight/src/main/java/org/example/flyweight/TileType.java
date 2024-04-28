package org.example.flyweight;

public enum TileType {
    BUILDING("/org/example/flyweight/images/building.png"),
    ROAD("/org/example/flyweight/images/road.png"),
    FOREST("/org/example/flyweight/images/forest.png"),
    SWAMP("/org/example/flyweight/images/swamp.png"),
    WATER("/org/example/flyweight/images/water.png");

    private final String imagePath; // Intrinsic state: the image path is constant and shared.

    TileType(String imagePath) {
        this.imagePath = imagePath;
    } // Each type of tile shares a single image path.

    public String getImagePath() {
        return imagePath;
    }

}
