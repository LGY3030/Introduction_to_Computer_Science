import java.util.Scanner;

public class hw4 {
	
	private static Object[] player1area=new Object[6];
	private static Object[] player2area=new Object[6];
	private static String[] player1areahint=new String[6];
	private static String[] player2areahint=new String[6];
	private static player player1=new player("player1");
	private static player player2=new player("player2");
	public static void main(String[] args) {
		
		int roundflag=1;
		int round=1;
		String[] getname;
		String[] instruction;
		for(int i=0;i<6;i++) {
			player1area[i]=null;
			player2area[i]=null;
			player1areahint[i]="";
			player2areahint[i]="";
		}
		Scanner scanner=new Scanner(System.in);
		System.out.println("輸入玩家名稱:");
		getname=scanner.next().split(" ");
		player1.name=getname[0];
		player2.name=getname[1];
		while(true) {
			instruction=scanner.next().split(" ");
			if(instruction[0].equals("exit")) {
				break;
			}
			if(roundflag==1) {
				while(true) {
					player1.drawcard(round);
					if(instruction[0].equals("finish")) {
						roundflag=2;
						break;
					}
					else if(instruction[0].equals("select")) {
						createcardobject(1,instruction[1],Integer.parseInt(instruction[2].substring(1)),instruction[3],round);
					}
					else if(instruction[0].equals("change")) {
						changestatus(1,Integer.parseInt(instruction[1].substring(1)));
					}
					else {
						if(instruction[2].equals("enemy")) {
							
						}
						else {
							attackcard(Integer.parseInt(instruction[0].substring(1)),Integer.parseInt(instruction[2].substring(1)),instruction[2].substring(0,1));
						}
					}
					instruction=scanner.next().split(" ");
				}
			}
			else {
				while(true) {
					break;
				}
				round+=1;
				changeAttackFlagAndAction();
				player1.crystal=round;
				player2.crystal=round;
			}
		}
	}

