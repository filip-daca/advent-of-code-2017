package day02b;

import java.util.Arrays;

import commons.InputReader;

public class Main {
	
	private static int div(int i, int j) {
		if (i < j) {
			return j / i;
		} else {
			return i / j;
		}
	}
	
	private static int count(String input) {
		String[] numbers = input.split("\\s");
		int[] a = Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
		
		int j, i = 0;
		while (i < a.length) {
			j = 0;
			while (j < a.length) {
				if (i != j && a[i] % a[j] == 0) {
					return div(a[i], a[j]);
				}
				j++;
			}
			i++;
		}
		
		return 0;
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
