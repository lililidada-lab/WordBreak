package org.example.word.breaker;

import java.util.List;

public class ComposeWordBreaker extends AbstractWordBreaker {
    private final List<WordBreaker> breakers;

    public ComposeWordBreaker(List<WordBreaker> breakers) {
        this.breakers = breakers;
    }

    @Override
    public boolean isValidWord(String word) {
        // if anyone breaker contain this word return true, otherwise return false
        for (WordBreaker breaker : breakers) {
            if (breaker.isValidWord(word)) {
                return true;
            }
        }
        return false;
    }
}
