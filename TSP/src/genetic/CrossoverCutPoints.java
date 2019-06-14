package genetic;

public abstract class CrossoverCutPoints extends Crossover {

	protected int startIndex = -1;
	protected int endIndex = -1;
	
	public CrossoverCutPoints(Chromosome firstParent, Chromosome secondParent,
								int startIndex, int endIndex) {
		super(firstParent, secondParent);
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	
	}

	@Override
	public void start() {

				if (startIndex == -1) {
					  throw new IllegalStateException("The start index is not set!");
				  }
				  if (endIndex == -1) {
					  throw new IllegalStateException("The end index is not set!");
				  }
				  kid1 = doCrossover(parent1, parent2);
				  kid2 = doCrossover(parent2, parent1);

	}
	
	protected abstract Chromosome doCrossover(int [] parent1, int [] parent2);

}
