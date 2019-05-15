package minerals;

import images.CalciteImage;
import images.Image;
import rocks.Rock;

import java.util.ArrayList;
import java.util.Objects;

public class Calcite extends Mineral {

    private ArrayList<Rock> hostRocks = new ArrayList<>();
    public String name = "Calcite";

    // made these variables final since they'll never need to change
    public static final String FORMULA = "CaCO3";
    public static final String COLOUR = "usually white but varies";
    public static final String STREAK = "white";
    public static final String LUSTER = "vitreous";
    public static final String DIAPHANEITY = "transparent to translucent";
    public static final String CLEAVAGE = "perfect rhombohedral";
    public static final String CRYSTAL_SYSTEM = "hexagonal";
    public static final int HARDNESS = 3;
    public static final double SPECIFIC_GRAVITY = 2.7;

    // EFFECTS: prints all the properties of calcite
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

    // EFFECTS: creates a pop-up image of calcite
    public void createImage() {
        Image calImg = new CalciteImage();
        calImg.createImage(CalciteImage.WIDTH, CalciteImage.HEIGHT, CalciteImage.TITLE, CalciteImage.IMAGE_FILE);
        calImg.imageCaption();
    }

    // EFFECTS: returns the name of Calcite
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
        Calcite calcite = (Calcite) o;
        return Objects.equals(name, calcite.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
