package com.github.SunyaWhite.abbyy.Homework2;

/**
 * Утилитный класс
 */
public class Rects {

    private Rects(){}

    /**
     * Вычисление периметра
     * @param rect
     * @return
     * @throws IllegalArgumentException
     */
    public static int getPerimetr(Rect rect) throws IllegalArgumentException
    {
        if(rect == null)
            throw new IllegalArgumentException();
        return rect.getHeight() * 2 + rect.getWidth() * 2;
    }

    /**
     * Вычисление площади
     * @param rect
     * @return
     * @throws IllegalArgumentException
     */
    public static int getSquare(Rect rect) throws IllegalArgumentException
    {
        if(rect == null)
            throw new IllegalArgumentException();
        return rect.getHeight() * rect.getWidth();
    }

    /**
     * Вычисление диагонали
     * @param rect
     * @return
     * @throws IllegalArgumentException
     */
    public static double getDiagonal(Rect rect) throws IllegalArgumentException
    {
        if(rect == null)
            throw new IllegalArgumentException();
        return Math.sqrt(Math.pow(rect.getHeight(), 2) + Math.pow(rect.getWidth(), 2));
    }
}
