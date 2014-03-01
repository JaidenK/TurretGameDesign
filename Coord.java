package king.jaiden.RATL;

public class Coord {
	private double x,y,z;

	/**
	 * Creates a new Coord Object
	 * @param x X Coordinate
	 * @param y Y Coordinate
	 * @param z Z Coordinate
	 */
	public Coord(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	/**
	 * Creates a new Coord Object with a z of 0.
	 * @param angle degrees from the positive x axis.
	 * @param radius distance from origin.
	 */
	public Coord(double angle, double radius){
		z = 0;
		y = Math.sin(Math.toRadians(angle)) * radius;
		x = Math.cos(Math.toRadians(angle)) * radius;
	}
	
	public Coord(double angle, double radius, boolean flat){
		z = Math.sin(Math.toRadians(angle)) * radius;
		y = 0;
		x = Math.cos(Math.toRadians(angle)) * radius;
	}
	
	/**
	 * Returns X coordinate
	 * @return X coordinate
	 */
	public double getX() {
		return x;
	}
	/**
	 * Sets the X coordinate
	 * @param x The new X coordinate
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Returns Y coordinate
	 * @return Y coordinate
	 */
	public double getY() {
		return y;
	}
	/**
	 * Sets the Y coordinate
	 * @param y The new Y coordinate
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * Returns Z coordinate
	 * @return Z coordinate
	 */
	public double getZ() {
		return z;
	}
	/**
	 * Sets the Z coordinate
	 * @param z The new Z coordinate
	 */
	public void setZ(double z) {
		this.z = z;
	}
	/**
	 * Compares the Coord with the given Coord
	 * @param c
	 * @return True if both Coords have equal coordinates
	 */
	public boolean equals(Coord c){
		if(c.getX()==x&&c.getY()==y&&c.getZ()==z)
			return true;
		else
			return false;
	}
	/**
	 * Adds the given Coord's coordinates to this Coord's coordinates
	 * @param c
	 * @return Returns itself.
	 */
	public Coord add(Coord c){
		x += c.getX();
		y += c.getY();
		z += c.getZ();
		return this;
	}
	/**
	 * Subtracs the given Coord's coordinates from this Coord's coordinates
	 * @param c
	 * @return Returns itself.
	 */
	public Coord subtract(Coord c){
		x -= c.getX();
		y -= c.getY();
		z -= c.getZ();
		return this;
	}
	/**
	 * Calculates the radius of the Coord.
	 * @return Radius from the origin as a positive number.
	 */
	public double getRadius(){
		return Math.sqrt(Math.pow(x,2)+Math.pow(y,2)+Math.pow(z,2));
	}
	
	/**
	 * Copies this Coord
	 * @return A Coord with the same coordinates
	 */
	public Coord copy(){
		return new Coord(x,y,z);
	}
	/**
	 * Sets the x coordinate to the specified value while keeping the ratio of x:y consistent.
	 * Ignores the z coordinate.
	 * @param x New x coordinate
	 */
	public void setXconstrained2D(double x){
		double b = y / this.x;
		this.x = x;
		y = b*x;
	}

	/**
	 * Sets the y coordinate to the specified value while keeping the ratio of x:y consistent.
	 * Ignores the z coordinate.
	 * @param y New y coordinate
	 */
	public void setYconstrained2D(double y){
		double b = this.y / this.x;
		this.y = y;
		x = b*y;
	}
	
	/**
	 * Sets the radius to the specified value while keeping the ratio of x:y consistent.
	 * Ignores the z coordinate.
	 * @param radius The new radius.
	 */
	public void setRadiusConstrained2D(double radius){
		double theta = Math.atan(y/x);
		if(x<0){
			theta+=Math.PI;
		}
		x = Math.cos(theta)*radius;
		y = Math.sin(theta)*radius;
	}

	/**
	 * Sets the radius to the specified value while keeping the ratio of x:z consistent.
	 * Ignores the y coordinate.
	 * @param radius The new radius.
	 */
	public void setRadiusConstrained2DZ(double radius){
		double theta = Math.atan(z/x);
		if(x<0){
			theta+=Math.PI;
		}
		x = Math.cos(theta)*radius;
		z = Math.sin(theta)*radius;
	}
	
	/**
	 * Returns the angle in radians of this vector (2D).
	 * @return The angle in radians.
	 */
	public double getAngle(){
		double a = Math.atan(y/x);
		if(x<0)
			a += Math.PI;
		return a;
	}
	/**
	 * Returns the angle in radians of this vector (2DZ).
	 * @return The angle in radians.
	 */
	public double getAngle2DZ(){
		double a = Math.atan(z/x);
		if(x<0)
			a += Math.PI;
		return a;
	}
	/**
	 * Sets the angle of this vector, keeping the radius constant. 2DZ
	 * @param radians the new angle, in radians.
	 */
	public void setAngle(double radians){
		double r = getRadius();
		x = Math.cos(radians) * r;
		z = Math.sin(radians) * r;
	}
}