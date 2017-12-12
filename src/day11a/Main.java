package day11a;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import commons.InputReader;

public class Main {

	private static void compute(String input) {
		List<HexDirection> steps = Arrays.stream(input.split(","))
			.map(s -> HexDirection.valueOf(s.toUpperCase()))
			.collect(Collectors.toList());
		
		int x = 0, y = 0, z = 0;
		
		int n = (int) steps.stream().filter(d -> d == HexDirection.N).count();
		int s = (int) steps.stream().filter(d -> d == HexDirection.S).count();
		int se = (int) steps.stream().filter(d -> d == HexDirection.SE).count();
		int nw = (int) steps.stream().filter(d -> d == HexDirection.NW).count();
		int ne = (int) steps.stream().filter(d -> d == HexDirection.NE).count();
		int sw = (int) steps.stream().filter(d -> d == HexDirection.SW).count();
		
		x += ne;
		x += se;
		x -= nw;
		x -= sw;
		
		y += n;
		y += nw;
		y -= s;
		y -= se;
		
		z += s;
		z += sw;
		z -= n;
		z -= ne;
		
		System.out.println("x:" + x + " y:" + y + " z:" + z);
		System.out.println(Math.max(Math.max(Math.abs(x), Math.abs(y)), Math.abs(z)));
	}
	
	public static void main(String[] args) {		
		InputReader.init();
		while (InputReader.hasNext()) {
			compute(InputReader.nextLine());
		}
		InputReader.close();
	}

}
