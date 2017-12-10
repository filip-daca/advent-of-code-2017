package day10b;

import java.nio.charset.Charset;
import java.util.ArrayList;
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
	
	private static List<Integer> createLengths(String input) {
		List<Integer> lengths = new ArrayList<>();
		byte[] bytes = input.getBytes(Charset.forName("ASCII"));
		for (byte b : bytes) {
			lengths.add((int) b);
		}
		lengths.add(17);
		lengths.add(31);
		lengths.add(73);
		lengths.add(47);
		lengths.add(23);
		return lengths;
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
	
	private static int[] createDenseHash(int[] a) {
		int[] dh = new int[16];
		for (int i = 0; i < dh.length; i++) {
			int j = i * 16;
			while (j < (i + 1) * 16) {
				dh[i] = dh[i] ^ a[j];
				j++;
			}
		}
		return dh;
	}
	
	private static void compute(String input) {
		List<Integer> lengths = createLengths(input);
		int[] a = createInitialArray();
		
		int index = 0;
		int skipSize = 0;
		for (int n = 0; n < 64; n++) {
			for (Integer length : lengths) {
				reverse(a, index, (index + length - 1) % a.length, length);
				
				index = (index + length + skipSize) % a.length;
				skipSize++;
			}
		}
		
		int[] dh = createDenseHash(a);
		for (int i : dh) {
			if (i < 10) {
				System.out.print(0);
			}
			System.out.print(Integer.toHexString(i));
		}
	}

	public static void main(String[] args) {		
		InputReader.init();
		while (InputReader.hasNext()) {
			compute(InputReader.nextLine());
		}
		InputReader.close();
	}
	
}
