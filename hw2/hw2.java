import java.util.Scanner;

public class hw2 {
	public static void main(String[] args) {

		Scanner scanner=new Scanner(System.in);        //new一個scanner來輸入資料
		String a="";        //用來接收輸入的資料


		int switchflag=0;        //判斷是月行事曆還是日行事曆(0為月行事曆，1為日行事曆)
		int activitycheck=0;        //判斷輸入新的activity時，有沒有時間衝突
		int montha=0,monthb=0;        //用來記錄從月行事曆轉換到日行事曆時，輸入的月和日
		int day=0;        //day=monthb，用來記錄當前所編輯的日
		int checkeventa=0,checkeventb=0;        //紀錄activity的時間(checkeventa是開始時間，checkeventb是結束時間)，將所有的時跟分轉換成只有分，比較好儲存和比較，所以單位是分
		int temp1=0,temp2=0;        //在重新排序activity時，暫存的變數
		String temp3="";        //在重新排序activity時，暫存的變數

		int[] eventflag = new int[32];        //new一個array，用來判斷31天每日是否有活動(0為沒活動，1為有活動)
		String[][][] event = new String[32][22][3];        //new一個array，儲存31天每日的activity、activity數量和activity開始到結束的時間
		

		//array初始化
		for(int i=0;i<=31;i++) {
			eventflag[i]=0;
		}

		//array初始化
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

		
		//程式會一直在這裡面執行，直到在月行事曆或日行事曆中輸入"exit"
		while(true) {

			//月行事曆(switchflag為0)
			if(switchflag==0) {
				
				//印出月行事曆
				System.out.println("");
				System.out.println("                                 2018年10月");
				System.out.println("");
				System.out.println("Sun.        Mon.        Tue.        Wed.        Thu.        Fri.        Sat.");

				for(int i=0;i<=31;i++) {

					//用if-else來印月行事曆，是要換行和版面好看
					if(i==0) {
						System.out.print("  ");
					}
					else if(i%7==6){
						if(eventflag[i]==1) {
							System.out.printf("%12d*\n",i);        //如果那天有activity，則要在日期後面加*
						}
						else {
							System.out.printf("%12d\n",i);
						}
					}
					else if(i%7==0) {
						if(eventflag[i]==1) {
							System.out.printf("%2d*",i);        //如果那天有activity，則要在日期後面加*
						}
						else {
							System.out.printf("%2d",i);
						}
					}
					else {
						if(eventflag[i]==1) {
							System.out.printf("%12d*",i);        //如果那天有activity，則要在日期後面加*
						}
						else {
							System.out.printf("%12d",i);
						}
					}
				}

				System.out.println("");
				System.out.println("");

				System.out.println("輸入指令:");

				a=scanner.nextLine();        //讀取下個輸入

				if(a.equals("exit")) {        //若輸入"exit"，則跳出while迴圈
					break;
				}

				else if(a.equals("show")){        //若輸入"show"，則印出所有有activity的日期和activity
					System.out.println("");
					System.out.print("============================================================================");
					System.out.println("");
					System.out.println("");
					
					//直接檢查31天，看eventflag是否為1，為1則印出日期和activity，為0則不管
					for(int i=1;i<=31;i++){
						if(eventflag[i]==1){
							System.out.printf("        2018 年 10 月 %d日\n",i);        //印出日期
							System.out.println("");
							System.out.println("活動:");
							for(int j=1;j<=Integer.parseInt(event[i][21][0]);j++){        //印出活動
								System.out.printf("%d.",j);
								System.out.println(event[i][j][0]);
							}	
						System.out.println("");
						System.out.println("");
						}
					}
				}

				else{        //輸入的是day-[日期]，紀錄日期並轉換到日行事曆模式
					montha=Integer.parseInt(a.substring(4,6));
					monthb=Integer.parseInt(a.substring(7,9));
					switchflag=1;
					day=monthb;
				}

				System.out.println("");
				System.out.print("============================================================================");

			}			
		


			//日行事曆(switchflag為1)
			if(switchflag==1) {

				//印出日行事曆
				System.out.println("");
				System.out.println("");
				System.out.printf("        2018 年 10 月 %d日\n",day);
				System.out.println("");
				System.out.println("活動:");

				//若當日有activity，會先進行排序，再印出
				if(eventflag[day]==1 && Integer.parseInt(event[day][21][0])>0) {

					//排序
					for(int i=1;i<Integer.parseInt(event[day][21][0]);i++) {
						temp1=Integer.parseInt(event[day][i][1]);        //activity的開始時間
						temp2=Integer.parseInt(event[day][i][2]);        //activity的結束時間
						temp3=event[day][i][0];        //activity
						for(int j=i+1;j<=Integer.parseInt(event[day][21][0]);j++){
							//利用activity的開始時間進行排序
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

					//印出
					for(int i=1;i<=Integer.parseInt(event[day][21][0]);i++) {
						System.out.printf("%d.",i);
						System.out.println(event[day][i][0]);
					}
				}

				System.out.println("");

				System.out.println("輸入指令:");

				a=scanner.nextLine();        //讀取下個輸入

				if(a.equals("exit")) {        //若輸入"exit"，則跳出while迴圈
					break;
				}

				else if(a.equals("month")) {        //若輸入"month"，則返回月行事曆模式
					switchflag=0;
				}

				else if(a.substring(0,4).equals("edit")) {        //若輸入edit-[活動編號]-[活動時間]，則編輯現有activity
					for(int i=1;i<=Integer.parseInt(event[day][21][0]);i++) {

						checkeventa=60*Integer.parseInt(a.substring(7,9))+Integer.parseInt(a.substring(10,12));        //把開始的時跟分轉換成用分表示
						checkeventb=60*Integer.parseInt(a.substring(13,15))+Integer.parseInt(a.substring(16,18));        //把結束的時跟分轉換成用分表示

						//檢查欲改變的時間是否有跟其他activity衝突
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

						//若activitycheck為0，代表沒有衝突，可以編輯，若不為0，則有衝突，不可編輯
						if(activitycheck>0){
							System.out.println("該時間區段已有活動");
						}
						else{
							event[day][Integer.parseInt(a.substring(5,6))][0]=a.substring(7,9)+":"+a.substring(10,12)+"~"+a.substring(13,15)+":"+a.substring(16,18)+" "+event[day][Integer.parseInt(a.substring(5,6))][0].substring(12);        //新的activity
							event[day][Integer.parseInt(a.substring(5,6))][1]=String.valueOf(checkeventa);        //新的開始時間
							event[day][Integer.parseInt(a.substring(5,6))][2]=String.valueOf(checkeventb);        //新的結束時間
						}
						activitycheck=0;        //每次檢查完，要把activitycheck設為0，下次檢查才會是對的
				}

				else if(a.substring(0,3).equals("del")) {        //若前3個字是輸入del，進入此迴圈

					if(a.substring(4,5).equals("a")) {        //若是輸入del-all，則刪除當日所有activity 
						//所有當日東西皆初始化
						for(int i=1;i<=Integer.parseInt(event[day][21][0]);i++){
							event[day][i][0]="";
							event[day][i][1]="";
							event[day][i][2]="";
						}
						eventflag[day]=0;
						event[day][21][0]="0";
					}

					else{        //若是輸入del-[活動編號]，則刪除當日該活動編號的activity
						event[day][Integer.parseInt(a.substring(4,5))][0]="";
						event[day][Integer.parseInt(a.substring(4,5))][1]="";
						event[day][Integer.parseInt(a.substring(4,5))][2]="";

						//刪除一個activity之後，後面的acivity要往前遞補
						for(int i=Integer.parseInt(a.substring(4,5));i<=Integer.parseInt(event[day][21][0]);i++){
							event[day][i][0]=event[day][i+1][0];
							event[day][i][1]=event[day][i+1][1];
							event[day][i][2]=event[day][i+1][2];
						}
						event[day][Integer.parseInt(event[day][21][0])][0]="";        //原本的最後一個activity要清空
						event[day][Integer.parseInt(event[day][21][0])][1]="";        //原本的最後一個activity要清空
						event[day][Integer.parseInt(event[day][21][0])][2]="";        //原本的最後一個activity要清空
						event[day][21][0]=String.valueOf(Integer.parseInt(event[day][21][0])-1);        //當日activity數量減1
						if(Integer.parseInt(event[day][21][0])==0){
							eventflag[day]=0;
						}
					}
				}

				else if(a.substring(0,3).equals("add")) {        //若輸入add-[活動時間]-[活動名稱]，則增加新的activity
					
					//若當日原本沒有activity，則直接加入activity
					if(Integer.parseInt(event[day][21][0])==0){
						checkeventa=60*Integer.parseInt(a.substring(4,6))+Integer.parseInt(a.substring(7,9));        //把開始的時跟分轉換成用分表示
						checkeventb=60*Integer.parseInt(a.substring(10,12))+Integer.parseInt(a.substring(13,15));        //把結束的時跟分轉換成用分表示
						event[day][21][0]=String.valueOf(Integer.parseInt(event[day][21][0])+1);        //activity數量加1
						eventflag[day]=1;
						event[day][Integer.parseInt(event[day][21][0])][0]=a.substring(4,15)+" "+a.substring(16);        //activity
						event[day][Integer.parseInt(event[day][21][0])][1]=String.valueOf(checkeventa);        //開始時間
						event[day][Integer.parseInt(event[day][21][0])][2]=String.valueOf(checkeventb);        //結束時間
					}

					//若當日已有activity，則要確認欲加入的activity沒有和原本的acivity時間衝突
					else{
						for(int i=1;i<=Integer.parseInt(event[day][21][0]);i++) {
							checkeventa=60*Integer.parseInt(a.substring(4,6))+Integer.parseInt(a.substring(7,9));        //把開始的時跟分轉換成用分表示
							checkeventb=60*Integer.parseInt(a.substring(10,12))+Integer.parseInt(a.substring(13,15));        //把結束的時跟分轉換成用分表示

							//檢查欲加入的activity是否有跟其他activity衝突
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

						//若activitycheck為0，代表沒有衝突，可以增加，若不為0，則有衝突，不可增加
						if(activitycheck>0){
							System.out.println("該時間區段已有活動");
						}
						else{
							event[day][21][0]=String.valueOf(Integer.parseInt(event[day][21][0])+1);        //activity數量加1
							eventflag[day]=1;
							event[day][Integer.parseInt(event[day][21][0])][0]=a.substring(4,15)+" "+a.substring(16);
							event[day][Integer.parseInt(event[day][21][0])][1]=String.valueOf(checkeventa);        //開始時間
							event[day][Integer.parseInt(event[day][21][0])][2]=String.valueOf(checkeventb);        //結束時間
						}
						activitycheck=0;        //每次檢查完，要把activitycheck設為0，下次檢查才會是對的

					}
					
				}
				System.out.println("");
				System.out.print("============================================================================");
			}
		}
	}
}
