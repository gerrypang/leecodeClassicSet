package com.gerry.string;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
		Map<String, Integer> perfixMap = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			if (perfixMap.containsKey(strs[i].charAt(i))) {
				
//				perfixMap.put(strs[i].charAt(i)), perfixMap.get(strs[i].charAt(i)) + 1
			}
			 
			
			
//			if (maxLength < strs.length) {
//				maxLength = strs.length;
//				maxLengthIndex = i;
//			}
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		
	}
}
