package tests;

import org.junit.jupiter.api.Test;
import main.Log;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LogTest {

    Log log = new Log();

    @Test
    public void testMineralLog() {

        // check that the mineralLog is empty
        assertEquals(log.mineralLog.size(), 0);


        // insert a mineral into the mineralLog
        log.mineralLog.add("Calcite");

        // check that the size of the array is one and that it contains Calcite
        assertEquals(log.mineralLog.size(), 1);
        assertTrue(log.mineralLog.contains("Calcite"));

        // add an additional mineral Magnetite to the mineralLog
        log.mineralLog.add("Magnetite");

        // check that the size of the mineralLog is now two and it contains both minerals
        assertEquals(log.mineralLog.size(), 2);
        assertTrue(log.mineralLog.contains("Calcite"));
        assertTrue(log.mineralLog.contains("Magnetite"));
    }
}
