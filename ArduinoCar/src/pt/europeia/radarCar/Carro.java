package pt.europeia.radarCar;

import javafx.scene.canvas.GraphicsContext;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;




public class Carro {													//			|
	private int velX;													//			|
																		//			|
	private int x = 350;												//			| DECLARAÇAO
	private int y = 300;												//			|
	private double sens1;												//			| DE
	private double sens2;												//			|
	private int lim;													//			|
	private boolean canMoveSens1 = true;								//	        | VARIAVEIS
	private boolean canMoveSens2 = true;								//			|
	private boolean reverse = false;									//			|
	private int velocidadeX = 0;										//			|																	
//	private int sentido;												//			|
//	private int angulo = 0;												//			| VARIAVEIS PARA RODAR O CARRO

	
	private static final Image CARIMAGE = new Image(Carro.class.getResource("imgs/car.png").toString());
	
	
	
	
	
	// <-------------------->
	
	public Carro(int movx, int movy, int lim) {							//			|
		this.velX = this.velX + movx;									//			| CONSTRUTOR
		this.sens1 = 100;												//			|
		this.sens2 = 100;												//			|	
		this.lim = lim;													//			|
		this.canMoveSens1 = true;										//			|
		this.canMoveSens2 = true;										//			|
	}
	// <-------------------->
	public void setSens1(double sens1) {								// 			|
		this.sens1 = sens1;												//			|
	}																	//			| GETTERS
	public double getSens1() {											//			|
		return sens1;													//			|
	}																	//			|
	// <-------------------->
	public void setSens2(double sens2) {								// 			| 
		this.sens1 = sens2;												//			|
	}																	//			|
	public double getSens2() {											//			|
		return sens1;													//			|
	}																	//			|
	// <-------------------->
	public void setLimit(int lim) {										//			|
		this.lim = lim;													//			|
	}																	//			|
	// <-------------------->
	public void setVelX(int movx) {										//			|
		this.velX = movx;												//			|
	}																	//			|	
	// <-------------------->
	public boolean getCanMoveSens1() {									//			| AND
		return canMoveSens1;											//			|
	}																	//			|
	public void setCanMoveSens1(boolean canMoveSens1) {					//			|
		this.canMoveSens1 = canMoveSens1;								//			|
	}																	//			|
	// <-------------------->
	public boolean getCanMoveSens2() {									//			|
		return canMoveSens2;											//			|
	}																	//			|
	public void setCanMoveSens2(boolean canMoveSens2) {					//			|
		this.canMoveSens2 = canMoveSens2;								//			|
	}																	//			|
	// <-------------------->
	public boolean isReverse() {										//			|
		return reverse;													//			|	
	}																	//			|
	public void setReverse(boolean reverse) {							//			|
		this.reverse = reverse;											//			|
	}																	// 			| SETTERS
	// <-------------------->
	/*public int getSentido() {																					//		|
		return sentido;																							//		|
	}																											//		|
	public void setSentido(int sentido) {																		//		|
		this.sentido = sentido;																					//		|
	}*/
	// <-------------------->
	
