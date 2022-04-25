ArrayList<Orb>orbList;
Orb orby;
void setup() {
  size(1000, 700);
  orbList = new ArrayList<Orb>();
  orby = new Orb(width/2, height/2, 0, 0, 10);
}
void mouseClicked() {
  //add a new Orb to the orbList, constructed as follows:
  //The x and y positions are the same as the mouse
  //the radius should be between in the range [20.0,70.0)
  //the xSpeed and ySpeed should be in the range [-3.0,3.0)
  float radius = random(20.0,70.0);
  float xSpeed = random(-3.0, 3.0);
  float ySpeed = random(-3.0, 3.0);
  Orb orb = new Orb(mouseX, mouseY, xSpeed, ySpeed, radius);
  orbList.add(orb);
}
void draw() {
  background(255);
  orby.display();
  for (Orb o : orbList) {
    o.move();
    o.display();
    o.attract(orby);
  }
  fill(0);
  text(frameRate,20,20);
  text(orbList.size(),20,40);
}
