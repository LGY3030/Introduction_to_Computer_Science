import java.util.ArrayList;

public class seat {

	public int flag=0;        //紀錄是否有人坐
	public ArrayList <Integer> meal = new ArrayList();        //紀錄餐點號碼
	public ArrayList <Integer> done = new ArrayList();        //紀錄是否已上桌
	public ArrayList <Integer> eat = new ArrayList();        //紀錄是否已食用完
	public ArrayList <Integer> time = new ArrayList();        //紀錄食用所需時間
	public ArrayList <Integer> oktime = new ArrayList();        //紀錄餐點完成時間

	//印出餐點的名稱
	public void printmeal(int i){
		if(meal.get(i)==1){
			System.out.println("炒飯");
		}
		else if(meal.get(i)==2){
			System.out.println("鍋燒意麵");
		}
		else if(meal.get(i)==3){
			System.out.println("炒青菜");
		}
		else if(meal.get(i)==4){
			System.out.println("奶油千層蛋糕");
		}
		else{
			System.out.println("綜合果汁");
		}
	}

	//將餐點食用時間加入time arraylist
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

	//模擬顧客食用餐點
	public static void eat(int totaltime,int time,seat seatnow){

		int noweatmeal=0;        //目前食用的餐點
		int temp=10000;        //暫存餐點完成時間
		int check=1;        //判斷已上桌但未食用的餐點
		int temp2=0;
		
		//顧客有餐點可以食用
		if(seatnow.meal.size()>0) {

			//check乘上所有已上桌餐點的eat arraylist值(因為已食用餐點的eat arraylist會變為1，沒食用完會是0，因此如果有可食用但沒食用完的餐點，check就會為0)
			for(int i=0;i<seatnow.meal.size();i++) {
				if(seatnow.done.get(i)==1) {
					check*=seatnow.eat.get(i);
				}
			}

			//當還有剩餘時間或餐點尚未食用完時，會在while迴圈裡
			while(time!=0&&check==0){

				//找出最早製作完成的餐點，當作目前要食用的餐點(比較 oktime arraylist)
				for(int i=0;i<seatnow.meal.size();i++) {
					if(seatnow.done.get(i)==1&&seatnow.eat.get(i)==0) {
						if(seatnow.oktime.get(i)<temp) {
							temp=seatnow.oktime.get(i);
							noweatmeal=i;
						}
						else {
							temp=temp;
							noweatmeal=noweatmeal;
						}
					}
				}

				//起始時間大於目前餐點的完成時間(代表餐點早就完成，可立即食用)
				if(totaltime>=seatnow.oktime.get(noweatmeal)) {

					//模擬時間大於餐點需食用時間(代表可以完整食用完畢)
					if(time>=seatnow.time.get(noweatmeal)) {
						time=time-seatnow.time.get(noweatmeal);
						totaltime+=seatnow.time.get(noweatmeal);
						seatnow.time.set(noweatmeal,0);
						seatnow.eat.set(noweatmeal,1);

					}
					//模擬時間小於餐點需食用時間(代表不能食用完畢)
					else {
						totaltime+=time;
						temp2=seatnow.time.get(noweatmeal)-time;
						seatnow.time.set(noweatmeal,temp2);
						time=0;

					}
				}

				//起始時間小於目前餐點的完成時間(代表餐點未完成，不能立即食用)
				else {
					//目前時間加上模擬的時間大於目前餐點的完成時間(代表需要等待一段時間，但在模擬的時間結束以前，餐點會完成，所以先模擬至餐點完成時，在根據剩下時間模擬顧客食用餐點)
					if(totaltime+time>=seatnow.oktime.get(noweatmeal)) {
						time=time-(seatnow.oktime.get(noweatmeal)-totaltime);
						totaltime=seatnow.oktime.get(noweatmeal);

					}
					//目前時間加上模擬的時間小於目前餐點的完成時間(代表在模擬的時間結束後，目前餐點仍未完成)
					else {
						totaltime+=time;
						time=0;
					}
				}
				//重新判斷check
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