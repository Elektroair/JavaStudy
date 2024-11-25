package Client.Socket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocketApp
{
	public static void main(String[] args)
	{
		String serverHost = "127.0.0.1";
		int    port       = 9000;
		try (Socket socket = new Socket(serverHost, port))
		{
			InputStream inputStream = socket.getInputStream();
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter socketWriter = new PrintWriter(outputStream);
			BufferedReader socketReader = new BufferedReader(new InputStreamReader(inputStream));
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Enter your message or exit for quit");
			String message = bufferedReader.readLine();

			while (!"exit".equalsIgnoreCase(message))
			{
				socketWriter.println(message);
				socketWriter.flush();
				String response = socketReader.readLine();
				System.out.println(response);

				System.out.println("Enter your message or exit for quit ");
				message = bufferedReader.readLine();
			}
		}
		catch (UnknownHostException e)
		{
			throw new RuntimeException(e);
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}
}
