package base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IOSpecialistTest {

    @Test
    void getString() {
        IOSpecialist ioSpecialist = new IOSpecialist();
        IOLibrary.setStringForTest("Test Input");

        String result = ioSpecialist.getString();
        assertEquals("Test Input", result);
    }
}