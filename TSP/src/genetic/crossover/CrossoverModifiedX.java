package genetic.crossover;

import java.util.HashSet;

import genetic.Chromosome;
import util.SaveCopy;

public class CrossoverModifiedX extends CrossoverCutPoint {

	public CrossoverModifiedX(Chromosome firstParent, Chromosome secondParent, int cutPoint) {
		super(firstParent, secondParent, cutPoint);
	}

	@Override
	protected Chromosome doCrossover(int[] parent1, int[] parent2) {

		// make a set with values till the cut point
		HashSet<Integer> cut = new HashSet<Integer>();

		// fill in the offspring with the values from the first parent
		// from the beginning till the cut point
		for (int i = 0; i < cutPoint; i++) {
			arrKid[i] = parent1[i];
			// fill in the set
			cut.add(arrKid[i]);
		}

		// if the cut point is the first or the last index
		// then we just copy the corresponding parent
		if (cutPoint == 0) {
			SaveCopy.copy(arrKid, parent2);
		} else if (cutPoint == arrLength - 1) {
			SaveCopy.copy(arrKid, parent1);
		} else {

			// define where we start to fill in the offspring
			// with the values from the second parent
			int pos = cutPoint;

			for (int i = 0; i < arrLength; i++) {
				if (!cut.contains(parent2[i])) {
					arrKid[pos] = parent2[i];
					pos++;
				}
			}
		}

		return new Chromosome(arrKid);
	}

}
