package com.interview.practice.b.synechron;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SynechronQuestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Question 01: String input = "welcome0to1my2house3today4";
		                String output = “emocllew0ot1ym2esuoh3yadot4”

		 */
		String input = "welcome0to1my2house3today4";
		System.out.println("Question 01: input: "+input);
		reverseOnlyString(input);
		
		/*
		 * Question 02: String arr[] = [Java, jAva, JaVa, oops Oops, ooPs, lang, Lang, is]
		   Using java stream find the max occurs string ignore case sensitive 

		 */
		
		String[] arr = { "Java", "jAva", "JaVa",
	            "oops", "Oops", "ooPs",
	            "lang", "Lang",
	            "is"
			};
		
		findMaxOccuringIgnoreCase(arr);
		
		/*
		 * Question 04: Find k th highest integer Without using stream and sorting 
		   arr = {1, 4, 3, 8, 7, 9, 5}

		 */
		int[] kthArr = {1, 4, 3, 8, 7, 9, 5};
		int k = 4;
		findkThHighestNum(kthArr, k);
		System.out.println("kthArr: "+Arrays.toString(kthArr));
		findkThHighestNumUsingPriorityQueue(kthArr, k);
		
		/*
		 * Question 03: Write an sql query which returns employee id name salary whose salary is > is manager salary 
		 * Solution 01:
		 * SELECT e.id, e.name, e.salary 
		 * FROM employee e
		 * JOIN employee m
		 * ON e.manager_id = m.id
		 * WHERE e.salary > m.salary;
		 * 
		 */

	}

	private static void reverseOnlyString(String input) {
		// TODO Auto-generated method stub
		StringBuilder result = new StringBuilder();
		StringBuilder temp = new StringBuilder();
		
		for(char c : input.toCharArray()) {
			if(Character.isDigit(c)) {
				result.append(temp.reverse());
				temp.setLength(0);
				result.append(c);
			} else {
				temp.append(c);
			}
		}
		
		result.append(temp.reverse());
		System.out.println("Output: "+result.toString());
		
	}
	
	private static void findMaxOccuringIgnoreCase(String[] arr) {
		// TODO Auto-generated method stub
		String maxOccuringWord = Arrays.stream(arr)
			.map(String::toLowerCase)
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
			.entrySet()
			.stream()
			.max(Map.Entry.comparingByValue())
			.get()
			.getKey();
		
		System.out.println("Question 02: Max Occuring Word: "+maxOccuringWord);
		
	}
	

	private static void findkThHighestNum(int[] kthArr, int k) {
		int[] kthArr1 = kthArr.clone();
		// TODO Auto-generated method stub
		int kthHighest = Integer.MIN_VALUE;

		for(int i = 0; i< k; i++) {
		    int max = Integer.MIN_VALUE;
			int index = -1;
			for(int j=0; j<kthArr1.length; j++) {
				if(kthArr1[j]>max) {
					max = kthArr1[j];
					index = j;
				}
			}
			kthHighest = max;
			kthArr1[index] = Integer.MIN_VALUE;
		}
		
		System.out.println(k+" th Highest Num: "+kthHighest);
		System.out.println("kthArr1: "+Arrays.toString(kthArr1));
		
	}
	
	private static void findkThHighestNumUsingPriorityQueue(int[] kthArr, int k) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i : kthArr) {
			pq.add(i);
			if(pq.size() > k) {
				pq.poll();
			}
		}
		
		System.out.println(k+" th Highest Num: "+pq.peek());
		
	}



}
