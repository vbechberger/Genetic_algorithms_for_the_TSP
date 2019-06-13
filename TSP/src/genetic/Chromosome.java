package genetic;

import util.SaveCopy;

public class Chromosome {

	//parameters
	
	private double fitness;
	private int[] genes;
	
	public Chromosome(Instance instance) {
		genes = new int[instance.getTour().size()];
		SaveCopy.copy(genes, instance.getTour());
		calculateFitness();
		
	}
	public Chromosome(int[] numbers) {
		genes = new int[numbers.length];
		SaveCopy.copy(genes, numbers);
		calculateFitness();
		
	}
	
	double calculateFitness(){
		System.out.println("calculate Fitness is to implement!");
		return 0;
	}

	public double getFitness() {
		return fitness;
	}


	public int[] getGenes() {
		return genes;
	}

	
	
}