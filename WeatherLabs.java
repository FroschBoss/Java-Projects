import java.util.Scanner;
import java.util.Arrays;

public class WeatherLabs {

	public static void main(String[] args)
	{
		Scanner reader = new Scanner (System.in);
		
		int num = 0;

		System.out.println("how many day's temperature");
	    num = reader.nextInt();
	    
	    int [] days = new int [num];
		
	
		  
		int count = 0;
		
		int temp = 0;
		
		double Ttemperature = 0.0;
		
		int Ndays = 0;
		


		 if(days.length<2)
		 {
			   System.out.println("that is not enough data to provide you with the average temperature, lowest temperature of the highest temperature"); 
		 }
		 
		for(int val = 0; val<days.length; val++)
		{
			    Ndays = Ndays+1;
			
				System.out.println("day "+ Ndays + " peak temperature is");
			    temp = reader.nextInt();
			    
			    days[val] = temp;
			    
			    Ttemperature = Ttemperature + temp;    
		}
	    
		double Average = Ttemperature/days.length;
	
	   
	   for(int val2 = 0; val2<days.length; val2++)
	   {
		   if(days[val2]>Average)
			{
			count = count +1;
			}
	   }
	   
	 Arrays.sort(days);
	 int HTemp = days[days.length-1];
	 int HTemp2 = days[days.length-2];
	 
	 int MTemp = days[0];
	 int MTemp2 = days[1];
	 
	 
	
	 if(days.length==2 || days.length==3 )
	 {
		   System.out.println("The average temperature was " + Average);
		   System.out.println("The lowest temperature was "+ MTemp);
		   System.out.println("The highest temperature was "+ HTemp);
		   System.out.println(count+" days were above average temperature");
	 }
	 else
	 {   
		 System.out.println("The average temperature was " + Average);
		 System.out.println("The lowest temperature was "+ MTemp + " and " + MTemp2);
		 System.out.println("The highest temperature was "+ HTemp + " and " + HTemp2);
		 
		 System.out.println(count+" days were above average temperature"); 
	 }
	 
	 
	}

}
