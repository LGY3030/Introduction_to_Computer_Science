import java.util.Scanner;

public class hw1 {
	public static void main (String[] args) {
		Scanner scanner=new Scanner(System.in);
		int a,b;
		double a1=0;
		double b1=0,b2=0,b3=0,bAll=0,b1Count=0,b2Count=0,b3Count=0,bAllCount=0;
		char c;
		System.out.println("�w��ϥοﲼ�p��t��");
		System.out.println("=================");
		while(true) {
			System.out.println("�Юھڿﲼ�W���ǥͦ~�ſ�J�~�Žs��:");
			a=scanner.nextInt();
			while(a<1||a>6) {
				System.out.println("��J���~�A�Э��s��J");
				a=scanner.nextInt();
			}
			switch (a) {
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
			b=scanner.nextInt();
			while(b<1||b>3) {
				System.out.println("��J���~�A�Э��s��J");
				b=scanner.nextInt();
			}
			switch (b) {
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
			bAll+=a1;
			bAllCount++;
			System.out.println("�O�_�~���J�]Y or N�^:");
			c=scanner.next().charAt(0);
			if(c=='N'||c=='n') {
				break;
			}
		}
		bAll/=2;
		if(b1>bAll&&b1Count>5) {
			System.out.println("1���Կ�H���");
		}
		else if(b2>bAll&&b2Count>5) {
			System.out.println("2���Կ�H���");
		}
		else if(b3>bAll&&b3Count>5) {
			System.out.println("3���Կ�H���");
		}
		else {
			System.out.println("�L�H���");
		}
	}
}