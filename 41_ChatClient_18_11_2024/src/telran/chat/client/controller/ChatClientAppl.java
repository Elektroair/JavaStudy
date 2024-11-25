package telran.chat.client.controller;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import telran.chat.client.tasks.Receiver;
import telran.chat.client.tasks.Sender;

public class ChatClientAppl {

	public static void main(String[] args) {
		String serverHost = "6.tcp.eu.ngrok.io"; // localhost
		int post = 19128;
		try (Socket socket = new Socket(serverHost, post);) {
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);

			Thread sernderThread = new Thread(sender);
			Thread receiverThread = new Thread(receiver);
			receiverThread.setDaemon(true);
			receiverThread.start();
			sernderThread.start();
			try {
				sernderThread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
