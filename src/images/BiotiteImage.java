package images;

public class BiotiteImage extends Image {

    public static final int WIDTH = 700;
    public static final int HEIGHT = 600;
    public static final String IMAGE_FILE = "src/btimage1.jpg";
    public static final String TITLE = "Biotite";

    public void imageCaption() {
        System.out.println("Image file: " + IMAGE_FILE + ".");
        System.out.println("In this image of biotite you can clearly see the perfect planar cleavage and characteristic dark brown colour." );
    }
}
