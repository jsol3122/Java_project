import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class SwitchTest {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("월 입력 : ");
		int month = Integer.parseInt(br.readLine());
		int days=0;

		switch(month){
			case 1: 
			case 3: 
			case 5: 
			case 7: 
			case 8: 
			case 10: 
			case 12: days=31; break;

			case 2: days=28; break;
			
			case 4: 
			case 6: 
			case 9: 
			case 11: days=30; break;
		}

		System.out.println(month+"월은 "+days+"일 입니다");

	}
}
