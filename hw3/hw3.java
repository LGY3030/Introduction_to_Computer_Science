import java.util.Scanner;

public class hw3 {
	public static void main(String[] args) {
		
		seat seat1=new seat();
		seat seat2=new seat();
		seat seat3=new seat();
		seat seat4=new seat();
		chef chef1=new chef();
		chef chef2=new chef();
		Scanner scanner=new Scanner(System.in);
		String get="";
		int mode=0;
		int order=0;
		
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
					else {
						System.out.println("廚師1");
						if(chef1.meal.size()==0) {
							System.out.println("無餐點");
						}
						else {
							System.out.println("正在準備餐點:");
							chef1.printmeal(0);
							System.out.println("");
							System.out.println("未準備餐點:");
							if(chef1.meal.size()>1) {
								for(int i=1;i<chef1.meal.size();i++) {
									chef1.printmeal(i);
								}
							}
							else
								System.out.println("無");
						}
						System.out.println("");
						System.out.println("廚師2");
						if(chef2.meal.size()==0) {
							System.out.println("無餐點");
						}
						else {
							System.out.println("正在準備餐點:");
							chef2.printmeal(0);
							System.out.println("");
							System.out.println("未準備餐點:");
							if(chef2.meal.size()>1) {
								for(int i=1;i<chef2.meal.size();i++) {
									chef2.printmeal(i);
								}
							}
							else
								System.out.println("無");
						}
					}
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
						switch (Integer.parseInt(get.substring(5,6))) {
							case 1:
								chef1.time.add(6);
								break;
							case 2:
								chef1.time.add(4);
								break;
							case 3:
								chef1.time.add(2);
								break;
							case 4:
								chef1.time.add(8);
								break;
							case 5:
								chef1.time.add(2);
								break;
							default:
								break;
						}
					}
					else {
						chef2.meal.add(Integer.parseInt(get.substring(5,6)));
						chef2.seat.add(order);
						switch (Integer.parseInt(get.substring(5,6))) {
							case 1:
								chef2.time.add(6);
								break;
							case 2:
								chef2.time.add(4);
								break;
							case 3:
								chef2.time.add(2);
								break;
							case 4:
								chef2.time.add(8);
								break;
							case 5:
								chef2.time.add(2);
								break;
							default:
								break;
						}
					}
				}
			}
		}
	}
}

