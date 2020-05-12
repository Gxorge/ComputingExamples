package me.gabriella.example.examples;

import me.gabriella.example.innerworkings.Example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwitchCase extends Example
{
    public void run()
    {
        //Try-catch to catch any errors during the input read.
        try
        {
            System.out.println("What is your favourite subject?");
            String text = "";

            //Reads the input
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            text = reader.readLine();

            //Now it will go through all the cases I have listed below to see if what was inputted matches.
            switch (text.toLowerCase())
            {
                case "computing":
                    System.out.println("Excellent choice!");
                    break;
                case "imedia":
                    System.out.println("Creativity is the best, right?");
                    break;
                case "drama":
                    System.out.println("Yuck, you uncultured swine!");
                    break;
                case "pe":
                    System.out.println("Exercise? I though you said extra fries!");
                    break;
                case "buisness":
                    System.out.println("meh");
                    break;

                //Default is used if what the user has entered is not listed.
                default:
                    System.out.println("I don't know what subject you entered, but I'm sure it's good!");
            }
        }
        catch (IOException e)
        {
            System.out.println("There was an error! See below:");
            e.printStackTrace();
        }
    }
}
