package com.gr02.BomberMania.model;

import java.util.Objects;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position getLeft() {
        return new Position(x-1, y);
    }
    public Position getRight() {
        return new Position(x+1, y);
    }
    public Position getUp() {
        return new Position(x, y-1);
    }
    public Position getDown() {
        return new Position(x, y+1);
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Position)) return false;

        Position position = (Position) o;
        return (x == position.x && y == position.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
