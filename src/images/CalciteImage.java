// Code modified from CPSC 210 lecture lab B01 - PhotoViewer

package images;

public class CalciteImage extends Image {

    public static final int WIDTH = 700;
    public static final int HEIGHT = 600;
    public static final String IMAGE_FILE = "src/calimage1.jpg";
    public static final String TITLE = "Calcite";

    public void imageCaption() {
        System.out.println("Image file: " + IMAGE_FILE + ". ");
        System.out.println("This image of calcite displays the perfect rhomobhedral cleavage of the mineral.");
    }
}