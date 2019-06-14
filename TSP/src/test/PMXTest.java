package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import genetic.Chromosome;
import genetic.CrossoverType;
import genetic.Simulation;

public class PMXTest {
	
	private Simulation simulation;
	//private Crossover crossover;
	private static Chromosome c1;
	private static Chromosome c2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		int [] tour1 = new int[] {1,2,5,6,4,3,8,7};
		c1 = new Chromosome(tour1);
		
		int [] tour2 = new int[] {1,4,2,3,6,5,7,8};
		c2 = new Chromosome(tour2);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testPMXKid1CutMiddle() {
		
		simulation = new Simulation(CrossoverType.PARTIALLYMAPPED, c1, c2, 2, 4);		
		simulation.start();
		
		int [] expected = new int[] {1,3,5,6,4,2,7,8};
		
		Assert.assertArrayEquals(expected, simulation.getKid1().getGenes());
		
	}
	
	@Test
	public void testPMXKid2CutMiddle() {
		
		simulation = new Simulation(CrossoverType.PARTIALLYMAPPED, c1, c2, 2, 4);		
		simulation.start();
		
		int [] expected = new int[] {1,5,2,3,6,4,8,7};
		
		Assert.assertArrayEquals(expected, simulation.getKid2().getGenes());
		
	}
	
	@Test
	public void testPMXKid1IndexEnd() {
		
		simulation = new Simulation(CrossoverType.PARTIALLYMAPPED, c1, c2, 5, 7);		
		simulation.start();
		
		int [] expected = new int[] {1,4,2,5,6,3,8,7};
		Assert.assertArrayEquals(expected, simulation.getKid1().getGenes());
		
	}
	
	@Test
	public void testPMXKid2IndexEnd() {
		
		simulation = new Simulation(CrossoverType.PARTIALLYMAPPED, c1, c2, 5, 7);		
		simulation.start();
		
		int [] expected = new int[] {1,2,3,6,4,5,7,8};
		Assert.assertArrayEquals(expected, simulation.getKid2().getGenes());
		
	}
	
	@Test
	public void testPMXKid1IndexStart() {
		
		simulation = new Simulation(CrossoverType.PARTIALLYMAPPED, c1, c2, 0, 2);		
		simulation.start();
		
		int [] expected = new int[] {1,2,5,3,6,4,7,8};
		Assert.assertArrayEquals(expected, simulation.getKid1().getGenes());
		
	}
	
	@Test
	public void testPMXKid2IndexStart() {
		
		simulation = new Simulation(CrossoverType.PARTIALLYMAPPED, c1, c2, 0, 2);		
		simulation.start();
		
		int [] expected = new int[] {1,4,2,6,5,3,8,7};
		Assert.assertArrayEquals(expected, simulation.getKid2().getGenes());		
	}


}
