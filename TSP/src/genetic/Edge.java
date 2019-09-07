package genetic;

public class Edge {
	
	private int startVertex = -1;
	private int endVertex = -1;

	private double value = -1;
	

	public Edge(int startVertex, int endVertex, double value) {
		setStartVertex(startVertex);
		setEndVertex(endVertex);
		setValue(value);
	}

	private void setStartVertex(int startVertex) {
		if (startVertex <= 0) {
			throw new IllegalArgumentException(
					"The number of the city " + "has to be positive!");
		}
		this.startVertex = startVertex;
	}
	
	private void setEndVertex(int endVertex) {
		if (endVertex <= 0) {
			throw new IllegalArgumentException(
					"The number of the city " + "has to be positive!");
		}
		this.endVertex = endVertex;
	}
	
	private void setValue(double value) {
		if (value <= 0) {
			throw new IllegalArgumentException(
					"The distance " + "between cities has to be positive!");
		}
		this.value = value;
	}

	public int getStartVertex() {
		return startVertex;
	}

	public int getEndVertex() {
		return endVertex;
	}

	public double getValue() {
		return value;
	}
	
	

}
