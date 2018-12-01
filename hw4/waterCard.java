

public class waterCard {
	int attack;
	int health;
	int crystal;
	int attack(String card) {
		if(card=="E") {
			attack=attack-1;
		}
		else if(card=="B") {
			attack=attack+1;
		}
		else {
			attack=attack;
		}
		return attack;
	}
}
