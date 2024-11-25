package telran.chat.client.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Receiver implements Runnable {
	Socket socket;

	public Receiver(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try (Socket socket = this.socket;
				InputStream inputStream = socket.getInputStream();
				BufferedReader socketReader = new BufferedReader(new InputStreamReader(inputStream));) {

			while (true) {
				String message = socketReader.readLine();
				System.out.println(message);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
