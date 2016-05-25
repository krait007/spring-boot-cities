package com.example.cities.domain;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CityTest  {

    @Test
    public void testPostal() {
        City city = new City("Beijing", "010", "100000");
        assertEquals("100000", city.getPostalCode());
    }
}
