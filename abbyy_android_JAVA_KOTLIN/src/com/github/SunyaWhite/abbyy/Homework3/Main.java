package com.github.SunyaWhite.abbyy.Homework3;

import java.util.*;
import java.io.*;

public class Main {


    /*
       Method to count the number of characters in a file and write it into other file
       Params path - string / path to the file to read

       return void / Write results into file ""

     */
    public static void GetCharactersCountFromFile(String fullPath) throws IOException
    {
        // Store for characters count
        SortedMap<Character, Integer> dictionary = new TreeMap<>();
        String newFileName;

        // Checking, if file exists and can be read
        var file = new File(fullPath);
        if(!file.exists() || !file.canRead())
            throw new IOException("File doesn't exist");

        // Getting file path and new file name
        newFileName = file.getName().split("[.]")[0] + "_character_count.txt";

        //FileReader and storing it into store
        try(var fileReader = new FileReader(fullPath))
        {
            int c;

            // reading the file by one character per iteration
            while ((c = fileReader.read()) > 0)
            {
                var character = (char) c;
                if(!dictionary.containsKey(character))
                    dictionary.put(character, 0);
                dictionary.put(character, dictionary.get(character) + 1);
            }

        }
        catch (IOException exc)
        {
            throw  exc;
        }

        // File writer. Write character counts into file
        try(var fileWriter = new FileWriter(newFileName, false))
        {
            for (var key : dictionary.keySet())
            {
                fileWriter.append(key + " - " + dictionary.get(key).toString());
                fileWriter.append("\n");
            }
        }
        catch (IOException exc)
        {
            throw  exc;
        }

    }


    public static void main(String[] args)
    {
        // Path to the file
        String path = "links.txt";

        try {
            GetCharactersCountFromFile(path);
        }
        catch (Exception exc)
        {
            System.out.println(exc.getMessage());
        }

    }


}
