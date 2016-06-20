package bomberman;

import java.awt.Rectangle;

public class Bomba {
	private Sprite bombaSprite;
	private int potencia;
	private float tiempoExplosion;
	private Punto2D posicion; //no deberia tambien tener atributo ubicacion?
	
		
	public Bomba(int potencia, float tiempoExplosion,Punto2D ubic) {		
		posicion = new Punto2D(ubic.getX(),ubic.getY());
		this.potencia = potencia;
		this.tiempoExplosion = tiempoExplosion;
	}
	
	public void explotar(float tiempoExplocion){
		
	}
	
	public void dibujarExplosion(){
		
	}
	
	public void dibujarBomba(){
		
	}
			
	public Sprite getBombaSprite() {
		return bombaSprite;
	}
	public Rectangle getBounds(){
		return new Rectangle((int)this.posicion.getX(),(int)this.posicion.getY(),(int)this.bombaSprite.getHeight(),(int)this.bombaSprite.getWidth());
	}
}
