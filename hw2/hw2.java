import java.util.Scanner;

public class hw2 {
	public static void main(String[] args) {
		int switchflag=0;
		int endflag=0;
		int montha=0,monthb=0;
		int day=0;
		int temp1=0,temp2=0;
		String temp3="";
		int checkeventa=0,checkeventb=0;
		String a="";
		int[] eventflag = new int[32];
		String[][][] event = new String[32][22][3];
		Scanner scanner=new Scanner(System.in);
		for(int i=0;i<=31;i++) {
			eventflag[i]=0;
		}
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
		while(true) {
			if(switchflag==0) {
				System.out.println("");
				System.out.println("                                 2018年10月");
				System.out.println("");
				System.out.println("Sun.        Mon.        Tue.        Wed.        Thu.        Fri.        Sat.");
				for(int i=0;i<=31;i++) {
					if(i==0) {
						System.out.print("  ");
					}
					else if(i%7==6){
						if(eventflag[i]==1) {
							System.out.printf("%12d*\n",i);
						}
						else {
							System.out.printf("%12d\n",i);
						}
					}
					else if(i%7==0) {
						if(eventflag[i]==1) {
							System.out.printf("%2d*",i);
						}
						else {
							System.out.printf("%2d",i);
						}
					}
					else {
						if(eventflag[i]==1) {
							System.out.printf("%12d*",i);
						}
						else {
							System.out.printf("%12d",i);
						}
					}
				}
				System.out.println("");
				System.out.println("");
				System.out.println("輸入指令:");
				a=scanner.nextLine();
				if(a.equals("exit")) {
					break;
				}
				else {
					montha=Integer.parseInt(a.substring(4,6));
					monthb=Integer.parseInt(a.substring(7,9));
					switchflag=1;
					day=monthb;
				}
				System.out.println("");
				System.out.print("============================================================================");
			}			
		
			if(switchflag==1) {
				System.out.println("");
				System.out.println("");
				System.out.printf("        2018 年 10 月 %d日\n",day);
				System.out.println("");
				System.out.println("活動:");
				if(eventflag[day]==1 && Integer.parseInt(event[day][21][0])>0) {
					for(int i=1;i<Integer.parseInt(event[day][21][0]);i++) {
						temp1=Integer.parseInt(event[day][i][1]);
						temp2=Integer.parseInt(event[day][i][2]);
						temp3=event[day][i][0];
						for(int j=i+1;j<=Integer.parseInt(event[day][21][0]);j++){
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
					for(int i=1;i<=Integer.parseInt(event[day][21][0]);i++) {
						System.out.printf("%d.",i);
						System.out.println(event[day][i][0]);
					}
				}
				System.out.println("");
				System.out.println("輸入指令:");
				a=scanner.nextLine();
				if(a.equals("exit")) {
					break;
				}
				else if(a.equals("month")) {
					switchflag=0;
				}
				else if(a.substring(0,3).equals("del")) {
					
				}
				else if(a.substring(0,3).equals("add")) {
					if(Integer.parseInt(event[day][21][0])==0){
						checkeventa=60*Integer.parseInt(a.substring(4,6))+Integer.parseInt(a.substring(7,9));
						checkeventb=60*Integer.parseInt(a.substring(10,12))+Integer.parseInt(a.substring(13,15));
						event[day][21][0]=String.valueOf(Integer.parseInt(event[day][21][0])+1);
						eventflag[day]=1;
						event[day][Integer.parseInt(event[day][21][0])][0]=a.substring(4,15)+" "+a.substring(16);
						event[day][Integer.parseInt(event[day][21][0])][1]=String.valueOf(checkeventa);
						event[day][Integer.parseInt(event[day][21][0])][2]=String.valueOf(checkeventb);
					}
					else{
						for(int i=1;i<=Integer.parseInt(event[day][21][0]);i++) {
							checkeventa=60*Integer.parseInt(a.substring(4,6))+Integer.parseInt(a.substring(7,9));
							checkeventb=60*Integer.parseInt(a.substring(10,12))+Integer.parseInt(a.substring(13,15));
							if(checkeventa>=Integer.parseInt(event[day][i][1])&&checkeventa<=Integer.parseInt(event[day][i][2])) {
								System.out.println("該時間區段已有活動");
								break;
							}
							else if(checkeventb>=Integer.parseInt(event[day][i][1])&&checkeventb<=Integer.parseInt(event[day][i][2])){
								System.out.println("該時間區段已有活動");
								break;
							}
							else if(checkeventa<=Integer.parseInt(event[day][i][1])&&checkeventb>=Integer.parseInt(event[day][i][2])){
								System.out.println("該時間區段已有活動");
								break;
							}
							else {
								event[day][21][0]=String.valueOf(Integer.parseInt(event[day][21][0])+1);
								eventflag[day]=1;
								event[day][Integer.parseInt(event[day][21][0])][0]=a.substring(4,15)+" "+a.substring(16);
								event[day][Integer.parseInt(event[day][21][0])][1]=String.valueOf(checkeventa);
								event[day][Integer.parseInt(event[day][21][0])][2]=String.valueOf(checkeventb);
								break;
							}
						}
					}
					
				}
				System.out.println("");
				System.out.print("============================================================================");
			}
		}
	}
}
