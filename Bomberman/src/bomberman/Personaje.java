package bomberman;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;


public abstract class Personaje {	
	protected Sprite personajeN;
	protected Sprite personajeS;
	protected Sprite personajeE;
	protected Sprite personajeO;
	protected Sprite personajeMuerte;
	protected byte direccion;
	protected Punto2D posicion;
	protected float velocidad; 
	
	public Personaje(Punto2D posicion) {
		this.posicion = posicion;
		this.direccion = Protocolo.ESTE;
		this.velocidad = 1f;
	}
	
	public abstract void atacar();
	
	public void setPosicion(Punto2D posicion) {
		this.posicion = posicion;
	}
	
	public Punto2D getPosicion() {
		return posicion;
	}
	
	public synchronized void playAnimation(){
		switch(direccion){
		case Protocolo.NORTE:
			personajeN.setLooping(true);
			break;
		case Protocolo.SUR:
			personajeS.setLooping(true);
			break;
		case Protocolo.ESTE:
			personajeE.setLooping(true);
			break;
		case Protocolo.OESTE:
			personajeO.setLooping(true);
			break;
		}
	}
	
	public synchronized void stopAnimating(){
		switch(direccion){
		case Protocolo.NORTE:
			personajeN.setLooping(false);
			break;
		case Protocolo.SUR:
			personajeS.setLooping(false);
			break;
		case Protocolo.ESTE:
			personajeE.setLooping(false);
			break;
		case Protocolo.OESTE:
			personajeO.setLooping(false);
			break;
		}
	}
	
	public void dibujar(Graphics2D g ,ImageObserver io){
		switch(direccion){
			case Protocolo.NORTE:
				personajeN.dibujar(g, io, posicion);
				break;
			case Protocolo.SUR:
				personajeS.dibujar(g, io, posicion);
				break;
			case Protocolo.ESTE:
				personajeE.dibujar(g, io, posicion);
				break;
			case Protocolo.OESTE:
				personajeO.dibujar(g, io, posicion);
				break;
		}
	}
	
	public synchronized void mover(int direccion){ // norte sur este oeste
		switch(direccion){
			case Protocolo.NORTE: //cambiar por protocolo.norte
				if(limiteNorte())
					posicion = new Punto2D(posicion.getX(), this.posicion.getY() - (1*velocidad));
				break;
			case Protocolo.SUR: //cambiar por protocolo.sur
				if(!limiteSur())
					posicion = new Punto2D(posicion.getX(), this.posicion.getY() + (1*velocidad));
				break;
			case Protocolo.ESTE: //cambiar por protocolo.este
				if(!limiteEste())
					posicion = new Punto2D(posicion.getX() + (1*velocidad), posicion.getY());
				break;
			case Protocolo.OESTE: //cambiar por protocolo.oeste
				if(!limiteOeste())
					posicion = new Punto2D(posicion.getX() - (1*velocidad), posicion.getY());
				break;
		}		
	}
	
	public float getVelocidad() {
		return velocidad;
	}
	
	public void setVelocidad(float velocidad) {
		this.velocidad = velocidad;
	}
	public Rectangle getBounds(){
		return new Rectangle((int)posicion.getX(),(int)posicion.getY(),(int)personajeN.getHeight(),(int)personajeN.getWidth());
	}
	public boolean limiteNorte(){
		return (posicion.getY() - 1*velocidad) >= 0;
	}
	public boolean limiteOeste(){
		return (posicion.getX() - 1*velocidad) <= 0;
	}
	public boolean limiteSur(){
		return (posicion.getY() - 1*velocidad) >= 100;//puse eso para testear cuando funque va lo de abajo
		//return (posicion.getY() - 1*velocidad) >= Mundo.getInstance().getMap().getSizeY();
	}
	public boolean limiteEste(){
		return (posicion.getX() - 1*velocidad) >= 100; //puse eso para testear cuando funque va lo de abajo
		//return (posicion.getX() - 1*velocidad) >= Mundo.getInstance().getMap().getSizeX();
	}

	public boolean colision() {
		for(Tile tile: Mundo.getInstance().getTiles())
			if(getBounds().intersects(tile.getBounds()))
				return true;
		return false;
	}
}
