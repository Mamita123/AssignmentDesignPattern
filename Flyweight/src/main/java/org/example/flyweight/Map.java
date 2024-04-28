package org.example.flyweight;

public interface Map {
    void display();
    Tile getTileAt(int x, int y);
    void generateMap();
    int getSize();
}