	private static void attackcard(int offend, int defend, String hint) {
		int offendattack=0;
		int defendattack=0;
		int stopflag=0;
		if(player1areahint[offend-1].length()==2) {
			switch(player1areahint[offend-1]) {
				case "A1":
					if(((A1)player1area[offend-1]).action==0&&((A1)player1area[offend-1]).attackflag==1) {
						offendattack=((A1)player1area[offend-1]).attack(hint);
					}
					else {
						System.out.println("無法攻擊");
						stopflag=1;
					}
					break;
				case "A2":
					if(((A2)player1area[offend-1]).action==0&&((A2)player1area[offend-1]).attackflag==1) {
						offendattack=((A2)player1area[offend-1]).attack(hint);
					}
					else {
						System.out.println("無法攻擊");
						stopflag=1;
					}
					break;
				case "B1":
					if(((B1)player1area[offend-1]).action==0&&((B1)player1area[offend-1]).attackflag==1) {
						offendattack=((B1)player1area[offend-1]).attack(hint);
					}
					else {
						System.out.println("無法攻擊");
						stopflag=1;
					}
					break;
				case "B2":
					if(((B2)player1area[offend-1]).action==0&&((B2)player1area[offend-1]).attackflag==1) {
						offendattack=((B2)player1area[offend-1]).attack(hint);
					}
					else {
						System.out.println("無法攻擊");
						stopflag=1;
					}
					break;
				case "C1":
					if(((C1)player1area[offend-1]).action==0&&((C1)player1area[offend-1]).attackflag==1) {
						offendattack=((C1)player1area[offend-1]).attack(hint);
					}
					else {
						System.out.println("無法攻擊");
						stopflag=1;
					}
					break;
				case "C2":
					if(((C2)player1area[offend-1]).action==0&&((C2)player1area[offend-1]).attackflag==1) {
						offendattack=((C2)player1area[offend-1]).attack(hint);
					}
					else {
						System.out.println("無法攻擊");
						stopflag=1;
					}
					break;
				case "D1":
					if(((D1)player1area[offend-1]).action==0&&((D1)player1area[offend-1]).attackflag==1) {
						offendattack=((D1)player1area[offend-1]).attack(hint);
					}
					else {
						System.out.println("無法攻擊");
						stopflag=1;
					}
					break;
				case "D2":
					if(((D2)player1area[offend-1]).action==0&&((D2)player1area[offend-1]).attackflag==1) {
						offendattack=((D2)player1area[offend-1]).attack(hint);
					}
					else {
						System.out.println("無法攻擊");
						stopflag=1;
					}
					break;
				case "E1":
					if(((E1)player1area[offend-1]).action==0&&((E1)player1area[offend-1]).attackflag==1) {
						offendattack=((E1)player1area[offend-1]).attack(hint);
					}
					else {
						System.out.println("無法攻擊");
						stopflag=1;
					}
					break;
				default:
					break;
			}
		}
		if(stopflag==0) {
			
			if(player2areahint[defend-1].length()==2) {
				switch(player2areahint[defend-1]) {
					case "A1":
						defendattack=((A1)player2area[defend-1]).attack;
						((A1)player2area[defend-1]).health-=offendattack;
						break;
					case "A2":
						defendattack=((A2)player2area[defend-1]).attack;
						((A2)player2area[defend-1]).health-=offendattack;
						break;
					case "B1":
						defendattack=((B1)player2area[defend-1]).attack;
						((B1)player2area[defend-1]).health-=offendattack;
						break;
					case "B2":
						defendattack=((B2)player2area[defend-1]).attack;
						((B2)player2area[defend-1]).health-=offendattack;
						break;
					case "C1":
						defendattack=((C1)player2area[defend-1]).attack;
						((C1)player2area[defend-1]).health-=offendattack;
						break;
					case "C2":
						defendattack=((C2)player2area[defend-1]).attack;
						((C2)player2area[defend-1]).health-=offendattack;
						break;
					case "D1":
						defendattack=((D1)player2area[defend-1]).attack;
						((D1)player2area[defend-1]).health-=offendattack;
						break;
					case "D2":
						defendattack=((D2)player2area[defend-1]).attack;
						((D2)player2area[defend-1]).health-=offendattack;
						break;
					case "E1":
						defendattack=((E1)player2area[defend-1]).attack;
						((E1)player2area[defend-1]).health-=offendattack;
						break;
					default:
						break;
				}
			}
			if(player1areahint[offend-1].length()==2) {
				switch(player1areahint[offend-1]) {
					case "A1":
						((A1)player1area[offend-1]).health-=defendattack;
						break;
					case "A2":
						((A2)player1area[offend-1]).health-=defendattack;
						break;
					case "B1":
						((B1)player1area[offend-1]).health-=defendattack;
						break;
					case "B2":
						((B2)player1area[offend-1]).health-=defendattack;
						break;
					case "C1":
						((C1)player1area[offend-1]).health-=defendattack;
						break;
					case "C2":
						((C2)player1area[offend-1]).health-=defendattack;
						break;
					case "D1":
						((D1)player1area[offend-1]).health-=defendattack;
						break;
					case "D2":
						((D2)player1area[offend-1]).health-=defendattack;
						break;
					case "E1":
						((E1)player1area[offend-1]).health-=defendattack;
						break;
					default:
						break;
				}
			}
			checkdead();
		}
	}

