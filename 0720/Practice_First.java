class Practice_First {
	public static void main(String[] args) {
		System.out.print("안녕하세요\n연습용\t파일");
		System.out.println("의 이름: "+"\"비트캠프수강생\""+ " 입니다.");
		System.out.println();
		System.out.println(String.format("%.2f", 38.52/3.9));
		System.out.println(String.format("%s", 38/3));
		System.out.println(String.format("%s", 38.52/3.9));
		System.out.println(String.format("%s", 38.52/3.9)+"A");
		System.out.println(String.format("%s", 38.52/3.9)+999);
		System.out.println();
		System.out.println(String.format("%d", 12/4));
		System.out.println((double)(35/2)*3);
		System.out.println();
		System.out.println('a'*3.0);
		System.out.println(String.format("%.4f", 'a'/3.7));
		System.out.println();
		System.out.println((char)('a'-32));
		System.out.println((char)('a'-32) + String.format("%s", 30));
		System.out.println();
		System.out.printf("a=%s\n", (30/7));
		System.out.printf("a=%f\n", (30./7));
		System.out.printf("a=%s\n", (30./7));
		System.out.printf("a=%.3f\n", (30./7));
		System.out.println();
		System.out.printf("a=%s\n", ('a'-32));
		System.out.println();
		System.out.printf("a=%s\n", (char)('a'-32));
		System.out.printf("a=%s\n", ((char)('a'-32)));
		System.out.printf("38%s\n", ((char)('a'-32)));
		System.out.printf("38%s\n", (char)('a'-32));
		System.out.println();
		System.out.printf("38%s\n", ('a'-32));
		System.out.printf("38%d\n", +('a'-32));
		System.out.printf("38%f\n", +('a'-32.));
		System.out.println();
		System.out.println("가\t나\t다\t라\t총점\t평균");
		System.out.println(33+"\t"+66+"\t"+99+"\t"+132+"\t"+(33+66+99+132)+"\t"+String.format("%.3f", ((33+66+99+132)/4.)));
		System.out.println();
		System.out.println(33/2);
		System.out.println((double)(33/2));
		System.out.println((double)33/2);
		System.out.println();
		System.out.println((double)(35/2)*3);
		System.out.println((double)35/2*3);
		System.out.println(35/2*3);
	}
}