class MethodTest2 {
	public static void main(String[] args) {
		MethodTest2 mt = new MethodTest2();
		System.out.println("�� = "+mt.sum(320, 258));
		System.out.println("�� = "+mt.sub(320, 258));
		System.out.println("�� = "+mt.mul(320, 258));
		System.out.println("�� = "+String.format("%.2f",mt.div(320, 258)));
	}

	public int sum(int a,int b){ //����
		return a+b;}
	public int sub(int a,int b){
		return a-b;}
	public int mul(int a,int b){
		return a*b;}
	public float div(int a,int b){
		return (float)a/b;}
	
	
}
