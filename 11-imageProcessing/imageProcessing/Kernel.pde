public class Kernel {
  float[][]kernel;

  /**Constructor takes the kernel that will be applied to the image
   *This implementation only allows 3x3 kernels
   */
  public Kernel(float[][]init) {
    kernel = init;
  }

  /**If part of the kernel is off of the image, return black, Otherwise
   *Calculate the convolution of r/g/b separately, and return that color\
   *if the calculation for any of the r,g,b values is outside the range
   *     0-255, then clamp it to that range (< 0 becomes 0, >255 becomes 255)
   */
  color calcNewColor(PImage img, int x, int y) {
    //Hint: start by always returning black.
    //This will let you test your apply method right away!
    if (x == 0) {
      return 0;
    } else if (x == height + img.height-1) {
      return 0;
    } else if (y == 0) {
      return 0;
    } else if (y == width + img.width-1) {
      return 0;
    } else {
      float red = 0;
      float green = 0;
      float blue = 0;
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          color pixel = img.get(x+j-1, y+i-1);
          red += red(pixel)*kernel[i][j];
          green += green(pixel)*kernel[i][j];
          blue += blue(pixel)*kernel[i][j];
        }
      }
      if (red < 0) {
        red = 0;
      } else if (red > 255) {
        red = 255;
      }
      if (green < 0) {
        green = 0;
      } else if (green > 255) {
        green = 255;
      }
      if (blue < 0) {
        blue = 0;
      } else if (blue > 255) {
        blue = 255;
      }
      color c = color(red, green, blue);
      return c;
    }
  }

  /**You must write this method that applies the kernel to the source,
   *and saves the data to the destination.*/
  void apply(PImage source, PImage destination) {
    for (int i = 0; i < source.width; i++) {
      for (int j = 0; j < source.height; j++) {
        destination.set(i, j, calcNewColor(source, i, j));
      }
    }
  }
}
