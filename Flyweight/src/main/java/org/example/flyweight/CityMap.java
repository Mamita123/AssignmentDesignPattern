package org.example.flyweight;


import java.util.Random;

public class CityMap implements Map {
    final Tile[][] grid;
    final int size = 5;

    public CityMap() {
        grid = new Tile[size][size];
        generateMap();
    }

    @Override
    public void generateMap() {
        Random random = new Random();
        TileType[] types = {TileType.ROAD, TileType.BUILDING, TileType.FOREST};
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new GenericTile(types[random.nextInt(types.length)]);
            }
        }
    }

    @Override
    public Tile getTileAt(int x, int y) {
        return grid[x][y];
    }

    @Override
    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j].getImagePath() + " ");
            }
            System.out.println();
        }
    }

    @Override
    public int getSize() {
        return size;
    }
}
