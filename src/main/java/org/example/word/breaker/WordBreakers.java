package org.example.word.breaker;

import java.util.List;
import java.util.Set;

public class WordBreakers {
    private WordBreakers() {
    }

    /**
     * According to the default dictionary to break sentence
     *
     * @param input a sentence without space
     * @return all possible broken sentences
     */
    public static List<String> breakWordWithDefaultDict(String input) {
        return new DefaultWordBreaker().breakWord(input);
    }

    /**
     * According to the customized dictionary to break sentence
     *
     * @param input a sentence without space
     * @param customizedDict customized dictionary
     * @return all possible broken sentences
     */
    public static List<String> breakWordWithCustomizedDict(String input, Set<String> customizedDict) {
        return new CustomizedDictBreaker(customizedDict).breakWord(input);
    }


    /**
     * According to the customized dictionary and default dictionary to break sentence
     *
     * @param input a sentence without space
     * @param customizedDict customized dictionary
     * @return all possible broken sentences
     */
    public static List<String> breakWordWithBothDict(String input, Set<String> customizedDict) {
        List<WordBreaker> breakers = List.of(new DefaultWordBreaker(),
                new CustomizedDictBreaker(customizedDict));
        return new ComposeWordBreaker(breakers).breakWord(input);
    }
}
