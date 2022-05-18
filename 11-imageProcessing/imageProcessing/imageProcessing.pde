String[]names;
Kernel[]kernels;
int currentKernel;
PImage car;
PImage output;

void setup() {
  size(1450, 500);
  car = loadImage("redcar.png");
  output = car.copy();
  image(car, 0, 0);
  currentKernel = 0;
        names = new String[]{
          "Identity", "Blur", "Sharpen",
          "Outline", "Left Sobel", "Right Sobel",
          "Top Sobel", "Emboss"
        };

        kernels = new Kernel[] {
          new Kernel( new float[][] {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
          }) ,
          new Kernel( new float[][] {
            {.111, .111, .111},
            {.111, .111, .111},
            {.111, .111, .111}
          }) ,
          new Kernel( new float[][] {
            {0, -1, 0},
            {-1, 5, -1},
            {0, -1, 0}
          }) ,
          new Kernel( new float[][] {
            {-1, -1, -1},
            {-1, 8, -1},
            {-1, -1, -1}
          }) ,
          new Kernel( new float[][] {
            {1, 0, -1},
            {2, 0, -2},
            {1, 0, -1}
          }) ,
          new Kernel( new float[][] {
            {-1, 0, 1},
            {-2, 0, 2},
            {-1, 0, 1}
          }) ,
          new Kernel( new float[][] {
            {1, 2,  1},
            {0, 0, 0},
            {-1, -2, -1}
          }),
          new Kernel( new float[][] {
            {-2, -1,  0},
            {-1, 1, 1},
            {0, 1, 2}
          })
        };
  }

 void keyPressed() {
   if (currentKernel == kernels.length-1) {
   currentKernel = 0;
   } else
   currentKernel++;
   }


  void draw() {
    kernels[currentKernel].apply(car, output);
    image(output, car.width, 0);

    // Help from Sloan to display text
    fill(255);
    rect(5, height -50, 110, 20);
    fill(0);
    text("Mode: " + names[currentKernel], 10, height-35);
 }
