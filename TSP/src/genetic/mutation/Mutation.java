package genetic.mutation;

import genetic.Chromosome;
import util.SaveCopy;

public abstract class Mutation {
	
	protected Chromosome mutant;
	protected int[] kidGenes;
	protected int index1 = -1;
	protected int index2 = -1;
	
	protected final int arrLength;
	
	public Mutation(Chromosome kid, int index1, int index2) {
		arrLength = kid.getGenes().length;
		kidGenes = new int[arrLength];
		//TODO: do it random-till the length of array
		this.index1 = index1;
		this.index2 = index2;
		SaveCopy.copy(kidGenes, kid.getGenes());
		
				
	}
	
	public void start() {

		if (index1 == -1 || index2 == -1) {
			throw new IllegalStateException("The index is not given!");
		}

		mutant = doMutation();
		
	}
	
	protected abstract Chromosome doMutation();

	public Chromosome getMutant() {
		return mutant;
	}
	
}