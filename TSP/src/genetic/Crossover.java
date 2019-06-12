package genetic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import util.SaveCopy;
import util.Printer;

public class Crossover {
  private CrossoverType type;
  private Chromosome kid1;
  private Chromosome kid2;
  private int [] parent1;
  private int [] parent2;
  private int [] arrKid;
  
  private final int arrLength;
//TODO: Make it random - GENERAL PARAMETER
  private int startIndex;
  private int endIndex;
  
  
  public Crossover(CrossoverType type, Chromosome firstParent,Chromosome secondParent, int startIndex, int endIndex) {
	  this.type = type;	
	  this.startIndex = startIndex;
	  this.endIndex = endIndex;
	  arrLength = firstParent.getGenes().length;
	  parent1 = new int[arrLength];
	  parent2 = new int[arrLength];
	  SaveCopy.copy(parent1, firstParent.getGenes());
	  SaveCopy.copy(parent2, secondParent.getGenes());	  
	  arrKid = new int[arrLength];
	  
	  
  }
  
  public void start() {
	   if (type == CrossoverType.ORDERBASED) {
		 // doOrderBased();
	  } else if (type == CrossoverType.POSITIONBASED) {
		 // doPositionBased();
	  } else if (type == CrossoverType.PARTIALLYMAPPED) {
		  kid1 = doPartiallyMapped(parent1, parent2);
		  kid2 = doPartiallyMapped(parent2, parent1);
		  
	  } else if (type == CrossoverType.CYCLE) {
		  //doCycle();  
	  } else {
		 //other types 
	  }
	   //make children's chromosomes
	  
	   
	   
  }
  
  
  
  
  private Chromosome doOrderBased() {
	 System.out.println("OrderBased to implement"); 
	 return null;
  }
  
  private Chromosome doPositionBased() {
		 System.out.println("PositionBased to implement");
		 return null;
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
  
  
  
  private Chromosome doCycle() {
		 System.out.println("PartiallyMapped to implement"); 
		 return null;
  }
  
  
  
  /*Getter methods*/
  public Chromosome getKid1() {
	  if(kid1 == null) {
		  throw new RuntimeException("Crossover was not started. There exists no kids!");
	  }
	  return kid1;
  }

  public Chromosome getKid2() {
	  if(kid2 == null) {
		  throw new RuntimeException("Crossover was not started. There exists no kids!");
	  }
	  return kid2;
  }

  
  
  
  
}
