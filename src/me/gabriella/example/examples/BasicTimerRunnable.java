package me.gabriella.example.examples;

import me.gabriella.example.innerworkings.Utils;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class BasicTimerRunnable extends TimerTask
{
    int duration;
    int countUp = 0;
    int totalDuration;

    int currentPos = 1;

    public BasicTimerRunnable(int duration)
    {
        this.duration = duration;
        this.totalDuration = duration;
    }

    @Override
    public void run()
    {
        //Clears the screen
        try {
            Utils.clearScreen();
        } catch (Exception e) {
            System.out.println("");
        }

        //Displays info about the timer.
        System.out.println("Currently running: Basic Timer");
        System.out.println("Timer: " + totalDuration / 1000 + " seconds");
        System.out.println(" ");
        //Progress bar!! (the +1 on the countup is because I change the timer after this is displayed (if that makes sense))
        System.out.println(Utils.createProgressbar((countUp / 1000) + 1, totalDuration / 1000, currentPos) + " " + duration / 1000 + " seconds left.");
        //As we are working in millis, 1 seconds = 1000 millis, but I set it to 999 so the progress bar has a chance to go to 0
        if (duration <= 999)
        {
            System.out.println("Time is up! Restarting in 5 seconds...");
            BasicTimer.timerFinished = true;
            try {
                TimeUnit.SECONDS.sleep(5);
                Utils.clearScreen();
            } catch (Exception e) {
                System.out.println("");
            }

            //This is lowkey cheecky as when the timer starts, the program resets back to the main menu as this is ran in another thread, so lets pray they dont start typing when this is running lmao
            System.out.println("\nPlease enter an example option you want to run!");
            cancel();
            return;
        }

        //WOOOOO PROGRESS BAR GO SPINNYYYYYY
        if (currentPos == 4)
            currentPos = 0;

        duration -= 100;
        countUp += 100;
        currentPos += 1;
    }
}
