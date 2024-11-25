package Socket.Server.Tasks;

import java.io.*;
import java.net.Socket;
import java.time.LocalTime;

public class ClientHandler implements Runnable
{
	private Socket socket;

	public ClientHandler(Socket socket)
	{
		this.socket = socket;
	}



	@Override
	public void run()
	{
		try
		{
			InputStream inputStream  = socket.getInputStream();
			OutputStream            outputStream = socket.getOutputStream();
			PrintWriter             socketWriter = new PrintWriter(outputStream);
			BufferedReader          socketReader = new BufferedReader(new InputStreamReader(inputStream));

			while (true)
			{
				String message = socketReader.readLine();
				if (message == null)
				{
					break;
				}
				System.out.println("Server received: " + message);
				socketWriter.println(message + " | Time: " + LocalTime.now());
				socketWriter.flush();
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}

	}
}
