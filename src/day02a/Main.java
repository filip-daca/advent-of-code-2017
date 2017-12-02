package day02a;

import java.util.Arrays;

import commons.InputReader;

public class Main {
	
	private static int count(String input) {
		String[] numbers = input.split("\\s");
		
		int min = Arrays.stream(numbers).mapToInt(Integer::parseInt).min().getAsInt();
		int max = Arrays.stream(numbers).mapToInt(Integer::parseInt).max().getAsInt();
		
		return max - min;
	}
	
	public static void main(String[] args) {
		int sum = 0;
		
		InputReader.init();
		while (InputReader.hasNext()) {
			sum += count(InputReader.nextLine());
		}
		InputReader.close();
		
		System.out.println(sum);
	}
}
