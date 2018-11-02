package prob1;

public class Dreptunghi {
	private double width;
	private double height;
	
	public Dreptunghi(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public double Perimetru() {
		return 2*width + 2*height;
	}
	
	public double Aria() {
		return width * height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	
}
