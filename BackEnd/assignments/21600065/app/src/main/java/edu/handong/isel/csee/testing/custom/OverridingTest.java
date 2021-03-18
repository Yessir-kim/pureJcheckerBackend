package edu.handong.isel.csee.testing.custom;

public class OverridingTest extends CustomData {
	private String skill ;
	
	public OverridingTest(int age, String name, String skill) 
	{
		super(age, name) ;
		this.skill = skill ;
	}
	
	public void printAllInfo()
	{
		super.printAllInfo() ;
		System.out.println("Skill : " + skill) ;
	}
	
	public void printAllInfo(String major)
	{
		super.printAllInfo() ;
		System.out.println("Skill : " + skill) ;
		System.out.println("Major : " + major) ;
	}

}
