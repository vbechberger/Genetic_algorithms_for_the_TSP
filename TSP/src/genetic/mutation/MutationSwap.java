package genetic.mutation;

import genetic.Chromosome;


/**
 * This class represents the swap mutation operator 
 * which randomly selects two random positions and swaps 
 * the cities in these positions.
 * 
 * @author Valeriya Bechberger(vsakharova@uos.de)
 *
 */
public class MutationSwap extends Mutation {

	public MutationSwap(Chromosome kid, int index1, int index2) {
		super(kid, index1, index2);
		// TODO Auto-generated constructor stub
	}
	
	public Chromosome doMutation() {
		
		int tempValue1 = kidGenes[index1];
		int tempValue2 = kidGenes[index2];
		
		kidGenes[index1] = tempValue2;
		kidGenes[index2] = tempValue1;
		
		return new Chromosome(kidGenes);
		
	}

}