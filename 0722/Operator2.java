class Operator2 
{
	public static void main(String[] args) 
	{
		boolean a = 25>36;
		System.out.println("a = "+a);
		System.out.println("!a = "+!a);
		System.out.println();

		String b = "apple";
		String c = new String("apple");
		System.out.println("b == c : "+(b==c)); //false
		System.out.println("b.equals(c) : "+(b.equals(c)));
		System.out.println("!b.equals(c) : "+(!b.equals(c)));
	}
}
