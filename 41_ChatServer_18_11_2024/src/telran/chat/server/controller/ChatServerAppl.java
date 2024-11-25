package telran.chat.server.controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import telran.chat.server.tasks.ChatServerReceiver;
import telran.chat.server.tasks.ChatServerSender;
import telran.mediation.BlkQueue;
import telran.mediation.BlkQueueImpl;

public class ChatServerAppl {

	public static void main(String[] args) {
		int port = 9000;
		BlkQueue<String> messageBox = new BlkQueueImpl<String>(10);
		ChatServerSender sender = new ChatServerSender(messageBox);
		Thread senderThread = new Thread(sender);
		senderThread.start();
		ExecutorService executorService = Executors.newFixedThreadPool(42);
		try (ServerSocket serverSocket = new ServerSocket(port);) {
			try {
				while (true) {
					System.out.println("Server is waiting...");
					Socket socket = serverSocket.accept();
					System.out.println("Connection established");
					System.out.println("Client host: " + socket.getInetAddress() + ":" + socket.getPort());
					sender.addClient(socket);
					ChatServerReceiver receiver = new ChatServerReceiver(socket, messageBox);
					executorService.execute(receiver);
				}
			} finally {
				executorService.shutdown();
				executorService.awaitTermination(1, TimeUnit.MINUTES);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
