package com.interview.practice.a.epam;

import java.util.*;

public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = { "abcd", "java", "dcba", "ajav", "xyz", "epam", "pame", "aepm" };
//		[abcd, dcba]
//		[epam, pame, aepm]
//		[java, ajav]
		
		//Approach will be 
		//1. convert the string to charArray() 
		//2. sort the char array then
		//3. convert this to string 
		//4. Add this string to Map as key and value as list of matching words
		Map<String, List<String>> result = new HashMap<>();
		
		for(String word: arr) {
			char[] chars = word.toCharArray();
			Arrays.sort(chars);
			String sortedString = new String(chars);
			
			if(result.containsKey(sortedString)) {
				result.get(sortedString).add(word);
			} else {
				 List<String> list = new ArrayList<>();
				 list.add(word);
				result.put(sortedString,list);
			}
			
		}
		
		for(List<String> values: result.values()) {
			if(values.size() > 1)
				System.out.println(values);
		}

	}

}
