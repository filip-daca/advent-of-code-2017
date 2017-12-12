package day11b;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import commons.InputReader;

public class Main {

	private static void compute(String input) {
		List<HexDirection> steps = Arrays.stream(input.split(","))
			.map(s -> HexDirection.valueOf(s.toUpperCase()))
			.collect(Collectors.toList());
		
		int x = 0, y = 0, z = 0, maxDist = 0;
		
		for (HexDirection direction : steps) {
			switch (direction) {
			case N: y++; z--; break;
			case S: y--; z++; break;
			case SE: x++; y--; break;
			case NW: y++; x--; break;
			case NE: x++; z--; break;
			case SW: z++; x--; break;
			}
			int currentDist = countDistance(x, y, z);
			if (currentDist > maxDist) {
				maxDist = currentDist;
			}
		}
		
		System.out.println(maxDist);
	}

	private static int countDistance(int x, int y, int z) {
		return Math.max(Math.max(Math.abs(x), Math.abs(y)), Math.abs(z));
	}
	
	public static void main(String[] args) {		
		InputReader.init();
		while (InputReader.hasNext()) {
			compute(InputReader.nextLine());
		}
		InputReader.close();
	}

}
