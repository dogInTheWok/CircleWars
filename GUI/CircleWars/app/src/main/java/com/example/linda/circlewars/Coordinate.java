package com.example.linda.circlewars;

/**
 * Created by Linda on 04.10.2014.
 */
public class Coordinate {

    public int x;
    public int y;
    private IGame.FIELD parentField;

    public Coordinate(int x, int y, IGame.FIELD parent) {
        this.x = x;
        this.y = y;
        parentField = parent;
    }

    public IGame.FIELD getParentField() {
        return parentField;
    }
}
