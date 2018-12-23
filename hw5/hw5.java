import java.util.Scanner;

public class hw5 {
	
	private static Object[] player1area=new Object[6];
	private static Object[] player2area=new Object[6];
	private static String[] player1areahint=new String[6];
	private static String[] player2areahint=new String[6];
	private static player player1=new player("player1");
	private static player player2=new player("player2");
	private static int roundflag=1;
	public static void main(String[] args) {
		
		int exit=0;
		int round=1;
		int checkatten=0;
		String[] instruction;
		for(int i=0;i<6;i++) {
			player1area[i]=null;
			player2area[i]=null;
			player1areahint[i]="";
			player2areahint[i]="";
		}
		Scanner scanner=new Scanner(System.in);
		System.out.println("Welcome to the game!!");
		System.out.println("輸入玩家名稱:");
		String[] getname=scanner.nextLine().split(" ");
		player1.name=getname[0];
		player1.careerandhealth(getname[1]);
		player2.name=getname[2];
		player2.careerandhealth(getname[3]);
		player1.drawcard(100);
		player2.drawcard(100);
		while(true) {
			if(exit==1){
				break;
			}
			if(roundflag==1) {
				player1.drawcard(round);
				while(true) {
					show();
					System.out.println("");
					System.out.println("指令:");
					instruction=scanner.nextLine().split(" ");
					if(instruction[0].equals("exit")) {
						exit=1;
						break;
					}
					else if(instruction[0].equals("finish")) {
						roundflag=2;
						break;
					}
					else if(instruction[0].equals("cast")) {
						playerability(1,instruction[2]);
					}
					else if(instruction[0].equals("select")) {
						createcardobject(1,instruction[1],Integer.parseInt(instruction[2].substring(1)),instruction[3]);
					}
					else if(instruction[0].equals("change")) {
						changestatus(1,Integer.parseInt(instruction[1].substring(1)));
					}
					else {
						if(instruction[2].equals("enemy")) {
							checkatten=hasdefend(2);
							if(checkatten==1){
								attackenemy(1,Integer.parseInt(instruction[0].substring(1)));
							}
							else{
								System.out.println("無法攻擊，因為場上有防禦的怪獸");
							}
							if(player2.health<=0){
								System.out.println(player1.name+" 獲勝");
								exit=1;
								break;
							}
						}
						else {
							attackcard(1,Integer.parseInt(instruction[0].substring(1)),Integer.parseInt(instruction[2].substring(1)),player2areahint[Integer.parseInt(instruction[2].substring(1,2))-1].substring(0,1));
							if(player2areahint.length==0&&player2.cards.size()==0&&player2.allcards.size()==0){
								System.out.println(player1.name+" 獲勝");
								exit=1;
								break;	
							}
						}
					}
				}
			}
			else {
				player2.drawcard(round);
				while(true) {
					show();
					System.out.println("");
					System.out.println("指令:");
					instruction=scanner.nextLine().split(" ");
					if(instruction[0].equals("exit")) {
						exit=1;
						break;
					}
					else if(instruction[0].equals("finish")) {
						roundflag=1;
						break;
					}
					else if(instruction[0].equals("select")) {
						createcardobject(2,instruction[1],Integer.parseInt(instruction[2].substring(1)),instruction[3]);
					}
					else if(instruction[0].equals("change")) {
						changestatus(2,Integer.parseInt(instruction[1].substring(1)));
					}
					else {
						if(instruction[2].equals("enemy")) {
							checkatten=hasdefend(1);
							if(checkatten==1){
								attackenemy(2,Integer.parseInt(instruction[0].substring(1)));	
							}
							else{
								System.out.println("無法攻擊，因為場上有防禦的怪獸");
							}
							if(player1.health<=0){
								System.out.println(player2.name+" 獲勝");
								exit=1;
								break;
							}
						}
						else {
							attackcard(2,Integer.parseInt(instruction[0].substring(1)),Integer.parseInt(instruction[2].substring(1)),player1areahint[Integer.parseInt(instruction[2].substring(1,2))-1].substring(0,1));
							if(player1areahint.length==0&&player1.cards.size()==0&&player1.allcards.size()==0){
								System.out.println(player2.name+" 獲勝");
								exit=1;
								break;	
							}
						}
					}
				}
				round+=1;
				changeAttackFlagAndAction();
				if(round>=10){
					player1.crystal=10;
					player2.crystal=10;
				}
				else{
					player1.crystal=round;
					player2.crystal=round;
				}
				player1.abilityflag=0;
				player1.abilityflag=0;
			}
		}
	}
	private static void playerability(int player,String victim) {
		if(player==1) {
			if(player1.abilityflag==0) {
				if(player1.career==0) {
					System.out.println("你沒有技能!!");
				}
				else if(player1.career==1) {
					if(player1.crystal>=2) {
						if(victim.equals("enemy")) {
							player1.crystal-=2;
							player2.health-=1;
						}
						else {
							player1.crystal-=2;
							switch(player2areahint[Integer.parseInt(victim.substring(1))-1]) {
								case "A1":
									((A1)player2area[Integer.parseInt(victim.substring(1))-1]).health-=1;
									break;
								case "A2":
									((A2)player2area[Integer.parseInt(victim.substring(1))-1]).health-=1;
									break;
								case "B1":
									((B1)player2area[Integer.parseInt(victim.substring(1))-1]).health-=1;
									break;
								case "B2":
									((B2)player2area[Integer.parseInt(victim.substring(1))-1]).health-=1;
									break;
								case "C1":
									((C1)player2area[Integer.parseInt(victim.substring(1))-1]).health-=1;
									break;
								case "C2":
									((C2)player2area[Integer.parseInt(victim.substring(1))-1]).health-=1;
									break;
								case "D1":
									((D1)player2area[Integer.parseInt(victim.substring(1))-1]).health-=1;
									break;
								case "D2":
									((D2)player2area[Integer.parseInt(victim.substring(1))-1]).health-=1;
									break;
								case "E1":
									((E1)player2area[Integer.parseInt(victim.substring(1))-1]).health-=1;
									break;
								default:
									break;
							}
						}
					}
					else {
						System.out.println("水晶不夠");
					}
				}
				else if(player1.career==2) {
					if(player1.crystal>=2) {
						if(victim.equals("myself")) {
							player1.crystal-=2;
							player1.health+=2;
							if(player1.health>=20) {
								player1.health=20;
							}
						}
						else {
							player1.crystal-=2;
							switch(player1areahint[Integer.parseInt(victim.substring(1))-1]) {
								case "A1":
									((A1)player1area[Integer.parseInt(victim.substring(1))-1]).health+=2;
									if(((A1)player1area[Integer.parseInt(victim.substring(1))-1]).health>=8) {
										((A1)player1area[Integer.parseInt(victim.substring(1))-1]).health=8;
									}
									break;
								case "A2":
									((A2)player1area[Integer.parseInt(victim.substring(1))-1]).health+=2;
									if(((A2)player1area[Integer.parseInt(victim.substring(1))-1]).health>=2) {
										((A2)player1area[Integer.parseInt(victim.substring(1))-1]).health=2;
									}
									break;
								case "B1":
									((B1)player1area[Integer.parseInt(victim.substring(1))-1]).health+=2;
									if(((B1)player1area[Integer.parseInt(victim.substring(1))-1]).health>=7) {
										((B1)player1area[Integer.parseInt(victim.substring(1))-1]).health=7;
									}
									break;
								case "B2":
									((B2)player1area[Integer.parseInt(victim.substring(1))-1]).health+=2;
									if(((B2)player1area[Integer.parseInt(victim.substring(1))-1]).health>=4) {
										((B2)player1area[Integer.parseInt(victim.substring(1))-1]).health=4;
									}
									break;
								case "C1":
									((C1)player1area[Integer.parseInt(victim.substring(1))-1]).health+=2;
									if(((C1)player1area[Integer.parseInt(victim.substring(1))-1]).health>=7) {
										((C1)player1area[Integer.parseInt(victim.substring(1))-1]).health=7;
									}
									break;
								case "C2":
									((C2)player1area[Integer.parseInt(victim.substring(1))-1]).health+=2;
									if(((C2)player1area[Integer.parseInt(victim.substring(1))-1]).health>=1) {
										((C2)player1area[Integer.parseInt(victim.substring(1))-1]).health=1;
									}
									break;
								case "D1":
									((D1)player1area[Integer.parseInt(victim.substring(1))-1]).health+=2;
									if(((D1)player1area[Integer.parseInt(victim.substring(1))-1]).health>=8) {
										((D1)player1area[Integer.parseInt(victim.substring(1))-1]).health=8;
									}
									break;
								case "D2":
									((D2)player1area[Integer.parseInt(victim.substring(1))-1]).health+=2;
									if(((D2)player1area[Integer.parseInt(victim.substring(1))-1]).health>=4) {
										((D2)player1area[Integer.parseInt(victim.substring(1))-1]).health=4;
									}
									break;
								case "E1":
									((E1)player1area[Integer.parseInt(victim.substring(1))-1]).health+=2;
									if(((E1)player1area[Integer.parseInt(victim.substring(1))-1]).health>=4) {
										((E1)player1area[Integer.parseInt(victim.substring(1))-1]).health=4;
									}
									break;
								default:
									break;
							}
						}
					}
					else {
						System.out.println("水晶不夠");
					}
				}
				else {
					if(player1.crystal>=2) {
						player1.crystal-=2;
						player2.health-=2;
					}
					else {
						System.out.println("水晶不夠");
					}
				}
				player1.abilityflag=1;
			}
			else {
				System.out.println("本回合已使用過");
			}
		}
		else {
			if(player2.abilityflag==0) {
				if(player2.career==0) {
					System.out.println("你沒有技能!!");
				}
				else if(player2.career==1) {
					if(player2.crystal>=2) {
						if(victim.equals("enemy")) {
							player2.crystal-=2;
							player1.health-=1;
						}
						else {
							player2.crystal-=2;
							switch(player1areahint[Integer.parseInt(victim.substring(1))-1]) {
								case "A1":
									((A1)player1area[Integer.parseInt(victim.substring(1))-1]).health-=1;
									break;
								case "A2":
									((A2)player1area[Integer.parseInt(victim.substring(1))-1]).health-=1;
									break;
								case "B1":
									((B1)player1area[Integer.parseInt(victim.substring(1))-1]).health-=1;
									break;
								case "B2":
									((B2)player1area[Integer.parseInt(victim.substring(1))-1]).health-=1;
									break;
								case "C1":
									((C1)player1area[Integer.parseInt(victim.substring(1))-1]).health-=1;
									break;
								case "C2":
									((C2)player1area[Integer.parseInt(victim.substring(1))-1]).health-=1;
									break;
								case "D1":
									((D1)player1area[Integer.parseInt(victim.substring(1))-1]).health-=1;
									break;
								case "D2":
									((D2)player1area[Integer.parseInt(victim.substring(1))-1]).health-=1;
									break;
								case "E1":
									((E1)player1area[Integer.parseInt(victim.substring(1))-1]).health-=1;
									break;
								default:
									break;
							}
						}
					}
					else {
						System.out.println("水晶不夠");
					}
				}
				else if(player2.career==2) {
					if(player2.crystal>=2) {
						if(victim.equals("myself")) {
							player2.crystal-=2;
							player2.health+=2;
							if(player2.health>=20) {
								player2.health=20;
							}
						}
						else {
							player2.crystal-=2;
							switch(player2areahint[Integer.parseInt(victim.substring(1))-1]) {
								case "A1":
									((A1)player2area[Integer.parseInt(victim.substring(1))-1]).health+=2;
									if(((A1)player2area[Integer.parseInt(victim.substring(1))-1]).health>=8) {
										((A1)player2area[Integer.parseInt(victim.substring(1))-1]).health=8;
									}
									break;
								case "A2":
									((A2)player2area[Integer.parseInt(victim.substring(1))-1]).health+=2;
									if(((A2)player2area[Integer.parseInt(victim.substring(1))-1]).health>=2) {
										((A2)player2area[Integer.parseInt(victim.substring(1))-1]).health=2;
									}
									break;
								case "B1":
									((B1)player2area[Integer.parseInt(victim.substring(1))-1]).health+=2;
									if(((B1)player2area[Integer.parseInt(victim.substring(1))-1]).health>=7) {
										((B1)player2area[Integer.parseInt(victim.substring(1))-1]).health=7;
									}
									break;
								case "B2":
									((B2)player2area[Integer.parseInt(victim.substring(1))-1]).health+=2;
									if(((B2)player2area[Integer.parseInt(victim.substring(1))-1]).health>=4) {
										((B2)player2area[Integer.parseInt(victim.substring(1))-1]).health=4;
									}
									break;
								case "C1":
									((C1)player2area[Integer.parseInt(victim.substring(1))-1]).health+=2;
									if(((C1)player2area[Integer.parseInt(victim.substring(1))-1]).health>=7) {
										((C1)player2area[Integer.parseInt(victim.substring(1))-1]).health=7;
									}
									break;
								case "C2":
									((C2)player2area[Integer.parseInt(victim.substring(1))-1]).health+=2;
									if(((C2)player2area[Integer.parseInt(victim.substring(1))-1]).health>=1) {
										((C2)player2area[Integer.parseInt(victim.substring(1))-1]).health=1;
									}
									break;
								case "D1":
									((D1)player2area[Integer.parseInt(victim.substring(1))-1]).health+=2;
									if(((D1)player2area[Integer.parseInt(victim.substring(1))-1]).health>=8) {
										((D1)player2area[Integer.parseInt(victim.substring(1))-1]).health=8;
									}
									break;
								case "D2":
									((D2)player2area[Integer.parseInt(victim.substring(1))-1]).health+=2;
									if(((D2)player2area[Integer.parseInt(victim.substring(1))-1]).health>=4) {
										((D2)player2area[Integer.parseInt(victim.substring(1))-1]).health=4;
									}
									break;
								case "E1":
									((E1)player2area[Integer.parseInt(victim.substring(1))-1]).health+=2;
									if(((E1)player2area[Integer.parseInt(victim.substring(1))-1]).health>=4) {
										((E1)player2area[Integer.parseInt(victim.substring(1))-1]).health=4;
									}
									break;
								default:
									break;
							}
						}
					}
					else {
						System.out.println("水晶不夠");
					}
				}
				else {
					if(player2.crystal>=2) {
						player2.crystal-=2;
						player1.health-=2;
					}
					else {
						System.out.println("水晶不夠");
					}
				}
				player2.abilityflag=1;
			}
			else {
				System.out.println("本回合已使用過");
			}
		}
	}
	private static void show() {
		String space=" ";
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("-----------------------------------------------------");
		if(roundflag==1) {
			System.out.println("Crystal-"+player1.crystal);
			System.out.println(player1.name+"'s turn");
		}
		else {
			System.out.println("Crystal-"+player2.crystal);
			System.out.println(player2.name+"'s turn");
		}
		System.out.println("-----------------------------------------------------");
		if(roundflag==1) {
			System.out.println(player1.name);
			System.out.println("HP: "+player1.health);
			System.out.print("Cards: ");
			for(int i=0;i<player1.cards.size();i++) {
				if(i==player1.cards.size()-1) {
					System.out.print(player1.cards.get(i));
				}
				else {
					System.out.print(player1.cards.get(i)+",");
				}
			}
			System.out.println("");
		}
		else {
			System.out.println(player1.name);
			System.out.println("HP: "+player1.health);
			System.out.println("Cards Number: "+player1.cards.size());
		}
		System.out.println("-----------------------------------------------------");
		for(int i=1;i<=4;i++) {
			System.out.printf("U%-18d",i);
		}
		System.out.println("");
		for(int i=0;i<4;i++) {
			if(player1areahint[i].length()==2) {
				System.out.printf("ID: %-15s",player1areahint[i]);
			}
			else {
				System.out.printf("%-19s",space);
			}
		}
		System.out.println("");
		for(int i=0;i<4;i++) {
			if(player1areahint[i].length()==2) {
				System.out.printf("ATK: %-3d",getattack(1,i));
				System.out.printf("HP: %-7d",gethealth(1,i));
			}
			else {
				System.out.printf("%-19s",space);
			}
		}
		System.out.println("");
		for(int i=0;i<4;i++) {
			if(player1areahint[i].length()==2) {
				System.out.printf("State: %-12s",getstate(1,i));
			}
			else {
				System.out.printf("%-19s",space);
			}
		}
		System.out.println("");
		System.out.println("");
		for(int i=5;i<=6;i++) {
			System.out.printf("U%-18d",i);
		}
		System.out.println("");
		for(int i=4;i<6;i++) {
			if(player1areahint[i].length()==2) {
				System.out.printf("ID: %-15s",player1areahint[i]);
			}
			else {
				System.out.printf("%-19s",space);
			}
		}
		System.out.println("");
		for(int i=4;i<6;i++) {
			if(player1areahint[i].length()==2) {
				System.out.printf("ATK: %-3d",getattack(1,i));
				System.out.printf("HP: %-7d",gethealth(1,i));
			}
			else {
				System.out.printf("%-19s",space);
			}
		}
		System.out.println("");
		for(int i=4;i<6;i++) {
			if(player1areahint[i].length()==2) {
				System.out.printf("State: %-12s",getstate(1,i));
			}
			else {
				System.out.printf("%-19s",space);
			}
		}
		System.out.println("");
		System.out.println("-----------------------------------------------------");
		for(int i=1;i<=4;i++) {
			System.out.printf("D%-18d",i);
		}
		System.out.println("");
		for(int i=0;i<4;i++) {
			if(player2areahint[i].length()==2) {
				System.out.printf("ID: %-15s",player2areahint[i]);
			}
			else {
				System.out.printf("%-19s",space);
			}
		}
		System.out.println("");
		for(int i=0;i<4;i++) {
			if(player2areahint[i].length()==2) {
				System.out.printf("ATK: %-3d",getattack(2,i));
				System.out.printf("HP: %-7d",gethealth(2,i));
			}
			else {
				System.out.printf("%-19s",space);
			}
		}
		System.out.println("");
		for(int i=0;i<4;i++) {
			if(player2areahint[i].length()==2) {
				System.out.printf("State: %-12s",getstate(2,i));
			}
			else {
				System.out.printf("%-19s",space);
			}
		}
		System.out.println("");
		System.out.println("");
		for(int i=5;i<=6;i++) {
			System.out.printf("D%-18d",i);
		}
		System.out.println("");
		for(int i=4;i<6;i++) {
			if(player2areahint[i].length()==2) {
				System.out.printf("ID: %-15s",player2areahint[i]);
			}
			else {
				System.out.printf("%-19s",space);
			}
		}
		System.out.println("");
		for(int i=4;i<6;i++) {
			if(player2areahint[i].length()==2) {
				System.out.printf("ATK: %-3d",getattack(2,i));
				System.out.printf("HP: %-7d",gethealth(2,i));
			}
			else {
				System.out.printf("%-19s",space);
			}
		}
		System.out.println("");
		for(int i=4;i<6;i++) {
			if(player2areahint[i].length()==2) {
				System.out.printf("State: %-12s",getstate(2,i));
			}
			else {
				System.out.printf("%-19s",space);
			}
		}
		System.out.println("");
		System.out.println("-----------------------------------------------------");
		if(roundflag==1) {
			System.out.println(player2.name);
			System.out.println("HP: "+player2.health);
			System.out.println("Cards Number: "+player2.cards.size());
		}
		else {
			System.out.println(player2.name);
			System.out.println("HP: "+player2.health);
			System.out.print("Cards: ");
			for(int i=0;i<player2.cards.size();i++) {
				if(i==player2.cards.size()-1) {
					System.out.print(player2.cards.get(i));
				}
				else {
					System.out.print(player2.cards.get(i)+",");
				}
			}
			System.out.println("");
		}
		System.out.println("-----------------------------------------------------");
		
	}
	private static int hasdefend(int player) {
		int answer=1;
		if(player==1) {
			if(player1areahint.length>0) {
				for(int i=0;i<player1areahint.length;i++) {
					switch(player1areahint[i]) {
						case "A1":
							answer*=((A1)player1area[i]).status;
							break;
						case "A2":
							answer*=((A2)player1area[i]).status;
							break;
						case "B1":
							answer*=((B1)player1area[i]).status;
							break;
						case "B2":
							answer*=((B2)player1area[i]).status;
							break;
						case "C1":
							answer*=((C1)player1area[i]).status;
							break;
						case "C2":
							answer*=((C2)player1area[i]).status;
							break;
						case "D1":
							answer*=((D1)player1area[i]).status;
							break;
						case "D2":
							answer*=((D2)player1area[i]).status;
							break;
						case "E1":
							answer*=((E1)player1area[i]).status;
							break;
						default:
							break;
					}
				}
				return answer;
			}
			else {
				return answer;
			}		
		}
		else {
			if(player2areahint.length>0) {
				for(int i=0;i<player2areahint.length;i++) {
					switch(player2areahint[i]) {
						case "A1":
							answer*=((A1)player2area[i]).status;
							break;
						case "A2":
							answer*=((A2)player2area[i]).status;
							break;
						case "B1":
							answer*=((B1)player2area[i]).status;
							break;
						case "B2":
							answer*=((B2)player2area[i]).status;
							break;
						case "C1":
							answer*=((C1)player2area[i]).status;
							break;
						case "C2":
							answer*=((C2)player2area[i]).status;
							break;
						case "D1":
							answer*=((D1)player2area[i]).status;
							break;
						case "D2":
							answer*=((D2)player2area[i]).status;
							break;
						case "E1":
							answer*=((E1)player2area[i]).status;
							break;
						default:
							break;
					}
				}
				return answer;
			}
			else {
				return answer;
			}	
		}
	}
	private static String getstate(int player, int i) {
		String state="";
		if(player==1) {
			switch(player1areahint[i]) {
				case "A1":
					if(((A1)player1area[i]).status==1){
						state="attack";
					}
					else {
						state="defense";
					}
					break;
				case "A2":
					if(((A2)player1area[i]).status==1){
						state="attack";
					}
					else {
						state="defense";
					}
					break;
				case "B1":
					if(((B1)player1area[i]).status==1){
						state="attack";
					}
					else {
						state="defense";
					}
					break;
				case "B2":
					if(((B2)player1area[i]).status==1){
						state="attack";
					}
					else {
						state="defense";
					}
					break;
				case "C1":
					if(((C1)player1area[i]).status==1){
						state="attack";
					}
					else {
						state="defense";
					}
					break;
				case "C2":
					if(((C2)player1area[i]).status==1){
						state="attack";
					}
					else {
						state="defense";
					}
					break;
				case "D1":
					if(((D1)player1area[i]).status==1){
						state="attack";
					}
					else {
						state="defense";
					}
					break;
				case "D2":
					if(((D2)player1area[i]).status==1){
						state="attack";
					}
					else {
						state="defense";
					}
					break;
				case "E1":
					if(((E1)player1area[i]).status==1){
						state="attack";
					}
					else {
						state="defense";
					}
					break;
				default:
					break;
			}
		}
		else {
			switch(player2areahint[i]) {
				case "A1":
					if(((A1)player2area[i]).status==1){
						state="attack";
					}
					else {
						state="defense";
					}
					break;
				case "A2":
					if(((A2)player2area[i]).status==1){
						state="attack";
					}
					else {
						state="defense";
					}
					break;
				case "B1":
					if(((B1)player2area[i]).status==1){
						state="attack";
					}
					else {
						state="defense";
					}
					break;
				case "B2":
					if(((B2)player2area[i]).status==1){
						state="attack";
					}
					else {
						state="defense";
					}
					break;
				case "C1":
					if(((C1)player2area[i]).status==1){
						state="attack";
					}
					else {
						state="defense";
					}
					break;
				case "C2":
					if(((C2)player2area[i]).status==1){
						state="attack";
					}
					else {
						state="defense";
					}
					break;
				case "D1":
					if(((D1)player2area[i]).status==1){
						state="attack";
					}
					else {
						state="defense";
					}
					break;
				case "D2":
					if(((D2)player2area[i]).status==1){
						state="attack";
					}
					else {
						state="defense";
					}
					break;
				case "E1":
					if(((E1)player2area[i]).status==1){
						state="attack";
					}
					else {
						state="defense";
					}
					break;
				default:
					break;
			}
		}
		return state;
	}
	private static int gethealth(int player,int i) {
		int health=0;
		if(player==1) {
			switch(player1areahint[i]) {
				case "A1":
					health=((A1)player1area[i]).health;
					break;
				case "A2":
					health=((A2)player1area[i]).health;
					break;
				case "B1":
					health=((B1)player1area[i]).health;
					break;
				case "B2":
					health=((B2)player1area[i]).health;
					break;
				case "C1":
					health=((C1)player1area[i]).health;
					break;
				case "C2":
					health=((C2)player1area[i]).health;
					break;
				case "D1":
					health=((D1)player1area[i]).health;
					break;
				case "D2":
					health=((D2)player1area[i]).health;
					break;
				case "E1":
					health=((E1)player1area[i]).health;
					break;
				default:
					break;
			}
		}
		else {
			switch(player2areahint[i]) {
				case "A1":
					health=((A1)player2area[i]).health;
					break;
				case "A2":
					health=((A2)player2area[i]).health;
					break;
				case "B1":
					health=((B1)player2area[i]).health;
					break;
				case "B2":
					health=((B2)player2area[i]).health;
					break;
				case "C1":
					health=((C1)player2area[i]).health;
					break;
				case "C2":
					health=((C2)player2area[i]).health;
					break;
				case "D1":
					health=((D1)player2area[i]).health;
					break;
				case "D2":
					health=((D2)player2area[i]).health;
					break;
				case "E1":
					health=((E1)player2area[i]).health;
					break;
				default:
					break;
			}
		}
		return health;
	}
	private static int getattack(int player,int i) {
		int attack=0;
		if(player==1) {
			switch(player1areahint[i]) {
				case "A1":
					attack=((A1)player1area[i]).attack;
					break;
				case "A2":
					attack=((A2)player1area[i]).attack;
					break;
				case "B1":
					attack=((B1)player1area[i]).attack;
					break;
				case "B2":
					attack=((B2)player1area[i]).attack;
					break;
				case "C1":
					attack=((C1)player1area[i]).attack;
					break;
				case "C2":
					attack=((C2)player1area[i]).attack;
					break;
				case "D1":
					attack=((D1)player1area[i]).attack;
					break;
				case "D2":
					attack=((D2)player1area[i]).attack;
					break;
				case "E1":
					attack=((E1)player1area[i]).attack;
					break;
				default:
					break;
			}
		}
		else {
			switch(player2areahint[i]) {
				case "A1":
					attack=((A1)player2area[i]).attack;
					break;
				case "A2":
					attack=((A2)player2area[i]).attack;
					break;
				case "B1":
					attack=((B1)player2area[i]).attack;
					break;
				case "B2":
					attack=((B2)player2area[i]).attack;
					break;
				case "C1":
					attack=((C1)player2area[i]).attack;
					break;
				case "C2":
					attack=((C2)player2area[i]).attack;
					break;
				case "D1":
					attack=((D1)player2area[i]).attack;
					break;
				case "D2":
					attack=((D2)player2area[i]).attack;
					break;
				case "E1":
					attack=((E1)player2area[i]).attack;
					break;
				default:
					break;
			}
		}
		return attack;
	}

