import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.text.DecimalFormat;

class Game {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat decimalFormat = new DecimalFormat();

		int money = 1000;
			System.out.print("가위(1), 바위(2), 보(3) 중 번호를 입력 : ");
		int user= System.in.read();
			System.in.read();
			System.in.read();
			System.out.print("배팅 금액 입력 : ");
		int bet = Integer.parseInt(br.readLine());
			
		
		int com = (int)(Math.random()*3)+1;
		
		if(user==1){
			if(com==1) {System.out.println("컴퓨터: 가위, 나: 가위\n비겼습니다.\n현재 금액은 "+decimalFormat.format(money)+"원입니다.");}
			else if(com==2) {System.out.println("컴퓨터: 바위, 나: 가위\n졌습니다.");
							money-=bet;
							System.out.println("현재 금액은 "+decimalFormat.format(money)+"원 입니다.");}
			else			{System.out.println("컴퓨터: 보, 나: 가위\n이겼습니다."); 
							money+=bet;
							System.out.println("현재 금액은 "+decimalFormat.format(money)+"원 입니다.");}
					}

		else if(user==2) {
			if(com==1)		{System.out.println("컴퓨터: 가위, 나: 바위\n이겼습니다.");
							money+=bet;
							System.out.println("현재 금액은 "+decimalFormat.format(money)+"원 입니다.");}
			else if(com==2) {System.out.println("컴퓨터: 바위, 나: 바위\n비겼습니다.\n현재 금액은 "+decimalFormat.format(money)+"원입니다.");}
			else			{System.out.println("컴퓨터: 보, 나: 바위\n졌습니다.");
							money-=bet;
							System.out.println("현재 금액은 "+decimalFormat.format(money)+"원 입니다.");}
					}
		
		else{
			if(com==1)		{System.out.println("컴퓨터: 가위, 나: 보\n졌습니다.");
							money-=bet;
							System.out.println("현재 금액은 "+decimalFormat.format(money)+"원 입니다.");}
			else if(com==2) {System.out.println("컴퓨터: 바위, 나: 보\n이겼습니다.");
							money+=bet;
							System.out.println("현재 금액은 "+decimalFormat.format(money)+"원 입니다.");}
			else			{System.out.println("컴퓨터: 보, 나: 보\n비겼습니다.\n현재 금액은 "+decimalFormat.format(money)+"원입니다."); }
					}

		
	  //Random r = new Random();
	  //int b = r.nextInt(3)+1;
   }
}