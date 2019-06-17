package genetic.crossover;

import genetic.Chromosome;

public abstract class CrossoverCutPoint extends Crossover {
	protected int cutPoint = -1;

	public CrossoverCutPoint(Chromosome firstParent, Chromosome secondParent, int cutPoint) {
		super(firstParent, secondParent);
		this.cutPoint = cutPoint;
	}

	public void start() {

		if (cutPoint == -1) {
			throw new IllegalStateException("The cut point is not given!");
		}

		kid1 = doCrossover(parent1, parent2);
		kid2 = doCrossover(parent2, parent1);

	}

	protected abstract Chromosome doCrossover(int[] parent1, int[] parent2);

}