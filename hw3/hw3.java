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
		
		int totaltime=0;
		Scanner scanner=new Scanner(System.in);

		
		while(true) {
			System.out.println("");
			System.out.println("===========================================================");
			System.out.println("");

			if(mode==0) {
				System.out.println("輸入指令:");
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
							System.out.println("");
							System.out.println("---座位1有人---");
							if(seat1.meal.isEmpty()==true) {
								System.out.println("");
								System.out.println("無餐點");
							}
							else {
								System.out.println("");
								System.out.println("已上桌:");
								System.out.println("");
								for(int i=0;i<seat1.done.size();i++) {
									if(seat1.done.get(i)==1) {
										seat1.printmeal(i);
									}
								}
								System.out.println("");

								System.out.println("未上桌:");
								System.out.println("");
								for(int i=0;i<seat1.done.size();i++) {
									if(seat1.done.get(i)==0) {
										seat1.printmeal(i);
									}
								}
							}
						}
						if(seat2.flag==1) {
							System.out.println("");
							System.out.println("---座位2有人---");
							if(seat2.meal.isEmpty()==true) {
								System.out.println("");
								System.out.println("無餐點");
							}
							else {
								System.out.println("");
								System.out.println("已上桌:");
								System.out.println("");
								for(int i=0;i<seat2.done.size();i++) {
									if(seat2.done.get(i)==1) {
										seat2.printmeal(i);
									}
								}

								System.out.println("");
								System.out.println("未上桌:");
								System.out.println("");
								for(int i=0;i<seat2.done.size();i++) {
									if(seat2.done.get(i)==0) {
										seat2.printmeal(i);
									}
								}
							}
						}
						if(seat3.flag==1) {
							System.out.println("");
							System.out.println("---座位3有人---");
							if(seat3.meal.isEmpty()==true) {
								System.out.println("");
								System.out.println("無餐點");
							}
							else {
								System.out.println("");
								System.out.println("已上桌:");
								System.out.println("");
								for(int i=0;i<seat3.done.size();i++) {
									if(seat3.done.get(i)==1) {
										seat3.printmeal(i);
									}
								}

								System.out.println("");
								System.out.println("未上桌:");
								System.out.println("");
								for(int i=0;i<seat3.done.size();i++) {
									if(seat3.done.get(i)==0) {
										seat3.printmeal(i);
									}
								}
							}
						}
						if(seat4.flag==1) {
							System.out.println("");
							System.out.println("---座位4有人---");
							if(seat4.meal.isEmpty()==true) {
								System.out.println("");
								System.out.println("無餐點");
							}
							else {
								System.out.println("");
								System.out.println("已上桌:");
								System.out.println("");
								for(int i=0;i<seat4.done.size();i++) {
									if(seat4.done.get(i)==1) {
										seat4.printmeal(i);
									}
								}

								System.out.println("");
								System.out.println("未上桌:");
								System.out.println("");
								for(int i=0;i<seat4.done.size();i++) {
									if(seat4.done.get(i)==0) {
										seat4.printmeal(i);
									}
								}
							}
						}
					}
					else{
						System.out.println("");
						System.out.println("---廚師1---");
						if(chef1.meal.size()==0) {
							System.out.println("");
							System.out.println("無餐點");
						}
						else {
							System.out.println("");
							System.out.println("正在準備餐點:");
							System.out.println("");
							for(int i=0;i<chef1.meal.size();i++){
								if(chef1.oktime.get(i)==0){
									chef1.printmeal(i);
									ready=i;
									break;
								}
							}

							System.out.println("");
							System.out.println("");
							System.out.println("未準備餐點:");
							System.out.println("");
							for(int i=0;i<chef1.meal.size();i++) {
								if(chef1.oktime.get(i)==0&&i!=ready){
									chef1.printmeal(i);
								}
							}
						}
						System.out.println("");
						System.out.println("");
						System.out.println("---廚師2---");
						if(chef2.meal.size()==0) {
							System.out.println("");
							System.out.println("無餐點");
						}
						else {
							System.out.println("");
							System.out.println("正在準備餐點:");
							System.out.println("");
							for(int i=0;i<chef2.meal.size();i++){
								if(chef2.oktime.get(i)==0){
									chef2.printmeal(i);
									ready=i;
									break;
								}
							}

							System.out.println("");
							System.out.println("");
							System.out.println("未準備餐點:");
							System.out.println("");
							for(int i=0;i<chef2.meal.size();i++) {
								if(chef2.oktime.get(i)==0&&i!=ready){
									chef2.printmeal(i);
								}
							}
						}
					}
				}
				else if(get.substring(0,3).equals("nex")){
					chef.work(totaltime,Integer.parseInt(get.substring(5)),chef1,seat1,seat2,seat3,seat4);
					chef.work(totaltime,Integer.parseInt(get.substring(5)),chef2,seat1,seat2,seat3,seat4);
					seat.eat(totaltime,Integer.parseInt(get.substring(5)),seat1);
					seat.eat(totaltime,Integer.parseInt(get.substring(5)),seat2);
					seat.eat(totaltime,Integer.parseInt(get.substring(5)),seat3);
					seat.eat(totaltime,Integer.parseInt(get.substring(5)),seat4);
					check(1,seat1);
					check(2,seat2);
					check(3,seat3);
					check(4,seat4);
					totaltime+=Integer.parseInt(get.substring(5));
				}	
				else {
					break;
				}
			}
			
			
			if(mode==1) {
				System.out.println("");
				System.out.println("點餐:");
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
							seat1.oktime.add(0);
							seat1.eat.add(0);
							seat1.addtime(Integer.parseInt(get.substring(5,6)));
							break;
						case 2:
							seat2.meal.add(Integer.parseInt(get.substring(5,6)));
							seat2.done.add(0);
							seat2.oktime.add(0);
							seat2.eat.add(0);
							seat2.addtime(Integer.parseInt(get.substring(5,6)));
							break;
						case 3:
							seat3.meal.add(Integer.parseInt(get.substring(5,6)));
							seat3.done.add(0);
							seat3.oktime.add(0);
							seat3.eat.add(0);
							seat3.addtime(Integer.parseInt(get.substring(5,6)));
							break;
						case 4:
							seat4.meal.add(Integer.parseInt(get.substring(5,6)));
							seat4.done.add(0);
							seat4.oktime.add(0);
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
	public static void check(int num,seat seatnow) {
		int check=1;
		if(seatnow.meal.size()>0) {
			for(int i=0;i<seatnow.meal.size();i++) {
				check*=seatnow.eat.get(i);
			}
			if(check==1) {
				seatnow.meal.clear();
				seatnow.done.clear();
				seatnow.eat.clear();
				seatnow.time.clear();
				seatnow.oktime.clear();
				seatnow.flag=0;
				for(int i=0;i<chef1.meal.size();i++) {
					if(chef1.seat.get(i)==num) {
						chef1.meal.remove(i);
						chef1.seat.remove(i);
						chef1.time.remove(i);
						chef1.oktime.remove(i);
					}
				}
				for(int i=0;i<chef2.meal.size();i++) {
					if(chef2.seat.get(i)==num) {
						chef2.meal.remove(i);
						chef2.seat.remove(i);
						chef2.time.remove(i);
						chef2.oktime.remove(i);
					}
				}
			}
		}
	}
}