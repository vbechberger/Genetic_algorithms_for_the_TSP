package test.crossover;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import genetic.Chromosome;
import genetic.crossover.Crossover;
import genetic.crossover.CrossoverPMX;

public class PMXTest {
	
	private Crossover crossover;
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
		
		crossover = new CrossoverPMX(c1, c2, 2, 4);		
		crossover.start();
		
		int [] expected = new int[] {1,3,5,6,4,2,7,8};
		
		Assert.assertArrayEquals(expected, crossover.getKid1().getGenes());
		
	}
	
	@Test
	public void testPMXKid2CutMiddle() {
		
		crossover = new CrossoverPMX(c1, c2, 2, 4);		
		crossover.start();
		
		int [] expected = new int[] {1,5,2,3,6,4,8,7};
		
		Assert.assertArrayEquals(expected, crossover.getKid2().getGenes());
		
	}
	
	@Test
	public void testPMXKid1IndexEnd() {
		
		crossover = new CrossoverPMX(c1, c2, 5, 7);		
		crossover.start();
		
		int [] expected = new int[] {1,4,2,5,6,3,8,7};
		Assert.assertArrayEquals(expected, crossover.getKid1().getGenes());
		
	}
	
	@Test
	public void testPMXKid2IndexEnd() {
		
		crossover = new CrossoverPMX(c1, c2, 5, 7);		
		crossover.start();
		
		int [] expected = new int[] {1,2,3,6,4,5,7,8};
		Assert.assertArrayEquals(expected, crossover.getKid2().getGenes());
		
	}
	
	@Test
	public void testPMXKid1IndexStart() {
		
		crossover = new CrossoverPMX(c1, c2, 0, 2);		
		crossover.start();
		
		int [] expected = new int[] {1,2,5,3,6,4,7,8};
		Assert.assertArrayEquals(expected, crossover.getKid1().getGenes());
		
	}
	
	@Test
	public void testPMXKid2IndexStart() {
		
		crossover = new CrossoverPMX(c1, c2, 0, 2);		
		crossover.start();
		
		int [] expected = new int[] {1,4,2,6,5,3,8,7};
		Assert.assertArrayEquals(expected, crossover.getKid2().getGenes());		
	}
	
	
	@Test
	public void testPMXKid1MultReplacement() {
		
		Chromosome c1 = new Chromosome(new int[] {0,5,1,2,4,3});
		Chromosome c2 = new Chromosome(new int[] {1,2,5,4,3,0});
		
		
		crossover = new CrossoverPMX(c1, c2, 1, 3);		
		crossover.start();
		
		int [] expected = new int[] {4,5,1,2,3,0};
		Assert.assertArrayEquals(expected, crossover.getKid1().getGenes());
		
	}
	
	@Test
	public void testPMXKid2MultReplacement() {
		
		Chromosome c1 = new Chromosome(new int[] {0,5,1,2,4,3});
		Chromosome c2 = new Chromosome(new int[] {1,2,5,4,3,0});
		
		
		crossover = new CrossoverPMX(c1, c2, 1, 3);		
		crossover.start();
		
		int [] expected = new int[] {0,2,5,4,1,3};
		Assert.assertArrayEquals(expected, crossover.getKid2().getGenes());
		
	}

}
