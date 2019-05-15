package tests;

import exceptions.ItemNotAvailableException;
import org.junit.jupiter.api.Test;
import main.AvailableItems;
import main.Operation;

import static org.junit.jupiter.api.Assertions.fail;

public class ExceptionTest {

    @Test
    public void itemNotAvailableExceptionTest() {
        AvailableItems ai = new AvailableItems();
        Operation op = new Operation();

        // check that it is not thrown when a valid entry is made
        op.setOperation("calcite");
        try {
            ai.checkAvailable(op);
        } catch (ItemNotAvailableException e) {
            fail("Should not have thrown a ItemNotAvailableException");
        }

        // check that it is thrown when an invalid entry is made
        op.setOperation("fail");
        try {
            ai.checkAvailable(op);
            fail("Should have thrown ItemNotAvailableException.");
        } catch (ItemNotAvailableException e) {
            System.out.println("Successfully caught the ItemNotAvailableException!");
        }
    }
}
