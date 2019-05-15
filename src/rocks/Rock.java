package rocks;

import minerals.Mineral;

import java.util.ArrayList;

public abstract class Rock {

    public ArrayList<String> printRFM(ArrayList<Mineral> minerals) {
        ArrayList<String> mineralNames = new ArrayList<>();
        for (Mineral m: minerals) {
            mineralNames.add(m.getName());
        }
        return mineralNames;
    }

    public void compareRockFormingMinerals(Rock r1, Rock r2) {
        ArrayList<Mineral> rfm1 = r1.getRFM();
        ArrayList<Mineral> rfm2 = r2.getRFM();
        ArrayList<String> sameRFM = new ArrayList<>();

        for (Mineral m: rfm1) {
            if (rfm2.contains(m)) {
                sameRFM.add(m.getName());
            }
        }
        if (sameRFM.isEmpty()) {
            System.out.println("These rocks have no rock forming minerals in common.");
        } else {
            System.out.println("Rock forming minerals in common: " + sameRFM);
        }
    }

    public abstract void addMineral(Mineral m);

    public abstract String getName();

    public abstract ArrayList<Mineral> getRFM();
}