	private static void checkdead() {
		for(int i=0;i<6;i++) {
			if(player1areahint[i].length()==2) {
				switch(player1areahint[i]) {
					case "A1":
						if(((A1)player1area[i]).health<=0) {
							player1areahint[i]="";
							player1area[i]=null;
						}
						break;
					case "A2":
						if(((A2)player1area[i]).health<=0) {
							player1areahint[i]="";
							player1area[i]=null;
						}
						break;
					case "B1":
						if(((B1)player1area[i]).health<=0) {
							player1areahint[i]="";
							player1area[i]=null;
						}
						break;
					case "B2":
						if(((B2)player1area[i]).health<=0) {
							player1areahint[i]="";
							player1area[i]=null;
						}
						break;
					case "C1":
						if(((C1)player1area[i]).health<=0) {
							player1areahint[i]="";
							player1area[i]=null;
						}
						break;
					case "C2":
						if(((C2)player1area[i]).health<=0) {
							player1areahint[i]="";
							player1area[i]=null;
						}
						break;
					case "D1":
						if(((D1)player1area[i]).health<=0) {
							player1areahint[i]="";
							player1area[i]=null;
						}
						break;
					case "D2":
						if(((D2)player1area[i]).health<=0) {
							player1areahint[i]="";
							player1area[i]=null;
						}
						break;
					case "E1":
						if(((E1)player1area[i]).health<=0) {
							player1areahint[i]="";
							player1area[i]=null;
						}
						break;
					default:
						break;
				}
			}
			if(player2areahint[i].length()==2) {
				switch(player2areahint[i]) {
					case "A1":
						if(((A1)player2area[i]).health<=0) {
							player2areahint[i]="";
							player2area[i]=null;
						}
						break;
					case "A2":
						if(((A2)player2area[i]).health<=0) {
							player2areahint[i]="";
							player2area[i]=null;
						}
						break;
					case "B1":
						if(((B1)player2area[i]).health<=0) {
							player2areahint[i]="";
							player2area[i]=null;
						}
						break;
					case "B2":
						if(((B2)player2area[i]).health<=0) {
							player2areahint[i]="";
							player2area[i]=null;
						}
						break;
					case "C1":
						if(((C1)player2area[i]).health<=0) {
							player2areahint[i]="";
							player2area[i]=null;
						}
						break;
					case "C2":
						if(((C2)player2area[i]).health<=0) {
							player2areahint[i]="";
							player2area[i]=null;
						}
						break;
					case "D1":
						if(((D1)player2area[i]).health<=0) {
							player2areahint[i]="";
							player2area[i]=null;
						}
						break;
					case "D2":
						if(((D2)player2area[i]).health<=0) {
							player2areahint[i]="";
							player2area[i]=null;
						}
						break;
					case "E1":
						if(((E1)player2area[i]).health<=0) {
							player2areahint[i]="";
							player2area[i]=null;
						}
						break;
					default:
						break;
				}
			}
		}
	}

	private static void changeAttackFlagAndAction() {
		for(int i=0;i<6;i++) {
			if(player1areahint[i].length()==2) {
				switch(player1areahint[i]) {
					case "A1":
						((A1)player1area[i]).attackflag=1;
						((A1)player1area[i]).action=0;
						break;
					case "A2":
						((A2)player1area[i]).attackflag=1;
						((A2)player1area[i]).action=0;
						break;
					case "B1":
						((B1)player1area[i]).attackflag=1;
						((B1)player1area[i]).action=0;
						break;
					case "B2":
						((B2)player1area[i]).attackflag=1;
						((B2)player1area[i]).action=0;
						break;
					case "C1":
						((C1)player1area[i]).attackflag=1;
						((C1)player1area[i]).action=0;
						break;
					case "C2":
						((C2)player1area[i]).attackflag=1;
						((C2)player1area[i]).action=0;
						break;
					case "D1":
						((D1)player1area[i]).attackflag=1;
						((D1)player1area[i]).action=0;
						break;
					case "D2":
						((D2)player1area[i]).attackflag=1;
						((D2)player1area[i]).action=0;
						break;
					case "E1":
						((E1)player1area[i]).attackflag=1;
						((E1)player1area[i]).action=0;
						break;
					default:
						break;
				}
			}
			if(player2areahint[i].length()==2) {
				switch(player2areahint[i]) {
					case "A1":
						((A1)player2area[i]).attackflag=1;
						((A1)player2area[i]).action=0;
						break;
					case "A2":
						((A2)player2area[i]).attackflag=1;
						((A2)player2area[i]).action=0;
						break;
					case "B1":
						((B1)player2area[i]).attackflag=1;
						((B1)player2area[i]).action=0;
						break;
					case "B2":
						((B2)player2area[i]).attackflag=1;
						((B2)player2area[i]).action=0;
						break;
					case "C1":
						((C1)player2area[i]).attackflag=1;
						((C1)player2area[i]).action=0;
						break;
					case "C2":
						((C2)player2area[i]).attackflag=1;
						((C2)player2area[i]).action=0;
						break;
					case "D1":
						((D1)player2area[i]).attackflag=1;
						((D1)player2area[i]).action=0;
						break;
					case "D2":
						((D2)player2area[i]).attackflag=1;
						((D2)player2area[i]).action=0;
						break;
					case "E1":
						((E1)player2area[i]).attackflag=1;
						((E1)player2area[i]).action=0;
						break;
					default:
						break;
				}
			}
		}
	}

