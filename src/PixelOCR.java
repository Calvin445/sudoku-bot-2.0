import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

class PixelOCR implements SudokuReader {

  private BufferedImage img;

  PixelOCR(File f) {
    try {
      this.img = ImageIO.read(f);
    }
    catch(IOException e) {
    }
  }

  public int[][] readToGrid() {
    return null;
  }

  private int[] readLine(BufferedImage line) {
    return null;
  }

  private BufferedImage[] separateLines() {
    return null;
  }

  private int[] verticalHistogram() {
    return null;
  }

}
