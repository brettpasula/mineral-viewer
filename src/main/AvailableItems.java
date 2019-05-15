package main;

import exceptions.ItemNotAvailableException;

import java.util.ArrayList;

public class AvailableItems {

    ArrayList<String> availableMinerals;
    ArrayList<String> availableRocks;

    public AvailableItems() {
        this.availableMinerals = new ArrayList<>();
        this.availableRocks = new ArrayList<>();
        availableMinerals.add("biotite");
        availableMinerals.add("calcite");
        availableMinerals.add("magnetite");
        availableMinerals.add("plagioclase");
        availableMinerals.add("quartz");
        availableRocks.add("granite");
        availableRocks.add("limestone");
    }

    public void checkAvailable(Operation op) throws ItemNotAvailableException {
        AvailableItems ai = new AvailableItems();

        if (!(ai.availableMinerals.contains(op.operation) || ai.availableRocks.contains(op.operation)) && (!op.operation.equals("quit"))) {
            throw new ItemNotAvailableException();
        }
    }
}
