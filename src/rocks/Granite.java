package rocks;

import minerals.Biotite;
import minerals.Mineral;
import minerals.Plagioclase;
import minerals.Quartz;
import main.GeoViewer;

import java.util.ArrayList;

public class Granite extends Rock {

    private ArrayList<Mineral> rockFormingMinerals = new ArrayList<>();

    public Granite() {
        Mineral bt = new Biotite();
        Mineral plag = new Plagioclase();
        Mineral qtz = new Quartz();
        addMineral(bt);
        addMineral(plag);
        addMineral(qtz);
        GeoViewer.rockMap.put(this, rockFormingMinerals);
    }

    public static final String NAME = "Granite";

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
        return rockFormingMinerals;
    }

}
