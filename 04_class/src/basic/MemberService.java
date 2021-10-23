package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MemberService { //���ϴ� ���� (��ü����, �����ͳֱ�, ���������, �����ͼ��� �� ��� �ϵ�), menu()�Լ�~Ż���Լ� ���ϱ�
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int num, count=0;
	
	MemberDTO[] dto = new MemberDTO[5];
	
	public void menu() throws IOException {	//�����ο� IOException�� �ɷ����� ȣ��ο��� �ɾ������
		
	for(;true;) {
		System.out.println("*****************");
		System.out.println("    1. ����");
		System.out.println("    2. ���");
		System.out.println("    3. ����");
		System.out.println("    4. Ż��");
		System.out.println("    5. ������");
		System.out.println("*****************");
		
		System.out.print("  ��ȣ : ");
		num=System.in.read()-48;
		System.in.read();
		System.in.read();
		System.out.println();
		
			if(num==1) insertMember();
			else if(num==2) list();
			else if(num==3) updateMember();
			else if(num==4) deleteMember();
			else if(num==5) break;
	}
	} // menu()
	
	public void insertMember() throws IOException {
		/*   �̷��� ���ʿ� null�̸� �迭������ ���ع������� ���� 
	 		->�׷��� �ڿ� dto[i].getName()==null �̷������� ���ϰ� dto[i]==null �̷������ε� ��� ����
	int i;
    for(i=0; i<ar.length; i++) {
      if(ar[i]==null) break;
    }
      
  if(i==ar.length) {
     System.out.println("���� �ʰ�..");
     return; //�޼ҵ带 �����
  }
  
  ar[i] = new MemberDTO();

		 */
	
	for(int i=0; i<dto.length; i++) {
	if(count>0)break;
	dto[i] = new MemberDTO();
	}
	
	for(int i=0; i<dto.length; i++) {
		if(count==5) { System.out.println("���� �ʰ�");
			return;
		}
		if(dto[i].getName()==null) {
			System.out.print("�̸� �Է� : ");
			dto[i].setName(br.readLine());
			System.out.print("���� �Է� : ");
			dto[i].setAge(Integer.parseInt(br.readLine()));
			System.out.print("�ڵ��� �Է� : ");
			dto[i].setCellphone(br.readLine());
			System.out.print("�ּ� �Է� : ");
			dto[i].setAddress(br.readLine());
			break;
		}
	}
	count++;
	System.out.println("��� �Ϸ� / "+(5-count)+"�ڸ� ���ҽ��ϴ�");
	System.out.println();
	// menu();  �̷��� �θ��� �ű� menu()�� ��� ���� ����ϱ� ���� ����!!
	} // insertMember()
	
	public void list() throws IOException {

	System.out.println("�̸�\t����\t�ڵ���\t�ּ�");
		for(int i=0; i<dto.length; i++) {
			if(dto[i].getName()!=null) {
			System.out.println(dto[i].getName()+"\t"
							+dto[i].getAge()+"\t"
							+dto[i].getCellphone()+"\t"
							+dto[i].getAddress());
			}
		}
	System.out.println();
		
	/*	���ʿ� null�� �迭���� ���� ���
	System.out.println();
      System.out.println("�̸�\t����\t�ڵ���\t\t�ּ�");
      for(int i=0; i<dto.length; i++) {
         if(dto[i]!=null) {
            System.out.println(dto[i].getName()+"\t"
                         + dto[i].getAge()+"\t"
                         + dto[i].getCellphone()+"\t"
                         + dto[i].getAddress());
         }
      }
	*/
	} // list()
	
	public void updateMember() throws IOException {
	
	String cnum;
	System.out.print("�ڵ��� ��ȣ �Է� : ");
	cnum=br.readLine();
	for(int i=0; i<dto.length; i++) {
		if(cnum.equals(dto[i].getCellphone())) {
			System.out.println(dto[i].getName()+"\t"
					+dto[i].getAge()+"\t"
					+dto[i].getCellphone()+"\t"
					+dto[i].getAddress());
			System.out.println();
			System.out.print("������ �̸� �Է� : ");
			dto[i].setName(br.readLine());
			System.out.print("������ ���� �Է� : ");
			dto[i].setAge(Integer.parseInt(br.readLine()));
			System.out.print("������ �ڵ��� �Է� : ");
			dto[i].setCellphone(br.readLine());
			System.out.print("������ �ּ� �Է� : ");
			dto[i].setAddress(br.readLine());
			System.out.println();
			System.out.println("���� �Ϸ�");
			return;
		}
	} 
	System.out.println("ã���� �ϴ� ȸ���� �����ϴ�");
	System.out.println();
	} // updateMember()
	
	public void deleteMember() throws IOException {

	String cnum;
	System.out.print("�ڵ��� ��ȣ �Է� : ");
	cnum=br.readLine();
		for(int i=0; i<dto.length; i++) {
			if(cnum.equals(dto[i].getCellphone())) {
				dto[i].setName(null);
				dto[i].setAge(0);
				dto[i].setCellphone(null);
				dto[i].setAddress(null);
				System.out.println("���� �Ϸ�");
				System.out.println();
				count--;
				return;
			}
		}
	System.out.println("ã���� �ϴ� ȸ���� �����ϴ�");
	System.out.println();
	
	/*	���ʿ� null�� �迭���� ���� ���
		
	System.out.print("�ڵ��� ��ȣ �Է� : ");
      String phone = br.readLine();
      
      int i;
      for(i=0; i<dto.length; i++) {
         if(dto[i] != null) {
            if(dto[i].getCellphone().equals(phone)) break;
         }//if
      }//for
      
      if(i==dto.length) {
         System.out.println("ã���� �ϴ� ȸ���� �����ϴ�");
         
      }else {
    	  dto[i] = null;
         System.out.println("Ż�� �Ϸ�...");
      }
	*/
	} // deleteMember()
}

