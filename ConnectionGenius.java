/**
 * ConnectionGenius class represents a utility for setting up a game connection.
 * It includes methods for downloading a specialized web version,
 * connecting to a web service, and initiating the game.
 */

package base;

import java.net.InetAddress;

public class ConnectionGenius {
    InetAddress gameServerIPAddress; // rename ipa to gameServerIPAddress

    public ConnectionGenius(InetAddress gameServerIPAddress) {
        this.gameServerIPAddress = gameServerIPAddress;
    }

    public void startGame() { // rename fireUpGame() to startGame()
        downloadWebVersion(); // rename downloadWebVersion() to fetchSpecializedWebVersion()
        connectToWebService(); // rename connectToWebService() to establishWebServiceConnection()
        launchGame(); // rename awayWeGo() to launchGame()
    }

    public void downloadWebVersion() {
        System.out.println("Getting specialised web version.");
        System.out.println("Wait a couple of moments");
    }

    public void connectToWebService() {
        System.out.println("Connecting");
    }

    public void launchGame() { // rename awayWeGo() to launchGame()
        System.out.println("Ready to play");
    }
}