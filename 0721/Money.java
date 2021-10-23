class  Money
{
	public static void main(String[] args) 
	{
		int money = 1234;
		int a = money/1000;
		int b = (money%1000)/100;
		int c = (money%100)/10;
		int d = money%10;

		System.out.println("[실행결과]");
		System.out.println("금액 : "+money+"원");
		System.out.println("천원 : "+a+"장");
		System.out.println("백원 : "+b+"개");
		System.out.println("십원 : "+c+"개");
		System.out.println("일원 : "+d+"개");
	}
}
