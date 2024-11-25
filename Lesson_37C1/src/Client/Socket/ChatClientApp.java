package Client.Socket;

import chat.Client.Task.MessageReceiver;
import chat.Client.Task.MessageSender;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClientApp
{
	public static void main(String[] args)
	{
		String serverHost = "5.tcp.eu.ngrok.io";
		int    port       = 19185;
		try
		{
			Socket socket = new Socket(serverHost, port);
			MessageSender sender = new MessageSender(socket);
			MessageReceiver receiver = new MessageReceiver(socket);

			Thread threadSender = new Thread(sender);
			Thread threadReceiver = new Thread(receiver);

			threadReceiver.setDaemon(true);
			threadReceiver.start();
			threadSender.start();
			threadSender.join();
		}
		catch (UnknownHostException e)
		{
			throw new RuntimeException(e);
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
		catch (InterruptedException e)
		{
			throw new RuntimeException(e);
		}
	}
}
