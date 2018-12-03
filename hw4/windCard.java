public class windCard {
	int attack;
	int health;
	int crystal;
	int status;
	int attackflag;
	int attack(String card) {
		if(card=="B") {
			attack=attack-1;
		}
		else if(card=="D") {
			attack=attack+1;
		}
		else {
			attack=attack;
		}
		return attack;
	}
}