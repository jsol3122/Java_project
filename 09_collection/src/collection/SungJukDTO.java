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
	// ���
	public void calc() {
		sum = kor + eng + math;
		avg = sum / 3.0;
	}
	
	// toString Override
	@Override
	public String toString() {
		return num+"\t"+name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+sum+"\t"+df.format(avg)+"\n";
	}
	
	// �������� �������� - ���������Ϸ��� �ε�ȣ ���⸸ �ٲ��ֱ�
	@Override // �̰ž����� Comparable�� implements���ֱ�!!!! (�ʼ�)
	public int compareTo(SungJukDTO dto) { // Comparable�� �ȸ���� Comparator�θ� ��� �����ᵵ ��
		if(this.sum > dto.sum) return -1;
		else if(this.sum == dto.sum) return 0;
		else return 1;
		
//		   [[[ if�� ��� ����?��:����; �̿��ϴ� ���]]]
//		return this.sum > dto.sum ? 1 : -1; -- �������� 
//		return this.sum > dto.sum ? -1 : 1; -- �������� (��������ġ ��� �ε�ȣ ����ٲٱ� or ���� �����ٲٱ� �� ����)
	}
	 
//	@Override -- �̸������� �������� comparable ���� ���
//	public int compareTo(SungJukDTO s) {
//		return this.name.compareTo(s.name);
//	}
	
//	@Override -- �̸������� �������� comparable ���� ���
//	public int compareTo(SungJukDTO s) {
//		return s.name.compareTo(this.name);
//	}
	
} // class
