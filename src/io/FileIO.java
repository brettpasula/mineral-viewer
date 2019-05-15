// Code modified from Michael Fudge's YouTube video "Learn Programming in Java - Lesson 17: File Input/Output"

package io;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class FileIO {

    FileIO io;

    public void saveList(List<String> toSave, String textFile) throws FileNotFoundException {
        File file = new File(textFile);
        PrintWriter output = new PrintWriter(file);
        int length = toSave.size();

        for (int i = 0; i < length; i++) {
            output.println(toSave.get(i));
        }

        output.close();
    }

    public void saveSet(Set<String> toSave, String textFile) throws FileNotFoundException {
        File file = new File(textFile);
        PrintWriter output = new PrintWriter(file);

        for(String s : toSave) {
            output.println(s);
        }

        output.close();
    }

    public ArrayList loadList(String textFile) throws FileNotFoundException {
        File file = new File(textFile);
        Scanner input = new Scanner(file);
        ArrayList<String> minerals = new ArrayList<>();

        while (input.hasNext()) {
            minerals.add(input.nextLine());
        }

        return minerals;
    }

    public HashSet<String> loadSet(String textFile) throws FileNotFoundException {
        File file = new File(textFile);
        Scanner input = new Scanner(file);
        HashSet<String> minerals = new HashSet<>();

        while (input.hasNext()) {
            minerals.add(input.nextLine());
        }

        return minerals;
    }

    public void printHistory() {
        io = new FileIO();
        try {
            System.out.println("Your mineral log from last time: " + io.loadList("mineral_log.txt"));
        }
        catch (FileNotFoundException e) {
            System.out.println("Your previous mineral log could not be loaded, sorry.");
        }
            try {
                System.out.println("Your rock log from last time: " + io.loadList("rock_log.txt"));
            }
            catch (FileNotFoundException e) {
                System.out.println("Your previous rock log could not be loaded, sorry.");
        }
        try {
            System.out.println("Your favourite minerals: " + io.loadSet("favourite_minerals.txt"));
        }
        catch (FileNotFoundException e) {
            System.out.println("Your favourite minerals could not be loaded, sorry.");
        }
        try {
            System.out.println("Your favourite rocks: " + io.loadSet("favourite_rocks.txt"));
        }
        catch (FileNotFoundException e) {
            System.out.println("Your favourite rocks could not be loaded, sorry.");
        }
    }

    public void saveFeedback(String name, String email, String feedback) throws FileNotFoundException {
        String textFile = "feedback.txt";
        File file = new File(textFile);
        PrintWriter output = new PrintWriter(file);
        output.println(name);
        output.println(email);
        output.println(feedback);
        output.close();
    }
}
