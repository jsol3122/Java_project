import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class IfTest3 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("첫번째 입력 : ");
		int a = Integer.parseInt(br.readLine());
		System.out.print("두번째 입력 : ");
		int b = Integer.parseInt(br.readLine());
		System.out.print("세번째 입력 : ");
		int c = Integer.parseInt(br.readLine());

		if (a>b && b>c && a>c)
			System.out.print(c+"\t"+b+"\t"+a);
		else if (a>b && c>b && a>c)
			System.out.print(b+"\t"+c+"\t"+a);
		else if (b>a && a>c && b>c)
			System.out.print(c+"\t"+a+"\t"+b);
		else if (b>a && c>a && b>c)
			System.out.print(a+"\t"+c+"\t"+b);
		else if (c>a && a>b && c>b)
			System.out.print(b+"\t"+a+"\t"+c);
		else
			System.out.print(a+"\t"+b+"\t"+c);

     /* if(a<b && a<c) {
         if(b<c) System.out.println(a+", "+b+", "+c);
         else System.out.println(a+", "+c+", "+b);

      }else if(b<c){
         if(a<c) System.out.println(b+", "+a+", "+c);
         else System.out.println(b+", "+c+", "+a);

      }else{
         if(a<b) System.out.println(c+", "+a+", "+b);
         else System.out.println(c+", "+b+", "+a);
      } 
	  
	  */

	}
}
