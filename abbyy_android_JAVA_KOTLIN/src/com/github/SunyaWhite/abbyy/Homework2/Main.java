package com.github.SunyaWhite.abbyy.Homework2;

import java.util.Random;

public class Main {

    private static void Display(int[][] matrix)
    {
        var rowLimit = matrix.length;
        var colLimit = matrix[0].length;

        for(int row = 0; row < rowLimit; row++)
        {
            for(int col = 0; col < colLimit; col++)
            {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }


    public static void main(String[] args)
    {
        var matrix = new int[6][7];

        var random = new Random();

        for(int row = 0; row < matrix.size(); row++)
        {
            for(int col = 0; col < matrix[row].size(); col++)
            {
                matrix[row][col] = random.nextInt(10);
            }
        }

        Display(matrix);

        for(int row = 0; row < matrix.size(); row++)
        {
            int max = 0;
            for(int col = 1; col < matrix[row].size(); col++)
            {
                max  = (matrix[row][max] < matrix[row][col]) ? col : max;
            }
            var temp = matrix[row][0];
            matrix[row][0] = matrix[row][max];
            matrix[row][max] = temp;
        }

        Display(matrix);
    }
}
