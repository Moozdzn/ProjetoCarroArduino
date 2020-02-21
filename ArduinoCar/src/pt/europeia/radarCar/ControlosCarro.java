package pt.europeia.radarCar;



import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class ControlosCarro {

	private double x;																//		|
	private double y;																//		| DECLARACAO 
	private final  String [] BUTTONS;												//		| DAS
	private int i;																	//		| VARIAVEIS
	private int chosen;																//		|
	private static final double BUTTONSIZE = 50;									//		|

//  <------------------------->
	
	public ControlosCarro(double x, double y, String[] bUTTONS) {					//		|
		this.x = x;																	//		|
		this.y = y;																	//		| CONSTRUTOR
		BUTTONS = bUTTONS;															//		|
		chosen = -1; 																//		|
	}

//  <------------------------->
	
	public void setChosen(int chosen) {												//		|
		this.chosen = chosen;														//		| SETTER
	}																				//		| 
				
//  <------------------------->
	
	public void draw(GraphicsContext gc) {

		double initx = x - (3*BUTTONSIZE/2);										//		| 
		double y = this.y;															//		|
		for ( i = 0; i < BUTTONS.length; i++) {										//		| 
																					//		|
			if (i == 3 || i == 6) {													//		| DESENHA A INTERFACE DOS BOTOES
				y+=BUTTONSIZE;														//		|
				initx-=150;															//		| DE CONTROLO
			}																		//		|
			if (i == chosen) gc.setFill(Color.GREEN);								//		| DO CARRO
			else gc.setFill(Color.GRAY);											//		|
			gc.fillRect(initx,y-BUTTONSIZE/2,BUTTONSIZE,BUTTONSIZE);				//		|
			gc.setFill(Color.WHITE);												//		|
			gc.fillText(BUTTONS[i], initx+BUTTONSIZE/2, y);							//		|
			initx+=BUTTONSIZE;														//		|
		}
	}

//  <------------------------->
	
	public boolean clicked(double x, double y) {
			if (y < this.y+(BUTTONSIZE)/2 && y > this.y-(BUTTONSIZE)/2) {			//		| 
			double initx = this.x - (3*BUTTONSIZE/2);								//		| 
			for (int i = 0; i < 3; i++) {											//		| 
				if (x > initx && x < initx+BUTTONSIZE) {							//		| 
					if (i == chosen) return true;									//		| 
					chosen = i;														//		| 
					return true;													//		| 
				}																	//		| 3 CICLOS for QUE VERIFICAM
				initx+=BUTTONSIZE;													//		| 
			}																		//		| 
		}																			//		| O BOTAO QUE FOI CLICADO
		if (y < this.y+50+(BUTTONSIZE)/2 && y > this.y-50-(BUTTONSIZE)/2) {			//		| 
			double initx = this.x - (3*BUTTONSIZE/2);								//		| 
			for (int i = 3; i < 6; i++) {											//		| EM CADA for  AUMENTA SE 
				if (x > initx && x < initx+BUTTONSIZE) {							//		| 
					if (i == chosen) return true;									//		| O this.y EM 50 PARA CONTAR COM
					chosen = i;														//		| 
					return true;													//		| OS BUTOES MAIS
				}																	//		| 	
				initx+=BUTTONSIZE;													//		| EM 
			}																		//		| 
		}																			//		| BAIXO
		if (y < this.y+100+(BUTTONSIZE)/2 && y > this.y-100-(BUTTONSIZE)/2) {		//		| 
			double initx = this.x - (3*BUTTONSIZE/2);								//		| 
			for (int i = 6; i < 10; i++) {											//		| 
				if (x > initx && x < initx+BUTTONSIZE) {							//		| 
					if (i == chosen) return true;									//		| 
					chosen = i;														//		| 
					return true;													//		| 
				}																	//		| 
				initx+=BUTTONSIZE;													//		| 
			}																		//		| 
		}																			//		| 
		return false;																//		| 
	}																				//		| 
	
//  <------------------------->

	public String getChosen() {
		if (chosen < 0 || chosen >= BUTTONS.length) return null;
		return BUTTONS[chosen];
	}
}