	/*public void detAngulo() {																					//		|
		switch(sentido) {																						//		|
		case 1:																									//		|
			if(angulo == 0) angulo = 270;																		//		|
			else if (angulo == 45) angulo = 315;																//		|
			else angulo -= 90;																					//		| DETERMINA O ANGULO PARA RODAR O CARRO
			break;																								//		|
		case 2:																									//		| 
			if (angulo == 0) angulo = 315;																		//		|
			else angulo -= 45;																					//		|
			break;																								//		|
		case 3:																									//		|
			if(angulo == 315) angulo = 0;																		//		|
			else angulo +=45;																					//		|
			break;																								//		|
		case 4:																									//		|
			if(angulo == 270) angulo = 0;																		//		|
			else if (angulo == 315) angulo = 45;																//		|
			else angulo += 90;																					//		|
			break;																								//		|
		}																										//		|
	}*/
	
	
	public void draw(GraphicsContext gc) {
			
																		//			| VELOCIDADE DO CARRO NO EIXO X --> SOMA AO SPAWN POINTx PARA SE MOVER
		gc.setFill(Color.GRAY);											//			|
		gc.fillRect(600, 0, 50 , 50);									//			|
		gc.fillRect(600, 50, 50 , 50);									//			|
		gc.fillRect(550, 0, 50 , 50);									//			| DESENHO DA INTERFACE DOS DOS SENSORES
		gc.fillRect(550, 50, 50 , 50);									//			|
		gc.setFill(Color.WHITE);										//			|
		gc.fillText("Sensor 1", 575, 25);								//			|
		gc.fillText("Sensor 2", 575, 75);								//			|
		
		// <-------------------->
		
		
		velocidadeX = velocidadeX + this.velX;
		/*
		gc.save();																															//		  |
		gc.translate(CARIMAGE.getWidth()/2+x, y+CARIMAGE.getHeight()/2);																	//		  | COMENTADO PORQUE NAO FOI POSSIVEL 
		gc.rotate(angulo);																													//		  |	POR A FUNCIONAR, ERA SUPOSTO O CARRO RODAR SOBRE SI NO MESMO ANGULO QUE A BUSSOLA
		gc.drawImage(CARIMAGE, -(CARIMAGE.getWidth()/2)+velocidadeX,-CARIMAGE.getHeight()/2);												//		  | MAS TEM UM PROBLEMA. OU ELE DEFINE A ORIGEM NUMA POSIÇÃO FIXA(NAO O CENTRO DO CARRO) E RODA SOBRE ESSE (x,y)  E ANDA EM TODAS AS DIRECOES
		gc.restore();																														//		  |						 OU VAI-SE DEFENINDO A ORIGEM(CENTRO DO CARRO) A MEDIDA QUE SE MOVE PELO CANVAS, MAS SO SE MOVE NO EIXO ORIGINAL DO x
		System.out.println(velocidadeX);																									//		  |
		*/
		if(isReverse()) {																													//        |
			if(x+velocidadeX >= 700 || x+velocidadeX <= 0) {																				//        |
				gc.drawImage(CARIMAGE, x+CARIMAGE.getWidth(), y, -CARIMAGE.getWidth(), CARIMAGE.getHeight());								//        | DESENHA O CARRO
				velocidadeX = 0;																											//        | CONFORME O VALOR 
				}																															//        | DE reverse E ATUALIZA.																																
			else {																															//        | VERIFICA TAMBEM SE O
				gc.drawImage(CARIMAGE, x+velocidadeX+CARIMAGE.getWidth(), y, -CARIMAGE.getWidth(), CARIMAGE.getHeight()); 					//        | CARRO SE ENCONTRA DENTRO
				}																															//        | CANVAS E SE NAO DA RESET A
			}																																//        | SUA POSIÇÃO POR ONDE SAIU														//        |
		else {																																//        |
			if(x+velocidadeX >= 700 || x+velocidadeX <= 0) {																				//        |
				gc.drawImage(CARIMAGE, x, y);																								//        |
				velocidadeX = 0;																											//        |
				}																															//        |																																//        |
			else {																															//        |
				gc.drawImage(CARIMAGE, x+velocidadeX, y);																					//        |	
				}																															//        |
			}																																//        |
		gc.restore();
		// <-------------------->	
		
		if (sens1 <= lim/2) {																	//			|
			gc.setFill(Color.GRAY);																//			|
			gc.fillRect(x+velocidadeX+sens1+CARIMAGE.getWidth(), y,25,100);						//			|
			gc.setFill(Color.WHITE);															//			|
			gc.fillText("STOP", 625, 25);														//			| SENSOR 1
			gc.setFill(Color.RED);																//			|
			gc.fillRect(650, 0, 50 , 50);														//			|
			if(this.velX > 0) {																	//			|
				this.velX= 0;																	//			| E
			}																					//			|
			setCanMoveSens1(false);																//			|
		} else if (sens1 <= lim) {																//			| DESENHO
			gc.setFill(Color.GRAY);																//			|
			gc.fillRect(x+velocidadeX+sens1+CARIMAGE.getWidth(), y,25,100);						//			| DA
			gc.setFill(Color.WHITE);															//			|
			gc.fillText("DANGER", 625, 25);														//			| PAREDE E  ATUALIZA A LUZ DO SENSOR
			gc.setFill(Color.YELLOW);															//			|
			gc.fillRect(650, 0, 50 , 50);														//			| CASO
			setCanMoveSens1(true);																//			| 
		} else {																				//			| DETETE	
			gc.setFill(Color.WHITE);															//			|
			gc.fillText("GO", 625, 25);															//			| COLISAO
			gc.setFill(Color.LAWNGREEN);														//			|
			gc.fillRect(650, 0, 50 , 50);														//			|
			gc.clearRect(x+velocidadeX+sens1+1+CARIMAGE.getWidth(), y, 25, 100);				//			|
			setCanMoveSens1(true);																//			|
		}																						//			|
		//  <------------------------->
		
		if (sens2 <= lim/2) {																	//			|
			gc.setFill(Color.GRAY);																//			|
			gc.fillRect(x+velocidadeX-(sens2+25), y,25,100);									//			|
			gc.setFill(Color.WHITE);															//			|
			gc.fillText("STOP", 625, 75);														//			| SENSOR 2
			gc.setFill(Color.RED);																//			|
			gc.fillRect(650, 50, 50 , 50);														//			|
			if(this.velX < 0) {																	//			|
				this.velX = 0;																	//			| E
			}																					//			|
			setCanMoveSens2(false);																//			|
		} else if (sens2 <= lim) {																//			| DESENHO
			gc.setFill(Color.GRAY);																//			|
			gc.fillRect(x+velocidadeX-(sens2+25), y,25,100);									//			| DA
			gc.setFill(Color.WHITE);															//			|
			gc.fillText("DANGER", 625, 75);														//			| PAREDE   E  ATUALIZA A LUZ DO SENSOR
			gc.setFill(Color.YELLOW);															//			|
			gc.fillRect(650, 50, 50 , 50);														//			| CASO 
			setCanMoveSens2(true);																//			| 
		} else {																				//			| DETETE 
			gc.setFill(Color.WHITE);															//			|
			gc.fillText("GO", 625, 75);															//			| COLISÃO
			gc.setFill(Color.LAWNGREEN);														//			|
			gc.fillRect(650, 50, 50 , 50);														//			|
			gc.clearRect(x+velocidadeX+1-(sens2+25), y, 25, 100);								//			|
			setCanMoveSens2(true);																//			|
		}
		
	}
}