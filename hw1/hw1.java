import java.util.Scanner;

public class hw1 {

	//�ŧi
	static int b1get=0,b2get=0,b3get=0; //���U�Կ�H��諸flag,���̦h��flag�ܬ�1

	public static void main (String[] args) {

		Scanner scanner=new Scanner(System.in);        //new�@��scanner�ӿ�J���

		//�ŧi
		int a,b;        //a����J���~�Žs��,b����J���Կ�H�s��
		double a1=0;        //�ھ�a��J���~�Žs��,a1���U�~�Ū������v��
		double b1=0,b2=0,b3=0,bAll=0;        //b1,b2,b3���U�Կ�H���[�v����,bAll���Ҧ��Կ�H�[�`���[�v����
		double b1Count=0,b2Count=0,b3Count=0,bAllCount=0;        //b1Count,b2Count,b3Count���U�Կ�H���벼�H��,bAllCount���Ҧ��Կ�H�[�`���벼�H��
		char c;        //c���P�_�O�_�~���J���(Y or N)


		System.out.println("�w��ϥοﲼ�p��t��");
		System.out.println("=================");

		//��J�벼��T
		while(true) {        //���_�i��while�j��,�����Jc��N

			System.out.println("�Юھڿﲼ�W���ǥͦ~�ſ�J�~�Žs��:");
			a=scanner.nextInt();        //a���U�ӿ�J��int


			while(a<1||a>6) {        //���_�i��while�j��,����1<=a<=6
				System.out.println("��J���~�A�Э��s��J");
				a=scanner.nextInt();
			}

			switch (a) {        //�N1<=a<=6�������۹�����a1(�U�~�Ū������v��)
				case 1:
					a1=1;
					break;
				case 2:
					a1=2;
					break;
				case 3:
					a1=3;
					break;
				case 4:
					a1=4;
					break;
				case 5:
					a1=0.5;
					break;
				case 6:
					a1=0.5;
					break;
				default:
					break;
			}



			System.out.println("�Юھڿﲼ�W���Կ�H��J�Կ�H�s��:");
			b=scanner.nextInt();        //b���U�ӿ�J��int


			while(b<1||b>3) {        //���_�i��while�j��,����1<=b<=3
				System.out.println("��J���~�A�Э��s��J");
				b=scanner.nextInt();
			}


			switch (b) {        //�ھڿ�J��1<=b<=3,�Na1�[�i�U�۪��Կ�H�[�v���Ȥ�,�ç�U�۪��Կ�H�벼�H�ƥ[1
				case 1:
					b1+=a1;
					b1Count++;
					break;
				case 2:
					b2+=a1;
					b1Count++;
					break;
				case 3:
					b3+=a1;
					b3Count++;
					break;
				default:
					break;
			}

			bAll+=a1;        //�Na1�[�i�`�[�v���Ȥ�
			bAllCount++;        //�N�`�벼�H�ƥ[1


			System.out.println("�O�_�~���J�]Y or N�^:");
			c=scanner.next().charAt(0);        //Ū��c���r��


			if(c=='N'||c=='n') {        //�P�_c�O�_��N��n,�p�G�O,�h���Xwhile�j��
				break;
			}
			else if(c=='B'||c=='b'){        //�P�_c�O�_��B��b,�p�G�O,�h�i�J���t��,�̫���Xwhile�j��
				bribe();
				break;
			}
		}


		bAll/=2;        //�N�`�[�v���Ȱ��H2,�]��������n�j��@�b�[�v�᪺�`���ȥH�W


		/*�P�_�O�_���
		  1.�Y�Ȧ��@�H���̦h,�h�����H���
		  2.�Y����H���̦h,�h����H����[�v����,�[�v���ȸ����̷��,�Y�[�v���Ȥ@��,�h����벼�H��,�벼�H�Ƹ����̷��
		  3.�Y�T�H���@�˦h�ΤT�H�������,�h�̷ӭ쥻���зǧP�O
		*/
		
		//�Ȧ��@�H���̦h
		if(b1get==1&&b2get==0&&b3get==0){
			System.out.print("\n");
			System.out.println("=================");
			System.out.println("1���Կ�H���");
			System.out.print("\n");
			pattern();       //�L�X�Ϯ�
		}

		else if(b1get==0&&b2get==1&&b3get==0){
			System.out.print("\n");
			System.out.println("=================");
			System.out.println("2���Կ�H���");
			System.out.print("\n");
			pattern();       //�L�X�Ϯ�
		}

		else if(b1get==0&&b2get==0&&b3get==1){
			System.out.print("\n");
			System.out.println("=================");
			System.out.println("3���Կ�H���");
			System.out.print("\n");
			pattern();       //�L�X�Ϯ�
		}

		//����H���̦h
		else if(b1get==1&&b2get==1&&b3get==0){
			if(b1>b2){
				System.out.print("\n");
				System.out.println("=================");
				System.out.println("1���Կ�H���");
				System.out.print("\n");
				pattern();       //�L�X�Ϯ�
			}
			else if(b2>b1){
				System.out.print("\n");
				System.out.println("=================");
				System.out.println("2���Կ�H���");
				System.out.print("\n");
				pattern();       //�L�X�Ϯ�
			}
			else{
				if(b1Count>b2Count){
					System.out.print("\n");
					System.out.println("=================");
					System.out.println("1���Կ�H���");
					System.out.print("\n");
					pattern();       //�L�X�Ϯ�
				}
				else if(b2Count>b1Count){
					System.out.print("\n");
					System.out.println("=================");
					System.out.println("2���Կ�H���");
					System.out.print("\n");
					pattern();       //�L�X�Ϯ�
				}
				else{
					System.out.println("�L�H���");
				}
			}
		}

		else if(b1get==1&&b2get==0&&b3get==1){
			if(b1>b3){
				System.out.print("\n");
				System.out.println("=================");
				System.out.println("1���Կ�H���");
				System.out.print("\n");
				pattern();       //�L�X�Ϯ�
			}
			else if(b3>b1){
				System.out.print("\n");
				System.out.println("=================");
				System.out.println("3���Կ�H���");
				System.out.print("\n");
				pattern();       //�L�X�Ϯ�
			}
			else{
				if(b1Count>b3Count){
					System.out.print("\n");
					System.out.println("=================");
					System.out.println("1���Կ�H���");
					System.out.print("\n");
					pattern();       //�L�X�Ϯ�
				}
				else if(b3Count>b1Count){
					System.out.print("\n");
					System.out.println("=================");
					System.out.println("3���Կ�H���");
					System.out.print("\n");
					pattern();       //�L�X�Ϯ�
				}
				else{
					System.out.println("�L�H���");
				}
			}
		}

		else if(b1get==0&&b2get==1&&b3get==1){
			if(b2>b3){
				System.out.print("\n");
				System.out.println("=================");
				System.out.println("2���Կ�H���");
				System.out.print("\n");
				pattern();       //�L�X�Ϯ�
			}
			else if(b3>b2){
				System.out.print("\n");
				System.out.println("=================");
				System.out.println("3���Կ�H���");
				System.out.print("\n");
				pattern();       //�L�X�Ϯ�
			}
			else{
				if(b2Count>b3Count){
					System.out.print("\n");
					System.out.println("=================");
					System.out.println("2���Կ�H���");
					System.out.print("\n");
					pattern();       //�L�X�Ϯ�
				}
				else if(b3Count>b2Count){
					System.out.print("\n");
					System.out.println("=================");
					System.out.println("3���Կ�H���");
					System.out.print("\n");
					pattern();       //�L�X�Ϯ�
				}
				else{
					System.out.println("�L�H���");
				}
			}
		}

		//�T�H���@�˦h�ΤT�H�������
		else if((b1get==1&&b2get==1&&b3get==1)||(b1get==0&&b2get==0&&b3get==0)){
			if(b1>bAll&&b1Count>=5) {
				System.out.print("\n");
				System.out.println("=================");
				System.out.println("1���Կ�H���");
				System.out.print("\n");
				pattern();       //�L�X�Ϯ�
			}
			else if(b2>bAll&&b2Count>=5) {
				System.out.print("\n");
				System.out.println("=================");
				System.out.println("2���Կ�H���");
				System.out.print("\n");
				pattern();        //�L�X�Ϯ�
			}
			else if(b3>bAll&&b3Count>=5) {
				System.out.print("\n");
				System.out.println("=================");
				System.out.println("3���Կ�H���");
				System.out.print("\n");
				pattern();        //�L�X�Ϯ�
			}
			else {
				System.out.println("�L�H���");
			}
		}
	}


