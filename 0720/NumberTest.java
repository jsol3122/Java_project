class NumberTest {
	public static void main(String[] args){
		System.out.println("'A'+3="+('A'+3));
		System.out.println("\"A\"+3="+("A"+3));
		System.out.println("'a'-32="+('a'-32));
		System.out.println("'a'-32="+(char)('a'-32));
		System.out.println("25 / 3 =" + (25/3));
		System.out.println("25.0 / 3 =" + (25./3));
		System.out.println("(double)25 / 3 =" + ((double)25/3));
		System.out.println("25. / 3 =" + String.format("%.2f", 25./3));
		System.out.printf("25 / 3 = %.2f \n", (25./3));
	}
}
