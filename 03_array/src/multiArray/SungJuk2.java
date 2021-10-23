package multiArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SungJuk2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("인원수 입력 : ");
		int cnt = Integer.parseInt(br.readLine());
		
		String[] name = new String[cnt];
		int subjectCnt;  // 배열로 잡을 필요 없음
		String[][] subject = new String[cnt][];  // 인원수는 입력받았지만 과목수는 아직 입력 안받아서 안정해졋으니 설정x
		int[][] jumsu = new int[cnt][];
		double[] avg = new double[cnt];			 // 총점은 소수점 둘째자리까지 표시해야하니까

		// 입력 + 처리
		
		for(int i=0; i<cnt; i++) { // 인원수만큼 반복해서 값 넣어주기
			System.out.print("이름 입력 : ");
			name[i] = br.readLine();
			
			System.out.print("과목수 입력 : ");
			subjectCnt = Integer.parseInt(br.readLine());
			
			subject[i] = new String[subjectCnt]; 	// 메모리에 가변길이 몇인지 생성
			for(int j=0; j<subjectCnt; j++) {
				System.out.print("과목명 입력 : ");
				subject[i][j] = br.readLine();
			}
			jumsu[i] = new int[subjectCnt+1];			// 과목수+1해서 총점 받을 공간까지 생성! (어차피 같은 int형이니까)
			for(int j=0; j<subjectCnt; j++) {
				System.out.print(subject[i][j] +"점수 입력 : ");
				jumsu[i][j] = Integer.parseInt(br.readLine());
				jumsu[i][subjectCnt] += jumsu[i][j];	// 총점 구하기
			}
			avg[i] = (double)jumsu[i][subjectCnt]/subjectCnt;	// int끼리 계산인데 평균은 실수여야 하니까
		} //for i
		
		// 출력
		
		for(int i=0; i<cnt; i++) {
			// 이름 과목 점수~~~ 타이틀 출력
			System.out.print("이름\t");
			for(int j=0; j<subject[i].length; j++) {
				System.out.print(subject[i][j]+"\t");			
			}
			System.out.println("총점\t평균");
			
			// 입력받은 점수들 출력
			System.out.print(name[i]+"\t");
			for(int j=0; j<jumsu[i].length; j++) {
				System.out.print(jumsu[i][j]+"\t");
			}
			System.out.println(String.format("%.2f", avg[i]));
			System.out.println();
			
		}	
	} //main
}
