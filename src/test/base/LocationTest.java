package base;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LocationTest {

    @Test
    void testToStringWithoutDirection() {
        // Arrange
        Location location = new Location(2, 3);

        // Act
        String result = location.toString();

        // Assert
        assertEquals("(4,3)", result);
    }

    @Test
    void testToStringWithDirection() {
        // Arrange
        Location location = new Location(2, 3, Location.DIRECTION.HORIZONTAL);

        // Act
        String result = location.toString();

        // Assert
        assertEquals("(4,3,HORIZONTAL)", result);
    }

    @Test
    void testDrawGridLines() {
        // Arrange
        Location location = new Location(0, 0);
        BufferedImage image = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = image.getGraphics();

        location.drawGridLines(graphics);
    }

    @Test
    void testDrawHorizontalLines() {
        // Arrange
        Location location = new Location(0, 0);
        BufferedImage image = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = image.getGraphics();

        // Act
        location.drawHorizontalLines(graphics);
}

    @Test
    void testDrawVerticalLines() {
        // Arrange
        Location location = new Location(0, 0);
        BufferedImage image = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = image.getGraphics();

        // Act
        location.drawVerticalLines(graphics);

   }


}
