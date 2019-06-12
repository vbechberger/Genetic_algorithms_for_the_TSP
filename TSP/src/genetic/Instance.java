package genetic;

import java.util.ArrayList;
import java.util.Collections;

import util.SaveCopy;

public class Instance {
	
	private int size = -1;

	private ArrayList<Integer> tour = new ArrayList<Integer>();
	
	public Instance() {
		tour.add(0);
		tour.add(5);
		tour.add(1);
		tour.add(2);
		tour.add(4);
		tour.add(3);
		this.size = tour.size();
	}
	
	public Instance(ArrayList<Integer> tour) {
		SaveCopy.copy(this.tour, tour);
		this.size = tour.size();
		if (!isValid()) {
			throw new IllegalStateException("The instance is not valid!");
		}
	}
	
	public Instance(int[] tour) {
		SaveCopy.copy(this.tour, tour);
		this.size = tour.length;
		if (!isValid()) {
			throw new IllegalStateException("The instance is not valid!");
		}
	}
	
	public Instance(Chromosome chromosome) {
		SaveCopy.copy(tour, chromosome.getGenes());
		this.size = tour.size();
		if (!isValid()) {
			throw new IllegalStateException("The instance is not valid!");
		}
	}
	
	
	public boolean isValid() {
		if(size <= 0) {
			throw new IllegalStateException("The instance is not valid! The size is <= 0");
		} 
		if(tour.size() != size) {
			throw new IllegalStateException("The instance is not valid! The size is inconsistent");
		}
		/*if a city in the tour is missed*/
		ArrayList<Integer> tempTour = new ArrayList<Integer>();
		
		for(int i = 0; i < tour.size(); i++) {
			tempTour.add(tour.get(i));
		}
		Collections.sort(tempTour);
		
		for(int i = 0; i < tempTour.size(); i++) {
			if (tempTour.get(i) != i) {
				throw new IllegalStateException("The city " + i + " is missed!");
			}
		}
		tempTour = null;
		
		System.out.println("The instance is valid!");
		return true;
		
	}
	
	
	public void print() {
		for(int i = 0; i < size; i++) {
			System.out.print(tour.get(i) + " ");
		}	
		System.out.println();
	}


	public int getSize() {
		return size;
	}



	public ArrayList<Integer> getTour() {
		return tour;
	}

	
	
}
