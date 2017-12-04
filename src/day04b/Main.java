package day04b;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import commons.InputReader;

public class Main {
	
	private static boolean isValid(String input) {
		String[] words = input.split(" ");
		Set<Map<Character, Integer>> usedWords = new HashSet<>();
		
		int i = 0;
		while (i < words.length) {
			String word = words[i];
			Map<Character, Integer> stamp = new HashMap<>();
			
			int j = 0;
			while (j < word.length()) {
				Character c = word.charAt(j);
				if (stamp.get(c) == null) {
					stamp.put(c, 1);
				} else {
					stamp.put(c, stamp.get(c) + 1);
				}
				j++;
			}
			
			if (usedWords.contains(stamp)) {
				return false;
			}
			
			usedWords.add(stamp);
			i++;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		int validPassphrases = 0;
		
		InputReader.init();
		while (InputReader.hasNext()) {
			if (isValid(InputReader.nextLine())) {
				validPassphrases++;
			}
		}
		InputReader.close();		
		
		System.out.println(validPassphrases);
	}
}
