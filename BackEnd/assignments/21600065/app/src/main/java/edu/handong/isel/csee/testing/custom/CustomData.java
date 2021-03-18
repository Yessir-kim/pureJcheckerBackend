package edu.handong.isel.csee.testing.custom;

public class CustomData {
	private int age ;
	private String name ;
	
	public CustomData(int age, String name) 
	{
		super() ;
		this.age = age ;
		this.name = name ;
	}
	
	public int getAge() { return age ; }
	
	public void setAge(int age) { this.age = age ; }
	
	public String getName() { return name ; }
	
	public void setName(String name) { this.name = name ; }
	
	public void printAllInfo()
	{
		System.out.println("Age : " + age) ;
		System.out.println("Name : " + name) ;
	}
}
