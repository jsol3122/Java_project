class SungJuk{

	public static void main(String[] args) {
		SungJuk sj = new SungJuk();

		String name = args[0];
		int kor = Integer.parseInt(args[1]);
		int eng = Integer.parseInt(args[2]);
		int math = Integer.parseInt(args[3]);
		int tot = sj.total(kor, eng, math);
		double avg = sj.average(tot);

		System.out.println("\t*** "+name+" 성적표 ***\t");
		System.out.println("국어\t영어\t수학\t총점\t평균");
		System.out.println(kor+"\t"+eng+"\t"+math+"\t"+tot+"\t"+String.format("%.2f",avg));
	}
		public int total(int kor, int eng, int math){
		return kor + eng + math;
		}
		public double average(int tot) {
		return tot/3.0;  //여기서 String.format걸어도 됨 ->이렇게하면 String avg로 형식 바꿔야함
		}
}