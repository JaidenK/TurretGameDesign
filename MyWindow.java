public abstract class MyWindow {
	public int WINDOW_WIDTH, WINDOW_HEIGHT, tick;
	public MyWindow(){
		This assigns default width, height, fov, etc by calling another constructor
	} 
	
	public MyWindow(int w,int h, int fov, String title, boolean fullscreen, boolean matrixMode){}
	public abstract void init();
	public abstract void input();
	public void tick(){}
	public void draw(){}
	public void setup3DMatrix(){}
	public void setup2DMatrix(int w, int h){}
	public void enableTests(){}
}
