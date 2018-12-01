

public class fireCard {
	int attack;
	int health;
	int crystal;
	int attack(String card) {
		if(card=="A") {
			attack=attack-1;
		}
		else if(card=="C") {
			attack=attack+1;
		}
		else {
			attack=attack;
		}
		return attack;
	}
}
