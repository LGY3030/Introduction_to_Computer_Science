public class thunderCard {
	int attack;
	int health;
	int crystal;
	int status;
	int attackflag;
	int action;
	int attack(String card,int attack) {
		if(card.equals("C")) {
			attack=attack-1;
			if(attack<0){
				attack=0;
			}
		}
		else if(card.equals("E")) {
			attack=attack+1;
		}
		else {
			attack=attack;
		}
		return attack;
	}
	void ability(int player,player player1,player player2) {
		if(player==1) {
			player2.health-=2;
		}
		else {
			player1.health-=2;
		}
	}
}
