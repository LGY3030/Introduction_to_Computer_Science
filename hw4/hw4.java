import java.util.Scanner;

public class hw4 {
	
	public static void main(String[] args) {
		
		int roundflag=1;
		int turn=0;
		String[] getname;
		String instruction;
		player player1=new player("player1");
		player player2=new player("player2");
		Scanner scanner=new Scanner(System.in);
		System.out.println("¿é¤Jª±®a¦WºÙ:");
		getname=scanner.next().split("]");
		player1.name=getname[0].substring(1);
		player2.name=getname[1].substring(1);
		while(true) {
			instruction=scanner.next();
			if(instruction.substring(0,4).equals("exit")) {
				break;
			}
			else if(instruction.substring(0,4).equals("fini")) {
				if(roundflag==1) {
					roundflag=2;
				}
				else {
					roundflag=1;
				}
			}
			else if(instruction.substring(0,4).equals("sele")) {
				
			}
		}
	}
}