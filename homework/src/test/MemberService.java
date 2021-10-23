package test;

import java.util.List;
import java.util.Scanner;

public class MemberService {
	Scanner scan = new Scanner(System.in);
	
	public MemberService() {
		
	} // ������
	
	public void menu() {
		while(true) {
			System.out.println();
			System.out.println("*****************\r\n"
					+ "1. ȸ������\r\n"
					+ "2. �α���\r\n"
					+ "3. ȸ�� ����Ʈ\r\n"
					+ "4. ��\r\n"
					+ "*****************");
			System.out.print("��ȣ : ");
			int num = scan.nextInt();
			
			if(num==4) break;
			if(num>4) {
				System.out.println("1~4 �߿� �����ϼ���\n");
				continue;
			}else if(num==1) writeMember();
			else if(num==2) loginMember();
			else if(num==3) listMember();			
		} // while
	} // menu()
	
	public void writeMember() {
		
		System.out.print("�̸� �Է� : ");
		String name = scan.next();
		System.out.print("���̵� �Է� : ");
		String id = scan.next();
		
		MemberDTO dto = new MemberDTO();
		// �̱������� DAO �ҷ����� -- ���� DB�� �������� new���� �ʰ� �ϳ����� ��ӽ���ϴϱ�
		MemberDAO dao = MemberDAO.getInstance(); 
		String yn = dao.checkMember(id); // id�ߺ�üũ�ϱ� id�� �������� Ȯ���ص� ��
		
		if(yn!=null) {
			System.out.println();
			System.out.println("�̹� ������� ���̵��Դϴ�");
			return;
		}else if(yn==null){ // "��밡�ɾ��̵�" ���� �������κ��� else�� �ۿ��� �ᵵ ��
			dto.setName(name);
			dto.setId(id);
			System.out.println("��� ������ ���̵��Դϴ�");
			System.out.print("��й�ȣ �Է� : ");
			dto.setPwd(scan.next());
			System.out.print("�̸��� �Է� : ");
			dto.setMail(scan.next());
			dao.insertMember(dto);
			System.out.println();
			System.out.println("ȸ�������� �����մϴ�");
		}
	} // writeMember()
	
	public void loginMember() {
		System.out.println();
		System.out.print("���̵� �Է� : ");
		String id = scan.next();
		System.out.print("��й�ȣ �Է� : ");
		String pwd = scan.next();
		System.out.println();
		
		MemberDAO dao = new MemberDAO();
		String name = dao.loginMember(id, pwd);
		
		if(name==null) System.out.println("���̵� �Ǵ� ��й�ȣ�� ���� �ʽ��ϴ�");
		else System.out.println(name+"�� �α���");
	} // loginMember()
	
	public void listMember() {
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.listMember();
		
		System.out.println("�̸�\t���̵�\t��й�ȣ\t�̸���");
		for(MemberDTO dto : list) {
			System.out.print(dto);
		}
	} // listMember()
}
