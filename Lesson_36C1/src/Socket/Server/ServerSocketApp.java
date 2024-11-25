package Socket.Server;

import Socket.Server.Tasks.ClientHandler;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerSocketApp
{
	public static void main(String[] args)
	{
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		int port = 9000;
		try (ServerSocket serverSocket = new ServerSocket(port))
		{
			while (true)
			{
				System.out.println("Server is wait...");
				Socket socket = serverSocket.accept();
				System.out.println("Connection established");
				System.out.println("Client host: " + socket.getInetAddress() + ":" + socket.getPort());
				ClientHandler task = new ClientHandler(socket);
				executorService.execute(task);
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}
}
