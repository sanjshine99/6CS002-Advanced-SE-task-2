package base;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MainTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testGenerateDominoes() {
        Main main = new Main();
        Main.generateDominoes();
        assertNotNull(Main.dominoList);
        assertEquals(28, Main.dominoList.size());
    }

    @Test
    public void testGenerateGuesses() {
        Main main = new Main();
        Main.generateGuesses();
        assertNotNull(Main.guessList);
        assertEquals(28, Main.guessList.size());
    }

    @Test
    public void testCollateGrid() {
        Main main = new Main();
        Main.generateDominoes();
        Main.collateGrid();
        // Add assertions based on the expected behavior of collateGrid()
    }

    @Test
    public void testCollateGuessGrid() {
        Main main = new Main();
        Main.generateGuesses();
        Main.collateGuessGrid();
}
    @Test
    public void testRun() {
        Main main = new Main();
System.setOut(originalOut);
    }
}