package commons;

import java.util.Scanner;

public class InputReader {

	private static Scanner scanner;
	
	public static void init() {
		scanner = new Scanner(System.in);
	}
	
	public static void close() {
		scanner.close();
	}
	
	public static boolean hasNext() {
		return scanner.hasNext();
	}
	
	public static String nextLine() {
		return scanner.nextLine();
	}
}
