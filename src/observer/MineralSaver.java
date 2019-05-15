package observer;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class MineralSaver implements Observer {

    private ArrayList<String> quartzVisits;

    public MineralSaver() {
        quartzVisits = new ArrayList<>();
    }

    @Override
    public void update(Observable o, Object arg) {
        this.quartzVisits.add(arg.toString());
        System.out.println("Nice choice! Quartz is my favourite mineral.");
    }

    public int totalQuartzVisits() {
        return this.quartzVisits.size();
    }
}
