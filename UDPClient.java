import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) {
        try {
            // Create a DatagramSocket for sending data
            DatagramSocket clientSocket = new DatagramSocket();

            // Define server address and port
            InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
            int serverPort = 65432;

            // Message to be sent to the server
            String message = "Hello, Server!";
            byte[] sendBuffer = message.getBytes();

            // Create a DatagramPacket for sending the message
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, serverPort);

            // Send the message to the server
            clientSocket.send(sendPacket);
            System.out.println("Sent to server: " + message);

            // Prepare a buffer to receive the server's response
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

            // Receive the response from the server
            clientSocket.receive(receivePacket);
            String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received from server: " + serverResponse);

            // Close the socket
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
