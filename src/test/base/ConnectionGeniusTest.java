package base;

import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.junit.jupiter.api.Assertions.*;

public class ConnectionGeniusTest {

    @Test
    public void testStartGame() {
        ConnectionGenius connectionGenius = new ConnectionGenius(getMockInetAddress());
        assertDoesNotThrow(connectionGenius::startGame);
    }

    @Test
    public void testDownloadWebVersion() {
        ConnectionGenius connectionGenius = new ConnectionGenius(getMockInetAddress());
        assertDoesNotThrow(connectionGenius::downloadWebVersion);
}

    @Test
    public void testConnectToWebService() {
        ConnectionGenius connectionGenius = new ConnectionGenius(getMockInetAddress());
        assertDoesNotThrow(connectionGenius::connectToWebService);
}

    @Test
    public void testLaunchGame() {
        ConnectionGenius connectionGenius = new ConnectionGenius(getMockInetAddress());
        assertDoesNotThrow(connectionGenius::launchGame);
    }

    private InetAddress getMockInetAddress() {
        try {
            return InetAddress.getByName("192.168.0.1");
        } catch (UnknownHostException e) {
            throw new RuntimeException("Error creating mock InetAddress", e);
        }
    }
}
