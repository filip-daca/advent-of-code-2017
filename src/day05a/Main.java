package day05a;

import java.util.ArrayList;
import java.util.List;

import commons.InputReader;

public class Main {
	
	private static void compute(List<Integer> a) {
		int i = 0, steps = 0, distance = 0;
		while (i >= 0 && i < a.size()) {
			distance = a.get(i);
			a.set(i, distance + 1);
			i += distance;
			steps++;
		}
		
		System.out.println(steps);
	}
	
	public static void main(String[] args) {
		List<Integer> a = new ArrayList<>();
		
		InputReader.init();
		while (InputReader.hasNext()) {
			a.add(Integer.parseInt(InputReader.nextLine()));
		}
		InputReader.close();		
		
		compute(a);
	}
}
