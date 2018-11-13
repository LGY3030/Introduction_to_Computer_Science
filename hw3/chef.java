import java.util.ArrayList;

public class chef {
	
	public ArrayList <Integer> meal = new ArrayList();
	public ArrayList <Integer> seat = new ArrayList();
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
	public void addtime(int i,int j){
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
	public static void work(int totaltime,int time,chef chefnow,seat seat1,seat seat2,seat seat3,seat seat4){
		int check=0;
		int nowdomeal=0;
		int nowdonum=0;
		int temp=0;
		if(chefnow.meal.size()>0){
			for(int i=0;i<chefnow.time.size();i++){
				check=check-chefnow.time.get(i);
			}
			while(time!=0&&check!=0){
				for(int i=0;i<chefnow.meal.size();i++){
					if(chefnow.time.get(i)!=0){
						nowdomeal=chefnow.meal.get(i);
						nowdonum=i;
						break;
					}
				}
				if(chefnow.meal.get(nowdonum)==1||chefnow.meal.get(nowdonum)==3||chefnow.meal.get(nowdonum)==5){
					if(time-chefnow.time.get(nowdonum)>=0){
						time=time-chefnow.time.get(nowdonum);
						for(int i=0;i<chefnow.meal.size();i++){
							if(chefnow.meal.get(i)==nowdomeal&&chefnow.time.get(i)!=0){
								temp=chefnow.time.get(i);
								chefnow.oktime.set(i,chefnow.time.get(i)+totaltime);
								switch(chefnow.seat.get(i)){
									case 1:
										for(int j=0;j<seat1.meal.size();j++){
											if(seat1.meal.get(j)==nowdomeal&&seat1.done.get(j)==0){
												seat1.done.set(j,1);
												seat1.oktime.set(j,chefnow.time.get(i)+totaltime);
												break;	
											}
										}
										break;
									case 2:
										for(int j=0;j<seat2.meal.size();j++){
											if(seat2.meal.get(j)==nowdomeal&&seat2.done.get(j)==0){
												seat2.done.set(j,1);
												seat2.oktime.set(j,chefnow.time.get(i)+totaltime);
												break;	
											}
										}
										break;
									case 3:
										for(int j=0;j<seat3.meal.size();j++){
											if(seat3.meal.get(j)==nowdomeal&&seat3.done.get(j)==0){
												seat3.done.set(j,1);
												seat3.oktime.set(j,chefnow.time.get(i)+totaltime);
												break;	
											}
										}
										break;
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
								chefnow.time.set(i,0);
							}

							totaltime+=temp;
						}
					}
					else{
						for(int i=0;i<chefnow.meal.size();i++){
							if(chefnow.meal.get(i)==nowdomeal&&chefnow.time.get(i)!=0){
								chefnow.time.set(i, chefnow.meal.get(i)-time);
							}
						}
						totaltime+=time;
						time=0;
					}
				}
				else{
					if(time-chefnow.time.get(nowdonum)>=0){
						time=time-chefnow.time.get(nowdonum);
						temp=chefnow.time.get(nowdonum);
						chefnow.oktime.set(nowdonum,chefnow.time.get(nowdonum)+totaltime);
						switch(chefnow.seat.get(nowdonum)){
							case 1:
								for(int j=0;j<seat1.meal.size();j++){
									if(seat1.meal.get(j)==nowdomeal&&seat1.done.get(j)==0){
										seat1.done.set(j,1);
										seat1.oktime.set(j,chefnow.time.get(nowdonum)+totaltime);
										break;	
									}
										}
								break;
							case 2:
								for(int j=0;j<seat2.meal.size();j++){
									if(seat2.meal.get(j)==nowdomeal&&seat2.done.get(j)==0){
										seat2.done.set(j,1);
										seat2.oktime.set(j,chefnow.time.get(nowdonum)+totaltime);
										break;	
									}
								}
								break;
							case 3:
								for(int j=0;j<seat3.meal.size();j++){
									if(seat3.meal.get(j)==nowdomeal&&seat3.done.get(j)==0){
										seat3.done.set(j,1);
										seat3.oktime.set(j,chefnow.time.get(nowdonum)+totaltime);
										break;	
									}
								}
								break;
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
						chefnow.time.set(nowdonum,0);
						totaltime+=temp;
					}
					else{
						chefnow.time.set(nowdonum,chefnow.time.get(nowdonum)-time);
						totaltime+=time;
						time=0;
					}

				}
				for(int i=0;i<chefnow.oktime.size();i++){
					check=check-chefnow.time.get(i);
				}	
			}
		}		
	}
}