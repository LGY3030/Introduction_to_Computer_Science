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
}