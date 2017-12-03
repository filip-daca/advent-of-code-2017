package day03a;

import commons.InputReader;

public class Main {
	
	private static void count(String input) {
		long n = Long.parseLong(input);
		long radDist = 0;
		
		long i = 1;
		while (n > i*i) {
			i += 2;
			radDist++;
		}	
		
		long j = i*i;
		while (j-(i-1) >= n) {
			j = j-(i-1);
		}
		
		long spiralDist = Math.abs(j - i/2 - n);
		
		System.out.println(radDist + spiralDist);
	}
	
	public static void main(String[] args) {		
		InputReader.init();
		while (InputReader.hasNext()) {
			count(InputReader.nextLine());
		}
		InputReader.close();		
	}
}
