import java.util.Scanner;

public class hw3 {

	static seat seat1=new seat();        //創建seat的物件
	static seat seat2=new seat();        //創建seat的物件
	static seat seat3=new seat();        //創建seat的物件
	static seat seat4=new seat();        //創建seat的物件
	static chef chef1=new chef();        //創建chef的物件
	static chef chef2=new chef();        //創建chef的物件
	static String get="";        //用來接收input
	static int mode=0;        //用來判斷管理模式or點餐模式的flag
	static int order=0;        //用來記錄目前的點餐者
	static int ready=0;        //廚師目前在準備的餐點

	//主程式
	public static void main(String[] args) {
		
		int totaltime=0;        //目前累計的模擬時間

		Scanner scanner=new Scanner(System.in);

		//點餐系統
		while(true) {

			System.out.println("");
			System.out.println("===========================================================");
			System.out.println("");

			//管理模式
			if(mode==0) {

				System.out.println("輸入指令:");
				get=scanner.nextLine();
				
				//安排顧客座位
				if(get.substring(0,3).equals("new")){

					//看安排的座位是哪，並判斷是否已經有人
					switch(Integer.parseInt(get.substring(4,5))) {

						//1號桌
						case 1:
							if(seat1.flag==0) {
								seat1.flag=1;
								order=1;
								mode=1;
							}
							else
								System.out.println("該座位有人");
							break;
						//2號桌
						case 2:
							if(seat2.flag==0) {
								seat2.flag=1;
								order=2;
								mode=1;
							}
							else
								System.out.println("該座位有人");
							break;
						//3號桌
						case 3:
							if(seat3.flag==0) {
								seat3.flag=1;
								order=3;
								mode=1;
							}
							else
								System.out.println("該座位有人");
							break;
						//4號桌
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
				
				//查看狀況
				else if(get.substring(0,3).equals("sta")){

					//查看店內狀況，直接檢查每一桌的flag，並印出餐點
					if(get.substring(7,8).equals("t")){
						//1號桌
						if(seat1.flag==1) {
							System.out.println("");
							System.out.println("---座位1有人---");

							//判斷有無餐點
							//無餐點
							if(seat1.meal.isEmpty()==true) {
								System.out.println("");
								System.out.println("無餐點");
							}
							//有餐點
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
						//2號桌
						if(seat2.flag==1) {
							System.out.println("");
							System.out.println("---座位2有人---");

							//判斷有無餐點
							//無餐點
							if(seat2.meal.isEmpty()==true) {
								System.out.println("");
								System.out.println("無餐點");
							}
							//有餐點
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
						//3號桌
						if(seat3.flag==1) {
							System.out.println("");
							System.out.println("---座位3有人---");

							//判斷有無餐點
							//無餐點
							if(seat3.meal.isEmpty()==true) {
								System.out.println("");
								System.out.println("無餐點");
							}
							//有餐點
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
						//4號桌
						if(seat4.flag==1) {
							System.out.println("");
							System.out.println("---座位4有人---");

							//判斷有無餐點
							//無餐點
							if(seat4.meal.isEmpty()==true) {
								System.out.println("");
								System.out.println("無餐點");
							}
							//有餐點
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

					//查看廚師狀況，直接印出美個廚師的餐點
					else{
						//廚師1
						System.out.println("");
						System.out.println("---廚師1---");
						
						//檢查有無餐點
						//無餐點
						if(chef1.meal.size()==0) {
							System.out.println("");
							System.out.println("無餐點");
						}
						//有餐點
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

						//廚師2
						System.out.println("");
						System.out.println("");
						System.out.println("---廚師2---");

						//檢查有無餐點
						//無餐點
						if(chef2.meal.size()==0) {
							System.out.println("");
							System.out.println("無餐點");
						}
						//有餐點
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

				//模擬經過時間
				else if(get.substring(0,3).equals("nex")){

					//call 廚師的workfunction
					chef.work(totaltime,Integer.parseInt(get.substring(5)),chef1,seat1,seat2,seat3,seat4);
					chef.work(totaltime,Integer.parseInt(get.substring(5)),chef2,seat1,seat2,seat3,seat4);

					//call 位子的eat function
					seat.eat(totaltime,Integer.parseInt(get.substring(5)),seat1);
					seat.eat(totaltime,Integer.parseInt(get.substring(5)),seat2);
					seat.eat(totaltime,Integer.parseInt(get.substring(5)),seat3);
					seat.eat(totaltime,Integer.parseInt(get.substring(5)),seat4);

					//檢查位子的顧客是否吃完
					check(1,seat1);
					check(2,seat2);
					check(3,seat3);
					check(4,seat4);

					//累計的模擬時間增加
					totaltime+=Integer.parseInt(get.substring(5));
				}
				
				//結束系統 	
				else {
					break;
				}
			}
			
			//點餐模式
			if(mode==1) {

				System.out.println("");
				System.out.println("點餐:");
				get=scanner.nextLine();

				//結束點餐模式
				if(get.substring(0,3).equals("end")) {
					mode=0;
				}

				//點餐
				else {

					//指派給廚師1
					if(Integer.parseInt(get.substring(8,9))==1) {
						//把點餐資訊加入所有arraylist
						chef1.meal.add(Integer.parseInt(get.substring(5,6)));
						chef1.seat.add(order);
						chef1.oktime.add(0);
						chef1.addtime(Integer.parseInt(get.substring(5,6)),1);
					}

					//指派給廚師2
					else {
						//把點餐資訊加入所有arraylist
						chef2.meal.add(Integer.parseInt(get.substring(5,6)));
						chef2.seat.add(order);
						chef2.oktime.add(0);
						chef2.addtime(Integer.parseInt(get.substring(5,6)),2);
					}

					//判斷是哪個位子點餐，並把點餐資訊加入所有arraylist
					switch(order){

						//1號桌
						case 1:
							seat1.meal.add(Integer.parseInt(get.substring(5,6)));
							seat1.done.add(0);
							seat1.oktime.add(0);
							seat1.eat.add(0);
							seat1.addtime(Integer.parseInt(get.substring(5,6)));
							break;

						//2號桌
						case 2:
							seat2.meal.add(Integer.parseInt(get.substring(5,6)));
							seat2.done.add(0);
							seat2.oktime.add(0);
							seat2.eat.add(0);
							seat2.addtime(Integer.parseInt(get.substring(5,6)));
							break;

						//3號桌
						case 3:
							seat3.meal.add(Integer.parseInt(get.substring(5,6)));
							seat3.done.add(0);
							seat3.oktime.add(0);
							seat3.eat.add(0);
							seat3.addtime(Integer.parseInt(get.substring(5,6)));
							break;

						//4號桌
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

	//用來判斷顧客是否已吃完所有餐點
	public static void check(int num,seat seatnow) {

		int check=1;

		//先判斷此座位是否有點餐
		if(seatnow.meal.size()>0) {

			//利用check這個變數與所有eat arraylist的變數相乘，如果check仍為1，代表所有eat arraylist都是1，代表此顧客已食用完畢
			for(int i=0;i<seatnow.meal.size();i++) {
				check*=seatnow.eat.get(i);
			}
			//已吃完
			if(check==1) {
				//把該位子的arraylist清空，flag歸0
				seatnow.meal.clear();
				seatnow.done.clear();
				seatnow.eat.clear();
				seatnow.time.clear();
				seatnow.oktime.clear();
				seatnow.flag=0;

				//把在廚師1的arraylist裡，該位子所點的餐點資訊清空
				for(int i=0;i<chef1.meal.size();i++) {
					if(chef1.seat.get(i)==num) {
						chef1.meal.remove(i);
						chef1.seat.remove(i);
						chef1.time.remove(i);
						chef1.oktime.remove(i);
					}
				}
				//把在廚師2的arraylist裡，該位子所點的餐點資訊清空
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