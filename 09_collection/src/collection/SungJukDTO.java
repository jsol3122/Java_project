package collection;

import java.text.DecimalFormat;

public class SungJukDTO implements Comparable<SungJukDTO>{
	private int num, kor, eng, math, sum;
	private String name;
	private double avg;
	DecimalFormat df = new DecimalFormat("#.##");
	
	// setter , getter
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSum() {
		return sum;
	}
	public double getAvg() {
		return avg;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	// 계산
	public void calc() {
		sum = kor + eng + math;
		avg = sum / 3.0;
	}
	
	// toString Override
	@Override
	public String toString() {
		return num+"\t"+name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+sum+"\t"+df.format(avg)+"\n";
	}
	
	// 총점으로 내림차순 - 오름차순하려면 부등호 방향만 바꿔주기
	@Override // 이거쓰려면 Comparable을 implements해주기!!!! (필수)
	public int compareTo(SungJukDTO dto) { // Comparable을 안만들고 Comparator로만 계속 만들어써도 됨
		if(this.sum > dto.sum) return -1;
		else if(this.sum == dto.sum) return 0;
		else return 1;
		
//		   [[[ if문 대신 조건?참:거짓; 이용하는 방법]]]
//		return this.sum > dto.sum ? 1 : -1; -- 오름차순 
//		return this.sum > dto.sum ? -1 : 1; -- 내림차순 (참거짓위치 대신 부등호 방향바꾸기 or 변수 순서바꾸기 다 가능)
	}
	 
//	@Override -- 이름순으로 오름차순 comparable 설정 방법
//	public int compareTo(SungJukDTO s) {
//		return this.name.compareTo(s.name);
//	}
	
//	@Override -- 이름순으로 내림차순 comparable 설정 방법
//	public int compareTo(SungJukDTO s) {
//		return s.name.compareTo(this.name);
//	}
	
} // class
