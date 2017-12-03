package day03b;

import commons.InputReader;

public class Main {
	
	private static long[][] a; 
	private static int x, y;
	
	private static void count(String input) {
		long n = Long.parseLong(input);
		long i = 1;
		
		a = new long[1000][1000]; 
		x = 500; y = 500;
		
		a[y][x] = 1;
		x++;
		
		while (i <= n) {
			i = getSiblingsSum();
			a[y][x] = i;
			
			if (emptyLeft() && emptyUp() && !emptyDown()) {
				x--;
			} else if (emptyUp() && emptyRight() && !emptyLeft()) {
				y--;
			} else if (emptyRight() && emptyDown() && !emptyUp()) {
				x++;
			} else {
				y++;
			}
		}
		
		System.out.println(i);
	}
	
	private static boolean emptyDown() {
		return a[y+1][x] == 0;
	}

	private static boolean emptyRight() {
		return a[y][x+1] == 0;
	}

	private static boolean emptyUp() {
		return a[y-1][x] == 0;
	}

	private static boolean emptyLeft() {
		return a[y][x-1] == 0;
	}

	private static long getSiblingsSum() {
		return a[y-1][x-1] + a[y-1][x] + a[y-1][x+1]
			+ a[y][x-1] 				+ a[y][x+1]
			+ a[y+1][x-1] + a[y+1][x] + a[y+1][x+1];
	}
	
	public static void main(String[] args) {		
		InputReader.init();
		while (InputReader.hasNext()) {
			count(InputReader.nextLine());
		}
		InputReader.close();		
	}
}
