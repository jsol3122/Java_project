class  Money
{
	public static void main(String[] args) 
	{
		int money = 1234;
		int a = money/1000;
		int b = (money%1000)/100;
		int c = (money%100)/10;
		int d = money%10;

		System.out.println("[������]");
		System.out.println("�ݾ� : "+money+"��");
		System.out.println("õ�� : "+a+"��");
		System.out.println("��� : "+b+"��");
		System.out.println("�ʿ� : "+c+"��");
		System.out.println("�Ͽ� : "+d+"��");
	}
}
