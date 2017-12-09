package day09a;

import commons.InputReader;

public class Main {
	
	private static StringBuilder sb = new StringBuilder();
	private static boolean scanningGarbage = false;
	private static boolean ignoringNext = false;
	
	private static void filterGarbage(Character c) {
		if (scanningGarbage) {
			if (ignoringNext) {
				ignoringNext = false;
			} else if (c.equals('>')) {
				scanningGarbage = false;
			} else if (c.equals('!')) {
				ignoringNext = true;
			}
		} else {
			if (c.equals('<')) {
				scanningGarbage = true;
			} else {
				sb.append(c);
			}
		}
	}
	
	private static int countScore(String input) {
		int score = 0;
		int depth = 1;
		int i = 0;
		while (i < input.length()) {
			if (input.charAt(i) == '{') {
				score += depth;
				depth++;
			} else if (input.charAt(i) == '}') {
				depth--;
			}
			i++;
		}
		return score;
	}
	
	public static void main(String[] args) {		
		InputReader.initCharByChar();
		while (InputReader.hasNext()) {
			filterGarbage(InputReader.nextChar());
		}
		InputReader.close();
		
		System.out.println(countScore(sb.toString().trim()));
	}

	
}
