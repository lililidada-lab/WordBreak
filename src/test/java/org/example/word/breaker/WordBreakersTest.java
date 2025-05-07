package org.example.word.breaker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class WordBreakersTest {

    @Test
    public void testBreakWordWithDefaultDict() {
        String caseOne = "ilikesamsungmobile";
        List<String> expectResultOne = Arrays.asList("i like sam sung mobile", "i like samsung mobile");
        expectResultOne.sort(String::compareTo);
        List<String> resultOne = WordBreakers.breakWordWithDefaultDict(caseOne);
        resultOne.sort(String::compareTo);
        Assert.assertEquals(expectResultOne, resultOne);
    }

    @Test
    public void testBreakWordWithCustomizedDict() {
        Set<String> customizedDict = Set.of("i", "like", "samsung", "mobile",
                "and", "iphone", "xiaomi", "xiao", "mi");
        String testCaseOne = "ilikesamsungmobile";
        List<String> expectResultOne = List.of("i like samsung mobile");
        Assert.assertEquals(expectResultOne, WordBreakers.breakWordWithCustomizedDict(testCaseOne, customizedDict));

        String testCaseTwo = "ilikeiphoneandxiaomimobile";
        List<String> expectResultTwo = Arrays.asList("i like iphone and xiaomi mobile",
                "i like iphone and xiao mi mobile");
        expectResultTwo.sort(String::compareTo);
        List<String> resultTwo = WordBreakers.breakWordWithCustomizedDict(testCaseTwo, customizedDict);
        resultTwo.sort(String::compareTo);
        Assert.assertEquals(expectResultTwo, resultTwo);
    }

    @Test
    public void testBreakWordWithBothDict() {
        Set<String> customizedDict = Set.of("iphone", "xiaomi", "xiao", "mi");
        String testCase = "ilikesamsungmobileandxiaomimobile";
        List<String> expectResult = Arrays.asList(
                "i like samsung mobile and xiaomi mobile",
                "i like sam sung mobile and xiaomi mobile",
                "i like samsung mobile and xiao mi mobile",
                "i like sam sung mobile and xiao mi mobile"
        );
        expectResult.sort(String::compareTo);
        List<String> result = WordBreakers.breakWordWithBothDict(testCase, customizedDict);
        result.sort(String::compareTo);
        Assert.assertEquals(expectResult, result);

        String invalidCase = "     ";
        List<String> resultTwo = WordBreakers.breakWordWithBothDict(invalidCase, customizedDict);
        Assert.assertTrue(resultTwo.isEmpty());
    }
}