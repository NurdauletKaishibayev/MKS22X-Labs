ArrayList<Orb>orbList;
Orb orby;
final int GRAVITY = 1;
final int ORBIT = 0;
final int SPRING = 2;
int MODE = ORBIT;
float gravity;
final float SPRING_CONSTANT = 0.005;
final float SPRING_LENGTH= 150;
final float SPRING_DAMPEN = 0.995;
boolean backgroundMode;
boolean gravityMode;

void setup() {
  size(1000, 800);
  orbList = new ArrayList<Orb>();
  orby = new Orb(width/2, height/2, 0, 0, 10);
  backgroundMode = true;
  gravityMode = true;
}
void mouseClicked() {
  //add a new Orb to the orbList, constructed as follows:
  //The x and y positions are the same as the mouse
  //the radius should be between in the range [20.0,70.0)
  //the xSpeed and ySpeed should be in the range [-3.0,3.0)
  float radius = 20.0;
  float xSpeed = 5;
  float ySpeed = 0;
  Orb orb = new Orb(mouseX, mouseY, xSpeed, ySpeed, radius);
  orbList.add(orb);
}

void keyPressed() {
  if (keyCode == BACKSPACE) {
    orbList.clear();
  }
  if (key == 32) {
    if (MODE == GRAVITY) {
      MODE = ORBIT;
    } else if (MODE == ORBIT) {
      MODE = SPRING;
    } else {
      MODE = GRAVITY;
    }
  }
  if (key == 'b') {
    if (backgroundMode) {
      backgroundMode = false;
    } else if (!backgroundMode) {
      backgroundMode = true;
    }
  }
  if (key == 'g') {
    if (gravityMode) {
      gravityMode = false;
    } else {
      gravityMode = true;
    }
  }
}
void draw() {
  if (backgroundMode) {
    background(255);
  } else {
    fill(255);
    rect(0, 0, 70, 70);
  }
  orby.display();
  for (Orb o : orbList) {
    o.move();
    o.display();
    if (MODE == ORBIT) {
      o.attract(orby);
    } else if (MODE == SPRING) {
      o.attractSpring(orby);
    }
  }
  fill(0);
  text(frameRate, 20, 20);
  text(orbList.size(), 20, 40);
  if (MODE == GRAVITY) {
    gravity = 0.15;
    text("GRAVITY", 20, 60);
  } else if (MODE == ORBIT) {
    gravity = 0.0;
    text("ORBIT", 20, 60);
  } else {
    text("SPRING", 20, 60);
  }
}
