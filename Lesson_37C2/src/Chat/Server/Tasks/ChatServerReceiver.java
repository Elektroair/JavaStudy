package Chat.Server.Tasks;

import Chat.BlockingQueue.Mediation.BlockingQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ChatServerReceiver implements Runnable
{
	Socket socket;
	BlockingQueue<String> messageBox;

	public ChatServerReceiver(Socket socket, BlockingQueue<String> messageBox)
	{
		this.socket     = socket;
		this.messageBox = messageBox;
	}



	@Override
	public void run()
	{
		try (Socket socket = this.socket;
		     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream())))
		{
			while (true)
			{
				String message = bufferedReader.readLine();
				if (message == null)
				{
					break;
				}
				messageBox.push(message);
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}
}
