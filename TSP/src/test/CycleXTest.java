package test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import genetic.Chromosome;
import genetic.Simulation;
import genetic.crossover.CrossoverType;
import util.Printer;

public class CycleXTest {
	
	private Simulation simulation;
	//private Crossover crossover;
	private static Chromosome c1;
	private static Chromosome c2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		int [] tour1 = new int[] {1,3,5,6,4,2,8,7};
		c1 = new Chromosome(tour1);
		
		int [] tour2 = new int[] {1,4,2,3,6,5,7,8};
		c2 = new Chromosome(tour2);
	}

	@Test
	public void testCycleXKid1() {
		simulation = new Simulation(CrossoverType.CYCLE, c1, c2);
		simulation.start();
		
		int [] expected = new int[] {1,3,2,6,4,5,7,8};
		Printer.printArray(simulation.getKid1().getGenes());
		Assert.assertArrayEquals(expected, simulation.getKid1().getGenes());
	}
	
	@Test
	public void testCycleXKid2() {
		simulation = new Simulation(CrossoverType.CYCLE, c1, c2);
		simulation.start();
		
		int [] expected = new int[] {1,4,5,3,6,2,8,7};
		Printer.printArray(simulation.getKid2().getGenes());
		Assert.assertArrayEquals(expected, simulation.getKid2().getGenes());
	}
	
	@Test
	public void testEqualParents() {
		
		int [] tour2 = new int[] {1,3,5,6,4,2,8,7};
		Chromosome c2 = new Chromosome(tour2);
		
		simulation = new Simulation(CrossoverType.CYCLE, c1, c2);
		simulation.start();
		
		int [] expected = new int[] {1,3,5,6,4,2,8,7};
		Printer.printArray(simulation.getKid1().getGenes());
		Assert.assertArrayEquals(expected, simulation.getKid1().getGenes());
	}

}
