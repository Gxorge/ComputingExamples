package me.gabriella.example.examples;

import me.gabriella.example.innerworkings.Example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Timer;

public class BasicTimer extends Example
{
    public static boolean timerFinished = false;

    @Override
    public void run()
    {
        int seconds = 0;
        try
        {
            boolean done = false;
            while (!done)
            {
                System.out.println("In seconds, how long would you like the timer to last for?");

                //Gets the user's input
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String input = reader.readLine();

                //This is checking if what the user inputted is a number
                try
                {
                    seconds = Integer.parseInt(input);
                    done = true;
                }
                catch (Exception e)
                {
                    //Will just loop until a number is inputted
                    System.out.println("That is not a valid number! Please try again.");
                    continue;
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Whoops! There was an error, see below:");
            e.printStackTrace();
        }

        //Stars the BasicTimerRunnable class so it fires every milliseconds. Why a millisecond you might ask? because woooo progressbar go spinny :D
        Timer timer = new Timer();
        timer.schedule(new BasicTimerRunnable(seconds * 1000), 0, 1); //making this milliseconds made my life hard, but anything for the spinny (laughs in egg)
    }
}
