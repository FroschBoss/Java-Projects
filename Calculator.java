import java.awt.Button; // Import the Button class from the AWT package for creating buttons.
import java.awt.Checkbox;//Imports the Checkbox class used for creating the check boxes
import java.awt.Color;
import java.awt.TextField;//Imports the TextField class used to make the big text box at tthe top where the number is shown
import java.util.Arrays;//Imports a bunch of useful features of array, for this programm I used to stringify one of the arrays to make it be able to go on the text box
//Define a public class named sampleGui that extends EasyApp class.
public class Calculator extends EasyApp {

Button number = addButton("Enter number",0,150,600,40, this); // Create a button with specified text and position.	


Button addition = addButton("+",475,200,90,50, this);//Creates a button that has a plus symbol, has specified text and positions
Button subtraction = addButton("-",385,200,90,50, this);//Creates a button that has a minus symbol, has specified text and positions
Button multiply = addButton("x",295,200,90,50, this);//Creates a button that has a x/multiplication symbol, has specified text and positions
Button divison = addButton("÷",205,200,90,50, this);//Creates a button that has a divison symbol, has specified text and positions
Button Power = addButton("^",115,200,90,50, this);//Creates a button that has a power/exponent symbol, has specified text and positions
Button Root = addButton("√",25,200,90,50,this);//Creates a button that has a root symbol, has specified text and positions
Button Average = addButton("Average",115,250,180,50,this);
Button Round = addButton("Round",295,250,180,50,this);
Checkbox Fact = addCheckbox("Factorial",475,250,180,50,this);
Checkbox Fib = addCheckbox("Fibonacci",20,250,180,50,this);
 

Button Quit = addButton("EXIT",0,350,90,50,this);
Button Clear = addButton("CLEAR",510,350,90,50,this);

TextField Display = addTextField("",0,0,600,150,this); // Create a text field with initial text and position.



double Amount = 0;//This is where I will store the number that the user had entered in the enter number button
double average = 0;//This is where I will store the average in
int avg = 0;//This is what I will use to keep up with how many additions were made so when the user presses average it will give the proper amount
int neg =1;

public Calculator() {//This is where I will have have the gui asthetic features like color
   
  addition.setBackground(Color.green); //This is used to set the color of the buttons
  
  subtraction.setBackground(Color.red);
  multiply.setBackground(new java.awt.Color(77,182,240));
  divison.setBackground(new java.awt.Color(240,210,70));
  Power.setBackground(new java.awt.Color(239,129,45));
  Root.setBackground(new java.awt.Color(153,36,240));
  
  Quit.setBackground(Color.RED);
  Clear.setBackground(Color.BLUE);
  
}

public void actions(Object source,String command) //In this method, all the of the math will occur. This is what allowed for on the on click events like with number subtraction, etc
{
	
   
	
	if(source == number) //When the number button is pressed, the following in the if statement will happen
	{          
		       avg = 1;
	           String Val = input("Enter a new amount"); //when you press the button a pop up will happen when it will ask you to enter a number
	          
	          
	           
	           if(Val.contains("-"))
	           //this is to see if the string has a minus sign
	           {
	        	   neg = -1; 
	               //if the string does contain a minus sign this variable will become negative and will later on be multiplied with the number to make the number negative.
	        	   //I did this because it would be far less annoying to check for minus symbol to be the first character of the string
	           }
	           else
	           {
	        	   neg = 1; 
	        	   //if the string doesn't contain a negative neg will turn positive so the resulting number will be positive
	        	   //the reason why I reset the neg if the string doesn't contain a minus sign is because for the next operation whether it would be subtraction of rooting, if enter the string for the amount you want to operate with and it doesn't have a minus it might accidently become negative if the previous operation is negative since neg is still negative
	           }
	           
	           if(Val.contains("."))
	           {
	        	  int dec = Val.indexOf(".");								
	        	  Val = Val.replaceAll("[^0-9]+", "");
	        	  Val = Val.substring(0,dec) + "." + Val.substring(dec);  
	        	  
	        	  /*
	        	   * This operation looks to see if the string contains a decimal
	        	   * then it will find the location in the string of the first decimal
	        	   * then remove all decimals except the first decimal with the replaceAll command
	        	   * The first decimal is then reinstated back into the string
	        	   */
	           }
	           
	           Val = Val.replaceAll("[^0-9.]+",""); //this removes everything except numbers and decimals
	           
	           
	           
	           if(Val.equals("")) //if the string is blank a message will pop up stating the error
	           {
	        	   output("please enter a number");
	        	   Amount = 0;
	        	   Display.setText("" + Amount);
	           }
	           else
	           {
	           Amount = Double.parseDouble(Val);//The string turns into a number and is stored in a variable which I named amount
	           Amount = Amount * neg; //The amount stored is then multiplied by variable neg which was used to turn the amount negative if the number had a minus sign in it.
	           Display.setText("" + Amount); //The amount that the user has put in will be displayed in the text box
	           average = Amount;
	           
	           
	           //all the commands explained will be reused for the other operations so there will be almost nothing new for most operations
	           }
	}
	
	
	
	if(source == multiply)
	{
		 String MultVal = input("Enter a new amount"); 
		 if(MultVal.contains("-"))
         {
      	   neg = -1;
         }
		 else
		 {
		   neg = 1;
		 }
		 
		 if(MultVal.contains("."))
         {
      	  int dec = MultVal.indexOf(".");
      	  MultVal = MultVal.replaceAll("[^0-9]+", "");
      	  MultVal = MultVal.substring(0,dec) + "." + MultVal.substring(dec);
         }
		 
		 MultVal = MultVal.replaceAll("[^0-9.]+", "");
         
		 if(MultVal.equals(""))
         {
      	   output("please enter a number");
      	   Display.setText("" + Amount);
         }
		 else
		 {
		 double MultAmount = Double.parseDouble(MultVal); 
		 MultAmount = MultAmount*neg;
         Amount = Amount*MultAmount; // multiply the current number with the number you want to multiply it with 
         Amount = Math.round(Amount*10000000.0)/10000000.0;
         Display.setText(""+Amount);
		 }
	}
	
	if(source == divison)
	{
		 String DivVal = input("Enter a new amount"); 
		 if(DivVal.contains("-"))
         {
      	   neg = -1;
         }
		 else
		 {
		   neg = 1;
		 }
		 
		 if(DivVal.contains("."))
         {
      	  int dec = DivVal.indexOf(".");
      	  DivVal = DivVal.replaceAll("[^0-9]+", "");
      	  DivVal = DivVal.substring(0,dec) + "." + DivVal.substring(dec);
         }
		 
		 DivVal = DivVal.replaceAll("[^0-9.]+", "");
       
		 if(DivVal.equals(""))
         {
      	   output("please enter a number");
      	   Display.setText("" + Amount);
         }
		 else
		 {
         double DAmount = Double.parseDouble(DivVal);
         DAmount = DAmount*neg;
         if(DAmount == 0)
         {
        	 output("A numbner can't be divided by zero");
        	 Display.setText("" + Amount);
         }
         else
         {
         Amount = Amount/DAmount;
         Amount = Math.round(Amount*10000000.0)/10000000.0;
         Display.setText("" + Amount);
         }
         
		 }
	}
	
	if(source == addition)
	{
		String AddVal = input("Enter a new Amount"); 
        // Parse the input string to an integer.
		 if(AddVal.contains("-"))
         {
      	   neg = -1;
         }
		 else
		 {
		   neg = 1;
		 }
		 
		 if(AddVal.contains("."))
         {
      	  int dec = AddVal.indexOf(".");
      	  AddVal = AddVal.replaceAll("[^0-9]+", "");
      	  AddVal = AddVal.substring(0,dec) + "." + AddVal.substring(dec);
         }
		 
		AddVal = AddVal.replaceAll("[^0-9.]+", "");
        
		 if(AddVal.equals(""))
         {
      	   output("please enter a number");
      	   Display.setText("" + Amount);
         }
		 else
		 {
		 double AddAmount = Double.parseDouble(AddVal);
		 AddAmount = AddAmount*neg;
         Amount = Amount+AddAmount;
         Amount = Math.round(Amount*10000000.0)/10000000.0;
         Display.setText("" + Amount);
        
         average = Amount;
         avg = avg+1;
         
		 }
	}
	
	
	if(source == subtraction)
	{
		 String SubVal = input("Enter a new amount"); 
        // Parse the input string to an double.
		 if(SubVal.contains("-"))
         {
      	   neg = -1;
         }
		 else
		 {
		   neg = 1;
		 }
		
		 if(SubVal.contains("."))
         {
      	  int dec = SubVal.indexOf(".");
      	  SubVal = SubVal.replaceAll("[^0-9]+", "");
      	  SubVal = SubVal.substring(0,dec) + "." + SubVal.substring(dec);
         }
			 
		 SubVal = SubVal.replaceAll("[^0-9.]+", "");
         
		 if(SubVal.equals(""))
         {
      	   output("please enter a number");
      	   Display.setText("" + Amount);
         }
		 else
		 {
		 double SubAmount = Double.parseDouble(SubVal);
		 SubAmount = SubAmount*neg;
         Amount = Amount-SubAmount;
        
         Amount = Math.round(Amount*10000000.0)/10000000.0; //there is an error within the computer itself when subtracting decimals which can cause incorrect answers and really long decimals that aren't correct, I just rounded to prevent that
        
         Display.setText("" + Amount);
		 }
    
	}
	
	if(source == Power)
	{
		String PowVal = input("Enter a new Amount"); 
		if(PowVal.contains("-"))
        {
     	   neg = -1;
        }
		else
		{
		   neg = 1;
		}
		
		if(PowVal.contains("."))
        {
     	  int dec = PowVal.indexOf(".");
     	  PowVal = PowVal.replaceAll("[^0-9]+", "");
     	  PowVal = PowVal.substring(0,dec) + "." + PowVal.substring(dec);
        }
		
		PowVal = PowVal.replaceAll("[^0-9.]+", "");
        
		 if(PowVal.equals(""))
         {
      	   output("please enter a number");
      	   Display.setText("" + Amount);
         }
		 else
		 {
		 double PowAmount = Double.parseDouble(PowVal); 
		 PowAmount = PowAmount * neg;
		
		//Since you have the number of your exponent, the number that is currently stored in the integer Amount will multiply it self by the value of Pamount
		
	     Amount = Math.pow(Amount, PowAmount);
	     Amount = Math.round(Amount*10000000.0)/10000000.0; 
		
		
		 Display.setText(""+Amount);
		 }
	}
	
	if(source == Root)
	{
		String RootVal = input("Enter a new amount"); 
		if(RootVal.contains("-"))
        {
     	   neg = -1;
        }
		else
		{
			neg =1;
		}
		
		 if(RootVal.contains("."))
         {
      	  int dec = RootVal.indexOf(".");
      	  RootVal = RootVal.replaceAll("[^0-9]+", "");
      	  RootVal = RootVal.substring(0,dec) + "." + RootVal.substring(dec);
         }
		
		RootVal = RootVal.replaceAll("[^0-9.]+", "");
       
		 if(RootVal.equals(""))
         {
      	   output("please enter a number");
      	   Display.setText("" + Amount);
         }
		 else
		 {
		 double RootAmount = Double.parseDouble(RootVal);
		 RootAmount = RootAmount*neg;
         Amount = Math.pow(Amount, (1/RootAmount));;
         Amount = Math.round(Amount*10000000.0)/10000000.0;
        
		 Display.setText(""+Amount);	  
		 }
	}
	
	if(Fib.getState() == true && Fact.getState() == false)//this allows the user to check if they want the fibonacci of the number they currently have
	{
		if(Amount <2)//this is some error handling for when the number is less than 2 since that causes errors
		{
			output("The number has to be higher than 1");
			Display.setText(""+Amount);
		}
		else
		{
		int[] num = new int[(int)Amount]; //To show the fibonacci until the value of amount you have to make an array which can story multiple number and thus multiple values of fibonacci
		num[0] = 0; //if fibonacci is 0 the value is zero
		num[1] = 1;// if fibonacci is 1 the value is 1
		for (int count = 2; count < num.length; count++)
		{
		
		//This basically does the fibonacci formula of  F(n)=F(n-1)+F(n-2) until it is looped as much as the length of num
		   num[count] = num[count-1] + num[count-2];
		   
		if(num[count]<0)
		{
		  num[count]=num[count]*-1;
		}
		
		}
		
		String NUM = Arrays.toString(num);//turns string into an array

		
		Display.setText(NUM);	  
		
		}
	}
	
	if(Fact.getState()== true && Fib.getState() == false) //this allows the user to check if they want the factorial of the number they currently have
	{
		
		if(Amount <1)
		{
			output("The number has to be higher than 1");
			Display.setText(""+Amount);
		}
		else
		{
		int sum = 1; //you need to make a new variable since if you use amount, the number would far surpass the actual factorial of the amount
		for(int count = (int)Amount; count>0;count--)
		//To get this loop right and to get the factorial I need to explain using an example, if amount was 5, sum would be 1x5, then after another loop it would be 5*4 and then 20x3 until the number you are multiply with
		//reaches 0, to get this I would need a variable that would go down each loop/multiplication until zero, this loop does that, by making the value of count the amount of 5 and the limit to be 0, it will loop until it reaches zero
		{
			sum = sum*count;
			
		}
		
		
		
		Display.setText(""+sum);	  
	
		}
	}
	
	if(Fact.getState()== true && Fib.getState() == true) //this makes is that if the user turns both fibonacci and factorial on, nothing will happen and no glicthes occur
	{
		output("Sorry but we can't do that");
		Display.setText(""+Amount);	 
	}
	
	if(Fact.getState()== false && Fib.getState() == false) //this makes so that if the user wants to return to the original value, they can easily do that by turning off both boxes without being stuck on the factorial or fibonacci of the number and having to restart to use the calculator
	{
		Display.setText(""+Amount);	  
	}
	
	if(source == Average)
	{
		if(avg == 0) //if avg is zero this makes is so that the program wouldn't glitch and give errors
		{
		output("sorry but we cannot find the average");
		}
		else
		{
		
		output("the average of the numbers added is "+average/avg);
		}
	}
	
	if(source == Round)
	{
		String RoundVal = input("to what decimal place do you want to round to (write zero if you want the whole number)");
	
		RoundVal = RoundVal.replaceAll("[^0-9]+", "");
		
		 if(RoundVal.equals(""))
         {
      	   output("please enter a number");
      	   Amount = 0;
      	   Display.setText("" + Amount);
         }
		 else
		 {
		 double round = Double.parseDouble(RoundVal);
	     round = Math.round(round);
	    
	    
	    
	    
	     double rnd = 1.0;
	     if(round <0 || Amount == 0)
	     {
	    	output("we can't round to that decimal place");
	    	Amount = 0;
	    	Display.setText(""+Amount);
	     }
	     else if(round == 0.0)
	     {
	    	Amount = Math.round(Amount);
	    	Display.setText(""+Amount);
	    	
	     }
	     else
	     {
	    	for(int count = 0; count<round; count++)
	    	{
	    		rnd = rnd*10.0;
	    	}
	    	Amount = Math.round(Amount * rnd)/rnd;
	    	Display.setText(""+Amount);
	     }
		 }
	}
	
	    if(source == Quit)
	    {
	    Display.setText("");
	    Amount = 0.0;
		System.exit(0); //when you press the exit button, the system will exit and close
	    }
	

	    if(source == Clear)
	    {
		Amount = 0.0;
		avg = 0; //this resets the average counter
		average = 0;
		Display.setText(""); //this will make the text blank
	    }
}

	    public static void main(String[] args)
	    {
	    
	
	    	new Calculator(); //This allowed the calculator to launch and start, without this if you tried to press play it would do nothing

	    }

}
