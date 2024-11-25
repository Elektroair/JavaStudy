package Chat.Server.Tasks;

import Chat.BlockingQueue.Mediation.BlockingQueue;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ChatServerSender implements Runnable
{
	BlockingQueue<String>   messageBox;
	Set<PrintWriter> clients;

	public ChatServerSender(BlockingQueue<String> messageBox)
	{
		this.messageBox = messageBox;
		this.clients    = new HashSet<>();
	}

	public synchronized boolean addClient(Socket socket) throws IOException
	{
//		return clients.add(new ObjectOutputStream(socket.getOutputStream()));
		return clients.add(new PrintWriter(new OutputStreamWriter(socket.getOutputStream())));
	}

	@Override
	public void run()
	{
		while (true)
		{
			String message = messageBox.pop();


			Iterator<PrintWriter> iterator = clients.iterator();
			while (iterator.hasNext())
			{
				PrintWriter printWriter = iterator.next();
				if (message != null)
				{
					printWriter.println(message);
					printWriter.flush();
				}
			}
		}
	}
}
