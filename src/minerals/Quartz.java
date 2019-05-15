package minerals;

import images.Image;
import images.QuartzImage;
import observer.MineralSaver;
import rocks.Rock;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Observer;

public class Quartz extends Mineral {

    ArrayList<Rock> hostRocks = new ArrayList<>();
    public String name = "Quartz";

    // made these variables final since they'll never need to change
    public static final String FORMULA = "SiO2";
    public static final String COLOUR = "highly variable, typically colourless";
    public static final String STREAK = "white";
    public static final String LUSTER = "vitreous";
    public static final String DIAPHANEITY = "transparent to opaque";
    public static final String CLEAVAGE = "none";
    public static final String CRYSTAL_SYSTEM = "hexagonal";
    public static final int HARDNESS = 7;
    public static final double SPECIFIC_GRAVITY = 2.65; // true SG 2.6 - 2.7

    // EFFECTS: prints all the properties of quartz
    public void properties(){
        setChanged();
        notifyObservers(name);
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

    public void createImage() {
        Image qtzImg = new QuartzImage();
        qtzImg.createImage(QuartzImage.WIDTH, QuartzImage.HEIGHT, QuartzImage.TITLE, QuartzImage.IMAGE_FILE);
        qtzImg.imageCaption();
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
        Quartz quartz = (Quartz) o;
        return Objects.equals(name, quartz.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}

