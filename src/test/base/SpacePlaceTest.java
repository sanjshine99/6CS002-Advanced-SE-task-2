package base;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SpacePlaceTest {

    @Test
    void testGetXOrigin() {
        SpacePlace spacePlace = new SpacePlace();
        spacePlace.setxOrgin(42);
        assertEquals(42, spacePlace.getxOrgin());
    }

    @Test
    void testSetXOrigin() {
        SpacePlace spacePlace = new SpacePlace();
        spacePlace.setxOrgin(42);
        assertEquals(42, spacePlace.getxOrgin());
    }

    @Test
    void testGetYOrigin() {
        SpacePlace spacePlace = new SpacePlace();
        spacePlace.setyOrgin(24);
        assertEquals(24, spacePlace.getyOrgin());
    }

    @Test
    void testSetYOrigin() {
        SpacePlace spacePlace = new SpacePlace();
        spacePlace.setyOrgin(24);
        assertEquals(24, spacePlace.getyOrgin());
    }

    @Test
    void testGetTheta() {
        SpacePlace spacePlace = new SpacePlace(1.5, 2.5);
        assertEquals(1.5, spacePlace.getTheta());
    }

    @Test
    void testSetTheta() {
        SpacePlace spacePlace = new SpacePlace();
        spacePlace.setTheta(3.14);
        assertEquals(3.14, spacePlace.getTheta());
    }

    @Test
    void testGetPhi() {
        SpacePlace spacePlace = new SpacePlace(1.5, 2.5);
        assertEquals(2.5, spacePlace.getPhi());
    }

    @Test
    void testSetPhi() {
        SpacePlace spacePlace = new SpacePlace();
        spacePlace.setPhi(3.14);
        assertEquals(3.14, spacePlace.getPhi());
    }
}
