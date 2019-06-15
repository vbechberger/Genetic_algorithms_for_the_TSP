package genetic;

public class Edge {

	double value;

	Edge(double value) {
		setValue(value);
	}

	void setValue(double value) {
		if (value <= 0) {
			throw new IllegalArgumentException(
					"The distance " + "							between cities has to be positive!");
		}
		this.value = value;
	}

}
