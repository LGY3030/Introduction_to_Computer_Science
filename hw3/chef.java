import java.util.ArrayList;

public class chef {
	
	public ArrayList <Integer> meal = new ArrayList();
	public ArrayList <Integer> seat = new ArrayList();
	public ArrayList <Integer> time = new ArrayList();
	public void printmeal(int i){
		if(meal.get(i)==1){
			System.out.println("����");
		}
		else if(meal.get(i)==2){
			System.out.println("��N�N��");
		}
		else if(meal.get(i)==3){
			System.out.println("���C��");
		}
		else if(meal.get(i)==4){
			System.out.println("���o�d�h�J�|");
		}
		else{
			System.out.println("��X�G��");
		}
	}
	public void addtime(int i){
		switch (i) {
			case 1:
				time.add(6);
				break;
			case 2:
				time.add(4);
				break;
			case 3:
				time.add(2);
				break;
			case 4:
				time.add(8);
				break;
			case 5:
				time.add(2);
				break;
			default:
				break;
		}
	}
}
