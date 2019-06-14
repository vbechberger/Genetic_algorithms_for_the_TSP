package genetic;

import java.util.HashMap;
import java.util.HashSet;

public class CrossoverPMX extends CrossoverCutPoints{

	public CrossoverPMX(Chromosome firstParent, Chromosome secondParent,
						int startIndex, int endIndex) {
		super(firstParent, secondParent, startIndex, endIndex);
	}
	
	protected Chromosome doCrossover(int [] parent1, int [] parent2) {
		 
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
		 
		 return new Chromosome(arrKid);
	  
  }

}
