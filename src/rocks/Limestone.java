package rocks;

import minerals.Calcite;
import minerals.Mineral;
import main.GeoViewer;

import java.util.ArrayList;

public class Limestone extends Rock {

    ArrayList<Mineral> rockFormingMinerals = new ArrayList<>();

    public Limestone() {
        Mineral cal = new Calcite();
        addMineral(cal);
        GeoViewer.rockMap.put(this, rockFormingMinerals);
    }

    public static final String NAME = "Limestone";

    public void addMineral(Mineral m) {
        if (!rockFormingMinerals.contains(m)) {
            rockFormingMinerals.add(m);
            m.addRock(this);
        }
    }

    public String getName() {
        return NAME;
    }

    public ArrayList<Mineral> getRFM() {
        return this.rockFormingMinerals;
    }

}
