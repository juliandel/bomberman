package bomberman;

import java.awt.Rectangle;

public class Enemigo extends Personaje {

	public Enemigo(Punto2D posicion) {
		super(posicion);
	}
	
	@Override
	public void atacar() {
		// TODO Auto-generated method stub
		
	}
	
	public void mover(){
		//ver para donde se mueve, esquivar bombas, seguir personaje (AI)
		super.mover(0); //mover alguna direccion
	}

	@Override
	public boolean colision() {
		return getBounds().intersects(this.getBounds());
	}
}
