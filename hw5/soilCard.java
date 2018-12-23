public class soilCard {
	int attack;
	int health;
	int crystal;
	int status;
	int attackflag;
	int action;
	int attack(String card,int attack) {
		if(card.equals("D")) {
			attack=attack-1;
			if(attack<0){
				attack=0;
			}
		}
		else if(card.equals("A")) {
			attack=attack+1;
		}
		else {
			attack=attack;
		}
		return attack;
	}
	void ability(int player,int place,Object[] player1area,Object[] player2area,String[] player1areahint,String[] player2areahint) {
		if(player==1) {
			if(place==0) {
				if(player1areahint[place+1].length()==2) {
					switch(player1areahint[place+1]){
						case "A1":
							((A1)player1area[place+1]).attack+=1;
							break;
						case "A2":
							((A2)player1area[place+1]).attack+=1;
							break;
						case "B1":
							((B1)player1area[place+1]).attack+=1;
							break;
						case "B2":
							((B2)player1area[place+1]).attack+=1;
							break;
						case "C1":
							((C1)player1area[place+1]).attack+=1;
							break;
						case "C2":
							((C2)player1area[place+1]).attack+=1;
							break;
						case "D1":
							((D1)player1area[place+1]).attack+=1;
							break;
						case "D2":
							((D2)player1area[place+1]).attack+=1;
							break;
						case "E1":
							((E1)player1area[place+1]).attack+=1;
							break;
						default:
							break;
					}
				}
			}
			else if(place>=1&&place<=4) {
				if(player1areahint[place+1].length()==2) {
					switch(player1areahint[place+1]){
						case "A1":
							((A1)player1area[place+1]).attack+=1;
							break;
						case "A2":
							((A2)player1area[place+1]).attack+=1;
							break;
						case "B1":
							((B1)player1area[place+1]).attack+=1;
							break;
						case "B2":
							((B2)player1area[place+1]).attack+=1;
							break;
						case "C1":
							((C1)player1area[place+1]).attack+=1;
							break;
						case "C2":
							((C2)player1area[place+1]).attack+=1;
							break;
						case "D1":
							((D1)player1area[place+1]).attack+=1;
							break;
						case "D2":
							((D2)player1area[place+1]).attack+=1;
							break;
						case "E1":
							((E1)player1area[place+1]).attack+=1;
							break;
						default:
							break;
					}
				}
				if(player1areahint[place-1].length()==2) {
					switch(player1areahint[place-1]){
						case "A1":
							((A1)player1area[place-1]).attack+=1;
							break;
						case "A2":
							((A2)player1area[place-1]).attack+=1;
							break;
						case "B1":
							((B1)player1area[place-1]).attack+=1;
							break;
						case "B2":
							((B2)player1area[place-1]).attack+=1;
							break;
						case "C1":
							((C1)player1area[place-1]).attack+=1;
							break;
						case "C2":
							((C2)player1area[place-1]).attack+=1;
							break;
						case "D1":
							((D1)player1area[place-1]).attack+=1;
							break;
						case "D2":
							((D2)player1area[place-1]).attack+=1;
							break;
						case "E1":
							((E1)player1area[place-1]).attack+=1;
							break;
						default:
							break;
					}
				}
			}
			else {
				if(player1areahint[place-1].length()==2) {
					switch(player1areahint[place-1]){
						case "A1":
							((A1)player1area[place-1]).attack+=1;
							break;
						case "A2":
							((A2)player1area[place-1]).attack+=1;
							break;
						case "B1":
							((B1)player1area[place-1]).attack+=1;
							break;
						case "B2":
							((B2)player1area[place-1]).attack+=1;
							break;
						case "C1":
							((C1)player1area[place-1]).attack+=1;
							break;
						case "C2":
							((C2)player1area[place-1]).attack+=1;
							break;
						case "D1":
							((D1)player1area[place-1]).attack+=1;
							break;
						case "D2":
							((D2)player1area[place-1]).attack+=1;
							break;
						case "E1":
							((E1)player1area[place-1]).attack+=1;
							break;
						default:
							break;
					}
				}
			}
		}
		else {
			if(place==0) {
				if(player2areahint[place+1].length()==2) {
					switch(player2areahint[place+1]){
						case "A1":
							((A1)player2area[place+1]).attack+=1;
							break;
						case "A2":
							((A2)player2area[place+1]).attack+=1;
							break;
						case "B1":
							((B1)player2area[place+1]).attack+=1;
							break;
						case "B2":
							((B2)player2area[place+1]).attack+=1;
							break;
						case "C1":
							((C1)player2area[place+1]).attack+=1;
							break;
						case "C2":
							((C2)player2area[place+1]).attack+=1;
							break;
						case "D1":
							((D1)player2area[place+1]).attack+=1;
							break;
						case "D2":
							((D2)player2area[place+1]).attack+=1;
							break;
						case "E1":
							((E1)player2area[place+1]).attack+=1;
							break;
						default:
							break;
					}
				}
			}
			else if(place>=1&&place<=4) {
				if(player2areahint[place+1].length()==2) {
					switch(player2areahint[place+1]){
						case "A1":
							((A1)player2area[place+1]).attack+=1;
							break;
						case "A2":
							((A2)player2area[place+1]).attack+=1;
							break;
						case "B1":
							((B1)player2area[place+1]).attack+=1;
							break;
						case "B2":
							((B2)player2area[place+1]).attack+=1;
							break;
						case "C1":
							((C1)player2area[place+1]).attack+=1;
							break;
						case "C2":
							((C2)player2area[place+1]).attack+=1;
							break;
						case "D1":
							((D1)player2area[place+1]).attack+=1;
							break;
						case "D2":
							((D2)player2area[place+1]).attack+=1;
							break;
						case "E1":
							((E1)player2area[place+1]).attack+=1;
							break;
						default:
							break;
					}
				}
				if(player2areahint[place-1].length()==2) {
					switch(player2areahint[place-1]){
						case "A1":
							((A1)player2area[place-1]).attack+=1;
							break;
						case "A2":
							((A2)player2area[place-1]).attack+=1;
							break;
						case "B1":
							((B1)player2area[place-1]).attack+=1;
							break;
						case "B2":
							((B2)player2area[place-1]).attack+=1;
							break;
						case "C1":
							((C1)player2area[place-1]).attack+=1;
							break;
						case "C2":
							((C2)player2area[place-1]).attack+=1;
							break;
						case "D1":
							((D1)player2area[place-1]).attack+=1;
							break;
						case "D2":
							((D2)player2area[place-1]).attack+=1;
							break;
						case "E1":
							((E1)player2area[place-1]).attack+=1;
							break;
						default:
							break;
					}
				}
			}
			else {
				if(player2areahint[place-1].length()==2) {
					switch(player2areahint[place-1]){
						case "A1":
							((A1)player2area[place-1]).attack+=1;
							break;
						case "A2":
							((A2)player2area[place-1]).attack+=1;
							break;
						case "B1":
							((B1)player2area[place-1]).attack+=1;
							break;
						case "B2":
							((B2)player2area[place-1]).attack+=1;
							break;
						case "C1":
							((C1)player2area[place-1]).attack+=1;
							break;
						case "C2":
							((C2)player2area[place-1]).attack+=1;
							break;
						case "D1":
							((D1)player2area[place-1]).attack+=1;
							break;
						case "D2":
							((D2)player2area[place-1]).attack+=1;
							break;
						case "E1":
							((E1)player2area[place-1]).attack+=1;
							break;
						default:
							break;
					}
				}
			}
		}
	}
}