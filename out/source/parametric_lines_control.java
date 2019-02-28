import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import controlP5.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class parametric_lines_control extends PApplet {

//x = sin((a+A)t)^e - sin((b+B)t)^f y = cos((c+C)t)^g - cos((d+D)t)^h
//inspired and adapted from ianbloom



float[] point = new float[2];
float[] temp = new float[2];

int a = 80;
int b = 1;
int c = 1;
int d = 80;

int e = 1;
int f = 3;
int g = 1;
int h = 3;

float centerX;
float centerY;

int coordinatex;
int coordinatey;

int cc1;
int cc2;
int cc3;

float strokesize;
float rotatevarx;
float rotatevary;
float rotatevarz;

float count = 0;
float tick = .01f;

ControlP5 cp5;
Slider abc;
int myColor = color(1,56,160);

public void setup()
{
  //size(displayWidth,displayHeight);
  
  
  frameRate(60);
  background(0);
  
  
  centerX = width/2 ;
  centerY = height/2 ;
  
  translate(centerX, centerY);
  scale(centerY/5,centerY/5);
  
  point[0] = sin(a * count) - sin(b * count);
  point[1] = cos(c * count) - cos(d * count);
// you will need ControlP5 library to run this!
cp5 = new ControlP5(this);

Group g1 = cp5.addGroup("g1")
.setPosition(0,0)
;
cp5.addSlider("sliderA")
     .setPosition(10,10)
     .setSize(100,20)
     .setRange(0,10)
     .setValue(5)
     .setNumberOfTickMarks(10)
     .setColorForeground(color(150))
     .setColorActive(color(180))
     .setColorBackground(color(230))
     ;
     
cp5.addSlider("sliderB")
     .setPosition(10,40)
     .setSize(100,20)
     .setRange(0,10)
     .setValue(5)
     .setNumberOfTickMarks(10)
     .setColorForeground(color(150))
     .setColorActive(color(180))
     .setColorBackground(color(230))
     ;
     
cp5.addSlider("sliderC")
     .setPosition(10,100)
     .setSize(100,20)
     .setRange(0,10)
     .setValue(3)
     .setNumberOfTickMarks(10)
     .setColorForeground(color(150))
     .setColorActive(color(180))
     .setColorBackground(color(230))
     ;
     
cp5.addSlider("sliderD")
     .setPosition(10,130)
     .setSize(100,20)
     .setRange(0,10)
     .setValue(5)
     .setNumberOfTickMarks(10)
     .setColorForeground(color(150))
     .setColorActive(color(180))
     .setColorBackground(color(230))
     ;
     
cp5.addSlider("expE")
     .setPosition(150,10)
     .setSize(40,20)
     .setRange(0,4)
     .setValue(2)
     .setNumberOfTickMarks(5)
     .setColorForeground(color(150))
     .setColorActive(color(180))
     .setColorBackground(color(230))
     ;
  
cp5.addSlider("expF")
     .setPosition(150,40)
     .setSize(40,20)
     .setRange(0,4)
     .setValue(1)
     .setNumberOfTickMarks(5)
     .setColorForeground(color(150))
     .setColorActive(color(180))
     .setColorBackground(color(230))
     ;
     
cp5.addSlider("expG")
     .setPosition(150,100)
     .setSize(40,20)
     .setRange(0,4)
     .setValue(2)
     .setNumberOfTickMarks(5)
     .setColorForeground(color(150))
     .setColorActive(color(180))
     .setColorBackground(color(230))
     ;
     
cp5.addSlider("expH")
     .setPosition(150,130)
     .setSize(40,20)
     .setRange(0,4)
     .setValue(1)
     .setNumberOfTickMarks(5)
     .setColorForeground(color(150))
     .setColorActive(color(180))
     .setColorBackground(color(230))
     ;
     
cp5.addSlider("t")
     .setPosition(10,200)
     .setSize(30,400)
     .setRange(.0001f,.01f)
     .setValue(.01f)
     .setColorForeground(color(150))
     .setColorActive(color(180))
     .setColorBackground(color(230))
     ;
     
cp5.addSlider("a")
     .setPosition(40,200)
     .setSize(20,400)
     .setRange(-3,3)
     .setValue(0)
     .setColorForeground(color(150))
     .setColorActive(color(180))
     .setColorBackground(color(230))
     ;
     
cp5.addSlider("b")
     .setPosition(60,200)
     .setSize(20,400)
     .setRange(-3,3)
     .setValue(0)
     .setColorForeground(color(150))
     .setColorActive(color(180))
     .setColorBackground(color(230))
     ;
     
cp5.addSlider("c")
     .setPosition(80,200)
     .setSize(20,400)
     .setRange(-3,3)
     .setValue(0)
     .setColorForeground(color(150))
     .setColorActive(color(180))
     .setColorBackground(color(230))
     ;
     
cp5.addSlider("d")
     .setPosition(100,200)
     .setSize(20,400)
     .setRange(-3,3)
     .setValue(0)
     .setColorForeground(color(150))
     .setColorActive(color(180))
     .setColorBackground(color(230))
     ;
     
cp5.addSlider("scalex")
     .setPosition(10,800)
     .setSize(100,20)
     .setRange(-2000,2000)
     .setValue(500)
     .setNumberOfTickMarks(30)
     .setColorForeground(color(150))
     .setColorActive(color(180))
     .setColorBackground(color(230))
     ;
     
cp5.addSlider("scaley")
     .setPosition(10,830)
     .setSize(100,20)
     .setRange(-2000,2000)
     .setValue(500)
     .setNumberOfTickMarks(30)
     .setColorForeground(color(150))
     .setColorActive(color(180))
     .setColorBackground(color(230))
     ;
     
cp5.addSlider("spacerotateX")
     .setPosition(10,860)
     .setSize(100,20)
     .setRange(0,.001f)
     .setValue(0)
     .setColorForeground(color(150))
     .setColorActive(color(180))
     .setColorBackground(color(230))
     ;
     
cp5.addSlider("spacerotateY")
     .setPosition(10,890)
     .setSize(100,20)
     .setRange(0,.001f)
     .setValue(0)
     .setColorForeground(color(150))
     .setColorActive(color(180))
     .setColorBackground(color(230))
     ;
     
     cp5.addSlider("spacerotateZ")
     .setPosition(10,920)
     .setSize(100,20)
     .setRange(0,.001f)
     .setValue(0)
     .setColorForeground(color(150))
     .setColorActive(color(180))
     .setColorBackground(color(230))
     ;
     
cp5.addSlider("strokepoint")
     .setPosition(10,950)
     .setSize(100,20)
     .setRange(.0001f,.01f)
     .setValue(.005f)
     .setColorForeground(color(150))
     .setColorActive(color(180))
     .setColorBackground(color(230))
     ;

    //  this background thing is broken, call a scientist!!!
     cp5.addSlider("originy")
     .setPosition(10,650)
     .setSize(100,20)
     .setRange(0,1080)
     .setValue(540)
     .setColorForeground(color(150))
     .setColorActive(color(180))
     .setColorBackground(color(230))
     ;
     
     cp5.addSlider("originx")
     .setPosition(10,670)
     .setSize(100,20)
     .setRange(0,1920)
     .setValue(960)
     .setColorForeground(color(150))
     .setColorActive(color(180))
     .setColorBackground(color(230))
     ;
     
     cp5.addSlider("colorchange1")
     .setPosition(10,700)
     .setSize(100,20)
     .setRange(0,255)
     .setValue(255)
     .setColorForeground(color(150,0,0))
     .setColorActive(color(180,0,0))
     .setColorBackground(color(255,0,0))
     ;
     
cp5.addSlider("colorchange2")
     .setPosition(10,730)
     .setSize(100,20)
     .setRange(0,255)
     .setValue(255)
     .setColorForeground(color(0,150,0))
     .setColorActive(color(0,180,0))
     .setColorBackground(color(0,255,0))
     ;
     
cp5.addSlider("colorchange3")
     .setPosition(10,760)
     .setSize(100,20)
     .setRange(0,255)
     .setValue(255)
     .setColorForeground(color(0,0,150))
     .setColorActive(color(0,0,180))
     .setColorBackground(color(0,0,255))
     ;
  
cp5.addButton("reset")
     .setValue(0)
     .setPosition(10,1050)
     .setSize(100,20)
     .setColorForeground(color(150))
     .setColorActive(color(180))
     .setColorBackground(color(200))
     ;
}

float aRate = 0;
float bRate = 0;
float cRate = 0;
float dRate = 0;

float tick_a = 0;
float tick_b = 0;
float tick_c = 0;
float tick_d = 0;

float a_ = 0;
float b_ = 0;
float c_ = 0;
float d_ = 0;

float scalex =0;
float scaley =0;


int periodic = 0;

public void draw()
{  
  line(0,0, width, height);
  println(frameRate);
  pushMatrix();
  translate(coordinatex, coordinatey);
  scale(scalex / 3, scaley / 3);
  blendMode(ADD);
  
  //count2 += pow(2 , tick2 - 20);
  
  aRate += tick_a;
  bRate += tick_b;
  cRate += tick_c;
  dRate += tick_d;
  
  periodic += .1f;
  if(aRate > 999999999999f)
    aRate = 0;
  //float a_ = a + .001 * cos(count2 / 600);
  a_ = a + 0.0001f * aRate;
  b_ = b + 0.0001f * bRate;
  c_ = c + 0.0001f * cRate;
  d_ = d + 0.0001f * dRate;
  background(0);
  count = 0;
  for(int i = 0; i < 8000; i++) {
    count += tick * 2;
    if(aRate > 999999999999f )
      aRate = 0;
    if(bRate > 999999999999f )
      bRate = 0;
    if(cRate > 999999999999f )
      cRate = 0;
    if(dRate > 999999999999f )
      dRate = 0;
    
    temp[0] = point[0];
    temp[1] = point[1];
    
    point[0] = pow(cos(a_ * count), e) - pow(sin(b_ * count), f);
    point[1] = pow(cos(c_ * count), g) - pow(sin(d_ * count), h);
    stroke(cc1 * ((cos(count * 10) + 1) / 2), cc2 * ((cos(TWO_PI / 3 + count * 10) + 1) / 2), cc3 * ((cos(2 * TWO_PI / 3 + count * 10) + 1) / 2));
    //stroke(#94D0FF , 100);
    strokeWeight(strokesize);
    // this is the rotation section I was referencing. Right not it act one the relationship between the point[0] and point[1] when ideally it would act on the entire "shape" the object is making. So far all my ideas for solutions to this boil down to adding a camera element in the setup or wrapping the matrix in a shape somehow.
    rotateX(rotatevarx);
    rotateY(rotatevary);
    rotateZ(rotatevarz);
    if(i != 0)  {
      line(temp[0],temp[1],point[0],point[1]);
    }
}
  popMatrix();
}


public void sliderA(int value) {
  a = value;
}

public void sliderB(int value) {
  b = value;
}

public void sliderC(int value) {
  c = value;
}

public void sliderD(int value) {
  d = value;
}

public void expE(int value) {
  e = value;
}

public void expF(int value) {
  f = value;
}

public void expG(int value) {
  g = value;
}

public void expH(int value) {
  h = value;
}

public void t(float value) {
  tick = value;
}

public void a(float value) {
  tick_a = value;
}

public void b(float value) {
  tick_b = value;
}

public void c(float value) {
  tick_c = value;
}

public void d(float value) {
  tick_d = value;
}

public void scalex(float value) {
  scalex = value;
}

public void scaley(float value) {
  scaley = value;
}

public void spacerotateX(float value) {
  rotatevarx = value;
}

public void spacerotateY(float value) {
  rotatevary = value;
}

public void spacerotateZ(float value) {
  rotatevarz = value;
}

public void colorchange1(int value) {
  cc1 = value;
}

public void colorchange2(int value) {
  cc2 = value;
}

public void colorchange3(int value) {
  cc3 = value;
}

public void strokepoint(float value) {
  strokesize = value;
}
public void originx(int value) {
  coordinatex = value;
}
public void originy(int value) {
  coordinatey = value;
}

public void reset() {
  cp5.getController("t").setValue(.01f);
  cp5.getController("a").setValue(0);
  cp5.getController("b").setValue(0);
  cp5.getController("c").setValue(0);
  cp5.getController("d").setValue(0);
  
  tick_a = 0;  
  tick_b = 0;
  tick_c = 0;
  tick_d = 0;
  
  a_ = a;
  b_ = b;
  c_ = c;
  d_ = d;
  
  aRate = 0;
  bRate = 0;
  cRate = 0;
  dRate = 0;
  scalex = 500;
  scaley = 500;
  coordinatex = 960;
  coordinatey = 540;
  cc1 = 255;
  cc2 = 255;
  cc3 = 255;
  rotatevarx = 0;
  rotatevary = 0;
  rotatevarz = 0;
}
  public void settings() {  size(1000,1000,OPENGL);  smooth(16);  pixelDensity(displayDensity()); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "parametric_lines_control" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
