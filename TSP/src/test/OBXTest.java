package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import genetic.*;

import util.*;

public class OBXTest {
	
	private Simulation simulation;
	//private Crossover crossover;
	private Chromosome c1;
	private Chromosome c2;
	private ArrayList<Integer> indices = new ArrayList<Integer>();
	
	
	

	@Test
	public void testOBXKid1() {
		
		int [] tour1 = new int[] {1,2,5,6,4,3,8,7};
		c1 = new Chromosome(tour1);
		
		int [] tour2 = new int[] {1,4,2,3,6,5,7,8};
		c2 = new Chromosome(tour2);
		
		indices.add(2);
		indices.add(4);
		indices.add(5);
		
		simulation = new Simulation(CrossoverType.ORDERBASED, c1, c2, indices);
		simulation.start();
		
		int [] expected = new int[] {1,5,2,4,6,3,7,8};
		Printer.printArray(simulation.getKid1().getGenes());
		Assert.assertArrayEquals(expected, simulation.getKid1().getGenes());
		
	}
	
	@Test
	public void testOBXKid2() {
		
		int [] tour1 = new int[] {1,2,5,6,4,3,8,7};
		c1 = new Chromosome(tour1);
		
		int [] tour2 = new int[] {1,4,2,3,6,5,7,8};
		c2 = new Chromosome(tour2);
		
		indices.add(2);
		indices.add(4);
		indices.add(5);
		
		simulation = new Simulation(CrossoverType.ORDERBASED, c1, c2, indices);
		simulation.start();
		
		int [] expected = new int[] {1,2,6,5,4,3,8,7};
		Printer.printArray(simulation.getKid2().getGenes());
		Assert.assertArrayEquals(expected, simulation.getKid2().getGenes());
		
	}

}
