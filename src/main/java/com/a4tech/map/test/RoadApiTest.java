package com.a4tech.map.test;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpEntity;

public class RoadApiTest {




    public RoadApiTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void snapToRoads() {
        final List<Coordinate3d> coordinates = new LinkedList<Coordinate3d>();
        coordinates.add(new Coordinate3d(24.942795, 60.170880, 0d));
        coordinates.add(new Coordinate3d(24.942796, 60.170879, 0d));
        coordinates.add(new Coordinate3d(24.942796, 60.170877, 0d));
        String val = "85.56853483,24.84226797|85.840945,24.967976";
        final HttpEntity httpEntity = GoogleMapsRoadsApi.snapToRoads(val, true);
    }

}
