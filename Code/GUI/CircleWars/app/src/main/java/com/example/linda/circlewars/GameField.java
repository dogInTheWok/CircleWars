package com.example.linda.circlewars;

/**
 * Created by Linda on 04.10.2014.
 */
public class GameField {
    final IGame.FIELD id;
    private int xCenter;
    private int yCenter;

    public GameField(IGame.FIELD id, int x, int y) {
        this.id = id;
        xCenter = x;
        yCenter = y;
    }

    public int getxCenter() {
        return xCenter;
    }
    public int getyCenter() {
        return yCenter;
    }
    public IGame.FIELD getId() {
        return id;
    }
}
