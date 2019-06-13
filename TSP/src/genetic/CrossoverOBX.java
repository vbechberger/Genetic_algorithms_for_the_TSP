package genetic;

import java.util.ArrayList;
import java.util.Collections;

import util.SaveCopy;

public class CrossoverOBX extends Crossover{
	
	private ArrayList<Integer> indices = new ArrayList<Integer>();

	public CrossoverOBX(CrossoverType type, Chromosome firstParent, Chromosome secondParent, ArrayList<Integer> indices) {
		super(type, firstParent, secondParent);
		SaveCopy.copy(this.indices, indices);
		// TODO Auto-generated constructor stub
	}
	
	public void start() {
		
		if (indices.size() == 0) {
			   throw new IllegalStateException("The indezes are not chosen!");
		}
		
		kid1 = doOrderBased(parent1, parent2);
		kid2 = doOrderBased(parent2, parent1);
	}
	
	private Chromosome doOrderBased(int [] parent1, int [] parent2) {
		 
		 SaveCopy.copy(arrKid, parent2);
		 
		 //find the elements which stand at the given positions in the first parent,
		 //preserving the order
		 int [] selected = new int[indices.size()];
		 
		 for(int i = 0; i < selected.length; i++){
				selected[i] = parent1[indices.get(i)];
		 }
		 
		 //find at which indices these elements stand in the second parent
		 ArrayList<Integer> parent2List = new ArrayList<Integer>();
		 	 
		 SaveCopy.copy(parent2List, parent2);
		 
		 ArrayList<Integer> indicesInParent2 = new ArrayList<Integer>();
		 for(int i = 0; i < selected.length; i++){
				indicesInParent2.add(parent2List.indexOf(selected[i]));
		 }
		 //sort the indices
		 Collections.sort(indicesInParent2);	 
		 
		 //put the chosen elements from the first parent into the second parent,
		 //at the defined indices but with preserved order
		 for(int i = 0; i < selected.length; i++){
			 arrKid[indicesInParent2.get(i)] = selected[i];
		 }
		 
		 return new Chromosome(arrKid);	 
		 
		 
	  }

}
