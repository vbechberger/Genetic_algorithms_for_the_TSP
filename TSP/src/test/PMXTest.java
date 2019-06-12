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
import util.*;

public class PMXTest {
	
	private Crossover crossover;
	private Chromosome c1;
	private Chromosome c2;
	private static int cutStartAt;
	private static int cutEndAt;
	
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
	public void testIsValid() {
		
		//t1.isValid();
		//t1.print();
		//Test 1: if the size does not correspond to the real size of array
		//t.tour.remove(0);
		//t.isValid();
		
		//Test 2: if the size <= 0
		//t.size = -10;
		//t.isValid();

		//Test 3: if a city is missed
		//t.tour.set(0, 10);
		//t.isValid();
		//t.print();
		//
	}
	
	@Test
	public void testPMXKid1CutMiddle() {
		cutStartAt = 2;
		cutEndAt = 4;
		int [] tour1 = new int[] {1,2,5,6,4,3,8,7};
		Chromosome c1 = new Chromosome(tour1);
		
		int [] tour2 = new int[] {1,4,2,3,6,5,7,8};
		Chromosome c2 = new Chromosome(tour2);
		
		crossover = new Crossover(CrossoverType.PARTIALLYMAPPED, c1, c2, cutStartAt, cutEndAt);
		crossover.start();
		
		int [] expected = new int[] {1,3,5,6,4,2,7,8};
		//Printer.printArray(crossover.getKid1().getGenes());
		Assert.assertArrayEquals(expected, crossover.getKid1().getGenes());
		
	}
	
	@Test
	public void testPMXKid2CutMiddle() {
		cutStartAt = 2;
		cutEndAt = 4;
		int [] tour1 = new int[] {1,2,5,6,4,3,8,7};
		Chromosome c1 = new Chromosome(tour1);
		
		int [] tour2 = new int[] {1,4,2,3,6,5,7,8};
		Chromosome c2 = new Chromosome(tour2);
		
		crossover = new Crossover(CrossoverType.PARTIALLYMAPPED, c1, c2, cutStartAt, cutEndAt);
		crossover.start();
		
		int [] expected = new int[] {1,5,2,3,6,4,8,7};
		//Printer.printArray(crossover.getKid1().getGenes());
		Assert.assertArrayEquals(expected, crossover.getKid2().getGenes());
		
	}
	
	@Test
	public void testPMXKid1IndexEnd() {
		cutStartAt = 3;
		cutEndAt = 5;
		
		int [] tour1 = {0,5,1,2,4,3};		
		int [] tour2 = {1,3,2,4,0,5};
				
		c1 = new Chromosome(tour1);
		c2 = new Chromosome(tour2);
		
		crossover = new Crossover(CrossoverType.PARTIALLYMAPPED, c1, c2, cutStartAt, cutEndAt);
		crossover.start();
		
		int [] expected = new int[] {1,5,0,2,4,3};
		Assert.assertArrayEquals(expected, crossover.getKid1().getGenes());
		
	}
	@Test
	public void testPMXKid2IndexEnd() {
		cutStartAt = 3;
		cutEndAt = 5;
		
		int [] tour1 = {0,5,1,2,4,3};		
		int [] tour2 = {1,3,2,4,0,5};
				
		c1 = new Chromosome(tour1);
		c2 = new Chromosome(tour2);
		
		crossover = new Crossover(CrossoverType.PARTIALLYMAPPED, c1, c2, cutStartAt, cutEndAt);
		crossover.start();
		
		int [] expected = new int[] {2,3,1,4,0,5};
		Assert.assertArrayEquals(expected, crossover.getKid2().getGenes());
		
	}
	
	@Test
	public void testPMXKid1IndexStart() {
		cutStartAt = 0;
		cutEndAt = 2;
		
		int [] tour1 = {1,3,4,5,6,0,2};		
		int [] tour2 = {4,3,2,1,6,5,0};
				
		c1 = new Chromosome(tour1);
		c2 = new Chromosome(tour2);
		
		crossover = new Crossover(CrossoverType.PARTIALLYMAPPED, c1, c2, cutStartAt, cutEndAt);
		crossover.start();
		
		int [] expected = new int[] {1,3,4,2,6,5,0};
		Assert.assertArrayEquals(expected, crossover.getKid1().getGenes());
		
	}
	
	@Test
	public void testPMXKid2IndexStart() {
		cutStartAt = 0;
		cutEndAt = 2;
		
		int [] tour1 = {1,3,4,5,6,0,2};		
		int [] tour2 = {4,3,2,1,6,5,0};
				
		c1 = new Chromosome(tour1);
		c2 = new Chromosome(tour2);
		
		crossover = new Crossover(CrossoverType.PARTIALLYMAPPED, c1, c2, cutStartAt, cutEndAt);
		crossover.start();
		
		int [] expected = new int[] {4,3,2,5,6,0,1};
		Assert.assertArrayEquals(expected, crossover.getKid2().getGenes());
		
	}


}
