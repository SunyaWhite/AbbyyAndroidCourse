package com.github.SunyaWhite.abbyy.Homework2;

/**
 * Класс прямоугольника
 */
public class Rect
{
    /**
     * верхняя-левая точка
     */
    private Point topLeft;

    /**
     * нижняя-правая точка
     */
    private Point bottomRight;


    /**
     * Конструктор прямоугольника
     * @param topLeft
     * @param bottomRight
     * @throws IllegalArgumentException
     */
    public Rect(Point topLeft, Point bottomRight) throws IllegalArgumentException
    {
        if(topLeft.getX() >= bottomRight.getX() || topLeft.getY() <= bottomRight.getY())
            throw new IllegalArgumentException();
        this.bottomRight = bottomRight;
        this.topLeft = topLeft;
    }

    /**
     * Получение ширины прямоугольника
     * @return
     */
    public int getWidth()
    {
        return bottomRight.getX() - topLeft.getX();
    }

    /**
     * Получение высоты прямоугольника
     * @return
     */
    public int getHeight()
    {
        return topLeft.getY() - bottomRight.getY();
    }

}
