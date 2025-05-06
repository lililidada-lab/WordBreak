package org.example.word.breaker;

import java.util.Set;

public class DefaultWordBreaker extends AbstractWordBreaker {
    private final static Set<String> defaultDict = Set.of("i", "like", "sam", "sung", "samsung",
            "mobile", "ice", "cream", "mango", "and");

    @Override
    public boolean isValidWord(String word) {
        return defaultDict.contains(word);
    }
}
