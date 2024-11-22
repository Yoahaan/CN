import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        // Define server address and port
        String serverAddress = "127.0.0.1";
        int serverPort = 65432;

        try {
            // Create a client socket and connect to the server
            Socket socket = new Socket(serverAddress, serverPort);
            System.out.println("Connected to server at " + serverAddress + " on port " + serverPort);

            // Set up input and output streams
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Send a message to the server
            String messageToSend = "Hello, Server!";
            out.println(messageToSend);
            System.out.println("Sent to server: " + messageToSend);

            // Receive response from the server
            String serverResponse = in.readLine();
            System.out.println("Received from server: " + serverResponse);

            // Close the connection
            socket.close();
            System.out.println("Connection closed.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
