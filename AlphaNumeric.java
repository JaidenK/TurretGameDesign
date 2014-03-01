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
	public AlphaNumeric() throws FileNotFoundException, IOException{
		tex = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/images/alpha.png")));
		tex2 = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/images/alpha2.png")));
		/*
		 * A note about the alpha.png image:
		 * there are 8 rows and columns, meaning the space for one character
		 * is 0.125, or 12.5%.
		 */
	}
	/**
	 * Draws onscreen a specified character at the specified coordinates.  The
	 * coordinates given will be the bottom left of the character.
	 * @param ch The character to draw
	 * @param posX The x coordinate
	 * @param posY The y coordinate
	 * @param posZ The z coordinate
	 * @param width The width of the character
	 * @param height The height of the character
	 */
	public void write(char ch, double posX, double posY, double posZ, double width, double height){
		boolean upperCase = false;		
		if(!Character.isLetter(ch)||Character.isUpperCase(ch))
				upperCase = true;
		ch = Character.toLowerCase(ch);
		float texCoordX = getTexCoordX(ch);
		float texCoordY = getTexCoordY(ch);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
		if(upperCase){
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, tex.getTextureID());
		}else{
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, tex2.getTextureID());
		}
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(texCoordX, texCoordY); 
			GL11.glVertex2d(posX,posY+height);
			GL11.glTexCoord2f(texCoordX+charSpace, texCoordY); 
			GL11.glVertex2d(posX+width,posY+height);
			GL11.glTexCoord2f(texCoordX+charSpace, texCoordY+charSpace);
			GL11.glVertex2d(posX+width,posY);
			GL11.glTexCoord2f(texCoordX, texCoordY+charSpace); 
			GL11.glVertex2d(posX,posY);
		GL11.glEnd();	
	}
	/**
	 * Draws onscreen a specified string at the specified coordinates.  The
	 * coordinates given will be the bottom left of the string.
	 * @param str The string to draw
	 * @param posX The x coordinate
	 * @param posY The y coordinate
	 * @param posZ The z coordinate
	 * @param width The width of each character
	 * @param height The height of each character
	 */
	public void write(String str, double posX, double posY, double posZ, double width, double height){
		for(int i = 0; i<str.length(); i++){
			double c = i * width;
			write(str.charAt(i),posX+c,posY,posZ,width,height);
		}
	}
	/**
	 * Draws onscreen a specified string with the specified coordinates being the bottom right of the String.
	 * @param str The string to draw
	 * @param posX The x coordinate
	 * @param posY The y coordinate
	 * @param posZ The z coordinate
	 * @param width The width of each character
	 * @param height The height of each character
	 */
	public void rightAlign(String str, double posX, double posY, double posZ, double width, double height){
		int n = 0;
		for(int i = str.length(); i > 0; i--){
			double c = i * width;
			write(str.charAt(n),posX-c,posY,posZ,width,height);
			n++;
		}
	}
	
	private float getTexCoordX(char ch){
		switch(ch){
		case 'a':
			return getFractionFromRowNum(0);
		case 'b':
			return getFractionFromRowNum(1);
		case 'c':
			return getFractionFromRowNum(2);
		case 'd':
			return getFractionFromRowNum(3);
		case 'e':
			return getFractionFromRowNum(4);
		case 'f':
			return getFractionFromRowNum(5);
		case 'g':
			return getFractionFromRowNum(6);
		case 'h':
			return getFractionFromRowNum(7);
		case 'i':
			return getFractionFromRowNum(0);
		case 'j':
			return getFractionFromRowNum(1);
		case 'k':
			return getFractionFromRowNum(2);
		case 'l':
			return getFractionFromRowNum(3);
		case 'm':
			return getFractionFromRowNum(4);
		case 'n':
			return getFractionFromRowNum(5);
		case 'o':
			return getFractionFromRowNum(6);
		case 'p':
			return getFractionFromRowNum(7);
		case 'q':
			return getFractionFromRowNum(0);
		case 'r':
			return getFractionFromRowNum(1);
		case 's':
			return getFractionFromRowNum(2);
		case 't':
			return getFractionFromRowNum(3);
		case 'u':
			return getFractionFromRowNum(4);
		case 'v':
			return getFractionFromRowNum(5);
		case 'w':
			return getFractionFromRowNum(6);
		case 'x':
			return getFractionFromRowNum(7);
		case 'y':
			return getFractionFromRowNum(0);
		case 'z':
			return getFractionFromRowNum(1);
		case '0':
			return getFractionFromRowNum(2);
		case '1':
			return getFractionFromRowNum(3);
		case '2':
			return getFractionFromRowNum(4);
		case '3':
			return getFractionFromRowNum(5);
		case '4':
			return getFractionFromRowNum(6);
		case '5':
			return getFractionFromRowNum(7);
		case '6':
			return getFractionFromRowNum(0);
		case '7':
			return getFractionFromRowNum(1);
		case '8':
			return getFractionFromRowNum(2);
		case '9':
			return getFractionFromRowNum(3);
		case '?':
			return getFractionFromRowNum(4);
		case '!':
			return getFractionFromRowNum(5);
		case ' ':
			return getFractionFromRowNum(6);
		case '(':
			return getFractionFromRowNum(7);
		case ')':
			return getFractionFromRowNum(0);
		case '.':
			return getFractionFromRowNum(1);
		case ':':
			return getFractionFromRowNum(2);
		default:
			return getFractionFromRowNum(7);
		}
	}
	
	private float getTexCoordY(char ch){
		switch(ch){
		case 'a':
			return getFractionFromRowNum(0);
		case 'b':
			return getFractionFromRowNum(0);
		case 'c':
			return getFractionFromRowNum(0);
		case 'd':
			return getFractionFromRowNum(0);
		case 'e':
			return getFractionFromRowNum(0);
		case 'f':
			return getFractionFromRowNum(0);
		case 'g':
			return getFractionFromRowNum(0);
		case 'h':
			return getFractionFromRowNum(0);
		case 'i':
			return getFractionFromRowNum(1);
		case 'j':
			return getFractionFromRowNum(1);
		case 'k':
			return getFractionFromRowNum(1);
		case 'l':
			return getFractionFromRowNum(1);
		case 'm':
			return getFractionFromRowNum(1);
		case 'n':
			return getFractionFromRowNum(1);
		case 'o':
			return getFractionFromRowNum(1);
		case 'p':
			return getFractionFromRowNum(1);
		case 'q':
			return getFractionFromRowNum(2);
		case 'r':
			return getFractionFromRowNum(2);
		case 's':
			return getFractionFromRowNum(2);
		case 't':
			return getFractionFromRowNum(2);
		case 'u':
			return getFractionFromRowNum(2);
		case 'v':
			return getFractionFromRowNum(2);
		case 'w':
			return getFractionFromRowNum(2);
		case 'x':
			return getFractionFromRowNum(2);
		case 'y':
			return getFractionFromRowNum(3);
		case 'z':
			return getFractionFromRowNum(3);
		case '0':
			return getFractionFromRowNum(3);
		case '1':
			return getFractionFromRowNum(3);
		case '2':
			return getFractionFromRowNum(3);
		case '3':
			return getFractionFromRowNum(3);
		case '4':
			return getFractionFromRowNum(3);
		case '5':
			return getFractionFromRowNum(3);
		case '6':
			return getFractionFromRowNum(4);
		case '7':
			return getFractionFromRowNum(4);
		case '8':
			return getFractionFromRowNum(4);
		case '9':
			return getFractionFromRowNum(4);
		case '?':
			return getFractionFromRowNum(4);
		case '!':
			return getFractionFromRowNum(4);
		case ' ':
			return getFractionFromRowNum(4);
		case '(':
			return getFractionFromRowNum(4);
		case ')':
			return getFractionFromRowNum(5);
		case '.':
			return getFractionFromRowNum(5);
		case ':':
			return getFractionFromRowNum(5);
		default:
			return getFractionFromRowNum(7);
		}
	}
	
	private float getFractionFromRowNum(int i){
		return i * charSpace;
	}
	
}
