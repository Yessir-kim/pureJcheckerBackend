package edu.handong.isel.csee.testing.main;

import edu.handong.isel.csee.testing.custom.CustomException;

public class Calculator{
    private int left, right ;
    
    public void setOprands(int left, int right)
    {
        this.left = left ;
        this.right = right ;
    }
    
    public void divide()
    {
        if(this.right == 0)
        {
            try { throw new CustomException("Do not allow divided by zero") ; } 
            catch(CustomException e) { e.printStackTrace() ; }
        }
        
        System.out.println(this.left/this.right) ;
    }
}
