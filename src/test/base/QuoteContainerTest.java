package base;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuoteContainerTest {
    private static String[] quoteArray;

    @BeforeClass
    public static void setUp() {
        quoteArray = QuoteContainer.quoteArray;
    }

    @Test
    public void testQuotesNotNull() {
        assertNotNull("Quotes array should not be null", quoteArray);
    }

    @Test
    public void testQuotesNotEmpty() {
        assertTrue("Quotes array should not be empty", quoteArray.length > 0);
    }

    @Test
    public void testQuoteFormat() {
        if (quoteArray.length == 0) {
            fail("No quoteArray found");
        }

        for (int i = 0; i < quoteArray.length; i += 3) {
            String quote = quoteArray[i];
            String author = quoteArray[i + 1];

            assertTrue(!quote.isEmpty());
            assertTrue(!author.isEmpty());
        }
    }

}