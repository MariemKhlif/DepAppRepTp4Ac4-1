package ac4_1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;

public class Serveur {

	public static void main(String[] args) throws IOException {
		//création d'un socket UPD
		DatagramSocket socket = new DatagramSocket(1223);
		System.out.println("Démarrage du serveur");
		//faire une boucle pour attendre les demandes de connexions
		while(true)
		{
			//Attendez un message du client 
			DatagramPacket packet = new DatagramPacket(new byte[1024],1024);
			socket.receive(packet);
			
			//Récupérez le messade du client 
			byte[] data = packet.getData();
			String message = new String(data,0,packet.getLength());
			
			//envoyer une réponse au client 
			message = "Bienvenu"+message;
			
			byte[]response = message.getBytes();
		
			DatagramPacket responsePacket= new DatagramPacket(response , response.length,packet.getAddress() ,packet.getPort());
			socket.send(responsePacket);
			
			
		}

	}

     }
