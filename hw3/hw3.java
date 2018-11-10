import java.util.Scanner;

public class hw3 {
	static seat seat1=new seat();
	static seat seat2=new seat();
	static seat seat3=new seat();
	static seat seat4=new seat();
	static chef chef1=new chef();
	static chef chef2=new chef();
	static String get="";
	static int mode=0;
	static int order=0;
	static int nexttime=0;
	static int delete=0;
	static int ready=0;
	public static void main(String[] args) {
		

		Scanner scanner=new Scanner(System.in);

		
		while(true) {
			
			if(mode==0) {
				
				get=scanner.nextLine();
				
				if(get.substring(0,3).equals("new")){
					switch(Integer.parseInt(get.substring(4,5))) {
						case 1:
							if(seat1.flag==0) {
								seat1.flag=1;
								order=1;
								mode=1;
							}
							else
								System.out.println("該座位有人");
							break;
						case 2:
							if(seat2.flag==0) {
								seat2.flag=1;
								order=2;
								mode=1;
							}
							else
								System.out.println("該座位有人");
							break;
						case 3:
							if(seat3.flag==0) {
								seat3.flag=1;
								order=3;
								mode=1;
							}
							else
								System.out.println("該座位有人");
							break;
						case 4:
							if(seat4.flag==0) {
								seat4.flag=1;
								order=4;
								mode=1;
							}
							else
								System.out.println("該座位有人");
							break;
						default:
							break;
					}
				}
				else if(get.substring(0,3).equals("sta")){
					if(get.substring(7,8).equals("t")){
						if(seat1.flag==1) {
							System.out.println("座位1有人");
							if(seat1.meal.isEmpty()==true) {
								System.out.println("無餐點");
							}
							else {
								System.out.println("已上桌:");
								for(int i=0;i<seat1.done.size();i++) {
									if(seat1.done.get(i)==1) {
										seat1.printmeal(i);
									}
								}
								System.out.println("");
								System.out.println("未上桌:");
								for(int i=0;i<seat1.done.size();i++) {
									if(seat1.done.get(i)==0) {
										seat1.printmeal(i);
									}
								}
							}
						}
						if(seat2.flag==1) {
							System.out.println("座位2有人");
							if(seat2.meal.isEmpty()==true) {
								System.out.println("無餐點");
							}
							else {
								System.out.println("已上桌:");
								for(int i=0;i<seat2.done.size();i++) {
									if(seat2.done.get(i)==1) {
										seat2.printmeal(i);
									}
								}
								System.out.println("");
								System.out.println("未上桌:");
								for(int i=0;i<seat2.done.size();i++) {
									if(seat2.done.get(i)==0) {
										seat2.printmeal(i);
									}
								}
							}
						}
						if(seat3.flag==1) {
							System.out.println("座位3有人");
							if(seat3.meal.isEmpty()==true) {
								System.out.println("無餐點");
							}
							else {
								System.out.println("已上桌:");
								for(int i=0;i<seat3.done.size();i++) {
									if(seat3.done.get(i)==1) {
										seat3.printmeal(i);
									}
								}
								System.out.println("");
								System.out.println("未上桌:");
								for(int i=0;i<seat3.done.size();i++) {
									if(seat3.done.get(i)==0) {
										seat3.printmeal(i);
									}
								}
							}
						}
						if(seat4.flag==1) {
							System.out.println("座位4有人");
							if(seat4.meal.isEmpty()==true) {
								System.out.println("無餐點");
							}
							else {
								System.out.println("已上桌:");
								for(int i=0;i<seat4.done.size();i++) {
									if(seat4.done.get(i)==1) {
										seat4.printmeal(i);
									}
								}
								System.out.println("");
								System.out.println("未上桌:");
								for(int i=0;i<seat4.done.size();i++) {
									if(seat4.done.get(i)==0) {
										seat4.printmeal(i);
									}
								}
							}
						}
					}
					else{
						System.out.println("廚師1");
						if(chef1.meal.size()==0) {
							System.out.println("無餐點");
						}
						else {
							System.out.println("正在準備餐點:");
							for(int i=0;i<chef1.meal.size();i++){
								if(chef1.oktime.get(i)==0){
									chef1.printmeal(i);
									ready=i;
									break;
								}
							}
							System.out.println("");
							System.out.println("未準備餐點:");
							for(int i=0;i<chef1.meal.size();i++) {
								if(chef1.oktime.get(i)==0&&i!=ready){
									chef1.printmeal(i);
								}
							}
						}
						System.out.println("");
						System.out.println("廚師2");
						if(chef2.meal.size()==0) {
							System.out.println("無餐點");
						}
						else {
							System.out.println("正在準備餐點:");
							for(int i=0;i<chef2.meal.size();i++){
								if(chef2.oktime.get(i)==0){
									chef2.printmeal(i);
									ready=i;
									break;
								}
							}
							System.out.println("");
							System.out.println("未準備餐點:");
							for(int i=0;i<chef2.meal.size();i++) {
								if(chef2.oktime.get(i)==0&&i!=ready){
									chef2.printmeal(i);
								}
							}
						}
					}
				}
				else if(get.substring(0,3).equals("nex")){
					work(Integer.parseInt(get.substring(5,6)),chef1);
					work(Integer.parseInt(get.substring(5,6)),chef2);
				}	
				else {
					break;
				}
			}
			
			
			if(mode==1) {
				
				get=scanner.nextLine();
				if(get.substring(0,3).equals("end")) {
					mode=0;
				}
				else {
					if(Integer.parseInt(get.substring(8,9))==1) {
						chef1.meal.add(Integer.parseInt(get.substring(5,6)));
						chef1.seat.add(order);
						chef1.oktime.add(0);
						chef1.addtime(Integer.parseInt(get.substring(5,6)),1);
					}
					else {
						chef2.meal.add(Integer.parseInt(get.substring(5,6)));
						chef2.seat.add(order);
						chef2.oktime.add(0);
						chef2.addtime(Integer.parseInt(get.substring(5,6)),2);
					}
					switch(order){
						case 1:
							seat1.meal.add(Integer.parseInt(get.substring(5,6)));
							seat1.done.add(0);
							seat1.eat.add(0);
							seat1.addtime(Integer.parseInt(get.substring(5,6)));
							break;
						case 2:
							seat2.meal.add(Integer.parseInt(get.substring(5,6)));
							seat2.done.add(0);
							seat2.eat.add(0);
							seat2.addtime(Integer.parseInt(get.substring(5,6)));
							break;
						case 3:
							seat3.meal.add(Integer.parseInt(get.substring(5,6)));
							seat3.done.add(0);
							seat3.eat.add(0);
							seat3.addtime(Integer.parseInt(get.substring(5,6)));
							break;
						case 4:
							seat4.meal.add(Integer.parseInt(get.substring(5,6)));
							seat4.done.add(0);
							seat4.eat.add(0);
							seat4.addtime(Integer.parseInt(get.substring(5,6)));
							break;
						default:
							break;
					}
				}
			}
		}
	}
	public static void work(int time,chef chefnow){
		int check=0;
		int nowdomeal=0;
		int nowdonum=0;
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
								chefnow.oktime.set(i,chefnow.time.get(i));
								chefnow.time.set(i,0);
								switch(chefnow.seat.get(i)){
									case 1:
										for(int j=0;j<seat1.meal.size();j++){
											if(seat1.meal.get(j)==nowdomeal&&seat1.done.get(j)==0){
												seat1.done.set(j,1);
												break;	
											}
										}
										break;
									case 2:
										for(int j=0;j<seat2.meal.size();j++){
											if(seat2.meal.get(j)==nowdomeal&&seat2.done.get(j)==0){
												seat2.done.set(j,1);
												break;	
											}
										}
										break;
									case 3:
										for(int j=0;j<seat3.meal.size();j++){
											if(seat3.meal.get(j)==nowdomeal&&seat3.done.get(j)==0){
												seat3.done.set(j,1);
												break;	
											}
										}
										break;
									case 4:
										for(int j=0;j<seat4.meal.size();j++){
											if(seat4.meal.get(j)==nowdomeal&&seat4.done.get(j)==0){
												seat4.done.set(i,1);
												break;	
											}
										}
										break;
									default:
										break;
								}
							}
						}
					}
					else{
						for(int i=0;i<chefnow.meal.size();i++){
							if(chefnow.meal.get(i)==nowdomeal&&chefnow.oktime.get(i)!=0){
								chefnow.time.set(i, chefnow.meal.get(i)-time);
								chefnow.oktime.set(i, time);
							}
						}
						time=0;
					}
				}
				else{
					if(time-chefnow.time.get(nowdonum)>=0){
						time=time-chefnow.time.get(nowdonum);
						chefnow.oktime.set(nowdonum,chefnow.time.get(nowdonum));
						chefnow.time.set(nowdonum,0);
						switch(chefnow.seat.get(nowdonum)){
							case 1:
								for(int j=0;j<seat1.meal.size();j++){
									if(seat1.meal.get(j)==nowdomeal&&seat1.done.get(j)==0){
										seat1.done.set(j,1);
										break;	
									}
										}
								break;
							case 2:
								for(int j=0;j<seat2.meal.size();j++){
									if(seat2.meal.get(j)==nowdomeal&&seat2.done.get(j)==0){
										seat2.done.set(j,1);
										break;	
									}
								}
								break;
							case 3:
								for(int j=0;j<seat3.meal.size();j++){
									if(seat3.meal.get(j)==nowdomeal&&seat3.done.get(j)==0){
										seat3.done.set(j,1);
										break;	
									}
								}
								break;
							case 4:
								for(int j=0;j<seat4.meal.size();j++){
									if(seat4.meal.get(j)==nowdomeal&&seat4.done.get(j)==0){
										seat4.done.set(j,1);
										break;	
									}
								}
								break;
							default:
								break;
						}
					}
					else{
						chefnow.time.set(nowdonum,chefnow.time.get(nowdonum)-time);
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

