package array_;

public class ArrayTest {

	public static void main(String[] args) {
		int[] ar;
		int i;
		ar = new int[5];
		
		System.out.println("�迭�� ar = "+ar);
		ar[0]=27;
		ar[1]=36;
		ar[2]=25;
		ar[3]=78;
		ar[4]=62;
		
		System.out.println("ar[0] = "+ar[0]);
		System.out.println("ar[1] = "+ar[1]);
		System.out.println("ar[2] = "+ar[2]);
		System.out.println("ar[3] = "+ar[3]);
		System.out.println("ar[4] = "+ar[4]);
		
		System.out.println("\n");
		System.out.println("�迭 ũ�� = "+ar.length);
		System.out.println("\n");
		for(i=0; i<5; i++) {
			System.out.println("ar["+i+"] = "+ar[i]);
			}

		System.out.println("�Ųٷ� ���");
			for(i=ar.length-1; i>=0; i--) {
				System.out.println("ar["+i+"] = "+ar[i]); }
				
				System.out.println("\n");
		System.out.println("¦�� �����͸� ���");
			for(i=0; i<ar.length; i++) {
				if(ar[i]%2==0) System.out.println("ar["+i+"] = "+ar[i]); 
			} // for
			System.out.println("\n");
			
			System.out.println("Ȯ�� for");
			for(int data : ar) {
				System.out.println(data);
			} // for
	
			} // main
		} // class
	


