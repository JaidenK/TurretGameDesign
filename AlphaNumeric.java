package king.jaiden.RATL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class AlphaNumeric {
	private Texture tex, tex2;
	private float charSpace = 0.125f;  // This is the fraction of the texture that represents one character.
	
	// Initialize the instance variables and such
	public AlphaNumeric() throws FileNotFoundException, IOException{}
	public void write(char ch, double posX, double posY, double posZ, double width, double height){}
	public void write(String str, double posX, double posY, double posZ, double width, double height){}
	public void rightAlign(String str, double posX, double posY, double posZ, double width, double height){}
	private float getTexCoordX(char ch){}
	private float getTexCoordY(char ch){}
	private float getFractionFromRowNum(int i){}
	
}
