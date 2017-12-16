package com.lemuel.lemubit.supplyjoke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Joke {

    public static String getJoke() {
        //List of Jokes
        List<String> jokes = Arrays.asList(
                "Of course I should clean my windows. But privacy is important too.",
                "My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.\n",
                "There is no place like 127.0.0.1",
                "When your hammer is C++, everything begins to look like a thumb.",
                "To understand what recursion is, you must first understand recursion.",
                "The non-programmer thinks a kilobyte is 1000 bytes while a programmer is convinced that a kilometer is 1024 meters",
                "Chuck Norris doesn't dial the wrong number, you pick up the wrong phone",
                "Chuck Norris can win an argument with his wife.",
                "Chuck Norris can sit at the corner of a round table",
                "Chuck Norris can put out a fire using nothing but gasoline."

        );

        //Randomly select and send jokes
        Random r = new Random();
        return jokes.get(r.nextInt(10));
    }

}

