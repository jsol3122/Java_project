import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.text.DecimalFormat;

class Game {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat decimalFormat = new DecimalFormat();

		int money = 1000;
			System.out.print("����(1), ����(2), ��(3) �� ��ȣ�� �Է� : ");
		int user= System.in.read();
			System.in.read();
			System.in.read();
			System.out.print("���� �ݾ� �Է� : ");
		int bet = Integer.parseInt(br.readLine());
			
		
		int com = (int)(Math.random()*3)+1;
		
		if(user==1){
			if(com==1) {System.out.println("��ǻ��: ����, ��: ����\n�����ϴ�.\n���� �ݾ��� "+decimalFormat.format(money)+"���Դϴ�.");}
			else if(com==2) {System.out.println("��ǻ��: ����, ��: ����\n�����ϴ�.");
							money-=bet;
							System.out.println("���� �ݾ��� "+decimalFormat.format(money)+"�� �Դϴ�.");}
			else			{System.out.println("��ǻ��: ��, ��: ����\n�̰���ϴ�."); 
							money+=bet;
							System.out.println("���� �ݾ��� "+decimalFormat.format(money)+"�� �Դϴ�.");}
					}

		else if(user==2) {
			if(com==1)		{System.out.println("��ǻ��: ����, ��: ����\n�̰���ϴ�.");
							money+=bet;
							System.out.println("���� �ݾ��� "+decimalFormat.format(money)+"�� �Դϴ�.");}
			else if(com==2) {System.out.println("��ǻ��: ����, ��: ����\n�����ϴ�.\n���� �ݾ��� "+decimalFormat.format(money)+"���Դϴ�.");}
			else			{System.out.println("��ǻ��: ��, ��: ����\n�����ϴ�.");
							money-=bet;
							System.out.println("���� �ݾ��� "+decimalFormat.format(money)+"�� �Դϴ�.");}
					}
		
		else{
			if(com==1)		{System.out.println("��ǻ��: ����, ��: ��\n�����ϴ�.");
							money-=bet;
							System.out.println("���� �ݾ��� "+decimalFormat.format(money)+"�� �Դϴ�.");}
			else if(com==2) {System.out.println("��ǻ��: ����, ��: ��\n�̰���ϴ�.");
							money+=bet;
							System.out.println("���� �ݾ��� "+decimalFormat.format(money)+"�� �Դϴ�.");}
			else			{System.out.println("��ǻ��: ��, ��: ��\n�����ϴ�.\n���� �ݾ��� "+decimalFormat.format(money)+"���Դϴ�."); }
					}

		
	  //Random r = new Random();
	  //int b = r.nextInt(3)+1;
   }
}