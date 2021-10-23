package io;

import java.io.Serializable;

public class PersonDTO implements Serializable { // 인터페이스지만 추상메소드가 없어서 override안함
	private String name;
	private int age;
	private double height;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	
}
