package org.example.flyweight;

public class GenericTile implements Tile {
    private final TileType type;

    public GenericTile(TileType type) {
        this.type = type;
    }

    @Override
    public String getImagePath() {
        return type.getImagePath();
    }

    @Override
    public TileType getType() {
        return type;
    }
}
