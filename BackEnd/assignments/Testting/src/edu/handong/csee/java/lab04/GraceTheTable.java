package edu.handong.csee.java.lab04;

public class GraceTheTable {
	
	public static void main(String[] args)
	{
		GraceTheTable runner = new GraceTheTable() ;
		runner.run(args);
	}
	/*
	 **/
	public void run(String[] args)
	{
		Reservation desk = new Reservation() ;
		
		Customer first = new Customer() ;
		first.setName("Kim") ;
		first.setFood(args[0]) ;
		
		desk.order(first.getFood(), 10000) ;
		
		/*
		Customer second = new Customer() ;
		second.setName("Park") ;
		second.setFood("Pizza") ;
		
		desk.order(second.getFood(), 15000) ;
		*/
		
		// desk.showCurrentState() ;
	}

}
