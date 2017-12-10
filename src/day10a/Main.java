package day10a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import commons.InputReader;

public class Main {
	
	private static int[] createInitialArray() {
		int[] a = new int[256];
		int i = 0;
		while (i < a.length) {
			a[i] = i;
			i++;
		}
		return a;
	}
	
	private static void reverse(int[] a, int i, int j, int dist) {
		if (dist <= 1) {
			return;
		}
		
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
			
		reverse(a, (i+1) % a.length, Math.floorMod((j-1), a.length), dist - 2);
	}
	
	private static void compute(String input) {
		String[] lengtsStrings = input.split(",");
		List<Integer> lengths = new ArrayList<>();
		int[] a = createInitialArray();
		Arrays.stream(lengtsStrings).forEach(s -> lengths.add(Integer.parseInt(s)));
		
		int index = 0;
		int skipSize = 0;
		for (Integer length : lengths) {
			reverse(a, index, (index + length - 1) % a.length, length);
			
			index = (index + length + skipSize) % a.length;
			skipSize++;
		}
		
		System.out.println(a[0] * a[1]);
	}

	public static void main(String[] args) {		
		InputReader.init();
		while (InputReader.hasNext()) {
			compute(InputReader.nextLine());
		}
		InputReader.close();
		
	}
	
}
