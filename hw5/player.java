import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class player {
	int health;
	int crystal;
	int career;
	int abilityflag=0;
	String name;
	ArrayList <String> cards;
	ArrayList <String> allcards;
	Scanner scanner;
	
	public player(String person) {
		
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
	public void careerandhealth(String career) {
		if(career.equals("Warrior")) {
			this.career=0;
			this.health=40;
		}
		else if(career.equals("Magician")) {
			this.career=1;
			this.health=20;
		}
		else if(career.equals("Priest")) {
			this.career=2;
			this.health=20;
		}
		else {
			this.career=3;
			this.health=16;
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
			for(int i=0;i<round;i++) {
				if(allcards.size()==0){
					break;
				}
				else{
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
}
