

public class thunderCard {
	int attack;
	int health;
	int crystal;
	int attack(String card) {
		if(card=="C") {
			attack=attack-1;
		}
		else if(card=="E") {
			attack=attack+1;
		}
		else {
			attack=attack;
		}
		return attack;
	}
}