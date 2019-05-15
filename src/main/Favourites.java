package main;

import java.util.HashSet;
import java.util.Scanner;

public class Favourites {

    public HashSet<String> favouriteMinerals;
    public HashSet<String> favouriteRocks;

    public Favourites() {

        this.favouriteMinerals = new HashSet<>();
        this.favouriteRocks = new HashSet<>();
    }

    public void addToFavouriteMinerals(Operation op, Scanner scanner, Log log, Favourites favs) {
        System.out.println("Would you like to add this mineral to your list of favourites?");
        op.operation = scanner.nextLine();

        if (op.operation.equals("yes")) {
            favs.favouriteMinerals.add(log.mineralLog.get(log.mineralLog.size() - 1));
        }
    }

    public void addToFavouriteRocks(Operation op, Scanner scanner, Log log, Favourites favs) {
        System.out.println("Would you like to add this rock to your list of favourites?");
        op.operation = scanner.nextLine();

        if (op.operation.equals("yes")) {
            favs.favouriteRocks.add(log.rockLog.get(log.rockLog.size() - 1));
        }
    }

    public void addToFavMin(String mineral) {
        favouriteMinerals.add(mineral);
    }
}
