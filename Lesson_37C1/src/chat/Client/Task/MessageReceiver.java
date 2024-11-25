package chat.Client.Task;

import chat.Message;

import java.io.*;
import java.net.Socket;

public class MessageReceiver implements Runnable
{
	Socket socket;

	public MessageReceiver(Socket socket)
	{
		this.socket = socket;
	}



	@Override
	public void run()
	{
		try (Socket socket = this.socket;
//		     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream())))
		     ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream()))
		{
			while (true)
			{
				Message response = (Message) objectInputStream.readObject();
				System.out.println(response);
			}
		}
		catch (ClassNotFoundException | IOException e)
		{
			throw new RuntimeException(e);
		}
	}
}
