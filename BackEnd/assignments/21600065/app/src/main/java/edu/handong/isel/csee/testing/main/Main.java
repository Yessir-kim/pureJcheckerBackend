package edu.handong.isel.csee.testing.main;

import edu.handong.isel.csee.testing.custom.CustomData;
import edu.handong.isel.csee.testing.custom.OverridingTest;

public class Main {
	
	
	public static int fac (int num)
	{
		if(num == 1) return 1 ;
		else return num * fac(num - 1) ;
	}
	
	public static void main(String[] args) 
	{			
		
		System.out.println(fac(Integer.parseInt(args[0]))) ;

		Calculator cal = new Calculator() ;
		cal.setOprands(5, Integer.parseInt(args[0])) ; // error
		cal.divide() ;

		CustomData person = new CustomData(25, "Kim") ;
		OverridingTest expert = new OverridingTest(25, "Lim", "Java") ;	
	}
}
