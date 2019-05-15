package tests;

import org.junit.jupiter.api.Test;
import main.Favourites;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FavouritesTest {

    Favourites fav = new Favourites();

    @Test
    public void testFavouriteMinerals() {

        // check that favouriteMinerals is empty
        assertEquals(fav.favouriteMinerals.size(), 0);


        // insert a mineral into favouriteMinerals
        fav.favouriteMinerals.add("Calcite");

        // check that the size of the set is one and that it contains Calcite
        assertEquals(fav.favouriteMinerals.size(), 1);
        assertTrue(fav.favouriteMinerals.contains("Calcite"));

        // add another mineral to favouriteMinerals
        fav.favouriteMinerals.add("Plagioclase");

        // check that the size of favouriteMinerals is now two and it contains both minerals
        assertEquals(fav.favouriteMinerals.size(), 2);
        assertTrue(fav.favouriteMinerals.contains("Calcite"));
        assertTrue(fav.favouriteMinerals.contains("Plagioclase"));
    }
}
