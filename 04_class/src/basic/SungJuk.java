package basic;

public class SungJuk {	// 구현부
	private String name;
	private char grade;
	private int kor, eng, math, tot;
	private double avg;
	
	public void setData(String name, int kor, int eng, int math) {
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.math=math;	
	}
	public void calcTot() {
		tot=kor+eng+math;
	}
	public void calcAvg() {
		avg=(double)(kor+eng+math)/3;
	}
	public void calcGrade() {
		if(avg>=90) grade='A';
		else if(avg>=80) grade='B';
		else if(avg>=70) grade='C';
		else if(avg>=60) grade='D';
		else grade='F';
	}
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
	public int getTot() {
		return tot;
	}
	public double getAvg() {  
		return avg;		// String.format("%.2f", avg);로 해서 String형 getAvg()로 해도 가능
	}
	public char getGrade() {
		return grade;
	}
}
