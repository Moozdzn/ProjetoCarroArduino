package pt.europeia.radarCar;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class ControlosSensor {

	private double x;																//		|
	private double y;																//		|
	private final  String [] BUTTONS;												//		| CONSTRUTOR
	private int chosen;																//		|
	private static final double BUTTONSIZE = 50;									//		|
	
	// <-------------------->
	
	public ControlosSensor(double x, double y, String[] bUTTONS) {
		super();																	//		|
		this.x = x;																	//		|
		this.y = y;																	//		| CONSTRUTOR
		BUTTONS = bUTTONS;															//		|
		chosen = -1; 																//		|
	}
	
	// <-------------------->
	
	public void setChosen(int chosen) {												//		|
		this.chosen = chosen;														//		| SETTER
	}																				//		|
	
	// <-------------------->
	
	public void draw(GraphicsContext gc) {
		
		double initx = x - (BUTTONS.length*BUTTONSIZE/2);							//		|
		for (int i = 0; i < BUTTONS.length; i++) {									//		|
			if (i == chosen) gc.setFill(Color.GREEN);								//		| DESENHA OS BUTOES QUE
			else gc.setFill(Color.GRAY);											//		|
																					//		| DETERMINAM
			gc.fillRect(initx,y-BUTTONSIZE/2,BUTTONSIZE,BUTTONSIZE);				//		|
			gc.setFill(Color.WHITE);												//		| A DISTANCIA MAXIMA DO SENSOR
			gc.fillText(BUTTONS[i], initx+BUTTONSIZE/2, y);							//		|
			initx+=BUTTONSIZE;														//		|
		}
	}
	
	// <-------------------->
	
	public boolean clicked(double x, double y) {
		if (y < this.y+BUTTONSIZE/2 && y > this.y-BUTTONSIZE/2) {					//		|
			double initx = this.x - (BUTTONS.length*BUTTONSIZE/2);					//		|
			for (int i = 0; i < BUTTONS.length; i++) {								//		|
				if (x > initx && x < initx+BUTTONSIZE) {							//		| DETERMINA O BOTAO QUE FOI CLICADO
					if (i == chosen) return true;									//		|
					chosen = i;														//		|
					return true;													//		|
				}																	//		|
				initx+=BUTTONSIZE;													//		|
			}																		//		|
		}																			//		|
		return false;																//		|
	}																				//		|
	
	// <-------------------->
	
	public String getChosen() {
		if (chosen < 0 || chosen >= BUTTONS.length) return null;
		return BUTTONS[chosen];
	}
	
}
