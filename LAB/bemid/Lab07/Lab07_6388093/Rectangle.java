
public class Rectangle extends Shape {
	private double length;
	private double width;
	
	public Rectangle() {
		length = 0;
		width = 0;
	}
	
	public Rectangle(String co, double le, double wi) {
		super.setColor(co);
		length = le;
		width = wi;
	}
	
	@Override
	public double getArea() {
		double area = length * width;
		return area;
	}
	
	@Override
	public String toString() {
		return "Rectangle[length=" + length + ", width="+width+","+super.toString()+"]";
	}
	
	public double getArea(double len, double wid) {
		length = len;
		width = wid;
		return getArea();
	}
}
