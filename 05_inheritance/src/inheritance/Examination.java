package inheritance; ////////// ���� �����

import java.util.Scanner;

public class Examination {
	public static final String JUNG = "11111";
	private String name, dap;
	private int score;
	private char ox[]; // char�迭�� �Ѱ��� ��� or StringBuffer�� ������� �߰��Ǵ°� �����ϴ��ϰ� ���
	Scanner scan = new Scanner(System.in);
	
	public Examination() {
		ox = new char[5];
		System.out.print("�̸� �Է� : ");
		this.name = scan.next();
		System.out.print("�� �Է� : ");
		this.dap = scan.next();		
	}

	public void compare() {
	//System.out.print(getName()+"\t");
		for(int i=0; i<ox.length; i++) {
		if(dap.substring(i,i+1).equals(JUNG.substring(i, i+1))) {
			// dap.charAt(i)==JUNG.charAt(i)���� �ص� ����
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
	public char[] getOx() { // �迭�� �ڷ����̴� �̷��� getter ����
		return ox;
	}
	
	
}
