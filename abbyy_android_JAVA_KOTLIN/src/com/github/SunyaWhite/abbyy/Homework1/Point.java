package com.github.SunyaWhite.abbyy.Homework1;

import java.util.Objects;

public class Point
{
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) { this.x = x; }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point(int x , int y) {
        this.x = x;
        this.y = y;
    }

    /*
    Собственная реализация методов Equals и hashCode
    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj.getClass() == Point.class) {
            Point point = (Point) obj;
            return this.x == point.x && this.y == point.y;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return x * 37 + y;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
