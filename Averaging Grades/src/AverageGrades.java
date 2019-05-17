/*
 * Program: Averaging Grades
 * Programmer: Jay
 * Date: 12/6/09
 * Purpose: To average grades for lab.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
public class AverageGrades{
	
	public static void main(String[] args)throws IOException
	{
		String Strgrade;
		DecimalFormat f = new DecimalFormat("###.####");
		NumberFormat percent =  NumberFormat.getPercentInstance();
		percent.setMaximumFractionDigits(1);
		percent.setMinimumFractionDigits(1);
		float Final = 0;
		String numberofgrades; 
		int grade = 0;
		float Average = 0;
		float TeacherAverage = 0;
		int scoreoutof = 0;
		String Strscoreoutof;
		int numberofgrade = 0;
		//User will first be asked how many grades they are entering.
	    Strgrade = JOptionPane.showInputDialog(null,"How may grades do you want to enter?");
	   
	    try
	    {
	    grade  = Integer.parseInt(Strgrade);
	    if(Strgrade == null || grade<=0)throw new Exception();
	    }
	    catch(Exception g)
	    {
	    	JOptionPane.showMessageDialog(null,"You cannot enter words,0, or negatives or decimals","Error",JOptionPane.ERROR_MESSAGE);
	    	System.exit(0);
	    }
	    int grades[] = new int[grade];
	    for(int i = 0; i<grades.length; i++)
	    {
	    	//user will than enter the grades by the for loop.
	    	numberofgrades = JOptionPane.showInputDialog(null,"What is the grades");
	    	 numberofgrade = Integer.parseInt(numberofgrades);
	    	try
	    	{
	    	if(numberofgrades == null || numberofgrade <=0)throw new Exception();
	    	}
	    	catch(Exception e)
	    	{
	    		JOptionPane.showMessageDialog(null,"You cannot enter words or negatives,","Error",JOptionPane.ERROR_MESSAGE);
	    	}
	    }
	      for(int i = 0; i<grades.length; i++)
	      {
	    	   Strscoreoutof = JOptionPane.showInputDialog(null,"What is the score out of");
	    	   scoreoutof = Integer.parseInt(Strscoreoutof);
	    	  Average = numberofgrade + numberofgrade ;
	    	  TeacherAverage = scoreoutof + scoreoutof;
	      }
	      Final = Average / TeacherAverage;
	      
	      JOptionPane.showMessageDialog(null, f.format(Final),"Final",JOptionPane.INFORMATION_MESSAGE);
	      JOptionPane.showMessageDialog(null,percent.format(Final),"Final Percent",JOptionPane.INFORMATION_MESSAGE);
	     
	   

		
	}
	
 
	

}


 