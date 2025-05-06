package org.example.word.breaker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DefaultWordBreakerTest {
    @Test
    public void testIsValidWord() {
        DefaultWordBreaker breaker = new DefaultWordBreaker();
        List<String> trueCases = List.of("i", "like", "sam", "sung", "samsung",
                "mobile", "ice", "cream", "mango", "and");
        trueCases.forEach(testCase -> {
            Assert.assertTrue(breaker.isValidWord(testCase));
        });

        List<String> falseCases = List.of("hello", "my", "he");
        falseCases.forEach(testCase -> {
            Assert.assertFalse(breaker.isValidWord(testCase));
        });
    }

    @Test
    public void testBreakWord() {
        DefaultWordBreaker breaker = new DefaultWordBreaker();
        String caseOne = "ilikesamsungmobile";
        List<String> expectResultOne = Arrays.asList("i like sam sung mobile", "i like samsung mobile");
        expectResultOne.sort(String::compareTo);
        List<String> resultOne = breaker.breakWord(caseOne);
        resultOne.sort(String::compareTo);
        Assert.assertEquals(expectResultOne, resultOne);

        String caseTwo = "ilikeicecreamandmango";
        List<String> expectResultTwo = List.of("i like ice cream and mango");
        List<String> resultTwo = breaker.breakWord(caseTwo);
        Assert.assertEquals(expectResultTwo, resultTwo);
    }
}