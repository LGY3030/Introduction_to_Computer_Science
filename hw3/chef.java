import java.util.ArrayList;

public class chef {
	
	public ArrayList <Integer> meal = new ArrayList();        //紀錄餐點號碼
	public ArrayList <Integer> seat = new ArrayList();        //紀錄哪桌餐的點
	public ArrayList <Integer> time = new ArrayList();        //紀錄餐點製作時間
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

	//將餐點製作時間加入time arraylist(兩個廚師製作的餐點時間不一樣)
	public void addtime(int i,int j){
		//廚師1
		if(j==1){
			switch (i) {
				case 1:
					time.add(3);
					break;
				case 2:
					time.add(4);
					break;
				case 3:
					time.add(1);
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
		//廚師2
		else{
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
					time.add(4);
					break;
				case 5:
					time.add(1);
					break;
				default:
					break;
			}
		}
	}

	//模擬廚師製作餐點
	public static void work(int totaltime,int time,chef chefnow,seat seat1,seat seat2,seat seat3,seat seat4){

		int check=0;        //判斷是否還有餐點沒做
		int nowdomeal=0;        //紀錄正在做的餐點
		int nowdonum=0;        //紀錄正在做的餐點的index
		int temp=0;        //暫存餐點需要製作時間

		//廚師有餐點可以製作
		if(chefnow.meal.size()>0){

			//check減去所有餐點的製作時間(因為我的設計，當該餐點製作完成後，他對應的製作時間的arraylist會歸0，所以所有餐點都製作完時，check最終會變為0)
			for(int i=0;i<chefnow.time.size();i++){
				check=check-chefnow.time.get(i);
			}

			//當還有剩餘時間或餐點尚未製作完時，會在while迴圈裡
			while(time!=0&&check!=0){
				//取得目前要製作的餐點
				for(int i=0;i<chefnow.meal.size();i++){
					if(chefnow.time.get(i)!=0){
						nowdomeal=chefnow.meal.get(i);
						nowdonum=i;
						break;
					}
				}
				//該餐點可以同時製作多份
				if(chefnow.meal.get(nowdonum)==1||chefnow.meal.get(nowdonum)==3||chefnow.meal.get(nowdonum)==5){
					//剩餘時間大於該餐點所需製作時間
					if(time-chefnow.time.get(nowdonum)>=0){
						time=time-chefnow.time.get(nowdonum);        //剩餘時間減去製作時間

						//因為此餐點可以同時製作多份，所以找出所有相同的餐點
						for(int i=0;i<chefnow.meal.size();i++){
							if(chefnow.meal.get(i)==nowdomeal&&chefnow.time.get(i)!=0&&chefnow.time.get(i)==chefnow.time.get(nowdonum)){
								temp=chefnow.time.get(i);
								chefnow.oktime.set(i,chefnow.time.get(i)+totaltime);        //紀錄完成時間

								//判斷該餐點是由哪桌所點
								switch(chefnow.seat.get(i)){

									//1號桌，並更改該餐點的done和oktime的arraylist
									case 1:
										for(int j=0;j<seat1.meal.size();j++){
											if(seat1.meal.get(j)==nowdomeal&&seat1.done.get(j)==0){
												seat1.done.set(j,1);
												seat1.oktime.set(j,chefnow.time.get(i)+totaltime);
												break;	
											}
										}
										break;

									//2號桌，並更改該餐點的done和oktime的arraylist
									case 2:
										for(int j=0;j<seat2.meal.size();j++){
											if(seat2.meal.get(j)==nowdomeal&&seat2.done.get(j)==0){
												seat2.done.set(j,1);
												seat2.oktime.set(j,chefnow.time.get(i)+totaltime);
												break;	
											}
										}
										break;

									//3號桌，並更改該餐點的done和oktime的arraylist
									case 3:
										for(int j=0;j<seat3.meal.size();j++){
											if(seat3.meal.get(j)==nowdomeal&&seat3.done.get(j)==0){
												seat3.done.set(j,1);
												seat3.oktime.set(j,chefnow.time.get(i)+totaltime);
												break;	
											}
										}
										break;

									//4號桌，並更改該餐點的done和oktime的arraylist
									case 4:
										for(int j=0;j<seat4.meal.size();j++){
											if(seat4.meal.get(j)==nowdomeal&&seat4.done.get(j)==0){
												seat4.done.set(i,1);
												seat4.oktime.set(j,chefnow.time.get(i)+totaltime);
												break;	
											}
										}
										break;
									default:
										break;
								}
								chefnow.time.set(i,0);        //因為餐點做完，所以製作時間歸0
							}

							totaltime+=temp;
						}
					}

					//剩餘時間小於該餐點所需製作時間，做不完，所以將該餐點製作時間減去剩餘時間
					else{
						for(int i=0;i<chefnow.meal.size();i++){
							if(chefnow.meal.get(i)==nowdomeal&&chefnow.time.get(i)!=0&&chefnow.time.get(i)==chefnow.time.get(nowdonum)){
								chefnow.time.set(i, chefnow.meal.get(i)-time);
							}
						}
						totaltime+=time;
						time=0;
					}
				}
				else{
					//剩餘時間大於該餐點所需製作時間
					if(time-chefnow.time.get(nowdonum)>=0){
						time=time-chefnow.time.get(nowdonum);        //剩餘時間減去製作時間
						temp=chefnow.time.get(nowdonum);
						chefnow.oktime.set(nowdonum,chefnow.time.get(nowdonum)+totaltime);        //紀錄完成時間

						//判斷該餐點是由哪桌所點
						switch(chefnow.seat.get(nowdonum)){

							//1號桌，並更改該餐點的done和oktime的arraylist
							case 1:
								for(int j=0;j<seat1.meal.size();j++){
									if(seat1.meal.get(j)==nowdomeal&&seat1.done.get(j)==0){
										seat1.done.set(j,1);
										seat1.oktime.set(j,chefnow.time.get(nowdonum)+totaltime);
										break;	
									}
										}
								break;
							//2號桌，並更改該餐點的done和oktime的arraylist
							case 2:
								for(int j=0;j<seat2.meal.size();j++){
									if(seat2.meal.get(j)==nowdomeal&&seat2.done.get(j)==0){
										seat2.done.set(j,1);
										seat2.oktime.set(j,chefnow.time.get(nowdonum)+totaltime);
										break;	
									}
								}
								break;
							//3號桌，並更改該餐點的done和oktime的arraylist
							case 3:
								for(int j=0;j<seat3.meal.size();j++){
									if(seat3.meal.get(j)==nowdomeal&&seat3.done.get(j)==0){
										seat3.done.set(j,1);
										seat3.oktime.set(j,chefnow.time.get(nowdonum)+totaltime);
										break;	
									}
								}
								break;
							//4號桌，並更改該餐點的done和oktime的arraylist
							case 4:
								for(int j=0;j<seat4.meal.size();j++){
									if(seat4.meal.get(j)==nowdomeal&&seat4.done.get(j)==0){
										seat4.done.set(j,1);
										seat4.oktime.set(j,chefnow.time.get(nowdonum)+totaltime);
										break;	
									}
								}
								break;
							default:
								break;
						}
						chefnow.time.set(nowdonum,0);        //因為餐點做完，所以製作時間歸0
						totaltime+=temp;
					}

					//剩餘時間小於該餐點所需製作時間，做不完，所以將該餐點製作時間減去剩餘時間
					else{
						chefnow.time.set(nowdonum,chefnow.time.get(nowdonum)-time);
						totaltime+=time;
						time=0;
					}

				}

				//重新判斷check
				for(int i=0;i<chefnow.oktime.size();i++){
					check=check-chefnow.time.get(i);
				}	
			}
		}		
	}
}