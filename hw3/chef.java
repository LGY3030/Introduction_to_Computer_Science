import java.util.ArrayList;

public class chef {
	
	public ArrayList <Integer> meal = new ArrayList();        //�����\�I���X
	public ArrayList <Integer> seat = new ArrayList();        //���������\���I
	public ArrayList <Integer> time = new ArrayList();        //�����\�I�s�@�ɶ�
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

	//�N�\�I�s�@�ɶ��[�Jtime arraylist(��Ӽp�v�s�@���\�I�ɶ����@��)
	public void addtime(int i,int j){
		//�p�v1
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
		//�p�v2
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

	//�����p�v�s�@�\�I
	public static void work(int totaltime,int time,chef chefnow,seat seat1,seat seat2,seat seat3,seat seat4){

		int check=0;        //�P�_�O�_�٦��\�I�S��
		int nowdomeal=0;        //�������b�����\�I
		int nowdonum=0;        //�������b�����\�I��index
		int temp=0;        //�Ȧs�\�I�ݭn�s�@�ɶ�

		//�p�v���\�I�i�H�s�@
		if(chefnow.meal.size()>0){

			//check��h�Ҧ��\�I���s�@�ɶ�(�]���ڪ��]�p�A����\�I�s�@������A�L�������s�@�ɶ���arraylist�|�k0�A�ҥH�Ҧ��\�I���s�@���ɡAcheck�̲׷|�ܬ�0)
			for(int i=0;i<chefnow.time.size();i++){
				check=check-chefnow.time.get(i);
			}

			//���٦��Ѿl�ɶ����\�I�|���s�@���ɡA�|�bwhile�j���
			while(time!=0&&check!=0){
				//���o�ثe�n�s�@���\�I
				for(int i=0;i<chefnow.meal.size();i++){
					if(chefnow.time.get(i)!=0){
						nowdomeal=chefnow.meal.get(i);
						nowdonum=i;
						break;
					}
				}
				//���\�I�i�H�P�ɻs�@�h��
				if(chefnow.meal.get(nowdonum)==1||chefnow.meal.get(nowdonum)==3||chefnow.meal.get(nowdonum)==5){
					//�Ѿl�ɶ��j����\�I�һݻs�@�ɶ�
					if(time-chefnow.time.get(nowdonum)>=0){
						time=time-chefnow.time.get(nowdonum);        //�Ѿl�ɶ���h�s�@�ɶ�

						//�]�����\�I�i�H�P�ɻs�@�h���A�ҥH��X�Ҧ��ۦP���\�I
						for(int i=0;i<chefnow.meal.size();i++){
							if(chefnow.meal.get(i)==nowdomeal&&chefnow.time.get(i)!=0&&chefnow.time.get(i)==chefnow.time.get(nowdonum)){
								temp=chefnow.time.get(i);
								chefnow.oktime.set(i,chefnow.time.get(i)+totaltime);        //���������ɶ�

								//�P�_���\�I�O�ѭ�����I
								switch(chefnow.seat.get(i)){

									//1����A�ç����\�I��done�Moktime��arraylist
									case 1:
										for(int j=0;j<seat1.meal.size();j++){
											if(seat1.meal.get(j)==nowdomeal&&seat1.done.get(j)==0){
												seat1.done.set(j,1);
												seat1.oktime.set(j,chefnow.time.get(i)+totaltime);
												break;	
											}
										}
										break;

									//2����A�ç����\�I��done�Moktime��arraylist
									case 2:
										for(int j=0;j<seat2.meal.size();j++){
											if(seat2.meal.get(j)==nowdomeal&&seat2.done.get(j)==0){
												seat2.done.set(j,1);
												seat2.oktime.set(j,chefnow.time.get(i)+totaltime);
												break;	
											}
										}
										break;

									//3����A�ç����\�I��done�Moktime��arraylist
									case 3:
										for(int j=0;j<seat3.meal.size();j++){
											if(seat3.meal.get(j)==nowdomeal&&seat3.done.get(j)==0){
												seat3.done.set(j,1);
												seat3.oktime.set(j,chefnow.time.get(i)+totaltime);
												break;	
											}
										}
										break;

									//4����A�ç����\�I��done�Moktime��arraylist
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
								chefnow.time.set(i,0);        //�]���\�I�����A�ҥH�s�@�ɶ��k0
							}

							totaltime+=temp;
						}
					}

					//�Ѿl�ɶ��p����\�I�һݻs�@�ɶ��A�������A�ҥH�N���\�I�s�@�ɶ���h�Ѿl�ɶ�
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
					//�Ѿl�ɶ��j����\�I�һݻs�@�ɶ�
					if(time-chefnow.time.get(nowdonum)>=0){
						time=time-chefnow.time.get(nowdonum);        //�Ѿl�ɶ���h�s�@�ɶ�
						temp=chefnow.time.get(nowdonum);
						chefnow.oktime.set(nowdonum,chefnow.time.get(nowdonum)+totaltime);        //���������ɶ�

						//�P�_���\�I�O�ѭ�����I
						switch(chefnow.seat.get(nowdonum)){

							//1����A�ç����\�I��done�Moktime��arraylist
							case 1:
								for(int j=0;j<seat1.meal.size();j++){
									if(seat1.meal.get(j)==nowdomeal&&seat1.done.get(j)==0){
										seat1.done.set(j,1);
										seat1.oktime.set(j,chefnow.time.get(nowdonum)+totaltime);
										break;	
									}
										}
								break;
							//2����A�ç����\�I��done�Moktime��arraylist
							case 2:
								for(int j=0;j<seat2.meal.size();j++){
									if(seat2.meal.get(j)==nowdomeal&&seat2.done.get(j)==0){
										seat2.done.set(j,1);
										seat2.oktime.set(j,chefnow.time.get(nowdonum)+totaltime);
										break;	
									}
								}
								break;
							//3����A�ç����\�I��done�Moktime��arraylist
							case 3:
								for(int j=0;j<seat3.meal.size();j++){
									if(seat3.meal.get(j)==nowdomeal&&seat3.done.get(j)==0){
										seat3.done.set(j,1);
										seat3.oktime.set(j,chefnow.time.get(nowdonum)+totaltime);
										break;	
									}
								}
								break;
							//4����A�ç����\�I��done�Moktime��arraylist
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
						chefnow.time.set(nowdonum,0);        //�]���\�I�����A�ҥH�s�@�ɶ��k0
						totaltime+=temp;
					}

					//�Ѿl�ɶ��p����\�I�һݻs�@�ɶ��A�������A�ҥH�N���\�I�s�@�ɶ���h�Ѿl�ɶ�
					else{
						chefnow.time.set(nowdonum,chefnow.time.get(nowdonum)-time);
						totaltime+=time;
						time=0;
					}

				}

				//���s�P�_check
				for(int i=0;i<chefnow.oktime.size();i++){
					check=check-chefnow.time.get(i);
				}	
			}
		}		
	}
}