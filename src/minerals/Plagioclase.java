package minerals;

import images.Image;
import images.PlagioclaseImage;
import observer.MineralSaver;
import rocks.Rock;

import java.util.ArrayList;
import java.util.Objects;

public class Plagioclase extends Mineral {

    String name = "Plagioclase";
    ArrayList<Rock> hostRocks = new ArrayList<>();


        // made these variables final since they'll never need to change
        public static final String NAME = "Plagioclase";
        public static final String FORMULA = "(Na,Ca)(Si,Al)4O8";
        public static final String COLOUR = "white, gray, bluish white, reddish white, greenish white";
        public static final String STREAK = "white";
        public static final String LUSTER = "vitreous";
        public static final String DIAPHANEITY = "transparent to translucent";
        public static final String CLEAVAGE = "good";
        public static final String CRYSTAL_SYSTEM = "triclinic";
        public static final int HARDNESS = 6; // actual HARDNESS is [6, 6.5]
        public static final double SPECIFIC_GRAVITY = 2.68; // actual SG is [2.61-2.76]

    // EFFECTS: prints all the properties of plagioclase
    public void properties() {
        System.out.println("Name: " + NAME);
        System.out.println("Formula: " + FORMULA);
        System.out.println("Colour: " + COLOUR);
        System.out.println("Streak: " + STREAK);
        System.out.println("Luster: " + LUSTER);
        System.out.println("Diaphaneity: " + DIAPHANEITY);
        System.out.println("Cleavage: " + CLEAVAGE);
        System.out.println("Crystal system: " + CRYSTAL_SYSTEM);
        System.out.println("Hardness: " + HARDNESS);
        System.out.println("Specific Gravity: " + SPECIFIC_GRAVITY);

    }

    // EFFECTS: creates a pop-up image of plagioclase
    public void createImage() {
        Image plagImg = new PlagioclaseImage();
        plagImg.createImage(PlagioclaseImage.WIDTH, PlagioclaseImage.HEIGHT, PlagioclaseImage.TITLE, PlagioclaseImage.IMAGE_FILE);
        plagImg.imageCaption();
    }

    public String getName() {
        return name;
    }

    public void addRock(Rock r) {
        if (!hostRocks.contains(r)) {
            hostRocks.add(r);
            r.addMineral(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plagioclase that = (Plagioclase) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
