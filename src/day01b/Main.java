package day01b;

import commons.InputReader;

public class Main {
	
	private static void solve(String input) {
		int[] digits = input.chars().map(c -> Character.getNumericValue(c)).toArray();
		
		int i = 0, j = digits.length / 2, sum = 0;
		while (i < digits.length) {
			if (digits[i] == digits[j]) {
				sum += digits[i];
			}
			
			i++;
			j = (j + 1) % digits.length;
		}
		
		System.out.println(sum);
	}
	
	public static void main(String[] args) {
		InputReader.init();
		while (InputReader.hasNext()) {
			solve(InputReader.nextLine());
		}
		InputReader.close();
	}
}
