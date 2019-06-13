package util;

import java.util.ArrayList;

public class Printer {

	public static void printArray(int [] array) {
		 System.out.println("Array of integers:");		 
		 for(int i = 0; i < array.length; i++) {			
			 System.out.print(" " + array[i] + " ");
		 }
		 System.out.println();
	}
	
	public static void printArrayList(ArrayList<Integer> array) {
		 System.out.println("ArrayList of integers:");		 
		 for(Integer elem: array) {			
			 System.out.print(" " + elem + " ");
		 }
		 System.out.println();
	}
	
	public static void printString(String string) {
		 System.out.println("///////" + string + "////////");		 			 
	}
}