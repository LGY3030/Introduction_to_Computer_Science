import java.util.Scanner;

public class hw2 {
	public static void main(String[] args) {

		Scanner scanner=new Scanner(System.in);        //new�@��scanner�ӿ�J���
		String a="";        //�Ψӱ�����J�����


		int switchflag=0;        //�P�_�O���ƾ��٬O���ƾ�(0�����ƾ�A1�����ƾ�)
		int activitycheck=0;        //�P�_��J�s��activity�ɡA���S���ɶ��Ĭ�
		int montha=0,monthb=0;        //�ΨӰO���q���ƾ��ഫ����ƾ�ɡA��J����M��
		int day=0;        //day=monthb�A�ΨӰO����e�ҽs�誺��
		int checkeventa=0,checkeventb=0;        //����activity���ɶ�(checkeventa�O�}�l�ɶ��Acheckeventb�O�����ɶ�)�A�N�Ҧ����ɸ���ഫ���u�����A����n�x�s�M����A�ҥH���O��
		int temp1=0,temp2=0;        //�b���s�Ƨ�activity�ɡA�Ȧs���ܼ�
		String temp3="";        //�b���s�Ƨ�activity�ɡA�Ȧs���ܼ�

		int[] eventflag = new int[32];        //new�@��array�A�ΨӧP�_31�ѨC��O�_������(0���S���ʡA1��������)
		String[][][] event = new String[32][22][3];        //new�@��array�A�x�s31�ѨC�骺activity�Bactivity�ƶq�Mactivity�}�l�쵲�����ɶ�
		

		//array��l��
		for(int i=0;i<=31;i++) {
			eventflag[i]=0;
		}

		//array��l��
		for(int i=0;i<=31;i++){
			for(int j=0;j<=21;j++){
				for(int k=0;k<=2;k++){
					if(j==21&&k==0){
						event[i][j][k]="0";
					}
					else{
						event[i][j][k]="";
					}
				}
			}
		}

		
		//�{���|�@���b�o�̭�����A����b���ƾ�Τ��ƾ䤤��J"exit"
		while(true) {

			//���ƾ�(switchflag��0)
			if(switchflag==0) {
				
				//�L�X���ƾ�
				System.out.println("");
				System.out.println("                                 2018�~10��");
				System.out.println("");
				System.out.println("Sun.        Mon.        Tue.        Wed.        Thu.        Fri.        Sat.");

				for(int i=0;i<=31;i++) {

					//��if-else�ӦL���ƾ�A�O�n����M�����n��
					if(i==0) {
						System.out.print("  ");
					}
					else if(i%7==6){
						if(eventflag[i]==1) {
							System.out.printf("%12d*\n",i);        //�p�G���Ѧ�activity�A�h�n�b����᭱�[*
						}
						else {
							System.out.printf("%12d\n",i);
						}
					}
					else if(i%7==0) {
						if(eventflag[i]==1) {
							System.out.printf("%2d*",i);        //�p�G���Ѧ�activity�A�h�n�b����᭱�[*
						}
						else {
							System.out.printf("%2d",i);
						}
					}
					else {
						if(eventflag[i]==1) {
							System.out.printf("%12d*",i);        //�p�G���Ѧ�activity�A�h�n�b����᭱�[*
						}
						else {
							System.out.printf("%12d",i);
						}
					}
				}

				System.out.println("");
				System.out.println("");

				System.out.println("��J���O:");

				a=scanner.nextLine();        //Ū���U�ӿ�J

				if(a.equals("exit")) {        //�Y��J"exit"�A�h���Xwhile�j��
					break;
				}

				else if(a.equals("show")){        //�Y��J"show"�A�h�L�X�Ҧ���activity������Mactivity
					System.out.println("");
					System.out.print("============================================================================");
					System.out.println("");
					System.out.println("");
					
					//�����ˬd31�ѡA��eventflag�O�_��1�A��1�h�L�X����Mactivity�A��0�h����
					for(int i=1;i<=31;i++){
						if(eventflag[i]==1){
							System.out.printf("        2018 �~ 10 �� %d��\n",i);        //�L�X���
							System.out.println("");
							System.out.println("����:");
							for(int j=1;j<=Integer.parseInt(event[i][21][0]);j++){        //�L�X����
								System.out.printf("%d.",j);
								System.out.println(event[i][j][0]);
							}	
						System.out.println("");
						System.out.println("");
						}
					}
				}

				else{        //��J���Oday-[���]�A����������ഫ����ƾ�Ҧ�
					montha=Integer.parseInt(a.substring(4,6));
					monthb=Integer.parseInt(a.substring(7,9));
					switchflag=1;
					day=monthb;
				}

				System.out.println("");
				System.out.print("============================================================================");

			}			
		


			//���ƾ�(switchflag��1)
			if(switchflag==1) {

				//�L�X���ƾ�
				System.out.println("");
				System.out.println("");
				System.out.printf("        2018 �~ 10 �� %d��\n",day);
				System.out.println("");
				System.out.println("����:");

				//�Y��馳activity�A�|���i��ƧǡA�A�L�X
				if(eventflag[day]==1 && Integer.parseInt(event[day][21][0])>0) {

					//�Ƨ�
					for(int i=1;i<Integer.parseInt(event[day][21][0]);i++) {
						temp1=Integer.parseInt(event[day][i][1]);        //activity���}�l�ɶ�
						temp2=Integer.parseInt(event[day][i][2]);        //activity�������ɶ�
						temp3=event[day][i][0];        //activity
						for(int j=i+1;j<=Integer.parseInt(event[day][21][0]);j++){
							//�Q��activity���}�l�ɶ��i��Ƨ�
							if(temp1>Integer.parseInt(event[day][j][1])){
								temp1=Integer.parseInt(event[day][j][1]);
								temp2=Integer.parseInt(event[day][j][2]);
								temp3=event[day][j][0];
								event[day][j][1]=event[day][i][1];
								event[day][j][2]=event[day][i][2];
								event[day][j][0]=event[day][i][0];
								event[day][i][1]=String.valueOf(temp1);
								event[day][i][2]=String.valueOf(temp2);
								event[day][i][0]=temp3;
							}
						}						
					}

					//�L�X
					for(int i=1;i<=Integer.parseInt(event[day][21][0]);i++) {
						System.out.printf("%d.",i);
						System.out.println(event[day][i][0]);
					}
				}

				System.out.println("");

				System.out.println("��J���O:");

				a=scanner.nextLine();        //Ū���U�ӿ�J

				if(a.equals("exit")) {        //�Y��J"exit"�A�h���Xwhile�j��
					break;
				}

				else if(a.equals("month")) {        //�Y��J"month"�A�h��^���ƾ�Ҧ�
					switchflag=0;
				}

				else if(a.substring(0,4).equals("edit")) {        //�Y��Jedit-[���ʽs��]-[���ʮɶ�]�A�h�s��{��activity
					for(int i=1;i<=Integer.parseInt(event[day][21][0]);i++) {

						checkeventa=60*Integer.parseInt(a.substring(7,9))+Integer.parseInt(a.substring(10,12));        //��}�l���ɸ���ഫ���Τ����
						checkeventb=60*Integer.parseInt(a.substring(13,15))+Integer.parseInt(a.substring(16,18));        //�⵲�����ɸ���ഫ���Τ����

						//�ˬd�����ܪ��ɶ��O�_�����Lactivity�Ĭ�
						if(checkeventa>=Integer.parseInt(event[day][i][1])&&checkeventa<=Integer.parseInt(event[day][i][2])) {
							activitycheck=activitycheck+1;
						}
						else if(checkeventb>=Integer.parseInt(event[day][i][1])&&checkeventb<=Integer.parseInt(event[day][i][2])){
							activitycheck=activitycheck+1;
						}
						else if(checkeventa<=Integer.parseInt(event[day][i][1])&&checkeventb>=Integer.parseInt(event[day][i][2])){
							activitycheck=activitycheck+1;
						}
					}

						//�Yactivitycheck��0�A�N��S���Ĭ�A�i�H�s��A�Y����0�A�h���Ĭ�A���i�s��
						if(activitycheck>0){
							System.out.println("�Ӯɶ��Ϭq�w������");
						}
						else{
							event[day][Integer.parseInt(a.substring(5,6))][0]=a.substring(7,9)+":"+a.substring(10,12)+"~"+a.substring(13,15)+":"+a.substring(16,18)+" "+event[day][Integer.parseInt(a.substring(5,6))][0].substring(12);        //�s��activity
							event[day][Integer.parseInt(a.substring(5,6))][1]=String.valueOf(checkeventa);        //�s���}�l�ɶ�
							event[day][Integer.parseInt(a.substring(5,6))][2]=String.valueOf(checkeventb);        //�s�������ɶ�
						}
						activitycheck=0;        //�C���ˬd���A�n��activitycheck�]��0�A�U���ˬd�~�|�O�諸
				}

				else if(a.substring(0,3).equals("del")) {        //�Y�e3�Ӧr�O��Jdel�A�i�J���j��

					if(a.substring(4,5).equals("a")) {        //�Y�O��Jdel-all�A�h�R�����Ҧ�activity 
						//�Ҧ����F��Ҫ�l��
						for(int i=1;i<=Integer.parseInt(event[day][21][0]);i++){
							event[day][i][0]="";
							event[day][i][1]="";
							event[day][i][2]="";
						}
						eventflag[day]=0;
						event[day][21][0]="0";
					}

					else{        //�Y�O��Jdel-[���ʽs��]�A�h�R�����Ӭ��ʽs����activity
						event[day][Integer.parseInt(a.substring(4,5))][0]="";
						event[day][Integer.parseInt(a.substring(4,5))][1]="";
						event[day][Integer.parseInt(a.substring(4,5))][2]="";

						//�R���@��activity����A�᭱��acivity�n���e����
						for(int i=Integer.parseInt(a.substring(4,5));i<=Integer.parseInt(event[day][21][0]);i++){
							event[day][i][0]=event[day][i+1][0];
							event[day][i][1]=event[day][i+1][1];
							event[day][i][2]=event[day][i+1][2];
						}
						event[day][Integer.parseInt(event[day][21][0])][0]="";        //�쥻���̫�@��activity�n�M��
						event[day][Integer.parseInt(event[day][21][0])][1]="";        //�쥻���̫�@��activity�n�M��
						event[day][Integer.parseInt(event[day][21][0])][2]="";        //�쥻���̫�@��activity�n�M��
						event[day][21][0]=String.valueOf(Integer.parseInt(event[day][21][0])-1);        //���activity�ƶq��1
						if(Integer.parseInt(event[day][21][0])==0){
							eventflag[day]=0;
						}
					}
				}

				else if(a.substring(0,3).equals("add")) {        //�Y��Jadd-[���ʮɶ�]-[���ʦW��]�A�h�W�[�s��activity
					
					//�Y���쥻�S��activity�A�h�����[�Jactivity
					if(Integer.parseInt(event[day][21][0])==0){
						checkeventa=60*Integer.parseInt(a.substring(4,6))+Integer.parseInt(a.substring(7,9));        //��}�l���ɸ���ഫ���Τ����
						checkeventb=60*Integer.parseInt(a.substring(10,12))+Integer.parseInt(a.substring(13,15));        //�⵲�����ɸ���ഫ���Τ����
						event[day][21][0]=String.valueOf(Integer.parseInt(event[day][21][0])+1);        //activity�ƶq�[1
						eventflag[day]=1;
						event[day][Integer.parseInt(event[day][21][0])][0]=a.substring(4,15)+" "+a.substring(16);        //activity
						event[day][Integer.parseInt(event[day][21][0])][1]=String.valueOf(checkeventa);        //�}�l�ɶ�
						event[day][Integer.parseInt(event[day][21][0])][2]=String.valueOf(checkeventb);        //�����ɶ�
					}

					//�Y���w��activity�A�h�n�T�{���[�J��activity�S���M�쥻��acivity�ɶ��Ĭ�
					else{
						for(int i=1;i<=Integer.parseInt(event[day][21][0]);i++) {
							checkeventa=60*Integer.parseInt(a.substring(4,6))+Integer.parseInt(a.substring(7,9));        //��}�l���ɸ���ഫ���Τ����
							checkeventb=60*Integer.parseInt(a.substring(10,12))+Integer.parseInt(a.substring(13,15));        //�⵲�����ɸ���ഫ���Τ����

							//�ˬd���[�J��activity�O�_�����Lactivity�Ĭ�
							if(checkeventa>=Integer.parseInt(event[day][i][1])&&checkeventa<=Integer.parseInt(event[day][i][2])) {
								activitycheck=activitycheck+1;
							}
							else if(checkeventb>=Integer.parseInt(event[day][i][1])&&checkeventb<=Integer.parseInt(event[day][i][2])){
								activitycheck=activitycheck+1;
							}
							else if(checkeventa<=Integer.parseInt(event[day][i][1])&&checkeventb>=Integer.parseInt(event[day][i][2])){
								activitycheck=activitycheck+1;
							}
						}

						//�Yactivitycheck��0�A�N��S���Ĭ�A�i�H�W�[�A�Y����0�A�h���Ĭ�A���i�W�[
						if(activitycheck>0){
							System.out.println("�Ӯɶ��Ϭq�w������");
						}
						else{
							event[day][21][0]=String.valueOf(Integer.parseInt(event[day][21][0])+1);        //activity�ƶq�[1
							eventflag[day]=1;
							event[day][Integer.parseInt(event[day][21][0])][0]=a.substring(4,15)+" "+a.substring(16);
							event[day][Integer.parseInt(event[day][21][0])][1]=String.valueOf(checkeventa);        //�}�l�ɶ�
							event[day][Integer.parseInt(event[day][21][0])][2]=String.valueOf(checkeventb);        //�����ɶ�
						}
						activitycheck=0;        //�C���ˬd���A�n��activitycheck�]��0�A�U���ˬd�~�|�O�諸

					}
					
				}
				System.out.println("");
				System.out.print("============================================================================");
			}
		}
	}
}
