class MethodTest{

	public static void main(String[] args) {
		//System.out.println("args[0] = "+args[0]);
		//System.out.println("args[1] = "+args[1]);
	
		MethodTest.output();

		MethodTest mt = new MethodTest();
		mt.disp();
	}
	public void disp(){ //구현
		System.out.println("non-static method");
	}
	public static void output(){  //구현
		System.out.println("static method");
	}
}
