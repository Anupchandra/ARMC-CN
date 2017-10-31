import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * UDP Client for sending message
 */
public class UDPClient4
{
        public static void main(String args[])
        {
                try
                {
                        String server_address = "localhost";
                        int server_port = 1111;
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Enter the message to be sent");
                        String message = scanner.nextLine();

                        InetAddress address = InetAddress.getByName(server_address);

                        // Create Datagram packet with the UDP Server Ipaddress/ Port and Message to be sent
                        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.getBytes().length, address, server_port);

                        // Create DatagramSocket socket and send the Message
                        DatagramSocket socket = new DatagramSocket();
                        socket.send(packet);
                        System.out.println("UDPClient: Sent data to Server ; Message = " + message);
                        socket.close();
                }
                catch (Exception e)
                {
                        e.printStackTrace();
                        System.out.println("Error in sending the Data to UDP Server");
                }
        }
}