	private static void changestatus(int player,int place) {
		if(player==1) {
			switch(player1areahint[place-1]) {
				case "A1":
					if(((A1)player1area[place-1]).status==1) {
						((A1)player1area[place-1]).status=0;
					}	
					else {
						((A1)player1area[place-1]).status=1;
					}
					((A1)player1area[place-1]).action=1;
					break;
				case "A2":
					if(((A2)player1area[place-1]).status==1) {
						((A2)player1area[place-1]).status=0;
					}
					else {
						((A2)player1area[place-1]).status=1;
					}
					((A2)player1area[place-1]).action=1;
					break;
				case "B1":
					if(((B1)player1area[place-1]).status==1) {
						((B1)player1area[place-1]).status=0;
					}
					else {
						((B1)player1area[place-1]).status=1;
					}
					((B1)player1area[place-1]).action=1;
					break;
				case "B2":
					if(((B2)player1area[place-1]).status==1) {
						((B2)player1area[place-1]).status=0;
					}
					else {
						((B2)player1area[place-1]).status=1;
					}
					((B2)player1area[place-1]).action=1;
					break;
				case "C1":
					if(((C1)player1area[place-1]).status==1) {
						((C1)player1area[place-1]).status=0;
					}
					else {
						((C1)player1area[place-1]).status=1;
					}	
					((C1)player1area[place-1]).action=1;
					break;
				case "C2":
					if(((C2)player1area[place-1]).status==1) {
						((C2)player1area[place-1]).status=0;
					}
					else {
						((C2)player1area[place-1]).status=1;
					}
					((C2)player1area[place-1]).action=1;
					break;
				case "D1":
					if(((D1)player1area[place-1]).status==1) {
						((D1)player1area[place-1]).status=0;
					}
					else {
						((D1)player1area[place-1]).status=1;
					}	
					((D1)player1area[place-1]).action=1;
					break;
				case "D2":
					if(((D2)player1area[place-1]).status==1) {
						((D2)player1area[place-1]).status=0;
					}
					else {
						((D2)player1area[place-1]).status=1;
					}
					((D2)player1area[place-1]).action=1;
					break;
				case "E1":
					if(((E1)player1area[place-1]).status==1) {
						((E1)player1area[place-1]).status=0;
					}
					else {
						((E1)player1area[place-1]).status=1;
					}
					((E1)player1area[place-1]).action=1;
					break;
				default:
					break;
			}
		}
		else {
			switch(player2areahint[place-1]) {
				case "A1":
					if(((A1)player2area[place-1]).status==1) {
						((A1)player2area[place-1]).status=0;
					}	
					else {
						((A1)player2area[place-1]).status=1;
					}	
					((A1)player2area[place-1]).action=1;
					break;
				case "A2":
					if(((A2)player2area[place-1]).status==1) {
						((A2)player2area[place-1]).status=0;
					}
					else {
						((A2)player2area[place-1]).status=1;
					}
					((A2)player2area[place-1]).action=1;
					break;
				case "B1":
					if(((B1)player2area[place-1]).status==1) {
						((B1)player2area[place-1]).status=0;
					}
					else {
						((B1)player2area[place-1]).status=1;
					}
					((B1)player2area[place-1]).action=1;
					break;
				case "B2":
					if(((B2)player2area[place-1]).status==1) {
						((B2)player2area[place-1]).status=0;
					}
					else {
						((B2)player2area[place-1]).status=1;
					}
					((B2)player2area[place-1]).action=1;
					break;
				case "C1":
					if(((C1)player2area[place-1]).status==1) {
						((C1)player2area[place-1]).status=0;
					}
					else {
						((C1)player2area[place-1]).status=1;
					}	
					((C1)player2area[place-1]).action=1;
					break;
				case "C2":
					if(((C2)player2area[place-1]).status==1) {
						((C2)player2area[place-1]).status=0;
					}	
					else {
						((C2)player2area[place-1]).status=1;
					}
					((C2)player2area[place-1]).action=1;
					break;
				case "D1":
					if(((D1)player2area[place-1]).status==1) {
						((D1)player2area[place-1]).status=0;
					}	
					else {
						((D1)player2area[place-1]).status=1;
					}
					((D1)player2area[place-1]).action=1;
					break;
				case "D2":
					if(((D2)player2area[place-1]).status==1) {
						((D2)player2area[place-1]).status=0;
					}	
					else {
						((D2)player2area[place-1]).status=1;
					}
					((D2)player2area[place-1]).action=1;
					break;
				case "E1":
					if(((E1)player2area[place-1]).status==1) {
						((E1)player2area[place-1]).status=0;
					}
					else {
						((E1)player2area[place-1]).status=1;
					}
					((E1)player2area[place-1]).action=1;
					break;
				default:
					break;
			}
		}
	}

