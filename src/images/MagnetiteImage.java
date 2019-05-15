// Code modified from CPSC 210 lecture lab B01 - PhotoViewer

package images;

public class MagnetiteImage extends Image {

    public static final int WIDTH = 300;
    public static final int HEIGHT = 300;
    public static final String IMAGE_FILE = "src/mtimage1.jpg";
    public static final String TITLE = "Magnetite";

    public void imageCaption() {
        System.out.println("Image file: " + IMAGE_FILE + ". ");
        System.out.println("This image of magnetite displays its dark black metallic colour.");
    }
}

