package com.zoo.safari;

import com.zoo.Zoo;

public class Safari extends Zoo{

	public static void main(String[] args) {
		Zoo z = new Zoo(); // 같은 패키지니까 import안해도됨
		z.tiger(); // public이라 가능
		// z.giraffe(); -- 부모만 잡아서 생성하면 부모가 자식 있는지 몰라서 못갖다씀
		//z.elephant();
		//z.lion();  
		System.out.println("------------------");
		Safari s = new Safari();
		s.tiger();
		s.giraffe(); // 자식 잡아서 생성하면 상속인지 아니까 부모거 갖다쓸 수 있음
		//s.elephant();
		//s.lion();
	}

}