	private static void createcardobject(int player,String card,int place,String status,int round) {
		int statusnum=0;
		if(status.equals("attack")) {
			statusnum=1;
		}
		else {
			statusnum=0;
		}
		if(player==1) {
			switch(card) {
				case "A1":
					player1area[place-1]=new A1(statusnum);
					player1areahint[place-1]="A1";
					player1.crystal-=8;
					player1.cards.remove("A1");
					break;
				case "A2":
					player1area[place-1]=new A2(statusnum);
					player1areahint[place-1]="A2";
					player1.crystal-=1;
					player1.cards.remove("A2");
					break;
				case "B1":
					player1area[place-1]=new B1(statusnum);
					player1areahint[place-1]="B1";
					player1.crystal-=7;
					player1.cards.remove("B1");
					break;
				case "B2":
					player1area[place-1]=new B2(statusnum);
					player1areahint[place-1]="B2";
					player1.crystal-=5;
					player1.cards.remove("B2");
					break;
				case "C1":
					player1area[place-1]=new C1(statusnum);
					player1areahint[place-1]="C1";
					player1.crystal-=6;
					player1.cards.remove("C1");
					break;
				case "C2":
					player1area[place-1]=new C2(statusnum);
					player1areahint[place-1]="C2";
					player1.crystal-=4;
					player1.cards.remove("C2");
					break;
				case "D1":
					player1area[place-1]=new D1(statusnum);
					player1areahint[place-1]="D1";
					player1.crystal-=9;
					player1.cards.remove("D1");
					break;
				case "D2":
					player1area[place-1]=new D2(statusnum);
					player1areahint[place-1]="D2";
					player1.crystal-=3;
					player1.cards.remove("D2");
					break;
				case "E1":
					player1area[place-1]=new E1(statusnum);
					player1areahint[place-1]="E1";
					player1.crystal-=2;
					player1.cards.remove("E1");
					break;
				default:
					break;
			}			
		}
		else {
			switch(card) {
				case "A1":
					player2area[place-1]=new A1(statusnum);
					player2areahint[place-1]="A1";
					player2.crystal-=8;
					player2.cards.remove("A1");
					break;
				case "A2":
					player2area[place-1]=new A2(statusnum);
					player2areahint[place-1]="A2";
					player2.crystal-=1;
					player2.cards.remove("A2");
					break;
				case "B1":
					player2area[place-1]=new B1(statusnum);
					player2areahint[place-1]="B1";
					player2.crystal-=7;
					player2.cards.remove("B1");
					break;
				case "B2":
					player2area[place-1]=new B2(statusnum);
					player2areahint[place-1]="B2";
					player2.crystal-=5;
					player2.cards.remove("B2");
					break;
				case "C1":
					player2area[place-1]=new C1(statusnum);
					player2areahint[place-1]="C1";
					player2.crystal-=6;
					player2.cards.remove("C1");
					break;
				case "C2":
					player2area[place-1]=new C2(statusnum);
					player2areahint[place-1]="C2";
					player2.crystal-=4;
					player2.cards.remove("C2");
					break;
				case "D1":
					player2area[place-1]=new D1(statusnum);
					player2areahint[place-1]="D1";
					player2.crystal-=9;
					player2.cards.remove("D1");
					break;
				case "D2":
					player2area[place-1]=new D2(statusnum);
					player2areahint[place-1]="D2";
					player2.crystal-=3;
					player2.cards.remove("D2");
					break;
				case "E1":
					player2area[place-1]=new E1(statusnum);
					player2areahint[place-1]="E1";
					player2.crystal-=2;
					player2.cards.remove("E1");
					break;
				default:
					break;
			}			
		}
	}
}
