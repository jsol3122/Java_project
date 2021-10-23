class Test {
	int a, b;
	public void sum(){
		System.out.println(a+" + "+b+" = "+(a+b));
	}
	public void mul(){
		System.out.println(a+" * "+b+" = "+(a*b));
	}
}
class MethodTest4 {
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println("a = "+t.a+"\t b = "+t.b);
		System.out.println();

		t.a = 50;
		t.b=60;
		t.sum();
		t.mul();
		System.out.println();

		Test t2 = new Test();
		t2.a=70;
		t2.b=80;
		t2.sum();
		t2.mul();
	}
}