	//�L�X�Ϯת�function
	static void pattern(){
		
		//�ŧi
		int x,y;

		//�L�X�@�Ӥj���x��
		for(x=1;x<=20;x++) {
			for(y=1;y<=46;y++){

				//�P�_�b���Ǧa��n����
				if(x==4||x==6){
					if((8<=y&&y<=12)||(35<=y&&y<=39)){
						System.out.print(" ");
					}
					else{
						System.out.print("*");
					}
				}
				else if(x==5){
					if((8<=y&&y<=12&&y!=10)||(35<=y&&y<=39&&y!=37)){
						System.out.print(" ");
					}
					else{
						System.out.print("*");
					}
				}
				else if(13<=x&&x<=18){
					if((2*x-13)<=y&&y<(2*(24-(2*x-13))+(2*x-13))){
						System.out.print(" ");	
					}
					else{
						System.out.print("*");
					}
				}
				else{
					System.out.print("*");
				}


			}

			//�̫�@���X�ᤣ�n����,�`�٪Ŷ��Ӥw
			if(x==20){
				;
			}
			else{
				System.out.print("\n");
			}
		}
	}


	//���t��
	static void bribe(){

		Scanner scanner=new Scanner(System.in);        //new�@��scanner�ӿ�J���

		//�ŧi
		int b1=0,b2=0,b3=0;        //b1,b2,b3���U�Կ�H�������B
		int a;        //a����J�������B
		int b;        //�ھ�b�����X,�Na���ȥ[�Jb1 or b2 or b3
		int c;        //c���P�_�O�_�~���J���(Y or N)

		//��J����T
		while(true){        //���_�i��while�j��,�����Jc��N

			System.out.println("��J�����B:");
			a=scanner.nextInt();        //a���U�ӿ�J��int


			System.out.println("��J��諸�Կ�H:");
			b=scanner.nextInt();        //b���U�ӿ�J��int


			while(b<1||b>3) {        //���_�i��while�j��,����1<=b<=3
				System.out.println("��J���~�A�Э��s��J");
				b=scanner.nextInt();
			}

			switch(b){        //�ھڿ�J��1<=b<=3,�Na�[�i�U�ۭԿ�H�������B��
				case 1:
					b1+=a;
					break;
				case 2:
					b2+=a;
					break;
				case 3:
					b3+=a;
					break;
				default:
					break;
			}


			System.out.println("�O�_�~���J�]Y or N�^:");
			c=scanner.next().charAt(0);        //Ū��c���r��


			if(c=='N'||c=='n') {        //�P�_c�O�_��N��n,�p�G�O,�h���Xwhile�j��
				break;
			}

		}

		
		//�P�_�����B�j�p
		if(b1>=b2&&b1>=b3){
			b1get=1;
		}
		else if(b2>=b1&&b2>=b3){
			b2get=1;
		}
		else if(b3>=b1&&b3>=b2){
			b3get=1;
		}
		
	}
}