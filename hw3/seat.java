import java.util.ArrayList;

public class seat {

	public int flag=0;
	public ArrayList <Integer> meal = new ArrayList();
	public ArrayList <Integer> done = new ArrayList();
	public ArrayList <Integer> time = new ArrayList();
	public void printmeal(int i){
		if(meal.get(i)==1){
			System.out.println("ª£¶º");
		}
		else if(meal.get(i)==2){
			System.out.println("Áç¿N·NÄÑ");
		}
		else if(meal.get(i)==3){
			System.out.println("ª£«Cµæ");
		}
		else if(meal.get(i)==4){
			System.out.println("¥¤ªo¤d¼h³J¿|");
		}
		else{
			System.out.println("ºî¦XªG¥Ä");
		}
	}
	
}