package com.github.SunyaWhite.abbyy.Homework1;

public class Main {

    public static double GetDistance(Point point1, Point point2)
    {
        try
        {
            if(point1 == null)
                throw new IllegalArgumentException("Variable point1 is null");
            if(point2 == null)
                throw new IllegalArgumentException("Variable point2 is null");
            return Math.sqrt(
                    Math.pow(point1.getX() - point2.getX(), 2) +
                    Math.pow(point1.getY() - point2.getY(), 2));
        }
        catch (Exception exc)
        {
            System.out.println(exc.getMessage());
            return -1;
        }
    }

    public static void main(String[] args) {

        var point1 = new Point(1, 2);
        var point2 = new Point(4, 6);
        System.out.println(GetDistance(point2, point1));
    }

}
