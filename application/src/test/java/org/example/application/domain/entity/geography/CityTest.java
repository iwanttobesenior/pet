package org.example.application.domain.entity.geography;


import org.example.application.domain.entity.enums.StationType;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Contains unit test to check functionality of {@link City} class
 *
 * @author Kul'baka Alex
 */
public class CityTest {

    private City city;

    @Before
    public void init() {
        city = new City("Munich");
    }

    @Test
    public void testAddValidStation_success() {

        Station station = city.addStation(StationType.AUTO);

        assertTrue(containsStation(city, station));
        assertEquals(city, station.getCity());
    }

    @Test(expected = NullPointerException.class)
    public void testAddInvalidStationTypeAsNull_failure() {

        city.addStation(null);
        fail();
    }

    @Test
    public void testAddAlreadyExistStation_duplicateImpossible() {

        city.addStation(StationType.OCEAN);
        city.addStation(StationType.OCEAN);

        assertEquals(1, city.getStationsCount());
    }

    @Test
    public void testRemoveStationValid_success() {

        Station station = city.addStation(StationType.RAILWAY);
        assertEquals(1, city.getStationsCount());

        city.removeStation(station);
        assertEquals(0, city.getStationsCount());
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveStationInvalidAsNull_failure() {

        city.removeStation(null);
        fail();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFromNonExistingCollectionOfStations_failure() {
        final Station station = new Station(StationType.AUTO, city);

        city.removeStation(station);
    }

    @Test
    public void testRemoveNonExistingStations_noEffect() {

        city.addStation(StationType.RIVER);
        city.addStation(StationType.SEA);
        int i = city.getStationsCount();
        city.removeStation(new Station(StationType.TAXI, city));

        assertEquals(i, city.getStationsCount());
    }

    private boolean containsStation(final City city, final Station station) {
        return city.getStations().contains(station);
    }
}
