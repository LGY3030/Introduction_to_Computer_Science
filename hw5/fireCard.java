public class fireCard {
	int attack;
	int health;
	int crystal;
	int status;
	int attackflag;
	int action;
	int attack(String card,int attack) {
		if(card.equals("A")) {
			attack=attack-1;
			if(attack<0){
				attack=0;
			}
		}
		else if(card.equals("C")) {
			attack=attack+1;
		}
		else {
			attack=attack;
		}
		return attack;
	}
	void ability(int player,Object[] player1area,Object[] player2area,String[] player1areahint,String[] player2areahint) {
		if(player==1) {
			for(int i=0;i<=5;i++) {
				if(player2areahint[i].length()==2) {
					switch(player2areahint[i]){
						case "A1":
							((A1)player2area[i]).health-=1;
							break;
						case "A2":
							((A2)player2area[i]).health-=1;
							break;
						case "B1":
							((B1)player2area[i]).health-=1;
							break;
						case "B2":
							((B2)player2area[i]).health-=1;
							break;
						case "C1":
							((C1)player2area[i]).health-=1;
							break;
						case "C2":
							((C2)player2area[i]).health-=1;
							break;
						case "D1":
							((D1)player2area[i]).health-=1;
							break;
						case "D2":
							((D2)player2area[i]).health-=1;
							break;
						case "E1":
							((E1)player2area[i]).health-=1;
							break;
						default:
							break;
					}
				}
			}
		}
		else {
			for(int i=0;i<=5;i++) {
				if(player1areahint[i].length()==2) {
					switch(player1areahint[i]){
						case "A1":
							((A1)player1area[i]).attack+=1;
							break;
						case "A2":
							((A2)player1area[i]).attack+=1;
							break;
						case "B1":
							((B1)player1area[i]).attack+=1;
							break;
						case "B2":
							((B2)player1area[i]).attack+=1;
							break;
						case "C1":
							((C1)player1area[i]).health-=1;
							break;
						case "C2":
							((C2)player1area[i]).health-=1;
							break;
						case "D1":
							((D1)player1area[i]).health-=1;
							break;
						case "D2":
							((D2)player1area[i]).health-=1;
							break;
						case "E1":
							((E1)player1area[i]).health-=1;
							break;
						default:
							break;
					}
				}
			}
		}
	}
}

