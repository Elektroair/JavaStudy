package Chat.Server;

import Chat.BlockingQueue.Mediation.BlockingQueue;
import Chat.BlockingQueue.Mediation.BlockingQueueImplemented;
import Chat.Server.Tasks.ChatServerReceiver;
import Chat.Server.Tasks.ChatServerSender;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServerApp
{
	public static void main(String[] args)
	{
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		BlockingQueue<String> messageBox = new BlockingQueueImplemented<>(10);
		ChatServerSender sender = new ChatServerSender(messageBox);
		Thread threadSender = new Thread(sender);
		threadSender.setDaemon(true);
		threadSender.start();
		int port = 9001;
		try (ServerSocket serverSocket = new ServerSocket(port))
		{
			while (true)
			{
				System.out.println("Server is wait...");
				Socket socket = serverSocket.accept();
				System.out.println("Connection established");
				System.out.println("Client host: " + socket.getInetAddress() + ":" + socket.getPort());
				sender.addClient(socket);
				ChatServerReceiver receiver = new ChatServerReceiver(socket, messageBox);
				executorService.execute(receiver);
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}
}
