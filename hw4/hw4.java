import java.util.Scanner;

public class hw4 {
	
	public static void main(String[] args) {
		
		int round=0;
		int turn=0;
		String[] getname;
		player player1=new player("player1");
		player player2=new player("player2");
		Scanner scanner=new Scanner(System.in);
		System.out.println("¿é¤Jª±®a¦WºÙ:");
		getname=scanner.next().split("]");
		player1.name=getname[0].substring(1);
		player2.name=getname[1].substring(1);
		for(int i=0;i<15;i++) {
			System.out.println(player1.allcards[i]);
		}
	}
}