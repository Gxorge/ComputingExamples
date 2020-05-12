package me.gabriella.example.innerworkings;

/*
Hi there! Pls no stealing, unless you were given express
permission to read this. if not, fuck off :)

Copyright (c) IsGeorgeCurious 2020
*/

import me.gabriella.example.examples.FizzBuzz;
import me.gabriella.example.examples.SwitchCase;

import java.lang.reflect.Method;

public enum ExampleEnum
{
    FIZZBUZZ("FizzBuzz", "FizzBuzz code test. Every multiple of 3 outputs \"Fizz\", every multiple of 5 outputs \"Buzz\".", FizzBuzz.class),
    SWITCHCASE("SwitchCase", "An example of switching.", SwitchCase.class);

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
