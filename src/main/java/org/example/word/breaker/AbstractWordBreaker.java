package org.example.word.breaker;

import java.util.*;
import java.util.stream.Collectors;

/**
 * this class provides a common break work method, subclasses only need to
 * implement the isValidWord method to break sentence according to different situations
 */
public abstract class AbstractWordBreaker implements WordBreaker {
    @Override
    public List<String> breakWord(String input) {
        List<List<String>> brokenWordsList = breakWordByBFS(input);
        return brokenWordsList.stream().
                map(brokenWords -> String.join(" ", brokenWords))
                .collect(Collectors.toList());
    }

    private List<List<String>> breakWordByBFS(String input) {
        if (isInValidInput(input)) {
            return Collections.emptyList();
        }
        List<List<String>> result = new ArrayList<>();
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(new ArrayList<>(), 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int start = pair.getStartIndex();
            for (int end = start + 1; end < input.length() + 1; end++) {
                String word = input.substring(start, end);
                if (!isValidWord(word)) {
                    continue;
                }
                List<String> brokenWords = new ArrayList<>(pair.getBrokenWords());
                brokenWords.add(word);
                if (end == input.length()) {
                    result.add(brokenWords);
                } else {
                    queue.offer(new Pair(brokenWords, end));
                }
            }
        }
        return result;
    }

    private boolean isInValidInput(String input) {
        return input == null || input.isBlank();
    }

    private static class Pair {
        private final List<String> brokenWords;
        private final int startIndex;

        public Pair(List<String> brokenWords, int startIndex) {
            this.brokenWords = brokenWords;
            this.startIndex = startIndex;
        }

        public List<String> getBrokenWords() {
            return brokenWords;
        }

        public int getStartIndex() {
            return startIndex;
        }
    }
}
