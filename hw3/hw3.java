import java.util.Scanner;

public class hw3 {

	static seat seat1=new seat();        //�Ы�seat������
	static seat seat2=new seat();        //�Ы�seat������
	static seat seat3=new seat();        //�Ы�seat������
	static seat seat4=new seat();        //�Ы�seat������
	static chef chef1=new chef();        //�Ы�chef������
	static chef chef2=new chef();        //�Ы�chef������
	static String get="";        //�Ψӱ���input
	static int mode=0;        //�ΨӧP�_�޲z�Ҧ�or�I�\�Ҧ���flag
	static int order=0;        //�ΨӰO���ثe���I�\��
	static int ready=0;        //�p�v�ثe�b�ǳƪ��\�I

	//�D�{��
	public static void main(String[] args) {
		
		int totaltime=0;        //�ثe�֭p�������ɶ�

		Scanner scanner=new Scanner(System.in);

		//�I�\�t��
		while(true) {

			System.out.println("");
			System.out.println("===========================================================");
			System.out.println("");

			//�޲z�Ҧ�
			if(mode==0) {

				System.out.println("��J���O:");
				get=scanner.nextLine();
				
				//�w���U�Ȯy��
				if(get.substring(0,3).equals("new")){

					//�ݦw�ƪ��y��O���A�çP�_�O�_�w�g���H
					switch(Integer.parseInt(get.substring(4,5))) {

						//1����
						case 1:
							if(seat1.flag==0) {
								seat1.flag=1;
								order=1;
								mode=1;
							}
							else
								System.out.println("�Ӯy�즳�H");
							break;
						//2����
						case 2:
							if(seat2.flag==0) {
								seat2.flag=1;
								order=2;
								mode=1;
							}
							else
								System.out.println("�Ӯy�즳�H");
							break;
						//3����
						case 3:
							if(seat3.flag==0) {
								seat3.flag=1;
								order=3;
								mode=1;
							}
							else
								System.out.println("�Ӯy�즳�H");
							break;
						//4����
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
				
				//�d�ݪ��p
				else if(get.substring(0,3).equals("sta")){

					//�d�ݩ������p�A�����ˬd�C�@�઺flag�A�æL�X�\�I
					if(get.substring(7,8).equals("t")){
						//1����
						if(seat1.flag==1) {
							System.out.println("");
							System.out.println("---�y��1���H---");

							//�P�_���L�\�I
							//�L�\�I
							if(seat1.meal.isEmpty()==true) {
								System.out.println("");
								System.out.println("�L�\�I");
							}
							//���\�I
							else {
								System.out.println("");
								System.out.println("�w�W��:");
								System.out.println("");
								for(int i=0;i<seat1.done.size();i++) {
									if(seat1.done.get(i)==1) {
										seat1.printmeal(i);
									}
								}
								System.out.println("");

								System.out.println("���W��:");
								System.out.println("");
								for(int i=0;i<seat1.done.size();i++) {
									if(seat1.done.get(i)==0) {
										seat1.printmeal(i);
									}
								}
							}
						}
						//2����
						if(seat2.flag==1) {
							System.out.println("");
							System.out.println("---�y��2���H---");

							//�P�_���L�\�I
							//�L�\�I
							if(seat2.meal.isEmpty()==true) {
								System.out.println("");
								System.out.println("�L�\�I");
							}
							//���\�I
							else {
								System.out.println("");
								System.out.println("�w�W��:");
								System.out.println("");
								for(int i=0;i<seat2.done.size();i++) {
									if(seat2.done.get(i)==1) {
										seat2.printmeal(i);
									}
								}

								System.out.println("");
								System.out.println("���W��:");
								System.out.println("");
								for(int i=0;i<seat2.done.size();i++) {
									if(seat2.done.get(i)==0) {
										seat2.printmeal(i);
									}
								}
							}
						}
						//3����
						if(seat3.flag==1) {
							System.out.println("");
							System.out.println("---�y��3���H---");

							//�P�_���L�\�I
							//�L�\�I
							if(seat3.meal.isEmpty()==true) {
								System.out.println("");
								System.out.println("�L�\�I");
							}
							//���\�I
							else {
								System.out.println("");
								System.out.println("�w�W��:");
								System.out.println("");
								for(int i=0;i<seat3.done.size();i++) {
									if(seat3.done.get(i)==1) {
										seat3.printmeal(i);
									}
								}

								System.out.println("");
								System.out.println("���W��:");
								System.out.println("");
								for(int i=0;i<seat3.done.size();i++) {
									if(seat3.done.get(i)==0) {
										seat3.printmeal(i);
									}
								}
							}
						}
						//4����
						if(seat4.flag==1) {
							System.out.println("");
							System.out.println("---�y��4���H---");

							//�P�_���L�\�I
							//�L�\�I
							if(seat4.meal.isEmpty()==true) {
								System.out.println("");
								System.out.println("�L�\�I");
							}
							//���\�I
							else {
								System.out.println("");
								System.out.println("�w�W��:");
								System.out.println("");
								for(int i=0;i<seat4.done.size();i++) {
									if(seat4.done.get(i)==1) {
										seat4.printmeal(i);
									}
								}

								System.out.println("");
								System.out.println("���W��:");
								System.out.println("");
								for(int i=0;i<seat4.done.size();i++) {
									if(seat4.done.get(i)==0) {
										seat4.printmeal(i);
									}
								}
							}
						}
					}

					//�d�ݼp�v���p�A�����L�X���Ӽp�v���\�I
					else{
						//�p�v1
						System.out.println("");
						System.out.println("---�p�v1---");
						
						//�ˬd���L�\�I
						//�L�\�I
						if(chef1.meal.size()==0) {
							System.out.println("");
							System.out.println("�L�\�I");
						}
						//���\�I
						else {
							System.out.println("");
							System.out.println("���b�ǳ��\�I:");
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
							System.out.println("���ǳ��\�I:");
							System.out.println("");
							for(int i=0;i<chef1.meal.size();i++) {
								if(chef1.oktime.get(i)==0&&i!=ready){
									chef1.printmeal(i);
								}
							}
						}

						//�p�v2
						System.out.println("");
						System.out.println("");
						System.out.println("---�p�v2---");

						//�ˬd���L�\�I
						//�L�\�I
						if(chef2.meal.size()==0) {
							System.out.println("");
							System.out.println("�L�\�I");
						}
						//���\�I
						else {
							System.out.println("");
							System.out.println("���b�ǳ��\�I:");
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
							System.out.println("���ǳ��\�I:");
							System.out.println("");
							for(int i=0;i<chef2.meal.size();i++) {
								if(chef2.oktime.get(i)==0&&i!=ready){
									chef2.printmeal(i);
								}
							}
						}
					}
				}

				//�����g�L�ɶ�
				else if(get.substring(0,3).equals("nex")){

					//call �p�v��workfunction
					chef.work(totaltime,Integer.parseInt(get.substring(5)),chef1,seat1,seat2,seat3,seat4);
					chef.work(totaltime,Integer.parseInt(get.substring(5)),chef2,seat1,seat2,seat3,seat4);

					//call ��l��eat function
					seat.eat(totaltime,Integer.parseInt(get.substring(5)),seat1);
					seat.eat(totaltime,Integer.parseInt(get.substring(5)),seat2);
					seat.eat(totaltime,Integer.parseInt(get.substring(5)),seat3);
					seat.eat(totaltime,Integer.parseInt(get.substring(5)),seat4);

					//�ˬd��l���U�ȬO�_�Y��
					check(1,seat1);
					check(2,seat2);
					check(3,seat3);
					check(4,seat4);

					//�֭p�������ɶ��W�[
					totaltime+=Integer.parseInt(get.substring(5));
				}
				
				//�����t�� 	
				else {
					break;
				}
			}
			
			//�I�\�Ҧ�
			if(mode==1) {

				System.out.println("");
				System.out.println("�I�\:");
				get=scanner.nextLine();

				//�����I�\�Ҧ�
				if(get.substring(0,3).equals("end")) {
					mode=0;
				}

				//�I�\
				else {

					//�������p�v1
					if(Integer.parseInt(get.substring(8,9))==1) {
						//���I�\��T�[�J�Ҧ�arraylist
						chef1.meal.add(Integer.parseInt(get.substring(5,6)));
						chef1.seat.add(order);
						chef1.oktime.add(0);
						chef1.addtime(Integer.parseInt(get.substring(5,6)),1);
					}

					//�������p�v2
					else {
						//���I�\��T�[�J�Ҧ�arraylist
						chef2.meal.add(Integer.parseInt(get.substring(5,6)));
						chef2.seat.add(order);
						chef2.oktime.add(0);
						chef2.addtime(Integer.parseInt(get.substring(5,6)),2);
					}

					//�P�_�O���Ӧ�l�I�\�A�ç��I�\��T�[�J�Ҧ�arraylist
					switch(order){

						//1����
						case 1:
							seat1.meal.add(Integer.parseInt(get.substring(5,6)));
							seat1.done.add(0);
							seat1.oktime.add(0);
							seat1.eat.add(0);
							seat1.addtime(Integer.parseInt(get.substring(5,6)));
							break;

						//2����
						case 2:
							seat2.meal.add(Integer.parseInt(get.substring(5,6)));
							seat2.done.add(0);
							seat2.oktime.add(0);
							seat2.eat.add(0);
							seat2.addtime(Integer.parseInt(get.substring(5,6)));
							break;

						//3����
						case 3:
							seat3.meal.add(Integer.parseInt(get.substring(5,6)));
							seat3.done.add(0);
							seat3.oktime.add(0);
							seat3.eat.add(0);
							seat3.addtime(Integer.parseInt(get.substring(5,6)));
							break;

						//4����
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

	//�ΨӧP�_�U�ȬO�_�w�Y���Ҧ��\�I
	public static void check(int num,seat seatnow) {

		int check=1;

		//���P�_���y��O�_���I�\
		if(seatnow.meal.size()>0) {

			//�Q��check�o���ܼƻP�Ҧ�eat arraylist���ܼƬۭ��A�p�Gcheck����1�A�N��Ҧ�eat arraylist���O1�A�N���U�Ȥw���Χ���
			for(int i=0;i<seatnow.meal.size();i++) {
				check*=seatnow.eat.get(i);
			}
			//�w�Y��
			if(check==1) {
				//��Ӧ�l��arraylist�M�šAflag�k0
				seatnow.meal.clear();
				seatnow.done.clear();
				seatnow.eat.clear();
				seatnow.time.clear();
				seatnow.oktime.clear();
				seatnow.flag=0;

				//��b�p�v1��arraylist�̡A�Ӧ�l���I���\�I��T�M��
				for(int i=0;i<chef1.meal.size();i++) {
					if(chef1.seat.get(i)==num) {
						chef1.meal.remove(i);
						chef1.seat.remove(i);
						chef1.time.remove(i);
						chef1.oktime.remove(i);
					}
				}
				//��b�p�v2��arraylist�̡A�Ӧ�l���I���\�I��T�M��
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