package me.gabriella.example.examples;

import me.gabriella.example.innerworkings.Example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FizzBuzz extends Example
{
    public void run()
    {
        int upTo = 100; //Base if something errors during the read

        //Catch any exceptions when reading the input
        try
        {
            //Method to keep asking until the user enters a valid int (again using try-catch)
            boolean done = false;
            while (!done)
            {
                System.out.println("What number would you like this to go up to?");

                //Reads "System.in", which is just what you enter when it asks you for a number
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String input = reader.readLine();

                //Makes sure what you entered is actually a Integer
                try
                {
                    upTo = Integer.parseInt(input);
                    done = true;
                } catch (Exception e) {
                    System.out.println("Try again! Not a number!");
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("Error! See below:");
            e.printStackTrace();
        }

        //Now to iterate through every number up to the one the user specified
        for (int i = 1; i<=upTo; i++)
        {
            String output = "";

            //% being MOD (gets the remainder)
            if ((i % 3) == 0) {output += "Fizz";} //Is 'i' a multiple of 3? If yes, it appends "Fizz" to the end of the output string
            if ((i % 5) == 0) {output += "Buzz";} //Is 'i' a multiple of 5? If yes, it appends "Buzz" to the end of the ouput string

            //If the string is just "", it is neither a multiple of 3 or 5 so 'i' is just outputted.
            if (output.equalsIgnoreCase(""))
                System.out.println(i);
            else
                System.out.println(output);
        }
    }
}
