package com.interview.practice.c.hcl;

import java.util.*;
import java.util.stream.Collectors;

public class HclQuestions {
    public static void main(String[] args) {
        /*
          Solution 1: Using Collectors.partitioningBy() (Returns Boolean keys)
        */
          
        List<Integer> input = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9);
        
        Map<Boolean, List<Integer>> result = input.stream()
            .collect(Collectors.partitioningBy(Main::isPrime));
        
        System.out.println("Prime: " + result.get(true));
        System.out.println("NonPrime: " + result.get(false));

      /*
        Solution 2: Using Collectors.groupingBy() (Returns String keys like you wanted)
        */
        List<Integer> input1 = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9);
          
          Map<String, List<Integer>> result1 = input1.stream()
              .collect(Collectors.groupingBy(i -> isPrime(i) ? "Prime" : "NonPrime"));
          
          System.out.println(result1);
          // Output: {Prime=[2, 3, 5, 7], NonPrime=[4, 6, 8, 9]}
    }
    
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
