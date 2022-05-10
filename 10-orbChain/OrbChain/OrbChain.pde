
final static int SPRING = 2;
static float SPRING_LENGTH = 50;
static float SPRING_DAMPEN = 0.990;
static float SPRING_CONSTANT = 0.015;
static float GRAVITY = 0.35;
final static int MODE = SPRING;
OrbList orbs;
void setup() {
  size(1000, 800);
  orbs = new OrbList();
}
void mouseClicked() {
  orbs.add(new OrbNode(mouseX, mouseY, 0, 0, 30));
}

void keyPressed() {
  if (key == '1') {
    SPRING_CONSTANT += 0.005;
  }
  if (key == '2') {
    SPRING_CONSTANT -= 0.005;
  }
  if (key == '3') {
    SPRING_DAMPEN += 0.01;
  }
  if (key == '4') {
    SPRING_DAMPEN -= 0.01;
  }
  if (key == '5') {
    SPRING_LENGTH += 1.0;
  }
  if (key == '6') {
    SPRING_LENGTH -= 1.0;
  }
  if (key == '7') {
    GRAVITY += 0.05;
  }
  if (key == '8') {
    GRAVITY -= 0.05;
  }
}

void draw() {
  background(255);
  orbs.processAll();
  orbs.display();
  text("SPRING_CONSTANT: " + SPRING_CONSTANT, 10, 20);
  text("SPRING_DAMPEN: " + SPRING_DAMPEN, 10, 40);
  text("SPRING_LENGTH: " + SPRING_LENGTH, 10, 60);
  text("GRAVITY: " + GRAVITY, 10, 80);
}
