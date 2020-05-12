package me.gabriella.example;

import me.gabriella.example.examples.FizzBuzz;
import me.gabriella.example.examples.SwitchCase;
import me.gabriella.example.innerworkings.ExampleEnum;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExampleHub
{
    public static void main(String[] args)
    {
        try
        {
            boolean active = true;
            while (active)
            {
                System.out.println("\nPlease enter an example option you want to run!");
                String example = "";
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                example = bufferedReader.readLine().toUpperCase();

                if (example.equalsIgnoreCase("stop"))
                {
                    active = false;
                    continue; //will just yeet back to the start where the loop will see active is false.
                }

                System.out.println(" ");
                ExampleEnum ee;
                try
                {
                    ee = ExampleEnum.valueOf(example);
                }
                catch (Exception e)
                {
                    System.out.println("That is not a valid example!");
                    continue;
                }

                System.out.println("Now running: " + ee.getName());
                System.out.println(ee.getDesc());
                System.out.println(" ");
                ee.run();
            }
            System.out.println("Thanks for using, goodbye!");
        }
        catch (Exception e)
        {
            System.out.println("There was an error! See below:");
            e.printStackTrace();
        }
    }

}
