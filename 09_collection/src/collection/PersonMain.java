package collection;

import java.util.ArrayList;

public class PersonMain {
	
	public ArrayList<PersonDTO> init() { // ���� generic���� �ڷ����� ������ - ������
		PersonDTO aa = new PersonDTO("ȫ�浿", 25);
		PersonDTO bb = new PersonDTO("���̾�", 30);
		PersonDTO cc = new PersonDTO("����ġ", 28);
		
		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		list.add(aa);
		list.add(bb);
		list.add(cc);
		
		return list; // �ּҰ��� list�� ��Ƴ��� ��
		// python�� return�� ������ ���� - java�� 1���ۿ� �������ϱ� collection���� �����ֱ�
	} // init()

	public static void main(String[] args) {
		PersonMain pm = new PersonMain(); // static�ƴϴϱ� ����
		ArrayList<PersonDTO> list = pm.init(); 
		// return�� �ް� ���ƿ� 
		// �޾ƿ� list�� �ּҰ� ���� �ʿ�(�ٽ� �� list�� ���� - init�� list�� ������)
		System.out.println("list = "+list); //  �ּҰ��� ���� ���̹Ƿ� �ּҰ����
		
		for(int i=0; i<list.size(); i++) {
			System.out.println("�̸� = "+list.get(i).getName()+
								"\t���� = "+list.get(i).getAge()); 
			// getter�̿��ؼ� ���� �� �����ͼ� ��� ����
		}
		System.out.println();
		
		for(PersonDTO dto : list) { // Ȯ��for�� �̿���� - �� ����
			System.out.println("�̸� = "+dto.getName()+"\t���� = "+dto.getAge());
		}
		System.out.println();
		
	}

}
