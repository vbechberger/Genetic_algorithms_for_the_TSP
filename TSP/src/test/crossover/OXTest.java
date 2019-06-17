package test.crossover;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import genetic.Chromosome;
import genetic.Simulation;
import genetic.crossover.CrossoverType;
import util.Printer;

public class OXTest {
	private Simulation simulation;
	private static Chromosome c1;
	private static Chromosome c2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		int [] tour1 = new int[] {1,2,5,6,4,3,8,7};
		c1 = new Chromosome(tour1);
		
		int [] tour2 = new int[] {1,4,2,3,6,5,7,8};
		c2 = new Chromosome(tour2);
	}
	
	@Test
	public void testOXMiddleKid1() {
		
		simulation = new Simulation(CrossoverType.ORDER, c1, c2, 2, 4);
		simulation.start();
		
		int [] expected = new int[] {2,3,5,6,4,7,8,1};
		Printer.printArray(simulation.getKid1().getGenes());
		Assert.assertArrayEquals(expected, simulation.getKid1().getGenes());
	}
	
	@Test
	public void testOXMiddleKid2() {
		
		simulation = new Simulation(CrossoverType.ORDER, c1, c2, 2, 4);
		simulation.start();
		
		int [] expected = new int[] {5,4,2,3,6,8,7,1};
		Printer.printArray(simulation.getKid2().getGenes());
		Assert.assertArrayEquals(expected, simulation.getKid2().getGenes());
	}
	
	@Test
	public void testOXEndKid1() {
		
		simulation = new Simulation(CrossoverType.ORDER, c1, c2, 5, 7);
		simulation.start();
		
		int [] expected = new int[] {1,4,2,6,5,3,8,7};
		Printer.printArray(simulation.getKid1().getGenes());
		Assert.assertArrayEquals(expected, simulation.getKid1().getGenes());
	}
	
	@Test
	public void testOXEndKid2() {
		
		simulation = new Simulation(CrossoverType.ORDER, c1, c2, 5, 7);
		simulation.start();
		
		int [] expected = new int[] {1,2,6,4,3,5,7,8};
		Printer.printArray(simulation.getKid2().getGenes());
		Assert.assertArrayEquals(expected, simulation.getKid2().getGenes());
	}
	
	@Test
	public void testOXStartKid1() {
		
		simulation = new Simulation(CrossoverType.ORDER, c1, c2, 0, 2);
		simulation.start();
		
		int [] expected = new int[] {1,2,5,3,6,7,8,4};
		Printer.printArray(simulation.getKid1().getGenes());
		Assert.assertArrayEquals(expected, simulation.getKid1().getGenes());
	}
	
	@Test
	public void testOXStartKid2() {
		
		simulation = new Simulation(CrossoverType.ORDER, c1, c2, 0, 2);
		simulation.start();
		
		int [] expected = new int[] {1,4,2,6,3,8,7,5};
		Printer.printArray(simulation.getKid2().getGenes());
		Assert.assertArrayEquals(expected, simulation.getKid2().getGenes());
	}

}