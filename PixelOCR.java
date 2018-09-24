class PixelNumberOCR implements SudokuReader {

  private BufferedImage img;

  PixelOCR(File f) {
    try {
      this.img = ImageIO.read(f);
    }
    catch(IOException e) {
    }
  }

  public int[][] readToGrid();

  private int readLine(BufferedImage line) {
    return 0;
  }

  private BufferedImage[] separateLines() {

  }

  private int[] verticalHistogram() {


  }




}
