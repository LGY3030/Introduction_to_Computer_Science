import java.util.Scanner;

public class hw1 {
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

		//��J��T
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
		}


		bAll/=2;        //�N�`�[�v���Ȱ��H2,�]��������n�j��@�b�[�v�᪺�`���ȥH�W

		//�P�_�O�_���
		if(b1>bAll&&b1Count>=5) {
			System.out.println("1���Կ�H���");
		}
		else if(b2>bAll&&b2Count>=5) {
			System.out.println("2���Կ�H���");
		}
		else if(b3>bAll&&b3Count>=5) {
			System.out.println("3���Կ�H���");
		}
		else {
			System.out.println("�L�H���");
		}
	}
}