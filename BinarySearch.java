/*******************************************************************************
 * 
 * Made by Michael Weedmark
 * Assignment 3b, ICS4U
 * this is a Binary search program
 * 
 ******************************************************************************/

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Main {

	public static int[] SortedArray(int[] array) {
		
		//Variables
		int max = 1000;
	    int min = 0;

	    int[] sortedArray = new int[array.length];
	    
	    for (int counterA = 0; counterA < array.length; counterA++){
	    	
	    	max = 1000;
	    	
	    	for(int counterB = 0; counterB < 250; counterB++){
                
	    		if (array [counterB] <= max ){
	    			
	    			max = array[counterB];
	    			min = counterB;

	    		}
	    		    		
	    	}
	    	
	    	sortedArray[counterA] = max;
			array[min] = 1001;
	    	
	    }
        
	    return sortedArray;
	    
	}
    
	public static void main(String[] args){
		
		//variables
		Random rng = new Random();
		Scanner UserInput = new Scanner(System.in);
		int[] amountOfNumbers = new int [250];
		int[] sortedNumbers = new int [250];
		int input;
		
		for (int counter = 0; counter < 250; counter++){
			
			amountOfNumbers[counter] = rng.nextInt(1000) + 1;
			
		}
		
		System.out.println(Arrays.toString(amountOfNumbers));
		sortedNumbers = SortedArray(amountOfNumbers).clone();
		System.out.println(Arrays.toString(sortedNumbers));
		
		while (true){
			
			System.out.println("Please enter a number between 1 and 1000. To add a number, enter 00");
			if (UserInput.hasNextInt()){
				
				input = UserInput.nextInt();
				
				if ((input > 0)&&(input < 1001)){
					
					FindInput(sortedNumbers, input);
					
				}
				
				else if (input == 00){
					
					System.out.println("Please enter the number you wish to add. (Must be between 1 to 1000)");
					
					if (UserInput.hasNextInt()){
						
						input = UserInput.nextInt();
						sortedNumbers = Arrays.copyOf(sortedNumbers, sortedNumbers.length + 1);
						sortedNumbers = AddNewNumber(sortedNumbers, input).clone();						
						System.out.println("You have added a number to the array.");
						System.out.println(Arrays.toString(sortedNumbers));
						
					}
					
					else {
						
						System.out.println("You can not enter that number.");
						break;
						
					}
					
				}
				
				else {
					
					System.out.println("That is not a valid input.");
					break;
					
				}
				
			}
			
			else {
				
				System.out.println("Invalid input");
				break;
				
			}
			
		}
		
	}
	
	public static void FindInput(int[] array, int input){
		
        boolean foundInput = false;
		
		for (int counter = 0; counter < array.length; counter++){
			
			if (input == array[counter]){
				
				System.out.println("that number is " + (counter + 1) + " from the top of the list.");
				
				foundInput = true;
			}
		}
		
		if (!foundInput){
			
			System.out.println("That number could not be found.");
			
		}
		
	}
	
	public static int[] AddNewNumber(int[] array, int number){
		
		int[] addedArray = new int [array.length];
		addedArray = array.clone();
		addedArray[addedArray.length - 1] = number;
		addedArray = SortedArray(addedArray);
		
	    return addedArray;
		
	}
	
}
