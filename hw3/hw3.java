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
		int nexttime=0;
		int delete=0;
		int nowdo=0;
		
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
								System.out.println("�Ӯy�즳�H");
							break;
						case 2:
							if(seat2.flag==0) {
								seat2.flag=1;
								order=2;
								mode=1;
							}
							else
								System.out.println("�Ӯy�즳�H");
							break;
						case 3:
							if(seat3.flag==0) {
								seat3.flag=1;
								order=3;
								mode=1;
							}
							else
								System.out.println("�Ӯy�즳�H");
							break;
						case 4:
							if(seat4.flag==0) {
								seat4.flag=1;
								order=4;
								mode=1;
							}
							else
								System.out.println("�Ӯy�즳�H");
							break;
						default:
							break;
					}
				}
				else if(get.substring(0,3).equals("sta")){
					if(get.substring(7,8).equals("t")){
						if(seat1.flag==1) {
							System.out.println("�y��1���H");
							if(seat1.meal.isEmpty()==true) {
								System.out.println("�L�\�I");
							}
							else {
								System.out.println("�w�W��:");
								for(int i=0;i<seat1.done.size();i++) {
									if(seat1.done.get(i)==1) {
										seat1.printmeal(i);
									}
								}
								System.out.println("");
								System.out.println("���W��:");
								for(int i=0;i<seat1.done.size();i++) {
									if(seat1.done.get(i)==0) {
										seat1.printmeal(i);
									}
								}
							}
						}
						if(seat2.flag==1) {
							System.out.println("�y��2���H");
							if(seat2.meal.isEmpty()==true) {
								System.out.println("�L�\�I");
							}
							else {
								System.out.println("�w�W��:");
								for(int i=0;i<seat2.done.size();i++) {
									if(seat2.done.get(i)==1) {
										seat2.printmeal(i);
									}
								}
								System.out.println("");
								System.out.println("���W��:");
								for(int i=0;i<seat2.done.size();i++) {
									if(seat2.done.get(i)==0) {
										seat2.printmeal(i);
									}
								}
							}
						}
						if(seat3.flag==1) {
							System.out.println("�y��3���H");
							if(seat3.meal.isEmpty()==true) {
								System.out.println("�L�\�I");
							}
							else {
								System.out.println("�w�W��:");
								for(int i=0;i<seat3.done.size();i++) {
									if(seat3.done.get(i)==1) {
										seat3.printmeal(i);
									}
								}
								System.out.println("");
								System.out.println("���W��:");
								for(int i=0;i<seat3.done.size();i++) {
									if(seat3.done.get(i)==0) {
										seat3.printmeal(i);
									}
								}
							}
						}
						if(seat4.flag==1) {
							System.out.println("�y��4���H");
							if(seat4.meal.isEmpty()==true) {
								System.out.println("�L�\�I");
							}
							else {
								System.out.println("�w�W��:");
								for(int i=0;i<seat4.done.size();i++) {
									if(seat4.done.get(i)==1) {
										seat4.printmeal(i);
									}
								}
								System.out.println("");
								System.out.println("���W��:");
								for(int i=0;i<seat4.done.size();i++) {
									if(seat4.done.get(i)==0) {
										seat4.printmeal(i);
									}
								}
							}
						}
					}
					else{
						System.out.println("�p�v1");
						if(chef1.meal.size()==0) {
							System.out.println("�L�\�I");
						}
						else {
							System.out.println("���b�ǳ��\�I:");
							chef1.printmeal(0);
							System.out.println("");
							System.out.println("���ǳ��\�I:");
							if(chef1.meal.size()>1) {
								for(int i=1;i<chef1.meal.size();i++) {
									chef1.printmeal(i);
								}
							}
							else
								System.out.println("�L");
						}
						System.out.println("");
						System.out.println("�p�v2");
						if(chef2.meal.size()==0) {
							System.out.println("�L�\�I");
						}
						else {
							System.out.println("���b�ǳ��\�I:");
							chef2.printmeal(0);
							System.out.println("");
							System.out.println("���ǳ��\�I:");
							if(chef2.meal.size()>1) {
								for(int i=1;i<chef2.meal.size();i++) {
									chef2.printmeal(i);
								}
							}
							else
								System.out.println("�L");
						}
					}
				}
				else if(get.substring(0,3).equals("nex")){
					nexttime=Integer.parseInt(get.substring(5,6));
					while(nexttime!=0||chef1.meal.size()!=0){
						if(chef1.meal.get(0)==1||chef1.meal.get(0)==3||chef1.meal.get(0)==5){
							nowdo=chef1.meal.get(0);
							if(nexttime-chef1.time.get(0)>=0){
								nexttime=nexttime-chef1.time.get(0);
								for(int i=0;i<chef1.meal.size();i++){
									if(chef1.meal.get(i)==nowdo){
										switch(chef1.seat.get(i)){
											case 1:
												for(int j=0;j<seat1.meal.size();j++){
													if(seat1.meal.get(j)==nowdo&&seat1.done.get(j)==0){
														seat1.done.set(j,1);
														break;	
													}
												}
												break;
											case 2:
												for(int j=0;j<seat2.meal.size();j++){
													if(seat2.meal.get(j)==nowdo&&seat2.done.get(j)==0){
														seat2.done.set(j,1);
														break;	
													}
												}
												break;
											case 3:
												for(int j=0;j<seat3.meal.size();j++){
													if(seat3.meal.get(j)==nowdo&&seat3.done.get(j)==0){
														seat3.done.set(j,1);
														break;	
													}
												}
												break;
											case 4:
												for(int j=0;j<seat4.meal.size();j++){
													if(seat4.meal.get(j)==nowdo&&seat4.done.get(j)==0){
														seat4.done.set(i,1);
														break;	
													}
												}
												break;
											default:
												break;
										}
									chef1.meal.remove(i);
									chef1.time.remove(i);
									chef1.seat.remove(i);
									}
								}
							}
							else{
								for(int i=0;i<chef1.meal.size();i++){
									if(chef1.meal.get(i)==nowdo){
										chef1.time.set(i, chef1.meal.get(i)-nexttime);
									}
								}
								nexttime=0;
							}
						}
						else{
							if(nexttime-chef1.time.get(0)>=0){
								nexttime=nexttime-chef1.time.get(0);
								switch(chef1.seat.get(0)){
									case 1:
										for(int j=0;j<seat1.meal.size();j++){
											if(seat1.meal.get(j)==nowdo&&seat1.done.get(j)==0){
												seat1.done.set(j,1);
												break;	
											}
										}
										break;
									case 2:
										for(int j=0;j<seat2.meal.size();j++){
											if(seat2.meal.get(j)==nowdo&&seat2.done.get(j)==0){
												seat2.done.set(j,1);
												break;	
											}
										}
										break;
									case 3:
										for(int j=0;j<seat3.meal.size();j++){
											if(seat3.meal.get(j)==nowdo&&seat3.done.get(j)==0){
												seat3.done.set(j,1);
												break;	
											}
										}
										break;
									case 4:
										for(int j=0;j<seat4.meal.size();j++){
											if(seat4.meal.get(j)==nowdo&&seat4.done.get(j)==0){
												seat4.done.set(j,1);
												break;	
											}
										}
										break;
									default:
										break;
								}
								chef1.meal.remove(0);
								chef1.time.remove(0);
								chef1.seat.remove(0);
							}
							else{
								chef1.time.set(0,chef1.time.get(0)-nexttime);
								nexttime=0;
							}
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
						chef1.addtime(Integer.parseInt(get.substring(5,6)),1);
					}
					else {
						chef2.meal.add(Integer.parseInt(get.substring(5,6)));
						chef2.seat.add(order);
						chef2.addtime(Integer.parseInt(get.substring(5,6)),2);
					}
					switch(order){
						case 1:
							seat1.meal.add(Integer.parseInt(get.substring(5,6)));
							seat1.done.add(0);
							seat1.addtime(Integer.parseInt(get.substring(5,6)));
							break;
						case 2:
							seat2.meal.add(Integer.parseInt(get.substring(5,6)));
							seat2.done.add(0);
							seat2.addtime(Integer.parseInt(get.substring(5,6)));
							break;
						case 3:
							seat3.meal.add(Integer.parseInt(get.substring(5,6)));
							seat3.done.add(0);
							seat3.addtime(Integer.parseInt(get.substring(5,6)));
							break;
						case 4:
							seat4.meal.add(Integer.parseInt(get.substring(5,6)));
							seat4.done.add(0);
							seat4.addtime(Integer.parseInt(get.substring(5,6)));
							break;
						default:
							break;
					}
				}
			}
		}
	}
}

