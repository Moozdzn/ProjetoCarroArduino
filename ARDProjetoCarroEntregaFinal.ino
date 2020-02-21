#include "Servo.h"
#define trigPin 4
#define echoPin 5
#define ledPin 11
#define trigPino 6
#define echoPino 7
#define ledPino 12

Servo servol; 
Servo servor;

boolean reverse =false;

void setup()
{
  
  Serial.begin(9600);     
  servol.attach(9); 
  servor.attach(10);
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);
  pinMode(ledPin, OUTPUT);
  pinMode(trigPino, OUTPUT);
  pinMode(echoPino, INPUT);
  pinMode(ledPino, OUTPUT);
}

long CLOSE = 20;
void loop(){
   digitalWrite(trigPin, LOW);        
  delayMicroseconds(2);              
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);           
  digitalWrite(trigPin, LOW);
  long duration = pulseIn(echoPin, HIGH);
  long distance = (duration/2) / 29.1;
  if (distance < CLOSE && distance > 0) {
    digitalWrite(ledPin, HIGH);
  } else {
    digitalWrite(ledPin, LOW);  
  }
  Serial.println(distance);
  delay(500); 

  
   digitalWrite(trigPino, LOW);        
  delayMicroseconds(2);              
  digitalWrite(trigPino, HIGH);
  delayMicroseconds(10);           
  digitalWrite(trigPino, LOW);
  long duration1 = pulseIn(echoPino, HIGH);
  long distance1 = (duration1/2) / 29.1;
  if (distance < CLOSE && distance > 0) {
    digitalWrite(ledPino, HIGH);
  } else {
    digitalWrite(ledPino, LOW);  
  }
  Serial.println(distance2);
  delay(500); 
}



void serialEvent() {
  while (Serial.available()) {
    String info= Serial.readString();
       String command = info.substring(0,5);
     if (command.equals("LIMIT")) {
       String arg = info.substring(6,10);     
       CLOSE = arg.toInt();
     } 
    Serial.println(info);
      if(info.equals("RVRS")) {
      reverse = !reverse;
      }
      servor.write(90);
      servol.write(90);
      if(reverse){  
  
     if (info.equals("STOP")) {
      servol.write(90);
      servor.write(90);
      }
     if (info.equals("FWD")) {
      servol.write(0);
      servor.write(180);
      }
     if (info.equals("BCK")) {
      servol.write(180);
      servor.write(0);
      }
     if (info.equals("LFT")) {
      servol.write(90);
      servor.write(180);
      }
     if (info.equals("RGHT")) {
      servol.write(180);
      servor.write(90);
      }
     if (info.equals("FLFT")) {
      servol.write(45);
      servor.write(180);
      }
     if (info.equals("FRGHT")) {
      servol.write(0);
      servor.write(135);
      }
     if (info.equals("BLFT")) {
      servol.write(135);
      servor.write(0);
      }
     if (info.equals("BRGHT")) {
      servol.write(180);
      servor.write(45);
      }
    }
    else {
     if (info.equals("STOP")) {
      servol.write(90);
      servor.write(90);
      }
     if (info.equals("FWD")) {
      servol.write(180);
      servor.write(0);
      }
     if (info.equals("BCK")) {
      servol.write(0);
      servor.write(180);
      }
     if (info.equals("LFT")) {
      servol.write(90);
      servor.write(180);
      }
     if (info.equals("RGHT")) {
      servol.write(180);
      servor.write(90);
      }
     if (info.equals("FLFT")) {
      servol.write(180);
      servor.write(45);
      }
     if (info.equals("FRGHT")) {
      servol.write(135);
      servor.write(0);
      }
     if (info.equals("BLFT")) {
      servol.write(0);
      servor.write(135);
      }
     if (info.equals("BRGHT")) {
      servol.write(45);
      servor.write(180);
      }
     }
    }
   }

