package minerals;

import images.BiotiteImage;
import images.Image;
import rocks.Rock;

import java.util.ArrayList;
import java.util.Objects;

public class Biotite extends Mineral {

    private ArrayList<Rock> hostRocks = new ArrayList<>();
    private String name = "Biotite";

    // made these variables final since they'll never need to change
    public static final String FORMULA = "K(Mg,Fe)3(AlSi3O10)(F,OH)2";
    public static final String COLOUR = "black, dark brown, dark green or reddish black";
    public static final String STREAK = "white";
    public static final String LUSTER = "pearly";
    public static final String DIAPHANEITY = "translucent to opaque";
    public static final String CLEAVAGE = "perfect rhombohedral";
    public static final String CRYSTAL_SYSTEM = "monoclinic";
    public static final int HARDNESS = 3;
    public static final double SPECIFIC_GRAVITY = 3.1;

    // EFFECTS: prints all the properties of biotite
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

    // EFFECTS: creates a pop-up image of biotite
    public void createImage() {
        Image btImg = new BiotiteImage();
        btImg.createImage(BiotiteImage.WIDTH, BiotiteImage.HEIGHT, BiotiteImage.TITLE, BiotiteImage.IMAGE_FILE);
        btImg.imageCaption();
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
        Biotite biotite = (Biotite) o;
        return Objects.equals(name, biotite.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
