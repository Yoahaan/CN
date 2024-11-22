import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) {
        try {
            // Create a DatagramSocket to listen on port 65432
            DatagramSocket serverSocket = new DatagramSocket(65432);
            System.out.println("Server is listening on port 65432...");

            byte[] receiveBuffer = new byte[1024];
            byte[] sendBuffer;

            // Create a DatagramPacket to receive incoming data
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

            // Receive data from the client
            serverSocket.receive(receivePacket);
            String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received from client: " + clientMessage);

            // Get client's address and port
            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();

            // Prepare response
            String response = "Server received: " + clientMessage;
            sendBuffer = response.getBytes();

            // Send the response back to the client
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, clientPort);
            serverSocket.send(sendPacket);

            // Close the socket
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
