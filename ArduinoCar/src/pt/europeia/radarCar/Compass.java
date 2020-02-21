package pt.europeia.radarCar;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Compass {																							//		|
	private int x;																								//		| DECLARAÇÃO 					
	private int y;																								//		| 	DAS
	private int sentido;																						//		| VARIAVEIS
	private int angulo = 0;																						//		|
	
	private static final Image COMPASS = new Image(Compass.class.getResource("imgs/compass.png").toString());	//		|

	// <-------------------->
	
	public int getSentido() {																					//		|
		return sentido;																							//		| GETTER 
	}																											//		| AND
	public void setSentido(int sentido) {																		//		| SETTER
		this.sentido = sentido;																					//		|
	}																											//		|
	
	// <-------------------->
	
	public Compass(int x, int y) {																				//		|	
		this.x = x;																								//		|
		this.y = y;																								//		|	CONSTRUTOR
	}																											//		|
	
	// <-------------------->
	
	public void detAngulo() {																					//		|
		switch(sentido) {																						//		|
		case 1:																									//		|
			if(angulo == 0) angulo = 270;																		//		|
			else if (angulo == 45) angulo = 315;																//		|
			else angulo -= 90;																					//		| DETERMINA O ANGULO 
			break;																								//		|
		case 2:																									//		| PARA RODAR  A 
			if (angulo == 0) angulo = 315;																		//		|
			else angulo -= 45;																					//		| BUSSOLA
			break;																								//		|
		case 3:																									//		| RECEBENDO O SENTIDO PRESSIONADO E 
			if(angulo == 315) angulo = 0;																		//		|
			else angulo +=45;																					//		| COMPARANDO COM O 
			break;																								//		| 
		case 4:																									//		|
			if(angulo == 270) angulo = 0;																		//		| ANGULO ATUAL
			else if (angulo == 315) angulo = 45;																//		|
			else angulo += 90;																					//		|
			break;																								//		|
		}																										//		|
	}																											//		|
	
	// <-------------------->
	
	public void draw(GraphicsContext gc) {																		//		|
												//		|
		gc.save();																								//		|
		gc.translate(x+COMPASS.getWidth()/2, y+COMPASS.getHeight()/2);											//		| DESENHA A BUSSOLA
		gc.rotate(angulo);																						//		|	
		gc.drawImage(COMPASS, -COMPASS.getWidth()/2,-COMPASS.getHeight()/2);									//		|
		gc.restore();																							//		|
	}										

}
