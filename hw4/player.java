import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class player {
	
	int health;
	int crystal;
	String name;
	ArrayList <String> cards;
	ArrayList <String> allcards;
	Scanner scanner;
	public player(String person) {
		
		health=20;
		crystal=1;
		name="";
		cards=new ArrayList();
		allcards=new ArrayList();
		scanner=null;
		try {
			scanner = new Scanner(new FileInputStream(person+"_cards.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (int i = 0; i<15; i++) {
			allcards.add(scanner.nextLine());
		}
	}
	public void drawcard(int round) {
		if(round==100){
			for(int i=0;i<5;i++) {
				cards.add(allcards.get(0));
				allcards.remove(0);
			}
		}
		else if(round==1) {
			for(int i=0;i<1;i++) {
				cards.add(allcards.get(0));
				allcards.remove(0);
			}
		}
		else {
			round/=3;
			round+=1;
			for(int i=0;i<round-1;i++) {
				if(cards.size()==8) {
					allcards.remove(0);
				}
				else {
					cards.add(allcards.get(0));
					allcards.remove(0);
				}
			}
		}
	}
}
