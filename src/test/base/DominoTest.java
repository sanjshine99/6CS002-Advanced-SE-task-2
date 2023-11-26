package base;

import org.junit.Test;

import static org.junit.Assert.*;

public class DominoTest {


    @Test
    public void testConstructorAndGetters() {
        Domino domino = new Domino(3, 5);

        assertEquals(3, domino.getHighValue());
        assertEquals(5, domino.getLowValue());
        assertFalse(domino.isPlaced());
    }


    @Test
    public void testPlace() {
        Domino domino = new Domino(2, 4);
        domino.place(1, 1, 2, 2);

        assertTrue(domino.isPlaced());
        assertEquals(1, domino.getHorizontalPositionX());
        assertEquals(1, domino.getHorizontalPositionY());
        assertEquals(2, domino.getVerticalPositionX());
        assertEquals(2, domino.getVerticalPositionY());
    }

    @Test
    public void testToString() {
        Domino domino = new Domino(1, 6);
        assertEquals("[16] unplaced", domino.toString());

        domino.place(2, 2, 3, 3);
        assertEquals("[16](3,3)(4,4)", domino.toString());
    }

    @Test
    public void testInvert() {
        Domino domino = new Domino(4, 3);
        domino.place(1, 1, 2, 2);
        domino.invert();

        assertEquals(2, domino.getHorizontalPositionX());
        assertEquals(2, domino.getHorizontalPositionY());
        assertEquals(1, domino.getVerticalPositionX());
        assertEquals(1, domino.getVerticalPositionY());
    }

    @Test
    public void testIsHorizontalPlacement() {
        Domino horizontalDomino = new Domino(2, 4);
        Domino verticalDomino = new Domino(5, 3);

        horizontalDomino.place(1, 1, 2, 1);
        verticalDomino.place(3, 3, 3, 4);

        assertTrue(horizontalDomino.isHorizontalPlacement());
        assertFalse(verticalDomino.isHorizontalPlacement());
    }
}
