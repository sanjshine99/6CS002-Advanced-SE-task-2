package base;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PictureFrameTest {

    private PictureFrame pictureFrame;

    @BeforeEach
    void setUp() {
        Main main = new Main();
        pictureFrame = new PictureFrame();
        pictureFrame.PictureFrame(main);
    }

    @Test
    void testPictureFrameInitialization() {
        assertNotNull(pictureFrame.dp);
    }

    @Test
    void testDominoPanelPreferredSize() {
        assertEquals(202, pictureFrame.dp.getPreferredSize().width);
        assertEquals(182, pictureFrame.dp.getPreferredSize().height);
    }

}
