package minerals;

import observer.MineralSaver;
import rocks.Rock;

import java.util.Observable;

public abstract class Mineral extends Observable {

    public void addMineralObserver() {
        addObserver(new MineralSaver());
    }

    // EFFECTS: prints all of the properties of the mineral
   public abstract void properties();

   // EFFECTS: creates a pop-up image of the mineral
   public abstract void createImage();

   public abstract String getName();

   public abstract void addRock(Rock r);

}
