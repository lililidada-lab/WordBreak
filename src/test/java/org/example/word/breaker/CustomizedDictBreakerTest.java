package org.example.word.breaker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class CustomizedDictBreakerTest {

    @Test
    public void testIsValidWord() {
        Set<String> testDictionary = Set.of("i", "like", "samsung", "mobile",
                "and", "iphone", "xiaomi", "xiao", "mi");
        CustomizedDictBreaker breaker = new CustomizedDictBreaker(testDictionary);
        List<String> trueCases = List.of("i", "like", "samsung", "mobile",
                "and", "iphone", "xiaomi", "xiao", "mi");
        for (String testCase : trueCases) {
            Assert.assertTrue(breaker.isValidWord(testCase));
        }

        List<String> falseCases = List.of("sam", "sung", "ice", "cream", "hello", "hi");
        for (String testCase : falseCases) {
            Assert.assertFalse(breaker.isValidWord(testCase));
        }
    }

    @Test
    public void testBreakWord() {
        Set<String> testDictionary = Set.of("i", "like", "samsung", "mobile",
                "and", "iphone", "xiaomi", "xiao", "mi");
        CustomizedDictBreaker breaker = new CustomizedDictBreaker(testDictionary);
        String testCaseOne = "ilikesamsungmobile";
        List<String> expectResultOne = List.of("i like samsung mobile");
        Assert.assertEquals(expectResultOne, breaker.breakWord(testCaseOne));

        String testCaseTwo = "ilikeiphoneandxiaomimobile";
        List<String> expectResultTwo = Arrays.asList("i like iphone and xiaomi mobile",
                "i like iphone and xiao mi mobile");
        expectResultTwo.sort(String::compareTo);
        List<String> resultTwo = breaker.breakWord(testCaseTwo);
        resultTwo.sort(String::compareTo);
        Assert.assertEquals(expectResultTwo, resultTwo);

        String invalidCase = null;
        Assert.assertTrue(breaker.breakWord(invalidCase).isEmpty());
    }
}