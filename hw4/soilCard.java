
public class soilCard {
	int attack;
	int health;
	int crystal;
	int attack(String card) {
		if(card=="D") {
			attack=attack-1;
		}
		else if(card=="A") {
			attack=attack+1;
		}
		else {
			attack=attack;
		}
		return attack;
	}
}
