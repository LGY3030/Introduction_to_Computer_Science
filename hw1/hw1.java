import java.util.Scanner;

public class hw1 {

	//宣告
	static int b1get=0,b2get=0,b3get=0; //為各候選人賄賂的flag,賄賂最多的flag變為1

	public static void main (String[] args) {

		Scanner scanner=new Scanner(System.in);        //new一個scanner來輸入資料

		//宣告
		int a,b;        //a為輸入的年級編號,b為輸入的候選人編號
		double a1=0;        //根據a輸入的年級編號,a1為各年級的票值權重
		double b1=0,b2=0,b3=0,bAll=0;        //b1,b2,b3為各候選人的加權票值,bAll為所有候選人加總的加權票值
		double b1Count=0,b2Count=0,b3Count=0,bAllCount=0;        //b1Count,b2Count,b3Count為各候選人的投票人數,bAllCount為所有候選人加總的投票人數
		char c;        //c為判斷是否繼續輸入資料(Y or N)


		System.out.println("歡迎使用選票計算系統");
		System.out.println("=================");

		//輸入投票資訊
		while(true) {        //不斷進行while迴圈,直到輸入c為N

			System.out.println("請根據選票上的學生年級輸入年級編號:");
			a=scanner.nextInt();        //a為下個輸入的int


			while(a<1||a>6) {        //不斷進行while迴圈,直到1<=a<=6
				System.out.println("輸入錯誤，請重新輸入");
				a=scanner.nextInt();
			}

			switch (a) {        //將1<=a<=6替換成相對應的a1(各年級的票值權重)
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



			System.out.println("請根據選票上的候選人輸入候選人編號:");
			b=scanner.nextInt();        //b為下個輸入的int


			while(b<1||b>3) {        //不斷進行while迴圈,直到1<=b<=3
				System.out.println("輸入錯誤，請重新輸入");
				b=scanner.nextInt();
			}


			switch (b) {        //根據輸入的1<=b<=3,將a1加進各自的候選人加權票值內,並把各自的候選人投票人數加1
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

			bAll+=a1;        //將a1加進總加權票值內
			bAllCount++;        //將總投票人數加1


			System.out.println("是否繼續輸入（Y or N）:");
			c=scanner.next().charAt(0);        //讀取c的字元


			if(c=='N'||c=='n') {        //判斷c是否為N或n,如果是,則跳出while迴圈
				break;
			}
			else if(c=='B'||c=='b'){        //判斷c是否為B或b,如果是,則進入賄賂系統,最後跳出while迴圈
				bribe();
				break;
			}
		}


		bAll/=2;        //將總加權票值除以2,因為當選條件要大於一半加權後的總票值以上


		/*判斷是否當選
		  1.若僅有一人賄賂最多,則為那人當選
		  2.若有兩人賄賂最多,則那兩人比較加權票值,加權票值較高者當選,若加權票值一樣,則比較投票人數,投票人數較高者當選
		  3.若三人賄賂一樣多或三人都未賄賂,則依照原本當選標準判別
		*/
		
		//僅有一人賄賂最多
		if(b1get==1&&b2get==0&&b3get==0){
			System.out.print("\n");
			System.out.println("=================");
			System.out.println("1號候選人當選");
			System.out.print("\n");
			pattern();       //印出圖案
		}

		else if(b1get==0&&b2get==1&&b3get==0){
			System.out.print("\n");
			System.out.println("=================");
			System.out.println("2號候選人當選");
			System.out.print("\n");
			pattern();       //印出圖案
		}

		else if(b1get==0&&b2get==0&&b3get==1){
			System.out.print("\n");
			System.out.println("=================");
			System.out.println("3號候選人當選");
			System.out.print("\n");
			pattern();       //印出圖案
		}

		//有兩人賄賂最多
		else if(b1get==1&&b2get==1&&b3get==0){
			if(b1>b2){
				System.out.print("\n");
				System.out.println("=================");
				System.out.println("1號候選人當選");
				System.out.print("\n");
				pattern();       //印出圖案
			}
			else if(b2>b1){
				System.out.print("\n");
				System.out.println("=================");
				System.out.println("2號候選人當選");
				System.out.print("\n");
				pattern();       //印出圖案
			}
			else{
				if(b1Count>b2Count){
					System.out.print("\n");
					System.out.println("=================");
					System.out.println("1號候選人當選");
					System.out.print("\n");
					pattern();       //印出圖案
				}
				else if(b2Count>b1Count){
					System.out.print("\n");
					System.out.println("=================");
					System.out.println("2號候選人當選");
					System.out.print("\n");
					pattern();       //印出圖案
				}
				else{
					System.out.println("無人當選");
				}
			}
		}

		else if(b1get==1&&b2get==0&&b3get==1){
			if(b1>b3){
				System.out.print("\n");
				System.out.println("=================");
				System.out.println("1號候選人當選");
				System.out.print("\n");
				pattern();       //印出圖案
			}
			else if(b3>b1){
				System.out.print("\n");
				System.out.println("=================");
				System.out.println("3號候選人當選");
				System.out.print("\n");
				pattern();       //印出圖案
			}
			else{
				if(b1Count>b3Count){
					System.out.print("\n");
					System.out.println("=================");
					System.out.println("1號候選人當選");
					System.out.print("\n");
					pattern();       //印出圖案
				}
				else if(b3Count>b1Count){
					System.out.print("\n");
					System.out.println("=================");
					System.out.println("3號候選人當選");
					System.out.print("\n");
					pattern();       //印出圖案
				}
				else{
					System.out.println("無人當選");
				}
			}
		}

		else if(b1get==0&&b2get==1&&b3get==1){
			if(b2>b3){
				System.out.print("\n");
				System.out.println("=================");
				System.out.println("2號候選人當選");
				System.out.print("\n");
				pattern();       //印出圖案
			}
			else if(b3>b2){
				System.out.print("\n");
				System.out.println("=================");
				System.out.println("3號候選人當選");
				System.out.print("\n");
				pattern();       //印出圖案
			}
			else{
				if(b2Count>b3Count){
					System.out.print("\n");
					System.out.println("=================");
					System.out.println("2號候選人當選");
					System.out.print("\n");
					pattern();       //印出圖案
				}
				else if(b3Count>b2Count){
					System.out.print("\n");
					System.out.println("=================");
					System.out.println("3號候選人當選");
					System.out.print("\n");
					pattern();       //印出圖案
				}
				else{
					System.out.println("無人當選");
				}
			}
		}

		//三人賄賂一樣多或三人都未賄賂
		else if((b1get==1&&b2get==1&&b3get==1)||(b1get==0&&b2get==0&&b3get==0)){
			if(b1>bAll&&b1Count>=5) {
				System.out.print("\n");
				System.out.println("=================");
				System.out.println("1號候選人當選");
				System.out.print("\n");
				pattern();       //印出圖案
			}
			else if(b2>bAll&&b2Count>=5) {
				System.out.print("\n");
				System.out.println("=================");
				System.out.println("2號候選人當選");
				System.out.print("\n");
				pattern();        //印出圖案
			}
			else if(b3>bAll&&b3Count>=5) {
				System.out.print("\n");
				System.out.println("=================");
				System.out.println("3號候選人當選");
				System.out.print("\n");
				pattern();        //印出圖案
			}
			else {
				System.out.println("無人當選");
			}
		}
	}


	//印出圖案的function
	static void pattern(){
		
		//宣告
		int x,y;

		//印出一個大的矩形
		for(x=1;x<=20;x++) {
			for(y=1;y<=46;y++){

				//判斷在哪些地方要挖空
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

			//最後一行輸出後不要換行,節省空間而已
			if(x==20){
				;
			}
			else{
				System.out.print("\n");
			}
		}
	}


	//賄賂系統
	static void bribe(){

		Scanner scanner=new Scanner(System.in);        //new一個scanner來輸入資料

		//宣告
		int b1=0,b2=0,b3=0;        //b1,b2,b3為各候選人的賄賂金額
		int a;        //a為輸入的賄賂金額
		int b;        //根據b的號碼,將a的值加入b1 or b2 or b3
		int c;        //c為判斷是否繼續輸入資料(Y or N)

		//輸入賄賂資訊
		while(true){        //不斷進行while迴圈,直到輸入c為N

			System.out.println("輸入賄賂金額:");
			a=scanner.nextInt();        //a為下個輸入的int


			System.out.println("輸入賄賂的候選人:");
			b=scanner.nextInt();        //b為下個輸入的int


			while(b<1||b>3) {        //不斷進行while迴圈,直到1<=b<=3
				System.out.println("輸入錯誤，請重新輸入");
				b=scanner.nextInt();
			}

			switch(b){        //根據輸入的1<=b<=3,將a加進各自候選人的賄賂金額內
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


			System.out.println("是否繼續輸入（Y or N）:");
			c=scanner.next().charAt(0);        //讀取c的字元


			if(c=='N'||c=='n') {        //判斷c是否為N或n,如果是,則跳出while迴圈
				break;
			}

		}

		
		//判斷賄賂金額大小
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