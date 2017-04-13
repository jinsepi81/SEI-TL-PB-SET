package com.sei.tlpbset;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

public class DeDupTest {
    DeDup dup = new DeDup();
    @Test
    public void testRemoveDuplicatedMemberByUsingDistinct() {
        int[] result = dup.removeDuplicatedMemberByUsingDistinct(dup.randomIntegers);
        Assert.assertTrue("Failed to remove duplicated member by using RemoveDuplicatedMemberByUsingDistinct",
                validateDuplicatedArray(result));
    }
    @Test
    public void testremoveDuplicatedMemberByUsingSet() {
        int[] result = dup.removeDuplicatedMemberByUsingSet(dup.randomIntegers);
        Assert.assertTrue("Failed to remove duplicated member by using removeDuplicatedMemberByUsingSet",
                validateDuplicatedArray(result));
    }
    @Test
    public void testRemoveDuplicatedMemberSortByASC() {
        int[] result = dup.removeDuplicatedMember(dup.randomIntegers, true);
        Assert.assertTrue("Failed to remove duplicated member by using removeDuplicatedMember sort is ASC.",
                validateDuplicatedArray(result));

        Assert.assertTrue("Failed to sort member by asc by using removeDuplicatedMember.",
                isSortedByAsc(result));
    }

    @Test
    public void testRemoveDuplicatedMemberSortByDSC() {
        int[] result = dup.removeDuplicatedMember(dup.randomIntegers, false);
        Assert.assertTrue("Failed to remove duplicated member by using removeDuplicatedMember sort is DESC.",
                validateDuplicatedArray(result));
        Assert.assertTrue("Failed to sort member by desc by using removeDuplicatedMember.",
                isSortedByDesc(result));

    }
    private boolean isSortedByAsc(int[] result){
        int length = result.length;
        for (int i = 1; i < length; i++) {
            if (result[i-1] > result[i] ) {
                return false;
            }
        }
        return true;
    }
    private boolean isSortedByDesc(int[] result){
        int length = result.length;
        for (int i = 1; i < length; i++) {
            if (result[i-1] < result[i] ) {
                return false;
            }
        }
        return true;
    }
    private boolean validateDuplicatedArray(int[] result){
        Map<Integer, Integer> testResult = new HashMap<>();
        IntStream.of(result).forEach(i->testResult.put(i, testResult.get(i)==null?0:testResult.get(i)+1));
        return testResult.entrySet().stream().noneMatch(map->map.getValue()>1);
    }
}
