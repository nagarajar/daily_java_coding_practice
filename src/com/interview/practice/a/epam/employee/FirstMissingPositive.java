package com.interview.practice.a.epam.employee;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 Problem: First Missing Positive

		 Given an unsorted integer array nums, return the smallest missing positive integer.

		 Examples:
		   Input: [1, 3, 6, 4, 1, 2]
		   Output: 5

		   Input: [1, 2, 3]
		   Output: 4

		   Input: [-1, -3]
		   Output: 1

		 Constraints:
		   - The array can contain both positive and negative integers
		   - Your algorithm should run in O(n) time
		   - You should use O(1) extra space (advanced requirement)
		*/
		int[] input1 = {1, 3, 6, 4, 1, 2};
		int[] input = {2, 3, 6, 4, 3, 2};
		int[] input2 = {1, 2, 3};
		int[] input3 = {-1, -3};
		
		//Start
		Set<Integer> nums = new HashSet<>();
		for(int num: input) {
			if(num>0) nums.add(num);
		}
		System.out.println(nums);
		int smallestPositiveInteger = 1;
		while(nums.contains(smallestPositiveInteger)) {
			smallestPositiveInteger++;
		}
		
		System.out.println("Smallest missing positive integer = "+smallestPositiveInteger);
		

	}

}
