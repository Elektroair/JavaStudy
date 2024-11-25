package chat.Client.Task;

import chat.Message;

import java.io.*;
import java.net.Socket;

public class MessageSender implements Runnable
{
	Socket socket;

	public MessageSender(Socket socket)
	{
		this.socket = socket;
	}


	@Override
	public void run()
	{
		try (Socket socket = this.socket;
		     ObjectOutputStream socketWriter = new ObjectOutputStream(socket.getOutputStream());
		     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)))
//		     PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
//		     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)))
		{
			System.out.println("Enter your name bellow:");
			String name = bufferedReader.readLine();
			System.out.println("Enter your message or «exit» for quit");
			String text = bufferedReader.readLine();

			while (!"exit".equalsIgnoreCase(text))
			{
				Message message = new Message(name, text);
				socketWriter.writeObject(message);
				System.out.println("Enter your message or «exit» for quit");
				text = bufferedReader.readLine();
			}

		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}
}
