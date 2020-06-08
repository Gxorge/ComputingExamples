package me.gabriella.example.innerworkings;

import me.gabriella.example.examples.BasicTimer;
import me.gabriella.example.examples.FizzBuzz;
import me.gabriella.example.examples.Quizes;
import me.gabriella.example.examples.SwitchCase;

import java.lang.reflect.Method;

public enum ExampleEnum
{
    QUIZES("Quizes", "A basic, 10 question quiz!", Quizes.class),
    FIZZBUZZ("FizzBuzz", "FizzBuzz code test. Every multiple of 3 outputs \"Fizz\", every multiple of 5 outputs \"Buzz\".", FizzBuzz.class),
    SWITCHCASE("SwitchCase", "An example of switching.", SwitchCase.class),
    BASICTIMER("BasicTimer", "A basic timer that counts down in seconds.", BasicTimer.class);

    private String name;
    private String desc;
    private Class<? extends Example> exampleClass;

    private ExampleEnum(String name, String desc, Class<? extends Example> exampleClass)
    {
        this.name = name;
        this.desc = desc;
        this.exampleClass = exampleClass;
    }

    //Reflection sucks
    public void run()
    {
       try
       {
           Object obj = getExampleClass().getDeclaredConstructor().newInstance();
           Method method = getExampleClass().getMethod("run");
           method.invoke(obj);
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
    }

    public String getName() { return name; }

    public String getDesc() { return desc; }

    public Class<? extends Example> getExampleClass() { return exampleClass; }

}
