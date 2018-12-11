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
		}
		else if(card.equals("E")) {
			attack=attack+1;
		}
		else {
			attack=attack;
		}
		return attack;
	}
}
