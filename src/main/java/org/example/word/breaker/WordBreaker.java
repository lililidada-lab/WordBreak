package org.example.word.breaker;

import java.util.List;

public interface WordBreaker {
    /**
     * find all possible ways to break the sentence in individual dictionary words
     *
     * @param input a sentence without any spaces
     * @return broken sentences
     */
    List<String> breakWord(String input);

    /**
     * Determine whether a word is in the dictionary
     *
     * @param word a english word
     * @return true if the word in the dictionary, otherwise false
     */
    boolean isValidWord(String word);
}
