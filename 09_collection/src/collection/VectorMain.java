package collection;

import java.util.Iterator;
import java.util.Vector;

public class VectorMain {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();	// ArrayList처럼 직접 new잡아버리기 가능
		// vector는 기본용량 10으로 잡고 시작 - arraylist는 그때그때 추가
		// vector에서 기본용량 10개 다쓰면 부족할때마다 10개씩 추가 - 데이터를 짱많이 잡음
		System.out.println("벡터 크기 = "+v.size()); // 0 - 항목 개수
		System.out.println("벡터 용량 = "+v.capacity()); // 10 - 벡터 크기(기본)
		System.out.println();
		
		System.out.println("--- 항목 추가 ---");
		for(int i=1; i<=10; i++) {
			v.add(i+"");
		}
		System.out.println();
		
		// v.add("5"); -- collection의 일종이라 중복o순서o
		v.addElement("5"); // add로 써도 되고 addElement써도 동일하게 입력됨
		System.out.println("벡터 크기 = "+v.size()); // 11 - 항목 개수
		System.out.println("벡터 용량 = "+v.capacity()); // 20 - 벡터 크기(기본10개 다써서 또 10추가)
		System.out.println();
		
		for(int i=0; i<v.size(); i++) {
			System.out.print(v.get(i)+"  ");
		}
		System.out.println();
		
		System.out.println("--- 항목 삭제 ---");
		v.remove("5");
		//v.removeElement("5"); -- remove랑 동일하게 삭제 메소드
		v.removeElementAt(9); // 해당 인덱스의 값을 삭제 (위치지정 삭제) 
		// 중복값 있는경우 remove하면 앞쪽 값 삭제하니까 removeElementAt(위치)으로 위치지정해서 삭제
		// 중간 값이 삭제된 경우 index번호는 그만큼 앞으로 땡겨짐 
		
		Iterator<String> it = v.iterator(); // 생성 -- get대신 iterator이용도 가능
		while(it.hasNext()) {
			System.out.print(it.next()+"  ");
		}
		System.out.println();
		
		Vector<String> v2 = new Vector<String>(5, 2); 
		// 기본용량 5로 잡고, 다쓰면 2씩 용량 증가하도록 설정 - 꼭 default값(10,10) 유지할 필요x
	}

}
