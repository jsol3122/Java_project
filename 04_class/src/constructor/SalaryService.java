package constructor;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class SalaryService {
	Scanner scan = new Scanner(System.in);
	private SalaryDTO[] ar;
	DecimalFormat df = new DecimalFormat();
	private int i;
	// main.ar[i]
	public SalaryService(SalaryDTO[] ar) { //main에서 받아온 ar주소를 똑같이 받아주기
		this.ar=ar;	// 같은 ar임을 this로 말해주고 this.ar에게 main에서 받아온 ar값 전달해서 보관
	}
	

	public void menu() throws IOException { //기본은 private형임 - 외부class에서 접근안할거라면 유지해도 됨
		for(;true;) {
			System.out.println("*****************");
			System.out.println("    1. 사원등록");
			System.out.println("    2. 전체 출력");
			System.out.println("    3. 사원 정보 수정");
			System.out.println("    4. 퇴사");
			System.out.println("    5. 종료");
			System.out.println("*****************");
			
			System.out.print("  번호 : ");
			int num=System.in.read()-48;
			System.in.read();
			System.in.read();
			System.out.println();
			
				if(num==1) insertEmp();
				else if(num==2) display();
				else if(num==3) updateEmp();
				else if(num==4) deleteEmp();
				else if(num==5) break;
		}
	}  // menu()
	
	public void insertEmp() {
		
		if(i==ar.length) {	// 5명 정원 다 찼으면 신규등록 불가
			System.out.println("정원 초과");
			return;
		}
		
		/* 	service에서 ar[i]=new SalaryDTO(); 로 불러오도록 하고나서~~
		 *  DTO에서 바로 받는 식 쓰기
		 *  ar[i].calcSalary();로 바로 계산까지 완료해도 됨
		 */
		
		for(i=0; i<ar.length; i++) {
			if(ar[i]==null) {
			System.out.print(" 사원번호 입력 : ");
			int a=(scan.nextInt());
			System.out.print(" 사원명 입력 : ");
			String b=(scan.next());
			System.out.print(" 직급 입력 : ");
			String c=(scan.next());
			System.out.print(" 기본급 입력 : ");
			int d=(scan.nextInt());
			System.out.print(" 수당 입력 : ");
			int e=(scan.nextInt());
			
			ar[i] = new SalaryDTO(a, b, c, d, e);
			break;
			}
		}
		System.out.println();
		System.out.println("등록 완료");
		System.out.println();
	} // insertEmp()
	
	public void display() {
		
		System.out.println("사원번호\t이름\t직급\t기본급\t\t수당\t세율\t세금\t월급");
		for(i=0; i<ar.length; i++) {
			if(ar[i]!=null) {
			ar[i].clacSalary();
			System.out.println(ar[i].getEmpId()+"\t"
							+ar[i].getName()+"\t"
							+ar[i].getPosition()+"\t"
							+df.format(ar[i].getBasePay())+"\t"
							+df.format(ar[i].getBenefit())+"\t"
							+(int)(ar[i].getTaxRate()*100)+"%\t"
							+df.format(ar[i].getTax())+"\t"
							+df.format(ar[i].getSalary()));
			}
		}
		// decimalformat은 숫자만 받기 때문에 문자열을 주면 오류뜸
		System.out.println();
	} // display()
	
	public void updateEmp() {
		
		System.out.print("사원번호 입력 : ");
		int num = (scan.nextInt());
		System.out.println();
		
		for(i=0; i<ar.length; i++) {
			if(ar[i].getEmpId()==num) {
				System.out.println("사원번호\t이름\t직급\t기본급\t\t수당\t세율\t세금\t월급");
				System.out.println(ar[i].getEmpId()+"\t"
						+ar[i].getName()+"\t"
						+ar[i].getPosition()+"\t"
						+df.format(ar[i].getBasePay())+"\t"
						+df.format(ar[i].getBenefit())+"\t"
						+(int)(ar[i].getTaxRate()*100)+"%\t"
						+df.format(ar[i].getTax())+"\t"
						+df.format(ar[i].getSalary()));
				
				System.out.println();
				System.out.print("수정할 직급 입력 :");
				String a = (scan.next());
				System.out.print("수정할 기본급 입력 :");
				int b = (scan.nextInt());
				System.out.print("수정할 수당 입력 :");
				int c = (scan.nextInt());
				
				/*수정해야 하는데 생성자 두번은 못부르니까 setter만들어서 수정하기
				public void setName(String name){ this.name.name;} 등등 만들어서~~ 
				ar[i].setName(scan.next()); 으로 받아주기   ---> 해야되는 것
				
				setter대신 생성자new해서 덮어쓰면, 수정이 아니라 새로운거 만들어서 얹는거라서 
				수정할때마다 메모리가 계속계속 다시 생성됨 ---> 내방법
				 */
				ar[i] = new SalaryDTO(ar[i].getEmpId(), ar[i].getName(), a, b, c);
				System.out.println("수정 완료");
				System.out.println();
				return;
			}
		}
	System.out.println("사원번호가 없습니다");
	//if(i==ar.length){ System.out.prinln("사원번호가없"); return;} 으로 잡아도 됨
	System.out.println();
	} // updateEmp()
	
	public void deleteEmp() { //java는 생성자를 지울 수 없음(JVM이 알아서하지 시킬순없음)
		// 실제로 지우지 못하고 연결고리를 없애주기(=주소값을 NULL로 잡기) 그러면 나중에 JVM이 알아서 삭제
		// NULL처리할 때 for문 안에서 해당 조건을 만나면 break;시킨 후 for문 밖에서 ar[i]=null해도 i값 유지돼서 잘 지워짐
		System.out.print("사원번호 입력 : ");
		int num = (scan.nextInt());
		System.out.println();
		
		for(i=0; i<ar.length; i++) {
			if(ar[i].getEmpId()==num) {
				ar[i]=null; // 연결고리 없애주려고 주소값 NULL준 것
				System.out.println("삭제 완료");
				System.out.println();
				return;
			}
		}
		System.out.println("사원번호가 없습니다");
		//if(i==ar.length){ System.out.prinln("사원번호가없"); return;} 으로 잡아도 됨
		System.out.println();
	} // deleteEmp()
}
