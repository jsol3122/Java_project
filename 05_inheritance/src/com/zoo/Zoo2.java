package com.zoo;

public class Zoo2 {

	public static void main(String[] args) {
		Zoo z = new Zoo(); // 같은 패키지니까 import안해도됨
		z.tiger(); // public이라 가능
		z.giraffe();
		z.elephant();
		//z.lion();  --> private은 같은패키지여도 접근 안됨 (only 자신만)
		
		
	}

}
