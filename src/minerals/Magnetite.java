package minerals;

import images.Image;
import images.MagnetiteImage;
import rocks.Rock;

import java.util.ArrayList;
import java.util.Objects;

public class Magnetite extends Mineral {

    ArrayList<Rock> hostRocks = new ArrayList<>();
    public String name = "Magnetite";

    // made these variables final since they'll never need to change
    public static final String FORMULA = "Fe3O4";
    public static final String COLOUR = "dark grey to black";
    public static final String STREAK = "black";
    public static final String LUSTER = "metallic";
    public static final String DIAPHANEITY = "opaque";
    public static final String CLEAVAGE = "none";
    public static final String CRYSTAL_SYSTEM = "isometric";
    public static final int HARDNESS = 6; // actual HARDNESS is [5.5, 6.5]
    public static final double SPECIFIC_GRAVITY = 5.05; // actual SG is [4.9, 5.2]

    // EFFECTS: prints all the properties of magnetite
    public void properties() {

        System.out.println("Name: " + name);
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

    // EFFECTS: creates a pop-up image of magnetite
    public void createImage() {
        Image mtImg = new MagnetiteImage();
        mtImg.createImage(MagnetiteImage.WIDTH, MagnetiteImage.HEIGHT, MagnetiteImage.TITLE, MagnetiteImage.IMAGE_FILE);
        mtImg.imageCaption();
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
        Magnetite magnetite = (Magnetite) o;
        return Objects.equals(name, magnetite.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
