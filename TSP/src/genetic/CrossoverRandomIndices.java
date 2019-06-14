package genetic;

import java.util.ArrayList;

import util.SaveCopy;

public abstract class CrossoverRandomIndices extends Crossover {
	protected ArrayList<Integer> indices = new ArrayList<Integer>();

	public CrossoverRandomIndices(Chromosome firstParent, Chromosome secondParent,
								ArrayList<Integer> indices) {
		super(firstParent, secondParent);
		SaveCopy.copy(this.indices, indices);
		
	}

	public void start() {

		if (indices == null || indices.size() == 0) {
			   throw new IllegalStateException("The indezes are not chosen!");
		}
		
		kid1 = doCrossover(parent1, parent2);
		kid2 = doCrossover(parent2, parent1);

	}
	
	protected abstract Chromosome doCrossover(int [] parent1, int [] parent2);

}
