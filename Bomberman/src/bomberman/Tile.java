package bomberman;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

public class Tile {
	private Sprite tileSprite; 
	//private double width, height; // 32x32, 64x64 , etc	
	private boolean seRompe;
	private boolean colisionable;
	private Punto2D posicion;
	
	
	public Tile(boolean seRompe, boolean colisionable, Sprite tileSprite,int x,int y) {
		this.seRompe = seRompe;
		this.colisionable = colisionable;
		this.tileSprite = tileSprite;
		posicion =  new Punto2D(x,y);
	}

	
	public void dibujar(Graphics2D g, ImageObserver io, Punto2D pos){
		tileSprite.dibujarTile(g, io, pos);
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)posicion.getX(),(int)posicion.getY(),(int)tileSprite.getHeight(),(int)tileSprite.getWidth());
	}
	
	public boolean isColisionable() {
		return colisionable;
	}
	
	public Sprite getTileSprite() {
		return tileSprite;
	}	
		
	public boolean isSeRompe() {
		return seRompe;
	}
}
