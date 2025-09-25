package com.interview.practice.a.epam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FindNumOfOccurence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] array = {"a","a","b","c","c","c"};
		Map<String, Integer> map = new HashMap<>();
		
		for(String s:array) {
			if(map.containsKey(s)) {
				map.put(s, map.get(s)+1);
			} else {
				map.put(s, 1);
			}
		}
		System.out.println(map);
		
		//using Java 8 streams
		Map<String, Long> mapByStream = Arrays.asList(array).stream().collect(
				Collectors.groupingBy(String::valueOf, Collectors.counting())
				);
		System.out.println("mapByStream="+mapByStream);
	}

}
