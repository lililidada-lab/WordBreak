package org.example.word.breaker;

import java.util.Set;

public class CustomizedDictBreaker extends AbstractWordBreaker {
    public final Set<String> customizedDict;

    public CustomizedDictBreaker(Set<String> customizedDict) {
        this.customizedDict = customizedDict;
    }

    @Override
    public boolean isValidWord(String word) {
        return customizedDict.contains(word);
    }
}
