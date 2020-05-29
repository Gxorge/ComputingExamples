package me.gabriella.example.innerworkings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils
{
    //i really hate this code
    public static String createProgressbar(int current, int outOf, int currentPos)
    {
        //This is the spinny bit of the progress bar
        String _rawPos = "|,/,-,\\";
        String _pos[] = _rawPos.split(",");
        List<String> pos = new ArrayList<>();
        pos = Arrays.asList(_pos);

        StringBuilder output = new StringBuilder("\r[");
        int percentage = (current++ * 100) / outOf; //works out the percentage of how full the bar is
        int counter = 0;

        for (int i = 1; i<=percentage / 10; i++) //i then use that percentage and divide it by 10 (as the bar supports 10 progress blocks). this will then append a blocc when its needed
        {
            output.append("█");
            counter++;
        }

        if (counter != 10) //fills the blanks with -
        {
            int left = 10 - counter;
            for (int i = 1; i<= left; i++) {
                output.append("-");
            }
        }
        output.append("] " + _pos[currentPos-1]); //adds the finishing bracket and then adds the SPINNNYYYYYYYY

        return output.toString();
    }

    //Basically runs the "cls" command in the command line.
    public static void clearScreen() throws IOException, InterruptedException
    {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
