import java.util.Random;
import java.util.Arrays;

class MethodTest3 {
	public static void main(String[] args) {  // static이 없으면 new로 새로 선언해서 안하면 에러뜸
		System.out.println("최대값 = "+ Math.max(25,36)); 
		System.out.println("최솟값 = "+Math.min(25.3,36.7));
// 그냥 max()하면 현재필드소속이라고 인식함(Math필드 소속인거 밝혀줘야함)-현재필드에 max없으니까 그대로라면 에러뜸

		System.out.println("난수 = "+Math.random());

		Random random = new Random();
		System.out.println("난수 = "+random.nextDouble());

		int[] ar = {25,12,37,56};
		System.out.println(ar[0]+", "+ar[1]+", "+ar[2]+", "+ar[3]);

		Arrays.sort(ar);
		System.out.println(ar[0]+", "+ar[1]+", "+ar[2]+", "+ar[3]);
	}
}
