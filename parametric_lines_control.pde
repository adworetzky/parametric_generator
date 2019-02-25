//x = sin((a+A)t)^e - sin((b+B)t)^f y = cos((c+C)t)^g - cos((d+D)t)^h
//inspired and adapted from https://github.com/ianbloom/Parametric-Animator

import controlP5.*;

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

int bgc;
int cc1;
int cc2;
int cc3;

float strokesize;
float rotatevarx;
float rotatevary;
float rotatevarz;

float count = 0;
float tick = .01;

ControlP5 cp5;
Slider abc;
int myColor = color(1,56,160);

void setup()
{
  //size(displayWidth,displayHeight);
  fullScreen(P3D);
  frameRate(24);
  background(0);
  smooth(16);
  
  centerX = width/2 ;
  centerY = height/2 ;
  
  translate(centerX, centerY);
  scale(centerY/5,centerY/5);
  
  point[0] = sin(a * count) - sin(b * count);
  point[1] = cos(c * count) - cos(d * count);
  
  cp5 = new ControlP5(this);
    // add a vertical slider
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
     .setPosition(10,70)
     .setSize(100,20)
     .setRange(0,10)
     .setValue(3)
     .setNumberOfTickMarks(10)
     .setColorForeground(color(150))
     .setColorActive(color(180))
     .setColorBackground(color(230))
     ;
     
  cp5.addSlider("sliderD")
     .setPosition(10,100)
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
     .setPosition(150,70)
     .setSize(40,20)
     .setRange(0,4)
     .setValue(2)
     .setNumberOfTickMarks(5)
     .setColorForeground(color(150))
     .setColorActive(color(180))
     .setColorBackground(color(230))
     ;
     
  cp5.addSlider("expH")
     .setPosition(150,100)
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
     .setRange(.0001,.01)
     .setValue(.01)
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
     .setRange(-1000,1000)
     .setValue(300)
     .setNumberOfTickMarks(30)
     .setColorForeground(color(150))
     .setColorActive(color(180))
     .setColorBackground(color(230))
     ;
     
 cp5.addSlider("scaley")
     .setPosition(10,830)
     .setSize(100,20)
     .setRange(-1000,1000)
     .setValue(300)
     .setNumberOfTickMarks(30)
     .setColorForeground(color(150))
     .setColorActive(color(180))
     .setColorBackground(color(230))
     ;
     
 cp5.addSlider("spacerotateX")
     .setPosition(10,860)
     .setSize(100,20)
     .setRange(0,.001)
     .setValue(0)
     .setColorForeground(color(150))
     .setColorActive(color(180))
     .setColorBackground(color(230))
     ;
     
     cp5.addSlider("spacerotateY")
     .setPosition(10,890)
     .setSize(100,20)
     .setRange(0,.001)
     .setValue(0)
     .setColorForeground(color(150))
     .setColorActive(color(180))
     .setColorBackground(color(230))
     ;
     
     cp5.addSlider("spacerotateZ")
     .setPosition(10,920)
     .setSize(100,20)
     .setRange(0,.001)
     .setValue(0)
     .setColorForeground(color(150))
     .setColorActive(color(180))
     .setColorBackground(color(230))
     ;
     
cp5.addSlider("strokepoint")
     .setPosition(10,950)
     .setSize(100,20)
     .setRange(.0001,.01)
     .setValue(.005)
     .setColorForeground(color(150))
     .setColorActive(color(180))
     .setColorBackground(color(230))
     ;
     
     cp5.addSlider("backgroundcolor")
     .setPosition(10,670)
     .setSize(100,20)
     .setRange(0,255)
     .setValue(0)
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

void draw()
{  
  pushMatrix();
  translate(width/2 , height/2);
  scale(scalex / 3, scaley / 3);
  blendMode(ADD);
  
  //count2 += pow(2 , tick2 - 20);
  
  aRate += tick_a;
  bRate += tick_b;
  cRate += tick_c;
  dRate += tick_d;
  
  periodic += .1;
  if(aRate > 999999999999f)
    aRate = 0;
  //float a_ = a + .001 * cos(count2 / 600);
  a_ = a + 0.0001 * aRate;
  b_ = b + 0.0001 * bRate;
  c_ = c + 0.0001 * cRate;
  d_ = d + 0.0001 * dRate;
  background(bgc);
  count = 0;
  for(int i = 0; i < 4000; i++) {
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
    
    point[0] = pow(sin(a_ * count), e) - pow(sin(b_ * count), f);
    point[1] = pow(cos(c_ * count), g) - pow(cos(d_ * count), h);
    stroke(cc1 * ((cos(count * 10) + 1) / 2), cc2 * ((cos(TWO_PI / 3 + count * 10) + 1) / 2), cc3 * ((cos(2 * TWO_PI / 3 + count * 10) + 1) / 2));
    //stroke(#94D0FF , 100);
    strokeWeight(strokesize);
    rotateX(rotatevarx);
  rotateY(rotatevary);
  rotateZ(rotatevarz);
    if(i != 0)  {
      line(temp[0],temp[1],point[0],point[1]);
    }
  }
  popMatrix();
}


void sliderA(int value) {
  a = value;
}

void sliderB(int value) {
  b = value;
}

void sliderC(int value) {
  c = value;
}

void sliderD(int value) {
  d = value;
}

void expE(int value) {
  e = value;
}

void expF(int value) {
  f = value;
}

void expG(int value) {
  g = value;
}

void expH(int value) {
  h = value;
}

void t(float value) {
  tick = value;
}

void a(float value) {
  tick_a = value;
}

void b(float value) {
  tick_b = value;
}

void c(float value) {
  tick_c = value;
}

void d(float value) {
  tick_d = value;
}

void scalex(float value) {
  scalex = value;
}

void scaley(float value) {
  scaley = value;
}

void spacerotateX(float value) {
  rotatevarx = value;
}

void spacerotateY(float value) {
  rotatevary = value;
}

void spacerotateZ(float value) {
  rotatevarz = value;
}

void colorchange1(int value) {
  cc1 = value;
}

void colorchange2(int value) {
  cc2 = value;
}

void colorchange3(int value) {
  cc3 = value;
}

void backgroundcolor(int value) {
  bgc = value;
}

void strokepoint(float value) {
  strokesize = value;
}

void reset() {
  cp5.getController("t").setValue(.01);
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
  scalex = 131;
  scaley = 131;
  cc1 = 255;
  cc2 = 255;
  cc3 = 255;
  rotatevarx = 0;
  rotatevary = 0;
  rotatevarz = 0;
  
}
