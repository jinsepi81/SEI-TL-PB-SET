package com.sei.tlpbset;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*

1.  Given the following class, write 3 methods that can be used to return an array that has no duplicates.
2.  You should define a method signature that you feel is appropriate to the problem.
3.  We would prefer to see three implementations (one that should take into consideration #4 below) and an explanation of what use-cases are suitable to each implementation
4.  What if we need to retain the original order?
5.  What are the positives and negatives of your solution?
a.  Can you implement it another way so as to avoid the negatives?
6.  Your solution should be testable and “production ready.”
7.  Your solution should be posted to a public github repo that SEI can clone.
*/
public class DeDup {

    public int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
                                   20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
                                   13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};

    public static void main(String [] args) {
        DeDup deDup = new DeDup();
        System.out.println(Arrays.toString(deDup.removeDuplicatedMemberByUsingDistinct(deDup.randomIntegers)));
        System.out.println("==================================");
        System.out.println(Arrays.toString(deDup.removeDuplicatedMemberByUsingSet(deDup.randomIntegers)));
        System.out.println("==================================");
        System.out.println(Arrays.toString(deDup.removeDuplicatedMember(deDup.randomIntegers, true)));
        System.out.println("==================================");
        System.out.println(Arrays.toString(deDup.removeDuplicatedMember(deDup.randomIntegers, false)));
    }

    /**
     * Removes the duplicated member from given int Array
     * it keeps the original order
     * positives : It's simple and fast implementation.
     * negatives : N/A
     * @param intArray the int array
     * @return the int[]
     */
    public int[] removeDuplicatedMemberByUsingDistinct(int[] intArray){
         return Arrays.stream(intArray).distinct().toArray();
    }

    /**
     * Removes the duplicated member from given int Array
     * negatives :It does not keep the original order, "boxed" method is expensive.
     * @param intArray the int array
     * @return the int[]
     */
    public int[] removeDuplicatedMemberByUsingSet(int[] intArray){
        Set<Integer> integerSet = new HashSet<>(IntStream.of(intArray).boxed()
                 .collect(Collectors.toList()));
        return integerSet.stream().mapToInt(i->i).toArray();
    }


    /**
     * Removes the duplicated member from given int Array
     * it does not keep the original order
     * positives : Sort could be changed.
     * negatives :It does not keep the original order, "boxed" method is expensive.
     * @param intArray the int array
     * @param ascSort configure sort by asc or desc
     * @return the int[]
     */
    public int[] removeDuplicatedMember(int[] intArray, boolean ascSort){
        if ( ascSort ) {
            return Arrays.stream(intArray).sorted().distinct().toArray();
        } else {
            return Arrays.stream(intArray).distinct().boxed()
                    .sorted((i1, i2) -> Integer.compare(i2, i1))
                    .mapToInt(i->i)
                    .toArray();
        }

    }
}