	private static void attackenemy(int player,int offend) {
		int offendattack=0;
		int stopflag=0;
		if(player==1) {
			if(player1areahint[offend-1].length()==2) {
				switch(player1areahint[offend-1]) {
					case "A1":
						if(((A1)player1area[offend-1]).action==0&&((A1)player1area[offend-1]).attackflag==1&&((A1)player1area[offend-1]).status==1) {
							offendattack=((A1)player1area[offend-1]).attack;
							((A1)player1area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "A2":
						if(((A2)player1area[offend-1]).action==0&&((A2)player1area[offend-1]).attackflag==1&&((A2)player1area[offend-1]).status==1) {
							offendattack=((A2)player1area[offend-1]).attack;
							((A2)player1area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "B1":
						if(((B1)player1area[offend-1]).action==0&&((B1)player1area[offend-1]).attackflag==1&&((B1)player1area[offend-1]).status==1) {
							offendattack=((B1)player1area[offend-1]).attack;
							((B1)player1area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "B2":
						if(((B2)player1area[offend-1]).action==0&&((B2)player1area[offend-1]).attackflag==1&&((B2)player1area[offend-1]).status==1) {
							offendattack=((B2)player1area[offend-1]).attack;
							((B2)player1area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "C1":
						if(((C1)player1area[offend-1]).action==0&&((C1)player1area[offend-1]).attackflag==1&&((C1)player1area[offend-1]).status==1) {
							offendattack=((C1)player1area[offend-1]).attack;
							((C1)player1area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "C2":
						if(((C2)player1area[offend-1]).action==0&&((C2)player1area[offend-1]).attackflag==1&&((C2)player1area[offend-1]).status==1) {
							offendattack=((C2)player1area[offend-1]).attack;
							((C2)player1area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "D1":
						if(((D1)player1area[offend-1]).action==0&&((D1)player1area[offend-1]).attackflag==1&&((D1)player1area[offend-1]).status==1) {
							offendattack=((D1)player1area[offend-1]).attack;
							((D1)player1area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "D2":
						if(((D2)player1area[offend-1]).action==0&&((D2)player1area[offend-1]).attackflag==1&&((D2)player1area[offend-1]).status==1) {
							offendattack=((D2)player1area[offend-1]).attack;
							((D2)player1area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "E1":
						if(((E1)player1area[offend-1]).action==0&&((E1)player1area[offend-1]).attackflag==1&&((E1)player1area[offend-1]).status==1) {
							offendattack=((E1)player1area[offend-1]).attack;
							((E1)player1area[offend-1]).action=1;
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
				player2.health-=offendattack;
			}	
		}
		else {
			if(player2areahint[offend-1].length()==2) {
				switch(player2areahint[offend-1]) {
					case "A1":
						if(((A1)player2area[offend-1]).action==0&&((A1)player2area[offend-1]).attackflag==1&&((A1)player2area[offend-1]).status==1) {
							offendattack=((A1)player2area[offend-1]).attack;
							((A1)player2area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "A2":
						if(((A2)player2area[offend-1]).action==0&&((A2)player2area[offend-1]).attackflag==1&&((A2)player2area[offend-1]).status==1) {
							offendattack=((A2)player2area[offend-1]).attack;
							((A2)player2area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "B1":
						if(((B1)player2area[offend-1]).action==0&&((B1)player2area[offend-1]).attackflag==1&&((B1)player2area[offend-1]).status==1) {
							offendattack=((B1)player2area[offend-1]).attack;
							((B1)player2area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "B2":
						if(((B2)player2area[offend-1]).action==0&&((B2)player2area[offend-1]).attackflag==1&&((B2)player2area[offend-1]).status==1) {
							offendattack=((B2)player2area[offend-1]).attack;
							((B2)player2area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "C1":
						if(((C1)player2area[offend-1]).action==0&&((C1)player2area[offend-1]).attackflag==1&&((C1)player2area[offend-1]).status==1) {
							offendattack=((C1)player2area[offend-1]).attack;
							((C1)player2area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "C2":
						if(((C2)player2area[offend-1]).action==0&&((C2)player2area[offend-1]).attackflag==1&&((C2)player2area[offend-1]).status==1) {
							offendattack=((C2)player2area[offend-1]).attack;
							((C2)player2area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "D1":
						if(((D1)player2area[offend-1]).action==0&&((D1)player2area[offend-1]).attackflag==1&&((D1)player2area[offend-1]).status==1) {
							offendattack=((D1)player2area[offend-1]).attack;
							((D1)player2area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "D2":
						if(((D2)player2area[offend-1]).action==0&&((D2)player2area[offend-1]).attackflag==1&&((D2)player2area[offend-1]).status==1) {
							offendattack=((D2)player2area[offend-1]).attack;
							((D2)player2area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "E1":
						if(((E1)player2area[offend-1]).action==0&&((E1)player2area[offend-1]).attackflag==1&&((E1)player2area[offend-1]).status==1) {
							offendattack=((E1)player2area[offend-1]).attack;
							((E1)player2area[offend-1]).action=1;
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
				player1.health-=offendattack;
			}
		}
	}
	private static void attackcard(int player,int offend, int defend, String hint) {
		int offendattack=0;
		int defendattack=0;
		int stopflag=0;
		if(player==1) {
			if(player1areahint[offend-1].length()==2) {
				switch(player1areahint[offend-1]) {
					case "A1":
						if(((A1)player1area[offend-1]).action==0&&((A1)player1area[offend-1]).attackflag==1&&((A1)player1area[offend-1]).status==1) {
							offendattack=((A1)player1area[offend-1]).attack(hint,8);
							((A1)player1area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "A2":
						if(((A2)player1area[offend-1]).action==0&&((A2)player1area[offend-1]).attackflag==1&&((A2)player1area[offend-1]).status==1) {
							offendattack=((A2)player1area[offend-1]).attack(hint,0);
							((A2)player1area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "B1":
						if(((B1)player1area[offend-1]).action==0&&((B1)player1area[offend-1]).attackflag==1&&((B1)player1area[offend-1]).status==1) {
							offendattack=((B1)player1area[offend-1]).attack(hint,7);
							((B1)player1area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "B2":
						if(((B2)player1area[offend-1]).action==0&&((B2)player1area[offend-1]).attackflag==1&&((B2)player1area[offend-1]).status==1) {
							offendattack=((B2)player1area[offend-1]).attack(hint,6);
							((B2)player1area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "C1":
						if(((C1)player1area[offend-1]).action==0&&((C1)player1area[offend-1]).attackflag==1&&((C1)player1area[offend-1]).status==1) {
							offendattack=((C1)player1area[offend-1]).attack(hint,5);
							((C1)player1area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "C2":
						if(((C2)player1area[offend-1]).action==0&&((C2)player1area[offend-1]).attackflag==1&&((C2)player1area[offend-1]).status==1) {
							offendattack=((C2)player1area[offend-1]).attack(hint,6);
							((C2)player1area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "D1":
						if(((D1)player1area[offend-1]).action==0&&((D1)player1area[offend-1]).attackflag==1&&((D1)player1area[offend-1]).status==1) {
							offendattack=((D1)player1area[offend-1]).attack(hint,10);
							((D1)player1area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "D2":
						if(((D2)player1area[offend-1]).action==0&&((D2)player1area[offend-1]).attackflag==1&&((D2)player1area[offend-1]).status==1) {
							offendattack=((D2)player1area[offend-1]).attack(hint,3);
							((D2)player1area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "E1":
						if(((E1)player1area[offend-1]).action==0&&((E1)player1area[offend-1]).attackflag==1&&((E1)player1area[offend-1]).status==1) {
							offendattack=((E1)player1area[offend-1]).attack(hint,0);
							((E1)player1area[offend-1]).action=1;
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
		else {
			if(player2areahint[offend-1].length()==2) {
				switch(player2areahint[offend-1]) {
					case "A1":
						if(((A1)player2area[offend-1]).action==0&&((A1)player2area[offend-1]).attackflag==1&&((A1)player2area[offend-1]).status==1) {
							offendattack=((A1)player2area[offend-1]).attack(hint,8);
							((A1)player2area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "A2":
						if(((A2)player2area[offend-1]).action==0&&((A2)player2area[offend-1]).attackflag==1&&((A2)player2area[offend-1]).status==1) {
							offendattack=((A2)player2area[offend-1]).attack(hint,0);
							((A2)player2area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "B1":
						if(((B1)player2area[offend-1]).action==0&&((B1)player2area[offend-1]).attackflag==1&&((B1)player2area[offend-1]).status==1) {
							offendattack=((B1)player2area[offend-1]).attack(hint,7);
							((B1)player2area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "B2":
						if(((B2)player2area[offend-1]).action==0&&((B2)player2area[offend-1]).attackflag==1&&((B2)player2area[offend-1]).status==1) {
							offendattack=((B2)player2area[offend-1]).attack(hint,6);
							((B2)player2area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "C1":
						if(((C1)player2area[offend-1]).action==0&&((C1)player2area[offend-1]).attackflag==1&&((C1)player2area[offend-1]).status==1) {
							offendattack=((C1)player2area[offend-1]).attack(hint,5);
							((C1)player2area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "C2":
						if(((C2)player2area[offend-1]).action==0&&((C2)player2area[offend-1]).attackflag==1&&((C2)player2area[offend-1]).status==1) {
							offendattack=((C2)player2area[offend-1]).attack(hint,6);
							((C2)player2area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "D1":
						if(((D1)player2area[offend-1]).action==0&&((D1)player2area[offend-1]).attackflag==1&&((D1)player2area[offend-1]).status==1) {
							offendattack=((D1)player2area[offend-1]).attack(hint,10);
							((D1)player2area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "D2":
						if(((D2)player2area[offend-1]).action==0&&((D2)player2area[offend-1]).attackflag==1&&((D2)player2area[offend-1]).status==1) {
							offendattack=((D2)player2area[offend-1]).attack(hint,3);
							((D2)player2area[offend-1]).action=1;
						}
						else {
							System.out.println("無法攻擊");
							stopflag=1;
						}
						break;
					case "E1":
						if(((E1)player2area[offend-1]).action==0&&((E1)player2area[offend-1]).attackflag==1&&((E1)player2area[offend-1]).status==1) {
							offendattack=((E1)player2area[offend-1]).attack(hint,0);
							((E1)player2area[offend-1]).action=1;
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
				
				if(player1areahint[defend-1].length()==2) {
					switch(player1areahint[defend-1]) {
						case "A1":
							defendattack=((A1)player1area[defend-1]).attack;
							((A1)player1area[defend-1]).health-=offendattack;
							break;
						case "A2":
							defendattack=((A2)player1area[defend-1]).attack;
							((A2)player1area[defend-1]).health-=offendattack;
							break;
						case "B1":
							defendattack=((B1)player1area[defend-1]).attack;
							((B1)player1area[defend-1]).health-=offendattack;
							break;
						case "B2":
							defendattack=((B2)player1area[defend-1]).attack;
							((B2)player1area[defend-1]).health-=offendattack;
							break;
						case "C1":
							defendattack=((C1)player1area[defend-1]).attack;
							((C1)player1area[defend-1]).health-=offendattack;
							break;
						case "C2":
							defendattack=((C2)player1area[defend-1]).attack;
							((C2)player1area[defend-1]).health-=offendattack;
							break;
						case "D1":
							defendattack=((D1)player1area[defend-1]).attack;
							((D1)player1area[defend-1]).health-=offendattack;
							break;
						case "D2":
							defendattack=((D2)player1area[defend-1]).attack;
							((D2)player1area[defend-1]).health-=offendattack;
							break;
						case "E1":
							defendattack=((E1)player1area[defend-1]).attack;
							((E1)player1area[defend-1]).health-=offendattack;
							break;
						default:
							break;
					}
				}
				if(player2areahint[offend-1].length()==2) {
					switch(player2areahint[offend-1]) {
						case "A1":
							((A1)player2area[offend-1]).health-=defendattack;
							break;
						case "A2":
							((A2)player2area[offend-1]).health-=defendattack;
							break;
						case "B1":
							((B1)player2area[offend-1]).health-=defendattack;
							break;
						case "B2":
							((B2)player2area[offend-1]).health-=defendattack;
							break;
						case "C1":
							((C1)player2area[offend-1]).health-=defendattack;
							break;
						case "C2":
							((C2)player2area[offend-1]).health-=defendattack;
							break;
						case "D1":
							((D1)player2area[offend-1]).health-=defendattack;
							break;
						case "D2":
							((D2)player2area[offend-1]).health-=defendattack;
							break;
						case "E1":
							((E1)player2area[offend-1]).health-=defendattack;
							break;
						default:
							break;
					}
				}
				checkdead();
			}
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

	private static void createcardobject(int player,String card,int place,String status) {
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
					if(player1.cards.contains("A1")==false){
						System.out.println("手中牌組沒有A1");
					}
					else if(player1.crystal-8<0){
						System.out.println("水晶不夠，無法召喚");
					}
					else{
						player1area[place-1]=new A1(statusnum);
						player1areahint[place-1]="A1";
						player1.crystal-=8;
						player1.cards.remove("A1");
						((A1)player1area[place-1]).ability(1, place-1, player1area, player2area, player1areahint, player2areahint);
					}
						break;
				case "A2":
					if(player1.cards.contains("A2")==false){
						System.out.println("手中牌組沒有A2");
					}
					else if(player1.crystal-1<0){
						System.out.println("水晶不夠，無法召喚");
					}
					else{
						player1area[place-1]=new A2(statusnum);
						player1areahint[place-1]="A2";
						player1.crystal-=1;
						player1.cards.remove("A2");
						((A2)player1area[place-1]).ability(1, place-1, player1area, player2area, player1areahint, player2areahint);
					}
					break;

				case "B1":
					if(player1.cards.contains("B1")==false){
						System.out.println("手中牌組沒有B1");
					}
					else if(player1.crystal-7<0){
						System.out.println("水晶不夠，無法召喚");
					}
					else{
						player1area[place-1]=new B1(statusnum);
						player1areahint[place-1]="B1";
						player1.crystal-=7;
						player1.cards.remove("B1");
						((B1)player1area[place-1]).ability(1, player1area, player2area, player1areahint, player2areahint);
					}
					break;
				case "B2":
					if(player1.cards.contains("B2")==false){
						System.out.println("手中牌組沒有B2");
					}
					else if(player1.crystal-5<0){
						System.out.println("水晶不夠，無法召喚");
					}
					else{
						player1area[place-1]=new B2(statusnum);
						player1areahint[place-1]="B2";
						player1.crystal-=5;
						player1.cards.remove("B2");
						((B2)player1area[place-1]).ability(1, player1area, player2area, player1areahint, player2areahint);
					}
					break;
				case "C1":
					if(player1.cards.contains("C1")==false){
						System.out.println("手中牌組沒有C1");
					}
					else if(player1.crystal-6<0){
						System.out.println("水晶不夠，無法召喚");
					}
					else{
						player1area[place-1]=new C1(statusnum);
						player1areahint[place-1]="C1";
						player1.crystal-=6;
						player1.cards.remove("C1");
						((C1)player1area[place-1]).ability(1, place-1, player1area, player2area, player1areahint, player2areahint);
						player1.health+=1;
						switch(player1.career) {
							case 0:
								if(player1.health>=40) {
									player1.health=40;
								}
								break;
							case 1:
								if(player1.health>=20) {
									player1.health=20;
								}
								break;
							case 2:
								if(player1.health>=20) {
									player1.health=20;
								}
								break;
							case 3:
								if(player1.health>=16) {
									player1.health=16;
								}
								break;
							default:
								break;
						}
					}
					break;
				case "C2":
					if(player1.cards.contains("C2")==false){
						System.out.println("手中牌組沒有C2");
					}
					else if(player1.crystal-4<0){
						System.out.println("水晶不夠，無法召喚");
					}
					else{
						player1area[place-1]=new C2(statusnum);
						player1areahint[place-1]="C2";
						player1.crystal-=4;
						player1.cards.remove("C2");
						((C2)player1area[place-1]).ability(1, place-1, player1area, player2area, player1areahint, player2areahint);
						player1.health+=1;
						switch(player1.career) {
							case 0:
								if(player1.health>=40) {
									player1.health=40;
								}
								break;
							case 1:
								if(player1.health>=20) {
									player1.health=20;
								}
								break;
							case 2:
								if(player1.health>=20) {
									player1.health=20;
								}
								break;
							case 3:
								if(player1.health>=16) {
									player1.health=16;
								}
								break;
							default:
								break;
						}
					}
					break;
				case "D1":
					if(player1.cards.contains("D1")==false){
						System.out.println("手中牌組沒有D1");
					}
					else if(player1.crystal-9<0){
						System.out.println("水晶不夠，無法召喚");
					}
					else{
						player1area[place-1]=new D1(statusnum);
						player1areahint[place-1]="D1";
						player1.crystal-=9;
						player1.cards.remove("D1");
						((D1)player1area[place-1]).ability(1, player1, player2);
					}
					break;
				case "D2":
					if(player1.cards.contains("D2")==false){
						System.out.println("手中牌組沒有D2");
					}
					else if(player1.crystal-3<0){
						System.out.println("水晶不夠，無法召喚");
					}
					else{
						player1area[place-1]=new D2(statusnum);
						player1areahint[place-1]="D2";
						player1.crystal-=3;
						player1.cards.remove("D2");
						((D2)player1area[place-1]).ability(1, player1, player2);
					}
					break;
				case "E1":
					if(player1.cards.contains("E1")==false){
						System.out.println("手中牌組沒有E1");
					}
					else if(player1.crystal-2<0){
						System.out.println("水晶不夠，無法召喚");
					}
					else{
						player1area[place-1]=new E1(statusnum);
						player1areahint[place-1]="E1";
						player1.crystal-=2;
						player1.cards.remove("E1");
						((E1)player1area[place-1]).ability(1, place-1, player1area, player2area, player1areahint, player2areahint);
					}
					break;
				default:
					break;
			}			
		}
		else {
			switch(card) {
				case "A1":
					if(player2.cards.contains("A1")==false){
						System.out.println("手中牌組沒有A1");
					}
					else if(player2.crystal-8<0){
						System.out.println("水晶不夠，無法召喚");
					}
					else{
						player2area[place-1]=new A1(statusnum);
						player2areahint[place-1]="A1";
						player2.crystal-=8;
						player2.cards.remove("A1");
						((A1)player2area[place-1]).ability(2, place-1, player1area, player2area, player1areahint, player2areahint);
					}
					break;
				case "A2":
					if(player2.cards.contains("A2")==false){
						System.out.println("手中牌組沒有A2");
					}
					else if(player2.crystal-1<0){
						System.out.println("水晶不夠，無法召喚");
					}
					else{
						player2area[place-1]=new A2(statusnum);
						player2areahint[place-1]="A2";
						player2.crystal-=1;
						player2.cards.remove("A2");
						((A2)player2area[place-1]).ability(2, place-1, player1area, player2area, player1areahint, player2areahint);
					}
					break;
				case "B1":
					if(player2.cards.contains("B1")==false){
						System.out.println("手中牌組沒有B1");
					}
					else if(player2.crystal-7<0){
						System.out.println("水晶不夠，無法召喚");
					}
					else{
						player2area[place-1]=new B1(statusnum);
						player2areahint[place-1]="B1";
						player2.crystal-=7;
						player2.cards.remove("B1");
						((B1)player2area[place-1]).ability(2, player1area, player2area, player1areahint, player2areahint);
					}
					break;
				case "B2":
					if(player2.cards.contains("B2")==false){
						System.out.println("手中牌組沒有B2");
					}
					else if(player2.crystal-5<0){
						System.out.println("水晶不夠，無法召喚");
					}
					else{
						player2area[place-1]=new B2(statusnum);
						player2areahint[place-1]="B2";
						player2.crystal-=5;
						player2.cards.remove("B2");
						((B2)player2area[place-1]).ability(2, player1area, player2area, player1areahint, player2areahint);
					}
					break;
				case "C1":
					if(player2.cards.contains("C1")==false){
						System.out.println("手中牌組沒有C1");
					}
					else if(player2.crystal-6<0){
						System.out.println("水晶不夠，無法召喚");
					}
					else{
						player2area[place-1]=new C1(statusnum);
						player2areahint[place-1]="C1";
						player2.crystal-=6;
						player2.cards.remove("C1");
						((C1)player2area[place-1]).ability(2, place-1, player1area, player2area, player1areahint, player2areahint);
						player2.health+=1;
						switch(player2.career) {
							case 0:
								if(player2.health>=40) {
									player2.health=40;
								}
								break;
							case 1:
								if(player2.health>=20) {
									player2.health=20;
								}
								break;
							case 2:
								if(player2.health>=20) {
									player2.health=20;
								}
								break;
							case 3:
								if(player2.health>=16) {
									player2.health=16;
								}
								break;
							default:
								break;
						}
					}
					break;
				case "C2":
					if(player2.cards.contains("C2")==false){
						System.out.println("手中牌組沒有C2");
					}
					else if(player2.crystal-4<0){
						System.out.println("水晶不夠，無法召喚");
					}
					else{
						player2area[place-1]=new C2(statusnum);
						player2areahint[place-1]="C2";
						player2.crystal-=4;
						player2.cards.remove("C2");
						((C2)player2area[place-1]).ability(2, place-1, player1area, player2area, player1areahint, player2areahint);
						player2.health+=1;
						switch(player2.career) {
							case 0:
								if(player2.health>=40) {
									player2.health=40;
								}
								break;
							case 1:
								if(player2.health>=20) {
									player2.health=20;
								}
								break;
							case 2:
								if(player2.health>=20) {
									player2.health=20;
								}
								break;
							case 3:
								if(player2.health>=16) {
									player2.health=16;
								}
								break;
							default:
								break;
						}
					}
					break;
				case "D1":
					if(player2.cards.contains("D1")==false){
						System.out.println("手中牌組沒有D1");
					}
					else if(player2.crystal-9<0){
						System.out.println("水晶不夠，無法召喚");
					}
					else{
						player2area[place-1]=new D1(statusnum);
						player2areahint[place-1]="D1";
						player2.crystal-=9;
						player2.cards.remove("D1");
						((D1)player2area[place-1]).ability(2, player1, player2);
					}
					break;
				case "D2":
					if(player2.cards.contains("D2")==false){
						System.out.println("手中牌組沒有D2");
					}
					else if(player2.crystal-3<0){
						System.out.println("水晶不夠，無法召喚");
					}
					else{
						player2area[place-1]=new D2(statusnum);
						player2areahint[place-1]="D2";
						player2.crystal-=3;
						player2.cards.remove("D2");
						((D2)player2area[place-1]).ability(2, player1, player2);
					}
					break;
				case "E1":
					if(player2.cards.contains("E1")==false){
						System.out.println("手中牌組沒有E1");
					}
					else if(player2.crystal-2<0){
						System.out.println("水晶不夠，無法召喚");
					}
					else{
						player2area[place-1]=new E1(statusnum);
						player2areahint[place-1]="E1";
						player2.crystal-=2;
						player2.cards.remove("E1");
						((E1)player2area[place-1]).ability(2, place-1, player1area, player2area, player1areahint, player2areahint);
					}
					break;
				default:
					break;
			}			
		}
	}
}
