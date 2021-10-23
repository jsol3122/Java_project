class CompTest3
{
	public static void main(String[] args) 
	{
		int num = 80;
		String result = num%2>0? "홀수":"짝수";
		System.out.println(num+"는 "+result+"이다");
		//System.out.println((int)num % 2>0 ? num+"는 홀수이다": num+"는 짝수이다");
	}
}
