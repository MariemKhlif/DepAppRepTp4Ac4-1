package ac4_1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws IOException  {
		try {
			InetAddress serverAddress = InetAddress.getByName("localhost");
	
		//création du socket UDP
		DatagramSocket socket = new DatagramSocket();
		
		//envoyer un message au serveur 
		String message ="Mariem Khlif";
		
		byte[] data = message.getBytes();
		DatagramPacket packet = new DatagramPacket(data,data.length,InetAddress.getByName("localhost"),1234);
		
		// Envoi du paquet
		socket.send(packet);
		System.out.println("Message envoyé vers le server");
		
        // Attendez la réponse du serveur.
        byte[] responseData = new byte[1024];
        DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length);
        socket.receive(responsePacket);
        
        // Affichez la réponse du serveur.
        String response = new String(responseData, 0, responsePacket.getLength());
        System.out.println(response);

        // Fermez le socket.
        socket.close();
        
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}}
