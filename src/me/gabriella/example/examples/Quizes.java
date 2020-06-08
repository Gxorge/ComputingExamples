package me.gabriella.example.examples;

import me.gabriella.example.innerworkings.Example;
import me.gabriella.example.innerworkings.Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class Quizes extends Example
{

    @Override
    public void run()
    {
        String input = "";
        String name = "";
        int score = 0;
        try
        {
            //Asks for user's name.
            System.out.println("Hello! What is your name?");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            name = reader.readLine();

            System.out.println(" ");
            System.out.println("Hello, " + name + "! Nice to meet you. My name is.. well uh I don't have one.");
            System.out.println("Anyway, let's get started on this quiz. I will ask you 10 questions and you must answer either A, B, or C.");
            System.out.println("Starting in 7 seconds...");
            TimeUnit.SECONDS.sleep(7);

            //A loop to go through 10 questions, getting question data from the QuizQuestions enum.
            for (int i = 1; i <= 10; i++) {
                Utils.clearScreen();
                QuizQuestions question = QuizQuestions.getQuestionFromInt(i);
                if (question == null)
                    break;

                System.out.println("Question " + i);
                System.out.println(" ");
                System.out.println(question.getQuestion());
                System.out.println("[A] " + question.getA());
                System.out.println("[B] " + question.getB());
                System.out.println("[C] " + question.getC());
                System.out.println(" ");

                input = reader.readLine().toUpperCase();
                if (input.equals(question.getAnswer())) {
                    score++;
                    System.out.println("Correct! You are now on " + score + " " + (score == 1 ? "point." : "points."));
                } else {
                    System.out.println("Bad luck! The correct answer was " + question.getAnswer() + ".");
                }
                if (i != 10) {
                    System.out.println("Next question in 3 seconds...");
                    TimeUnit.SECONDS.sleep(3);
                } else {
                    System.out.println(" ");
                    System.out.println("And we are done. Calculating your score now...");
                    TimeUnit.SECONDS.sleep(5);
                }

            }

            Utils.clearScreen();
            if (score <= 3) {
                System.out.println("Big oof. You got " + score + ". You need to get your knowledge up to scratch!");
            } else if (score == 6) {
                System.out.println("You did meh, I guess.");
            } else if (score == 7) {
                System.out.println("I see you are smart, young player.");
            } else {
                System.out.println("Very very well done! I see you are an intellectual!");
            }
            System.out.println("Score: " + score);
            System.out.println(" ");
            System.out.println("Thanks for playing, restarting in 10 seconds...");
            TimeUnit.SECONDS.sleep(10);
            Utils.clearScreen();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
