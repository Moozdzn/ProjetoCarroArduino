package pt.europeia.radarCar;

import javafx.geometry.VPos;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import pt.europeia.graphlib.GraphController;
import pt.europeia.graphlib.SerialManager;
import pt.europeia.graphlib.ServerComm;

public class GUI extends GraphController {

	private Carro car;																												
	private ControlosSensor cb;
	private Compass comp;
	//private SerialManager sm;
	private ControlosCarro but;
	@Override
	
	// <-------------------->
	
	protected void start() {
		
		graphics.setTextAlign(TextAlignment.CENTER);
        graphics.setTextBaseline(VPos.CENTER);
        but = new ControlosCarro(200, 500, new String[] {"FLFT","FWD","FRGHT","LFT","RVRS","RGHT","BLFT","BCK","BRGHT","STOP"});      
        but.setChosen(0);																									   		
		cb = new ControlosSensor(200, 100, new String[] {"20","30","40"});
		cb.setChosen(0);
		car = new Carro(0,0,40);
		comp = new Compass(500,500);
		System.out.println(car);
		//sm = new SerialManager("COM8",9600,this::updateDist);
	}

	// <-------------------->
	
	private void updateSens1(String distance) {											//		| RECEBE A DISTANCIA DO SENSOR 1 APARTIR DO ARDUINO
		double val = Double.parseDouble(distance);										//		|
		car.setSens1(val);																//		|
	}
	private void updateSens2(String distance2){											//		| RECEBE A DISTANCIA DO SENSOR 2 APARTIR DO ARDUINO
		double val = Double.parseDouble(distance2);										//		|
		car.setSens2(val);																//		|
	}
	
	// <-------------------->
	
	@Override
	protected void draw() {
		cleanScreen();
		car.draw(graphics);																//		| DESENHA O CARRO
		cb.draw(graphics); 																//		| DESENHA O RADAR
		but.draw(graphics);																//		| DESENHA OS BUTOES
		comp.draw(graphics);															//		| DESENHA A BUSSOLA
		
	}

	// <-------------------->
	
	@Override
	protected void mouseRead(double x, double y) {
		if (cb.clicked(x, y)) {															//		|
			String limStr = cb.getChosen();												//		| RECEBE O BOTAO CLICADO
			int lim = Integer.parseInt(limStr);											//		|
			car.setLimit(lim);															//		| E 
			System.out.print(limStr + "\n");											//		|
			//sm.writeSerial("LIMIT"+String.format("%5d",lim));							//		| ENVIA PARA O ARDUINO
		}
		
		
		if(but.clicked(x,y)) {															//		|
			String Movement = but.getChosen();											//		| SELECIONA O BOTAO DOS CONTROLOS DO CARRO
			if(Movement.equals("RVRS")) {												//		|
				car.setReverse(!car.isReverse()); 										//		| INVERTE O CARRO SE SE PRESSIONAR "RVRS"
				car.setVelX(0);															//		|
			}																			//		|	
			if(Movement.equals("STOP")) car.setVelX(0);									//		| PARA O CARRO SE SE PRESSIONAR "STOP"
			//<----------------------->
			if (!car.getCanMoveSens1() || !car.getCanMoveSens2()) {						//		|
				if (!car.getCanMoveSens1() && car.isReverse()) {						//		| CONDIÇAO QUE VERIFICA SE
					if(Movement.equals("FWD")) {										//		|
						car.setVelX(-1);												//		| PELO MENOS UM SENSOR 
					}																	//		|
				}																		//		| NÃO DEIXA AVANÇAR E DEPOS 
				else if (!car.getCanMoveSens1() && !car.isReverse()) {					//		|
					if(Movement.equals("BCK")) {										//		| OUTRA CONDIÇÃO QUE
						car.setVelX(-1);												//		|
					}																	//		| VERIFICA QUAL DELES
				}																		//		|
				else if (!car.getCanMoveSens2() && car.isReverse()) {					//		| E SO DEIXA PRESSIONAR O BOTAO QUE
					if(Movement.equals("BCK")) {										//		|
						car.setVelX(1);													//		| MOVA O CARRO NA DIREÇAO OPOSTA
						System.out.println("help");										//		|
					}																	//		|
				}																		//		|
				else if (!car.getCanMoveSens2() && !car.isReverse()) {					//		|
					if(Movement.equals("FWD")) {										//		|
						car.setVelX(1);													//		|
						System.out.println("help");										//		|
					}																	//		|
				}																		//		|
				}
			
			// <------------------------->
			
			else if (car.isReverse()) {													//		|
				switch(Movement) {														//		|
				case "FWD":																//		|
					car.setVelX(-1);													//		| SE OS DOIS SENSORES DEIXAREM AVANÇAR
					break;																//		|
				case "BCK":																//		|  VERIFICA SE TA INVERTIDO
					car.setVelX(1);														//		|
					break;																//		| E MOVE O CARRO
			}																			//		|
			}																			//		|
			else if (!car.isReverse()) {												//		|
					switch(Movement) {													//		|
					case "BCK":															//		|
						car.setVelX(-1);												//		|
						break;															//		|
					case "FWD":															//		|
						car.setVelX(1);													//		|
						break;															//		|
					}																	//		|	
				}																		//		|
										
			// <------------------------->
			
			if(Movement.equals("LFT")) {												//		|
				car.setVelX(0);															//		|
				comp.setSentido(1);														//		| 
				comp.detAngulo();														//		|
//				car.setSentido(1);														//		|
//				car.detAngulo();														//		|
			}																			//		| ENVIA O SENTIDO PARA A BUSSOLA
			else if(Movement.equals("FLFT") || Movement.equals("BRGHT")) {				//		|
				car.setVelX(0);															//		|
				comp.setSentido(2);														//		| E PARA O CARRO DE MODO A RODAREM 
				comp.detAngulo();														//		|
//				car.setSentido(2);														//		| DE MODO IGUAL
//				car.detAngulo();														//		|
			}																			//		|
			else if(Movement.equals("BLFT") || Movement.equals("FRGHT")) {				//		| 
				car.setVelX(0);															//		|
				comp.setSentido(3);														//		|
				comp.detAngulo();														//		|
//				car.setSentido(3);														//		|
//				car.detAngulo();														//		|
			}																			//		|	
			else if(Movement.equals("RGHT")) {											//		|
				car.setVelX(0);															//		|
				comp.setSentido(4);														//		|
				comp.detAngulo();														//		|
//				car.setSentido(4);														//		|
//				car.detAngulo();														//		|
			}																			//		|	
			//sm.writeSerial(Movement);													//		|
			}								
		}	
		
	// <-------------------->
	
	@Override
	protected void readCommand(KeyCode code) {
		switch(code) {
		case P :
			break;
		case U:
			
			break;
			default:
		}
	}

	// <-------------------->
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
