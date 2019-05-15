package images;

public class PlagioclaseImage extends Image {

    public static final int WIDTH = 300;
    public static final int HEIGHT = 350;
    public static final String IMAGE_FILE = "src/plagimage1.jpg";
    public static final String TITLE = "Plagioclase";

    public void imageCaption() {
        System.out.println("Image file: " + IMAGE_FILE + ". ");
        System.out.println("Notice the cream-white colour and linear cleavage of plagioclase.");
    }
}
