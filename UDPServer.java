import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP Server listening to receive data from UDP Clients
 */
public class UDPServer
{
        public static void main(String args[])
        {
                int server_port = 1111;
                System.out.println("UDP Server Listening in " + server_port);
                try
                {
                        // DatagramSocket created and listening in Port 1111
                        DatagramSocket socket = new DatagramSocket(server_port);
                        byte[] msgBuffer = new byte[1024];

                        // DatagramPacket for receiving the incoming data from UDP Client
                        DatagramPacket packet = new DatagramPacket(msgBuffer, msgBuffer.length);

                        while (true)
                        {
                                socket.receive(packet);
                                String message = new String(msgBuffer, 0, packet.getLength());
                                System.out.println("UDPServer: Message received = " + message);
                                packet.setLength(msgBuffer.length);
                                System.exit(1);
                        }
                }
                catch (Exception e)
                {
                        e.printStackTrace();
                        System.out.println("Error in getting the Data from UDP Client");
                }
        }
}