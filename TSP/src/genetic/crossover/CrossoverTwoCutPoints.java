package genetic.crossover;

import genetic.Chromosome;

public abstract class CrossoverTwoCutPoints extends CrossoverCutPoint {

	protected int cutPoint2 = -1;

	public CrossoverTwoCutPoints(Chromosome firstParent, Chromosome secondParent, int cutPoint, int cutPoint2) {
		super(firstParent, secondParent, cutPoint);
		this.cutPoint2 = cutPoint2;
	}

	public void start() {

		if (cutPoint == -1) {
			throw new IllegalStateException("The first cut point is not given!");
		}
		if (cutPoint2 == -1) {
			throw new IllegalStateException("The second cut point is not given!");
		}
		kid1 = doCrossover(parent1, parent2);
		kid2 = doCrossover(parent2, parent1);

	}

	protected abstract Chromosome doCrossover(int[] parent1, int[] parent2);

}