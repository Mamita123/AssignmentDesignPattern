package org.example.flyweight;

public interface Tile {
    String getImagePath();  // Intrinsic state
    TileType getType();
}