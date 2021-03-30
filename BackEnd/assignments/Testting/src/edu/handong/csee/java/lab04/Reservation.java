package edu.handong.csee.java.lab04;

public class Reservation {

	int totalNumber ;
	int income ;
	String lastOrder ;
	
	public Reservation() 
	{
		this.totalNumber = 0 ;
		this.income = 0 ;
	}
	
	public void order(String food, int money)
	{
		this.income += money ;
		this.totalNumber++ ;
		this.lastOrder = food ;
		
		System.out.println("Reservation complete!") ;
	}
	
	public void showCurrentState()
	{
		System.out.println(totalNumber + " / " + income) ;
	}

}
