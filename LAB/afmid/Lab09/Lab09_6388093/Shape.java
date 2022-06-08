
abstract class Shape implements Comparable {
	public static double PI = 3.14;
	private String color;
	private String description;
	
	Shape(String _color, String _description) {
		color = _color;
		description = _description;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
//	@Override
	public String toString() {
		return description+" (color="+color+", area="+getArea()+")";
	}
	
	public int compareTo(Object shape) {
		Shape a = (Shape) shape;
		
		if( getArea() > a.getArea()) {
			return 1;
		}else {
			if(getArea() == a.getArea()) {
				return 0;
			}else {
				return -1;
			}
		}
	}
	
	public abstract double getArea() ;
	
}
