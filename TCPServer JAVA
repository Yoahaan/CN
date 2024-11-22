import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        // Define server port
        int serverPort = 65432;

        try (ServerSocket serverSocket = new ServerSocket(serverPort)) {
            System.out.println("Server is listening on port " + serverPort);

            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            // Set up input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read message from client
            String clientMessage = in.readLine();
            System.out.println("Received from client: " + clientMessage);

            // Send a response to the client
            String responseMessage = "Hello from server!";
            out.println(responseMessage);
            System.out.println("Sent to client: " + responseMessage);

            // Close the client connection
            clientSocket.close();
            System.out.println("Client disconnected.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

