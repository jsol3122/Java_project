package collection;

import java.util.HashMap;
import java.util.Map;

public class MapMain {

	public static void main(String[] args) { // map�� add��� put���� �� ����
		Map<String, String> map = new HashMap<String, String>(); // �������̽���, <key, value> ��
		
		map.put("book101", "�鼳����");
		map.put("book201", "�ξ����");
		map.put("book102", "�鼳����"); // value �ߺ� ���
		map.put("book301", "�ǿ���");
		map.put("book101", "��������"); // key �ߺ� ��� -- ��� �ռ� ������ ���� ������� �� value���� ��������
		
		System.out.println(map.get("book102"));	// key���� �ָ� �ش��ϴ� value ���
		System.out.println(map.get("book103")); // �ش簪�� ���ٸ� ����x null�� ���
		System.out.println(map.get("book101")); // key�� �ߺ� �� ������ value������ ��ü (���� �� �Ҹ�)
		
		//iterator�� ���� value�� �ƴ� key���� ����ϱ� ������ �� �Ⱦ�
	}

}
