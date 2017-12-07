package day06b;

import java.util.HashMap;
import java.util.Map;

import commons.HashableArray;
import commons.InputReader;

public class Main {
	
	private static void compute(String s) {
		String[] sa = s.split("\\s");
		Integer[] a = new Integer[sa.length];
		
		int i = 0;
		while (i < sa.length) {
			a[i] = Integer.parseInt(sa[i]);
			i++;
		}
		
		int cycles = 0;
		Map<HashableArray<Integer>, Integer> states = new HashMap<HashableArray<Integer>, Integer>();
		HashableArray<Integer> ha = new HashableArray<>(a);
		while (!states.containsKey(ha)) {
			states.put((HashableArray<Integer>) ha.clone(), cycles);
			a = ha.getA();
			
			i = 0;
			int j = 0;
			while (i < a.length) {
				if (a[i] > a[j]) {
					j = i;
				}
				i++;
			}
			
			int counter = a[j];
			a[j] = 0;
			while (counter > 0) {
				j = (j + 1) % a.length;
				a[j] += 1;
				counter--;
			}
			
			ha = ha.clone();
			cycles++;
		}
		
		System.out.println(cycles - states.get(ha));
	}
	
	public static void main(String[] args) {
		InputReader.init();
		while (InputReader.hasNext()) {
			compute(InputReader.nextLine());
		}
		InputReader.close();
	}
}
