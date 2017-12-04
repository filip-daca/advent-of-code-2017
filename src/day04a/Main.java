package day04a;

import java.util.HashSet;
import java.util.Set;

import commons.InputReader;

public class Main {
	
	private static boolean isValid(String input) {
		String[] words = input.split(" ");
		Set<String> usedWords = new HashSet<>();
		
		int i = 0;
		while (i < words.length) {
			if (usedWords.contains(words[i])) {
				return false;
			}
			usedWords.add(words[i]);
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
