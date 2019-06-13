package genetic;

import java.util.HashMap;
import java.util.HashSet;

import util.Printer;

public class CrossoverPMX extends Crossover{
	private int startIndex = -1;
	private int endIndex = -1;

	public CrossoverPMX(CrossoverType type, Chromosome firstParent, Chromosome secondParent,
						int startIndex, int endIndex) {
		super(type, firstParent, secondParent);
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		// TODO Auto-generated constructor stub
	}
	
	public void start() {
		
		if (startIndex == -1) {
			  throw new IllegalStateException("The start index is not set!");
		  }
		  if (endIndex == -1) {
			  throw new IllegalStateException("The end index is not set!");
		  }
		  kid1 = doPartiallyMapped(parent1, parent2);
		  kid2 = doPartiallyMapped(parent2, parent1);
	}
	
	private Chromosome doPartiallyMapped(int [] parent1, int [] parent2) {
		 
	  	//randomly select two cut points on both parents		 
		 //fill in two kids by exchanging the genetic information between parents:		
		 for(int i = 0; i < startIndex; i++) {
			 arrKid[i] = parent2[i];			
		 }		 
		 for(int i = startIndex; i < endIndex + 1; i++) {
			 arrKid[i] = parent1[i];			 
		 }
		 for(int i = endIndex + 1; i < arrLength; i++) {
			 arrKid[i] = parent2[i];			 
		 }
		 
		 //handle the duplicates in kids:
		 
		 //make sets with values between cuts
		 HashSet<Integer> cut = new HashSet<Integer>();
		 				 
		 //determine mapping relationship between cuts <->
		 HashMap<Integer, Integer> mapping = new HashMap<Integer, Integer>();
		 
		 for(int i = startIndex; i < endIndex + 1; i++) {
			 mapping.put(parent1[i], parent2[i]);
			 cut.add(arrKid[i]);
		 }
		 		 
		 /**fill in the first kid from the rest of the second parent,
		 /*taking into account which values the first kid already has from 
		 /* the first parent
		  */
		 for(int i = 0; i < startIndex; i++) {
			 
			 //if the value at index i is in mapping, i.e. is duplicated in the kid
			 if(cut.contains(arrKid[i])) {
				 while(cut.contains(arrKid[i])) {
					 arrKid[i] = mapping.get(arrKid[i]);
				 }				
			 }			 			 
		 }
		 
		 for(int i = endIndex + 1; i < arrLength; i++) {
			 
			 //if the value at index i is in mapping, i.e. is duplicated in the kid
			 if(cut.contains(arrKid[i])) {
				 while(cut.contains(arrKid[i])) {
					 arrKid[i] = mapping.get(arrKid[i]);
				 }				
			 }
			 			 
		 }
		 Printer.printString("Kid in crossover:");
		 Printer.printArray(arrKid);
		 return new Chromosome(arrKid);
	  
  }

}
