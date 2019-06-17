package genetic.crossover;

import java.util.HashSet;

import genetic.Chromosome;

public class CrossoverOX extends CrossoverTwoCutPoints {

	public CrossoverOX(Chromosome firstParent, Chromosome secondParent, int cutPoint1, int cutPoint2) {
		super(firstParent, secondParent, cutPoint1, cutPoint2);
	}

	protected Chromosome doCrossover(int[] parent1, int[] parent2) {
		
		int[] arrKid = new int[arrLength];

		// make a set with values between cuts
		HashSet<Integer> cut = new HashSet<Integer>();

		// values between the cut points are copied to the offspring from the
		// first parent at the same positions
		for (int i = cutPoint; i < cutPoint2 + 1; i++) {
			arrKid[i] = parent1[i];

			// save the values between cut points of the first parent
			cut.add(parent1[i]);
		}

		// the remaining positions of the offspring are filled by considering
		// the sequence in the second parent, starting after the second
		// cut point and then continue from the beginning of the second parent
		int pos = -1;

		// define where we start to fill in the offspring
		if (cutPoint2 == arrLength - 1) {
			pos = 0;
		} else {
			pos = cutPoint2 + 1;
		}
		// fill in the offspring
		for (int i = cutPoint2 + 1; i < arrLength; i++) {
			if (!cut.contains(parent2[i])) {
				arrKid[pos] = parent2[i];
				pos++;
			}
		}
		for (int i = 0; i < cutPoint2 + 1; i++) {
			if (!cut.contains(parent2[i])) {
				arrKid[pos] = parent2[i];

				// if the tail part of the offspring is filled, start from the
				// beginning
				if (pos == arrLength - 1) {
					pos = 0;
				} else {
					pos++;
				}

			}
		}

		return new Chromosome(arrKid);
	}

}