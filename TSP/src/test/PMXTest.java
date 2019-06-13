package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import genetic.Chromosome;
import genetic.Crossover;
import genetic.CrossoverType;
import genetic.Instance;
import genetic.Simulation;
import util.*;

public class PMXTest {
	
	private Simulation simulation;
	//private Crossover crossover;
	private Chromosome c1;
	private Chromosome c2;
	private int startIndex;
	private int endIndex;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
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
	
	
	@Before
	public void before() {
		
		
				
    }

	
	@Test
	public void testPMXKid1CutMiddle() {
	
		int [] tour1 = new int[] {1,2,5,6,4,3,8,7};
		Chromosome c1 = new Chromosome(tour1);
		
		int [] tour2 = new int[] {1,4,2,3,6,5,7,8};
		Chromosome c2 = new Chromosome(tour2);
		
		simulation = new Simulation(CrossoverType.PARTIALLYMAPPED, c1, c2, 2, 4);		
		simulation.start();
		
		int [] expected = new int[] {1,3,5,6,4,2,7,8};
		
		Assert.assertArrayEquals(expected, simulation.getKid1().getGenes());
		
	}
	
	@Test
	public void testPMXKid2CutMiddle() {
		
		int [] tour1 = new int[] {1,2,5,6,4,3,8,7};
		Chromosome c1 = new Chromosome(tour1);
		
		int [] tour2 = new int[] {1,4,2,3,6,5,7,8};
		Chromosome c2 = new Chromosome(tour2);
		
		simulation = new Simulation(CrossoverType.PARTIALLYMAPPED, c1, c2, 2, 4);		
		simulation.start();
		
		int [] expected = new int[] {1,5,2,3,6,4,8,7};
		//Printer.printArray(crossover.getKid1().getGenes());
		Assert.assertArrayEquals(expected, simulation.getKid2().getGenes());
		
	}
	
	@Test
	public void testPMXKid1IndexEnd() {
		
		int [] tour1 = {0,5,1,2,4,3};		
		int [] tour2 = {1,3,2,4,0,5};
				
		c1 = new Chromosome(tour1);
		c2 = new Chromosome(tour2);
		
		simulation = new Simulation(CrossoverType.PARTIALLYMAPPED, c1, c2, 3, 5);		
		simulation.start();
		
		int [] expected = new int[] {1,5,0,2,4,3};
		Assert.assertArrayEquals(expected, simulation.getKid1().getGenes());
		
	}
	@Test
	public void testPMXKid2IndexEnd() {
		
		int [] tour1 = {0,5,1,2,4,3};		
		int [] tour2 = {1,3,2,4,0,5};
				
		c1 = new Chromosome(tour1);
		c2 = new Chromosome(tour2);
		
		simulation = new Simulation(CrossoverType.PARTIALLYMAPPED, c1, c2, 3, 5);		
		simulation.start();
		
		int [] expected = new int[] {2,3,1,4,0,5};
		Assert.assertArrayEquals(expected, simulation.getKid2().getGenes());
		
	}
	
	@Test
	public void testPMXKid1IndexStart() {
		
		int [] tour1 = {1,3,4,5,6,0,2};		
		int [] tour2 = {4,3,2,1,6,5,0};
				
		c1 = new Chromosome(tour1);
		c2 = new Chromosome(tour2);
		
		simulation = new Simulation(CrossoverType.PARTIALLYMAPPED, c1, c2, 0, 2);		
		simulation.start();
		
		int [] expected = new int[] {1,3,4,2,6,5,0};
		Assert.assertArrayEquals(expected, simulation.getKid1().getGenes());
		
	}
	
	@Test
	public void testPMXKid2IndexStart() {
		
		int [] tour1 = {1,3,4,5,6,0,2};		
		int [] tour2 = {4,3,2,1,6,5,0};
				
		c1 = new Chromosome(tour1);
		c2 = new Chromosome(tour2);
		
		simulation = new Simulation(CrossoverType.PARTIALLYMAPPED, c1, c2, 0, 2);		
		simulation.start();
		
		int [] expected = new int[] {4,3,2,5,6,0,1};
		Assert.assertArrayEquals(expected, simulation.getKid2().getGenes());
		
	}


}
