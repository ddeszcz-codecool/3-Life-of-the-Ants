package model;

import enums.UnicodeRepresentation;

public class Position {

    private int x;
    private int y;
    private UnicodeRepresentation unicodeRepresentation;

    public Position(int x, int y, UnicodeRepresentation unicodeRepresentation) {
        this.x = x;
        this.y = y;
        this.unicodeRepresentation = unicodeRepresentation;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setUnicodeRepresentation(UnicodeRepresentation unicodeRepresentation) {
        this.unicodeRepresentation = unicodeRepresentation;
    }

    public UnicodeRepresentation getUnicodeRepresentation() {
        return unicodeRepresentation;
    }

    @Override
    public String toString() {
        return unicodeRepresentation.getUnicodeRepresentation();
    }
}