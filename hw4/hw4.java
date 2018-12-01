

import java.util.Scanner;

public class hw4 {
	
	public static void main(String[] args) {
		
		int round=0;
		int turn=0;
		String[] getname;
		player player1=new player();
		player player2=new player();
		Scanner scanner=new Scanner(System.in);
		getname=scanner.next().split("]");
		player1.name=getname[0].substring(1);
		player2.name=getname[1].substring(1);
		System.out.println(player1.name);
		System.out.println(player2.name);
	}
}
