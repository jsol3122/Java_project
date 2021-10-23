package inheritance; ////////// 숙제 결과본

import java.util.Scanner;

public class Examination {
	public static final String JUNG = "11111";
	private String name, dap;
	private int score;
	private char ox[]; // char배열로 한개씩 잡기 or StringBuffer로 사람마다 추가되는값 설정하능하게 잡기
	Scanner scan = new Scanner(System.in);
	
	public Examination() {
		ox = new char[5];
		System.out.print("이름 입력 : ");
		this.name = scan.next();
		System.out.print("답 입력 : ");
		this.dap = scan.next();		
	}

	public void compare() {
	//System.out.print(getName()+"\t");
		for(int i=0; i<ox.length; i++) {
		if(dap.substring(i,i+1).equals(JUNG.substring(i, i+1))) {
			// dap.charAt(i)==JUNG.charAt(i)으로 해도 가능
			score+=20;
			ox[i]='O';			
		}
		else ox[i]='X';
		//System.out.print(ox[i]+" ");
		}
	//System.out.println("\t"+getScore());
	}
	
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	public char[] getOx() { // 배열도 자료형이니 이렇게 getter 설정
		return ox;
	}
	
	
}
