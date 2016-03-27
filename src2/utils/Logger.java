package utils;

import java.io.IOException;
import java.util.Scanner;

public class Logger {
	private static int behuzas = 0;
	
	// Belepes fuggvenybe
	public static void inFunction(String text) {
		behuzas++;
		log(text);
	}
	
	// Belepes fuggvenybe
	public static void outFunction(String text) {
		log(text);
		if (behuzas > 0) {
			behuzas--;
		}
	}
	
	// Sima szoveg kiirasa
	public static void log(String text){
		for(int i = 0; i < behuzas; i++){
			System.out.print("  ");
		}
		System.out.println(text);
	}
	
	// Karakter beolvasasa
	public static char readKey() {
		//key = (char) System.in.read();
		Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
		return line.charAt(0);
	}
}
