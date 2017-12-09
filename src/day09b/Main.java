package day09b;

import commons.InputReader;

public class Main {
	
	private static StringBuilder sb = new StringBuilder();
	private static boolean scanningGarbage = false;
	private static boolean ignoringNext = false;
	private static int garbageCleaned = 0;
	
	private static void filterGarbage(Character c) {
		if (scanningGarbage) {
			if (ignoringNext) {
				ignoringNext = false;
			} else if (c.equals('>')) {
				scanningGarbage = false;
			} else if (c.equals('!')) {
				ignoringNext = true;
			} else {
				garbageCleaned++;
			}
		} else {
			if (c.equals('<')) {
				scanningGarbage = true;
			} else {
				sb.append(c);
			}
		}
	}
	
	public static void main(String[] args) {		
		InputReader.initCharByChar();
		while (InputReader.hasNext()) {
			filterGarbage(InputReader.nextChar());
		}
		InputReader.close();
		
		System.out.println(garbageCleaned);
	}

	
}
