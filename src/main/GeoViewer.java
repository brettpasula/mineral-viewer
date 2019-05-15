// Code (heavily) modified from CPSC 210 lecture lab B4 - LittleCalculatorStarterLecLab

package main;

import exceptions.ItemNotAvailableException;
import io.FileIO;
import minerals.*;
import org.json.JSONException;
import rocks.Granite;
import rocks.Limestone;
import rocks.Rock;
import webreader.WebReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GeoViewer {

    private Scanner scanner = new Scanner(System.in);
    public static HashMap<Rock, ArrayList<Mineral>> rockMap = new HashMap<>();
    Favourites favs = new Favourites();
    AvailableItems ai = new AvailableItems();

    // MODIFIES: Log, Favourites, Operation
    // EFFECTS: produces an image and relevant information of a mineral based on user input
    private GeoViewer() {
        System.out.println("Welcome to GeoViewer!");
        WebReader wr = new WebReader();
        try {
            System.out.println("The current weather in Vancouver is: ");
            //wr.parseWeb(wr.readWeb());
            wr.readWeb();
        } catch(IOException | JSONException e) {
            System.out.println("We were unable to retrieve the weather for Vancouver at this time.");
            System.out.println();
        }
        Log log = new Log();
        Favourites favs = new Favourites();
        FileIO io = new FileIO();
        io.printHistory();

        while (true) {
            Operation op = new Operation();
            System.out.println("Please select a mineral or rock (typed in lowercase), or exit using 'quit'.");
            System.out.println("Currently available minerals: " + ai.availableMinerals);
            System.out.println("Currently available rocks: " + ai.availableRocks);
            op.operation = scanner.nextLine();
            System.out.println("You've selected: " + op.operation);

            try {
                ai.checkAvailable(op);
            } catch (ItemNotAvailableException e) {
                System.out.println("Sorry, that item is not available at this time.");
                continue;
            }

            if (op.operation.equals("calcite")) {
                Mineral mineral = new Calcite();
                mineralOperation(log, op, mineral);
            }

            if (op.operation.equals("magnetite")) {
                Mineral mineral = new Magnetite();
                mineralOperation(log, op, mineral);
            }

            if (op.operation.equals("quartz")) {
                Mineral mineral = new Quartz();
                mineralOperation(log, op, mineral);
            }

            if (op.operation.equals("biotite")) {
                Mineral mineral = new Biotite();
                mineralOperation(log, op, mineral);
            }

            if (op.operation.equals("plagioclase")) {
                Mineral mineral = new Plagioclase();
                mineralOperation(log, op, mineral);
            }

            if (op.operation.equals("granite")) {
                Rock rock = new Granite();
                rockOperation(log, op, rock);
                continue;
            }

            if (op.operation.equals("limestone")) {
                Rock rock = new Limestone();
                rockOperation(log, op, rock);
                continue;
            }

            else if (op.operation.equals("quit")) {
                try {
                    io.saveList(log.mineralLog, "mineral_log.txt");
                } catch (FileNotFoundException e) {
                    System.out.println("mineral_log.txt could not be found.");
                }
                try {
                    io.saveList(log.rockLog, "rock_log.txt");
                } catch (FileNotFoundException e) {
                    System.out.println("rock_log.txt could not be found.");
                }
                try {
                    io.saveSet(favs.favouriteMinerals, "favourite_minerals.txt");
                } catch (FileNotFoundException e) {
                    System.out.println("favourite_minerals.txt could not be found.");
                }
                try {
                    io.saveSet(favs.favouriteRocks, "favourite_rocks.txt");
                } catch (FileNotFoundException e) {
                    System.out.println("favourite_rocks.txt could not be found.");
                }
                finally {
                    System.out.println("Minerals you've visited: " + log.mineralLog);
                    System.out.println("Rocks you've visited: " + log.rockLog);
                    System.out.println("Your favourite minerals: " + favs.favouriteMinerals);
                    System.out.println("Your favourite rocks: " + favs.favouriteRocks);
                    System.out.println("Thank you for using GeoViewer!");
                    System.out.println();
                }
                break;
            }
    }

}

    private void mineralOperation(Log log, Operation op, Mineral mineral) {
        mineral.addMineralObserver();
        op.setOperation(op.operation);
        log.mineralLog.add(mineral.getName());
        mineral.properties();
        System.out.println("Would you like to see a photo of " + mineral.getName() + "?");
        op.operation = scanner.nextLine();

        if (op.operation.equals("yes")) {
            mineral.createImage();
        }

        favs.addToFavouriteMinerals(op, scanner, log, favs);
    }

    private void rockOperation(Log log, Operation op, Rock rock) {
        op.setOperation(op.operation);
        log.rockLog.add(rock.getName());
        System.out.println(rock.getName() + " contains the following rock forming minerals: " + rock.printRFM(rockMap.get(rock)));
        favs.addToFavouriteRocks(op, scanner, log, favs);
        System.out.println("Would you like to compare these rock forming minerals to another rock?");
        op.operation = scanner.nextLine();

        if (op.operation.equals("yes")) {
            System.out.println("Which rock would you like to compare it to? Currently available rocks: " + ai.availableRocks);
            op.operation = scanner.nextLine();

            if (op.operation.equals("limestone")) {
                Rock lim = new Limestone();
                rock.compareRockFormingMinerals(rock, lim);
            }

            if (op.operation.equals("granite")) {
                Rock gr = new Granite();
                rock.compareRockFormingMinerals(rock, gr);
            }
        }
    }

    public static void main (String[]args) {
            new GeoViewer();
        }
    }