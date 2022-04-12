int x,y;
int MODE;
void setup(){
         size(800,800);
         MODE = 3;
         x = width/2;
         y = height/2;
}
void draw(){
         background(255);
         x = change(x);
         y = change(y);
         avatar(x,y);
}
int change(int value){
  /**
   mode 1: return a random location on the screen.
   mode 2: change value by +1, 0, or -1 randomly
   mode 3: change value by +1 , but if it goes past the end of the screen ,
         wrap back around to the other end of the screen.
  */

  switch(MODE){
   case 1:
     return (int) random(height);
   case 2:
     return value + (int) random(-2, 2);
   case 3:
     if (value == height) {
       value = 0;
     }
     return value + 1;
   default:
     return width/2;
  }
}


/** Avatar: a function that draws a face/character/animal/object, 

 *at a particular x,y location. 

*/
void avatar(int x, int y){
  //your code here
  
  // Face
  fill(255, 234, 0);
  ellipse(x,y,200,200);
  
  // Eyes
  fill(255);
  ellipse(x+40, y+5, 30, 60);
  ellipse(x-40, y+5, 30, 60);
  
  // Iris
  fill(0);
  ellipse(x-40, y+5, 10, 10);
  ellipse(x+40, y+5, 10, 10);
  
  // Smile
  fill(231, 76, 60);
  arc(x, y+45, 60, 30, radians(0), radians(180));

}
