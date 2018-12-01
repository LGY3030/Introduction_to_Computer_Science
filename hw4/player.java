

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class player {
	
	int health;
	int crystal;
	String name;
	String[] cards;
	String[] allcards;
	Scanner scanner;
	public player(String person) {
		
		health=20;
		crystal=0;
		name="";
		cards=new String[5];
		allcards=new String[15];
		scanner=null;
		try {
			scanner = new Scanner(new FileInputStream(person+"_cards.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (int i = 0; i<15; i++) {
			allcards[i] = scanner.nextLine();
		}
	}	
}
