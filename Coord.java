package king.jaiden.RATL;

public class Coord {
	private double x,y,z;
	public Coord(double x, double y, double z){}
	public Coord(double angle, double radius){}
	
	public Coord(double angle, double radius, boolean flat){}
	public double getX() {}
	public void setX(double x) {}
	public double getY() {}
	public void setY(double y) {}
	public double getZ() {}
	public void setZ(double z) {}
	public boolean equals(Coord c){}
	public Coord add(Coord c){}
	public Coord subtract(Coord c){}
	public double getRadius(){}
	public Coord copy(){}
	public void setXconstrained2D(double x){}
	public void setYconstrained2D(double y){}
	public void setRadiusConstrained2D(double radius){}
	public void setRadiusConstrained2DZ(double radius){}
	public double getAngle(){}
	public double getAngle2DZ(){}
	public void setAngle(double radians){}
}