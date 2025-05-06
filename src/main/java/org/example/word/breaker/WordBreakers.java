package org.example.word.breaker;

import java.util.List;
import java.util.Set;

public class WordBreakers {
    private WordBreakers() {
    }

    public static List<String> breakWordWithDefaultDict(String input) {
        return new DefaultWordBreaker().breakWord(input);
    }

    public static List<String> breakWordWithCustomizedDict(String input, Set<String> customizedDict) {
        return new CustomizedDictBreaker(customizedDict).breakWord(input);
    }

    public static List<String> breakWordWithBothDict(String input, Set<String> customizedDict) {
        List<WordBreaker> breakers = List.of(new DefaultWordBreaker(),
                new CustomizedDictBreaker(customizedDict));
        return new ComposeWordBreaker(breakers).breakWord(input);
    }
}
