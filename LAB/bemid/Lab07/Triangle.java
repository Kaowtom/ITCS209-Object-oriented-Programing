
public class Triangle extends Shape{
	private double base=0;
	private double height=0;
	
	public Triangle() {
		base = 0;
		height = 0;
	}
	
	public Triangle(String co, double ba, double he) {
		super.setColor(co);
		base = ba;
		height = he;
	}
	
	@Override
	public double getArea() {
		double area = 0.5*base*height;
		return area;
	}
	
	@Override
	public String toString() {
		return "Triangle[base=" + base + ", height="+height+","+super.toString()+"]";
	}
	
	public double getArea(double bas, double hei) {
		base = bas;
		height = hei;
		return getArea();
	}
}
