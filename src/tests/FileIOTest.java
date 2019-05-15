package tests;

import io.FileIO;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileIOTest {

    // create an ArrayList to save to the test file
    ArrayList<String> testArray = new ArrayList<>();

    @Test
    public void testSaveListAndLoad() throws FileNotFoundException {

        FileIO io = new FileIO();

        // add some elements to the array
        testArray.add("test1");
        testArray.add("test2");
        testArray.add("test3");

        // check that the array is 3 long
        assertEquals(testArray.size(), 3);

        // save the array to the file
        io.saveList(testArray, "file_io_test_list.txt");

        // check that the loaded list matches the saved list
        assertEquals(testArray, io.loadList("file_io_test_list.txt"));
    }

    // create a set to save to the test file
    HashSet<String> testSet = new HashSet<>();

    @Test
    public void testSaveSetAndLoad() throws FileNotFoundException {

        FileIO io = new FileIO();

        // add some elements to the set
        testSet.add("test1");
        testSet.add("test2");
        testSet.add("test3");

        // check that the set is size 3
        assertEquals(testSet.size(), 3);

        // save the set to the file
        io.saveSet(testSet, "file_io_test_set.txt");

        // check that the loaded set matches the saved set
        assertEquals(testSet, io.loadSet("file_io_test_set.txt"));
    }
}
