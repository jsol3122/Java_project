package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class PersonSort {

	public static void main(String[] args) {
		String[] ar = {"orange", "apple", "banana", "pear", "peach", "applemango"};
		
		System.out.print("정렬 전 = ");
		for(String str : ar) {
			System.out.print(str+"  ");
		}
		System.out.println();
		
		Arrays.sort(ar); // sort로 알아서 정렬 - 배열이니까 Arrays로 잡음
		
		System.out.print("정렬 후 = ");
		for(String str : ar) {
			System.out.print(str+"  ");
		}
		System.out.println("\n");
		
		PersonDTO aa = new PersonDTO("홍길동", 25); 
		PersonDTO bb = new PersonDTO("라이언", 30);
		PersonDTO cc = new PersonDTO("어피치", 28);
		
		// 비교 위해 각각의 객체들을 한 곳에 담아놓기
		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>(); 
		list.add(aa);
		list.add(bb);
		list.add(cc);
		
		System.out.println("정렬 전 : ");
		System.out.println(list); 
		// list는 [,,]안에 항목을 보여줌
		// 원래 toString()에 따라 주소값 출력인데, override해서 내용값 출력하도록 설정함
		System.out.println();
		
		// 아까랑 달리 배열 아니라 collection을 sort하는 거니까 
		Collections.sort(list);
		
		System.out.println("나이로 오름차순(내림차순) : ");
		System.out.println(list); 
		System.out.println();
		
		System.out.println("이름으로 오름차순(내림차순) : ");
		Comparator<PersonDTO> com = new Comparator<PersonDTO>() { // 익명 inner이용해 생성
			@Override
			public int compare(PersonDTO dto1, PersonDTO dto2) { 
				// 문자열은 자체적으로 크기비교x - compareTo 이용하기
				// return dto1.getName().compareTo(dto2.getName()); - 오름차순
				// 결과가 -1/0/1 셋중 나오니까 그 자체를 return하기
				return dto2.getName().compareTo(dto1.getName()); // 내림차순 방법 1
				// return dto1.getName().compareTo(dto2.getName())*-1; - 내림차순 방법 2
			}
		};
	
		Collections.sort(list, com); // list에 담긴 값들을 내가 잡은 com기준으로 sort
		System.out.println(list);
		System.out.println();
		
	}
}
