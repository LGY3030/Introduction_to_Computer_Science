import java.util.ArrayList;

public class seat {

	public int flag=0;
	public ArrayList <Integer> meal = new ArrayList();
	public ArrayList <Integer> done = new ArrayList();
	public ArrayList <Integer> eat = new ArrayList();
	public ArrayList <Integer> time = new ArrayList();
	public ArrayList <Integer> oktime = new ArrayList();
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
	public void addtime(int i){
		switch (i) {
			case 1:
				time.add(10);
				break;
			case 2:
				time.add(8);
				break;
			case 3:
				time.add(2);
				break;
			case 4:
				time.add(5);
				break;
			case 5:
				time.add(3);
				break;
			default:
				break;
		}
	}
	public static void eat(int totaltime,int time,seat seatnow){
		int noweatmeal=0;
		int temp=10000;
		int check=1;
		
		if(seatnow.meal.size()>0) {
			for(int i=0;i<seatnow.meal.size();i++) {
				if(seatnow.done.get(i)==1) {
					check*=seatnow.eat.get(i);
				}
			}
			while(time!=0&&check==0){
				for(int i=0;i<seatnow.meal.size();i++) {
					if(seatnow.done.get(i)==1&&seatnow.eat.get(i)==0) {
						if(seatnow.oktime.get(i)<=temp) {
							temp=seatnow.oktime.get(i);
							noweatmeal=i;
						}
						else {
							temp=temp;
							noweatmeal=noweatmeal;
						}
					}
				}
				if(totaltime>=seatnow.oktime.get(noweatmeal)) {
					if(time>=seatnow.time.get(noweatmeal)) {
						time=time-seatnow.time.get(noweatmeal);
						seatnow.time.set(noweatmeal,0);
						seatnow.eat.set(noweatmeal,1);
					}
					else {
						seatnow.time.set(noweatmeal,seatnow.time.get(noweatmeal)-time);
						time=0;
					}
				}
				else {
					if(totaltime+time>=seatnow.oktime.get(noweatmeal)) {
						time=time-(seatnow.oktime.get(noweatmeal)-totaltime);
						totaltime=seatnow.oktime.get(noweatmeal);
					}
					else {
						totaltime+=time;
						time=0;
					}
				}
				check=1;
				noweatmeal=0;
				temp=10000;
				for(int i=0;i<seatnow.meal.size();i++) {
					if(seatnow.done.get(i)==1) {
						check*=seatnow.eat.get(i);
					}
				}
			}
			
		}	
	}
}