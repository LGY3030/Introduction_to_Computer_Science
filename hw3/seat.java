import java.util.ArrayList;

public class seat {

	public int flag=0;        //�����O�_���H��
	public ArrayList <Integer> meal = new ArrayList();        //�����\�I���X
	public ArrayList <Integer> done = new ArrayList();        //�����O�_�w�W��
	public ArrayList <Integer> eat = new ArrayList();        //�����O�_�w���Χ�
	public ArrayList <Integer> time = new ArrayList();        //�������Ωһݮɶ�
	public ArrayList <Integer> oktime = new ArrayList();        //�����\�I�����ɶ�

	//�L�X�\�I���W��
	public void printmeal(int i){
		if(meal.get(i)==1){
			System.out.println("����");
		}
		else if(meal.get(i)==2){
			System.out.println("��N�N��");
		}
		else if(meal.get(i)==3){
			System.out.println("���C��");
		}
		else if(meal.get(i)==4){
			System.out.println("���o�d�h�J�|");
		}
		else{
			System.out.println("��X�G��");
		}
	}

	//�N�\�I���ήɶ��[�Jtime arraylist
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

	//�����U�ȭ����\�I
	public static void eat(int totaltime,int time,seat seatnow){

		int noweatmeal=0;        //�ثe���Ϊ��\�I
		int temp=10000;        //�Ȧs�\�I�����ɶ�
		int check=1;        //�P�_�w�W��������Ϊ��\�I
		int temp2=0;
		
		//�U�Ȧ��\�I�i�H����
		if(seatnow.meal.size()>0) {

			//check���W�Ҧ��w�W���\�I��eat arraylist��(�]���w�����\�I��eat arraylist�|�ܬ�1�A�S���Χ��|�O0�A�]���p�G���i���Φ��S���Χ����\�I�Acheck�N�|��0)
			for(int i=0;i<seatnow.meal.size();i++) {
				if(seatnow.done.get(i)==1) {
					check*=seatnow.eat.get(i);
				}
			}

			//���٦��Ѿl�ɶ����\�I�|�����Χ��ɡA�|�bwhile�j���
			while(time!=0&&check==0){

				//��X�̦��s�@�������\�I�A��@�ثe�n���Ϊ��\�I(��� oktime arraylist)
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

				//�_�l�ɶ��j��ثe�\�I�������ɶ�(�N���\�I���N�����A�i�ߧY����)
				if(totaltime>=seatnow.oktime.get(noweatmeal)) {

					//�����ɶ��j���\�I�ݭ��ήɶ�(�N��i�H���㭹�Χ���)
					if(time>=seatnow.time.get(noweatmeal)) {
						time=time-seatnow.time.get(noweatmeal);
						totaltime+=seatnow.time.get(noweatmeal);
						seatnow.time.set(noweatmeal,0);
						seatnow.eat.set(noweatmeal,1);

					}
					//�����ɶ��p���\�I�ݭ��ήɶ�(�N���୹�Χ���)
					else {
						totaltime+=time;
						temp2=seatnow.time.get(noweatmeal)-time;
						seatnow.time.set(noweatmeal,temp2);
						time=0;

					}
				}

				//�_�l�ɶ��p��ثe�\�I�������ɶ�(�N���\�I�������A����ߧY����)
				else {
					//�ثe�ɶ��[�W�������ɶ��j��ثe�\�I�������ɶ�(�N��ݭn���ݤ@�q�ɶ��A���b�������ɶ������H�e�A�\�I�|�����A�ҥH���������\�I�����ɡA�b�ھڳѤU�ɶ������U�ȭ����\�I)
					if(totaltime+time>=seatnow.oktime.get(noweatmeal)) {
						time=time-(seatnow.oktime.get(noweatmeal)-totaltime);
						totaltime=seatnow.oktime.get(noweatmeal);

					}
					//�ثe�ɶ��[�W�������ɶ��p��ثe�\�I�������ɶ�(�N��b�������ɶ�������A�ثe�\�I��������)
					else {
						totaltime+=time;
						time=0;
					}
				}
				//���s�P�_check
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