public class windCard {
	int attack;
	int health;
	int crystal;
	int status;
	int attackflag;
	int action;
	int attack(String card,int attack) {
		if(card.equals("B")) {
			attack=attack-1;
			if(attack<0){
				attack=0;
			}
		}
		else if(card.equals("D")) {
			attack=attack+1;
		}
		else {
			attack=attack;
		}
		return attack;
	}
	void ability(int player,int place,Object[] player1area,Object[] player2area,String[] player1areahint,String[] player2areahint) {
		if(player==1) {
			for(int i=0;i<=5;i++) {
				if(i==place) {
					continue;
				}
				else {
					if(player1areahint[i].length()==2) {
						switch(player1areahint[i]){
							case "A1":
								((A1)player1area[i]).health+=1;
								if(((A1)player1area[i]).health>=8) {
									((A1)player1area[i]).health=8;
								}
								break;
							case "A2":
								((A2)player1area[i]).health+=1;
								if(((A2)player1area[i]).health>=2) {
									((A2)player1area[i]).health=2;
								}
								break;
							case "B1":
								((B1)player1area[i]).health+=1;
								if(((B1)player1area[i]).health>=7) {
									((B1)player1area[i]).health=7;
								}
								break;
							case "B2":
								((B2)player1area[i]).health+=1;
								if(((B2)player1area[i]).health>=4) {
									((B2)player1area[i]).health=4;
								}
								break;
							case "C1":
								((C1)player1area[i]).health+=1;
								if(((C1)player1area[i]).health>=7) {
									((C1)player1area[i]).health=7;
								}
								break;
							case "C2":
								((C2)player1area[i]).health+=1;
								if(((C2)player1area[i]).health>=1) {
									((C2)player1area[i]).health=1;
								}
								break;
							case "D1":
								((D1)player1area[i]).health+=1;
								if(((D1)player1area[i]).health>=8) {
									((D1)player1area[i]).health=8;
								}
								break;
							case "D2":
								((D2)player1area[i]).health+=1;
								if(((D2)player1area[i]).health>=4) {
									((D2)player1area[i]).health=4;
								}
								break;
							case "E1":
								((E1)player1area[i]).health+=1;
								if(((E1)player1area[i]).health>=4) {
									((E1)player1area[i]).health=4;
								}
								break;
							default:
								break;
						}
					}
				}
			}
		}
		else {
			for(int i=0;i<=5;i++) {
				if(i==place) {
					continue;
				}
				else {
					if(player2areahint[i].length()==2) {
						switch(player2areahint[i]){
							case "A1":
								((A1)player2area[i]).health+=1;
								if(((A1)player2area[i]).health>=8) {
									((A1)player2area[i]).health=8;
								}
								break;
							case "A2":
								((A2)player2area[i]).health+=1;
								if(((A2)player2area[i]).health>=2) {
									((A2)player2area[i]).health=2;
								}
								break;
							case "B1":
								((B1)player2area[i]).health+=1;
								if(((B1)player2area[i]).health>=7) {
									((B1)player2area[i]).health=7;
								}
								break;
							case "B2":
								((B2)player2area[i]).health+=1;
								if(((B2)player2area[i]).health>=4) {
									((B2)player2area[i]).health=4;
								}
								break;
							case "C1":
								((C1)player2area[i]).health+=1;
								if(((C1)player2area[i]).health>=7) {
									((C1)player2area[i]).health=7;
								}
								break;
							case "C2":
								((C2)player2area[i]).health+=1;
								if(((C2)player2area[i]).health>=1) {
									((C2)player2area[i]).health=1;
								}
								break;
							case "D1":
								((D1)player2area[i]).health+=1;
								if(((D1)player2area[i]).health>=8) {
									((D1)player2area[i]).health=8;
								}
								break;
							case "D2":
								((D2)player2area[i]).health+=1;
								if(((D2)player2area[i]).health>=4) {
									((D2)player2area[i]).health=4;
								}
								break;
							case "E1":
								((E1)player2area[i]).health+=1;
								if(((E1)player2area[i]).health>=4) {
									((E1)player2area[i]).health=4;
								}
								break;
							default:
								break;
						}
					}
				}
			}
		}
	}
}