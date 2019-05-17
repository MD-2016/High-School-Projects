/*
lkm.k * Program Title:	Monthly Loan Calculator
 * Programmer:		Jay		
 * Date Created:	October 1st, 2009
 * Purpose:			The purpose of this this program is for the user to enter in the information of the loan amount, down payment, deductions, the months the loan is used for, and interest rate. These values will all get calculated to become the monthly payment.
 */
import java.io.*;
import java.text.DecimalFormat;
public class MonthlyCalc 
{
public static void main(String[] args) throws IOException
{
	// The variables are declared here to get the users input.
		DecimalFormat f = new DecimalFormat("#");
	    String Name,loanAmountString, downPaymentString, DeductionsString, interestRateString, MonthlyString; 
		double loanAmount = 0, downPayment = 0, Deductions = 0, finalloanAmount;
		int Monthly = 0;
		double interestRate = 0, monthlyPayment;
		BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
		System.out.println();
		System.out.println("Monthly Loan Payment Calculator");
		
		//User will Enter Their Name Here.
		System.out.println("Enter your Name: ");
		Name = dataIn.readLine();
		
		//User will Enter the Loan Amount.
		System.out.println("Enter the Loan Amount: ");
		loanAmountString = dataIn.readLine();
		try
		{
			loanAmount = Double.parseDouble(loanAmountString);
			if(loanAmount <= 0)throw new NumberFormatException();
		}
		catch(NumberFormatException e)
		{
			System.out.println("Any number below 0 or is 0 is not allowed. No Words Either!");
			System.exit(0);
		}
		
		//User will put in the down payment.
		System.out.println("Enter The Down Payment: ");
		downPaymentString= dataIn.readLine();
		try
		{
			downPayment = Double.parseDouble(downPaymentString);
			if(downPayment < 0)throw new NumberFormatException();
		}
		catch(NumberFormatException e)
		{
			System.out.println("Any number below 0 or is 0 is not allowed. No Words Either!");
			System.exit(0);
		}
		
		//User will enter in the deductions.
		System.out.println("Enter the Deduction Amount: ");
		DeductionsString = dataIn.readLine();
		try
		{
			Deductions = Double.parseDouble(DeductionsString);
			if(Deductions < 0)throw new NumberFormatException();
		}
		catch(NumberFormatException e)
		{
			System.out.println("Any number below 0 or is 0 is not allowed. No Words Either!");
			System.exit(0);
		}
		
		//User enters in the Months.
		System.out.println("Enter the amount of Months of the loan: ");
		MonthlyString = dataIn.readLine();
		try
		{
			Monthly = Integer.parseInt(MonthlyString);
			if(Monthly <= 0) throw new NumberFormatException();
		}
		catch(NumberFormatException e)
		{
			System.out.println("Sorry This is Integer only. No Decimals and no negatives and no words please!");
			System.exit(0);
		}
		
		
		//User enters the Interest Rate as a Decimal.
		System.out.println("Enter the Interest Rate: (Decimal Form only)");
		interestRateString = dataIn.readLine();
		try
		{
			interestRate = Double.parseDouble(interestRateString);
		    interestRate = interestRate / 12;
		    if (interestRate <= 0) throw new NumberFormatException();
		}
		catch(NumberFormatException e)
		{
			System.out.println("Any number below 0 or is 0 is not allowed. No Words Either!");
			System.exit(0);
		}
		
		//Calculations for the Monthly Payment.
		finalloanAmount = loanAmount - Deductions - downPayment;
		monthlyPayment = (interestRate + interestRate /((Math.pow(1 + interestRate,Monthly))- 1)) * finalloanAmount;
		
		//Output for the Calculations from User's Input and the Formaula's Output Answer.
		System.out.println("The Monthly Payment for " + Name + "  $" + f.format(monthlyPayment));
}
}

