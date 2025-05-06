package org.example.word.breaker;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ComposeWordBreakerTest {

    @Test
    public void testIsValidWord() {
        Set<String> customizedDict = Set.of("i", "like", "samsung", "mobile",
                "and", "iphone", "xiaomi", "xiao", "mi");
        List<WordBreaker> breakers = List.of(new DefaultWordBreaker(), new CustomizedDictBreaker(customizedDict));
        ComposeWordBreaker breaker = new ComposeWordBreaker(breakers);

        List<String> trueCases = List.of("i", "like", "samsung", "mobile",
                "and", "iphone", "xiaomi", "xiao", "mi", "ice", "cream", "mango", "sam", "sung");
        trueCases.forEach(trueCase -> {
            Assert.assertTrue(breaker.isValidWord(trueCase));
        });

        List<String> falseCases = List.of("hello", "tony", "night");
        falseCases.forEach(falseCase -> {
            Assert.assertFalse(breaker.isValidWord(falseCase));
        });
    }

    @Test
    public void testBreakWord() {
        Set<String> customizedDict = Set.of("iphone", "xiaomi", "xiao", "mi");
        List<WordBreaker> breakers = List.of(new DefaultWordBreaker(), new CustomizedDictBreaker(customizedDict));
        ComposeWordBreaker breaker = new ComposeWordBreaker(breakers);

        String testCase = "ilikesamsungmobileandxiaomimobile";
        List<String> expectResult = Arrays.asList(
                "i like samsung mobile and xiaomi mobile",
                "i like sam sung mobile and xiaomi mobile",
                "i like samsung mobile and xiao mi mobile",
                "i like sam sung mobile and xiao mi mobile"
        );
        expectResult.sort(String::compareTo);
        List<String> result = breaker.breakWord(testCase);
        result.sort(String::compareTo);
        Assert.assertEquals(expectResult, result);
    }
}