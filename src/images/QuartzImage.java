// Code modified from CPSC 210 lecture lab B01 - PhotoViewer

package images;

    public class QuartzImage extends Image {

        public static final int WIDTH = 700;
        public static final int HEIGHT = 700;
        public static final String IMAGE_FILE = "src/qtzimage1.jpg";
        public static final String TITLE = "Quartz";

        public void imageCaption() {
            System.out.println("Image file: " + IMAGE_FILE + ". ");
            System.out.println("This large hexagonal quartz growing from a substrate indicates that this quartz grew in a void.");
        }
    }
