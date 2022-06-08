
public class Hexagons extends Shape{
	private double side;
	
	public Hexagons() {
		side = 0;
	}
	
	public Hexagons(String co, double si) {
		super.setColor(co);
		side = si;
	}
	
	@Override
	public double getArea() {
		double area = (6*(side*side))/(4*Math.tan(Math.PI/6));
		return area;
	}
	
	@Override
	public String toString() {
		return "Hexagons[side=" + side +","+super.toString()+"]";
	}
	
	public double getArea(double sid) {
		side = sid;
		return getArea();
	}
}
