package com.apple;

import com.zoo.Zoo;

public class Apple {
	public static void main(String[] args) {
		System.out.println("빨간 사과");
		// static없는 메소드니까 new해주기
		Zoo z = new Zoo();
		//com.zoo.Zoo z = new com.zoo.Zoo(); --> 이렇게 해도 됨 / 하지만 이 클래스안에서만 쓸수잇음
		z.tiger(); // public이라 다른 패키지여도 가능 - default,protected,private은 다른패키지x
		//z.giraffe();
		//z.elephant();
		//z.lion();
		
		
		
	}
}
